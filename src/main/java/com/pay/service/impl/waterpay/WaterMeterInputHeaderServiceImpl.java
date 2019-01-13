package com.pay.service.impl.waterpay;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.PayConstants;
import com.pay.common.print.WatermeterInputForPrint;
import com.pay.dao.ApportionTypeDao;
import com.pay.dao.BuildingDetailDao;
import com.pay.dao.BuildingInfoDao;
import com.pay.dao.PricingTypeDao;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.dao.waterpay.WaterMeterInputBuildingDao;
import com.pay.dao.waterpay.WaterMeterInputDetailDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.exception.BusinessException;
import com.pay.pojo.PayApportionType;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayBuildingInfo;
import com.pay.pojo.PayPricingType;
import com.pay.pojo.waterpay.PayOrderInfo;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;
import com.pay.service.PricingTypeService;
import com.pay.service.waterpay.WaterMeterInputHeaderService;

@Service("waterMeterInputHeaderService")
public class WaterMeterInputHeaderServiceImpl implements WaterMeterInputHeaderService {
	
	private static final Logger logger = Logger.getLogger(WaterMeterInputHeaderServiceImpl.class);
	
	@Autowired
	private WaterMeterInputHeaderDao waterMeterInputHeaderDao;
	
	@Autowired
	private WaterMeterInputDetailDao waterMeterInputDetailDao;
	
	@Autowired
	private WaterMeterInputBuildingDao waterMeterInputBuildingDao;
	
	@Autowired
	private BuildingDetailDao buildingDetailDao;
	
	@Autowired
	private BuildingInfoDao buildingInfoDao;
	
	@Autowired
	private ApportionTypeDao apportionTypeDao;
	
	@Autowired
	private PricingTypeDao pricingTypeDao;
	
	@Autowired
	private PricingTypeService pricingTypeService;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	/**
	 * 打印抄表表格
	 * @param payWaterMeterInputHeader
	 */
	@DataResolver
	public void print(Map<String,Object> params)throws Exception{
		

		String buildCode=(String)params.get("buildCode");
		//-------------------获取本月单号--------------------
		

		//-------------------水费录入楼宇信息--------------------
		
		Map<String,Object> buildParamsMap=new HashMap<String, Object>();
		buildParamsMap.put("status", PayConstants.ENABLED_STATUS);
		buildParamsMap.put("code", buildCode);
		
		List<PayBuildingInfo> buildingInfos=buildingInfoDao.queryForCondition(buildParamsMap);
		
		if(CollectionUtils.isEmpty(buildingInfos)){
			throw new BusinessException("查询不到楼宇资料，请检查数据！");
		}
		
		try{
			for(PayBuildingInfo buildingInfo:buildingInfos){
				WatermeterInputForPrint print=getPrintData(buildingInfo);
				//-------------------水费录入房间信息--------------------
					
				//-------------------打印--------------------
				// 通俗理解就是书、文档
				Book book = new Book();
				// 设置成竖打
				PageFormat pf = new PageFormat();
				pf.setOrientation(PageFormat.PORTRAIT);
				// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。  
				Paper p = new Paper(); 
				p.setSize(590, 840); // Warranty Paper Size,A4 590, 840  
				p.setImageableArea(10, 10, 590, 840); // Print Area  
				pf.setPaper(p);  
					
				// 把 PageFormat 和 Printable 添加到书中，组成一个页面
				book.append(print, pf);
				// 获取打印服务对象
				PrinterJob job = PrinterJob.getPrinterJob();
					
				// 设置打印类
				job.setPageable(book);
	
				// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
				// boolean a=job.printDialog();
				// if(a)
				// {
						
				String docName = print.getOrderNo()+print.getBuildingCode();
				if(job.getJobName().equals(docName)){
					job.setJobName(docName);
				}
						
				job.print();
				//-------------------打印--------------------
			}
		}catch(Exception e){
			logger.error("打印异常!",e);
			throw new BusinessException("打印异常，请查看日志！");
		}
		
	}
	
	private WatermeterInputForPrint getPrintData(PayBuildingInfo buildingInfo){
		//打印类
		WatermeterInputForPrint print = new WatermeterInputForPrint();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
		String orderNo=sdf.format(new Date());
		//获取抄表单号
		print.setOrderNo(orderNo);
		//获取楼宇ID和地址
		print.setBuildingCode(buildingInfo.getCode());
		print.setAddr(buildingInfo.getAddr());
		print.setHouseMaster(buildingInfo.getHousemaster());
		print.setDetailMap(queryPrintDetail(buildingInfo.getCode()));
		return print;
	}
	
	private Map<String, List<PayWaterMeterInputDetail>> queryPrintDetail(String buildingCode){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		
		//-------------------水费录入房间信息--------------------
		Map<String,Object> queryDetailParams=new HashMap<String, Object>();
		queryDetailParams.put("code", buildingCode);
		List<PayBuildingDetail> buildingDetails= buildingDetailDao.queryForCondition(queryDetailParams);

		Map<String, List<PayWaterMeterInputDetail>> detailMap = new HashMap<String, List<PayWaterMeterInputDetail>>();
		
		if(CollectionUtils.isNotEmpty(buildingDetails)){

			for(PayBuildingDetail buildingDetail:buildingDetails){
				
				String roomNo = buildingDetail.getRoomNo();
				
				List<PayWaterMeterInputDetail> printDetails = new ArrayList<PayWaterMeterInputDetail>();
				//获取每个房号1-12月的抄表记录
				for(int i = 1; i < 13; i++){
					String month = "0"+i;
					month = month.substring(month.length()-2, month.length());
					String yearMonth=year+month;
					Map<String, Object> parameterDetail = new HashMap<String, Object>();
					parameterDetail.put("monthlyCycle", Integer.parseInt(yearMonth));
					parameterDetail.put("buildingCode", buildingCode);
					parameterDetail.put("roomNo", roomNo);
					List<PayWaterMeterInputDetail> listDetails = waterMeterInputDetailDao.queryForCondition(parameterDetail);
					if(CollectionUtils.isEmpty(listDetails)){
						printDetails.add(null);
					}else{
						printDetails.add(listDetails.get(0));
					}
				}
				detailMap.put(roomNo, printDetails);
			}
		}
		return detailMap;
	}
	
	
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayWaterMeterInputHeader> page,Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			Date monthly=(Date)parameter.get("monthlyCycle");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			String dateFormat= sdf.format(monthly);
			parameter.put("monthly", Integer.parseInt(dateFormat));
		}
		
		waterMeterInputHeaderDao.queryPageForCondition(page, parameter);
		
		
		List<PayWaterMeterInputHeader> waterMeterInputHeaders= (List<PayWaterMeterInputHeader>)page.getEntities();
		
		if(CollectionUtils.isNotEmpty(waterMeterInputHeaders)){
			//计算录入比
			for(PayWaterMeterInputHeader waterMeterInputHeader:waterMeterInputHeaders){
				Map<String,Object> params =new HashMap<String, Object>();
				params.put("code", waterMeterInputHeader.getCode());
				Long totalCount=waterMeterInputDetailDao.getCountForCondition(params);
				
				params.put("status", 1);
				
				Long inputCount=waterMeterInputDetailDao.getCountForCondition(params);
				BigDecimal percent=new BigDecimal(0);
				if(totalCount!=0){
					percent=new BigDecimal(inputCount).divide(new BigDecimal(totalCount),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
				}
				
				waterMeterInputHeader.setInputPercent(percent.toString());
			}
		}
		
	}
	
	/**
	 * 创建水费录入记录
	 * @param payWaterMeterInputHeader
	 */
	@DataResolver
	public void create(Map<String,Object> params){
		
		if(MapUtils.isNotEmpty(params)){
			Date monthly=(Date)params.get("monthly");
			Date beginDate=(Date)params.get("beginDate");
			Date endDate=(Date)params.get("endDate");
			String remark=(String)params.get("remark");
			
			if(beginDate.after(endDate)){
				throw new BusinessException("开始日期不能大于结束日期！");
			}
			if(monthly.after(endDate)){
				throw new BusinessException("结束日期必须大于该月度开始日期！");
			}
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			Integer monthly2Int=Integer.parseInt(sdf.format(monthly));
			
			//查看该月度是否已初始化数据
			PayWaterMeterInputHeader waterMeterInputHeader=waterMeterInputHeaderDao.getByMonthly(monthly2Int);
			
			if(waterMeterInputHeader!=null){
				throw new BusinessException("已存在该批次，请先作废再重生生成！");
			}
			
			PayWaterMeterInputHeader header=new PayWaterMeterInputHeader();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String inputHeaderCode="WI"+sdf1.format(monthly);
			header.setCode(inputHeaderCode);
			header.setBeginDate(beginDate);
			header.setEndDate(endDate);
			header.setMonthlyCycle(monthly2Int);
			header.setStatus(PayConstants.INPUT_DATA_STATUS_NEW);
			header.setCreateUser(ContextHolder.getLoginUserName());
			header.setCreateTime(new Date());
			header.setLastModifyUser(ContextHolder.getLoginUserName());
			header.setLastModifyTime(new Date());
			header.setRemark(remark);
			
			Map<String,Object> buildParamsMap=new HashMap<String, Object>();
			buildParamsMap.put("status", PayConstants.ENABLED_STATUS);
			List<PayBuildingInfo> buildingInfos=buildingInfoDao.queryForCondition(buildParamsMap);
			createDetail(header.getCode(),header.getMonthlyCycle(),buildingInfos);
			
			waterMeterInputHeaderDao.save(header);
				
		}
		
	}
	
	/**
	 * 创建水费录入记录For楼宇编号
	 * @param params
	 */
	@DataResolver
	public void createForBuildingCode(Map<String,Object> params){
		
		if(MapUtils.isNotEmpty(params)){
			Date monthly=(Date)params.get("monthly");

			String buildingCode=(String)params.get("buildingCode");

			
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			Integer monthly2Int=Integer.parseInt(sdf.format(monthly));
			
			
			//查看该月度是否已初始化数据
			PayWaterMeterInputHeader waterMeterInputHeader=waterMeterInputHeaderDao.getByMonthly(monthly2Int);
			
			if(waterMeterInputHeader!=null){
				if(PayConstants.INPUT_DATA_STATUS_CONFIRM==waterMeterInputHeader.getMonthlyCycle()){
					throw new BusinessException("该批次已确认开始收费！");
				}else{
					if(StringUtils.isNotEmpty(buildingCode)){
						//查询该批次是否存在该楼宇录入记录
						PayWaterMeterInputBuilding waterMeterInputBuilding=waterMeterInputBuildingDao.getByCodeAndBuildCode(waterMeterInputHeader.getCode(), buildingCode);
						//存在则抛出异常
						if(waterMeterInputBuilding!=null){
							
							throw new BusinessException("该批次已存在该楼宇信息！");
						}else{
							Map<String,Object> buildParamsMap=new HashMap<String, Object>();
							buildParamsMap.put("status", PayConstants.ENABLED_STATUS);
							buildParamsMap.put("code", buildingCode);
							List<PayBuildingInfo> buildingInfos=buildingInfoDao.queryForCondition(buildParamsMap);
							if(CollectionUtils.isEmpty(buildingInfos)){
								throw new BusinessException("该楼宇不存在！");
							}
							createDetail(waterMeterInputHeader.getCode(),waterMeterInputHeader.getMonthlyCycle(),buildingInfos);
						}
					}else{
						throw new BusinessException("楼宇编号不能为空！");
					}
				}
			}else{
				throw new BusinessException("该批次不存在,不能追加楼宇信息!");
			}

			
			
			
			
			
		}
		
	}
	
	/**
	 * 根据楼宇信息创建录入明细
	 * @param code
	 * @param monthly
	 * @param buildingInfos
	 */
	private void createDetail(String code,Integer monthly, List<PayBuildingInfo> buildingInfos){
		if(CollectionUtils.isEmpty(buildingInfos)){
			throw new BusinessException("查询不到楼宇资料，请检查数据！");
		}
		
		for(PayBuildingInfo buildingInfo:buildingInfos){
			
			PayWaterMeterInputBuilding waterMeterInputBuilding=new PayWaterMeterInputBuilding();
			waterMeterInputBuilding.setCode(code);
			waterMeterInputBuilding.setBuildingCode(buildingInfo.getCode());
			waterMeterInputBuilding.setMonthlyCycle(monthly);
			waterMeterInputBuilding.setCurrentQty(new BigDecimal(0));
			waterMeterInputBuilding.setStatus(PayConstants.INPUT_DATA_STATUS_NEW);
			waterMeterInputBuilding.setCreateUser(ContextHolder.getLoginUserName());
			waterMeterInputBuilding.setCreateTime(new Date());
			waterMeterInputBuilding.setLastModifyUser(ContextHolder.getLoginUserName());
			waterMeterInputBuilding.setLastModifyTime(new Date());
			
			Map<String,Object> queryDetailParams=new HashMap<String, Object>();
			queryDetailParams.put("code", buildingInfo.getCode());
			
			List<PayBuildingDetail> buildingDetails= buildingDetailDao.queryForCondition(queryDetailParams);
			
			//-------------------水费录入楼宇明细信息--------------------
			if(CollectionUtils.isNotEmpty(buildingDetails)){
				List<PayWaterMeterInputDetail> waterMeterInputDetails=new ArrayList<PayWaterMeterInputDetail>();
				Map<Integer,PayPricingType> pricingTypeMap=pricingTypeService.queryApportionTypeForMap();
				for(PayBuildingDetail buildingDetail:buildingDetails){
					PayWaterMeterInputDetail waterMeterInputDetail=new PayWaterMeterInputDetail();
					waterMeterInputDetail.setCode(code);
					waterMeterInputDetail.setMonthlyCycle(monthly);
					waterMeterInputDetail.setBuildingCode(buildingDetail.getCode());
					waterMeterInputDetail.setRoomNo(buildingDetail.getRoomNo());
					waterMeterInputDetail.setWaterMeterCode(buildingDetail.getWaterMeterCode());
					waterMeterInputDetail.setBeforeQty(buildingDetail.getMonthlyQty()==null?new BigDecimal(0):buildingDetail.getMonthlyQty());
					waterMeterInputDetail.setCurrentQty(new BigDecimal(0));
					waterMeterInputDetail.setGarbagePrice(pricingTypeMap.get(buildingDetail.getPricingTypeId()).getGarbagePrice());
					waterMeterInputDetail.setNetworkPrice(pricingTypeMap.get(buildingDetail.getPricingTypeId()).getNetworkPrice());
					waterMeterInputDetail.setSewagePrice(new BigDecimal(0));
					waterMeterInputDetail.setOtherPrice(new BigDecimal(0));
					waterMeterInputDetail.setStatus(PayConstants.INPUT_DATA_STATUS_NEW);
					waterMeterInputDetail.setCreateUser(ContextHolder.getLoginUserName());
					waterMeterInputDetail.setCreateTime(new Date());
					waterMeterInputDetail.setLastModifyUser(ContextHolder.getLoginUserName());
					waterMeterInputDetail.setLastModifyTime(new Date());
					waterMeterInputDetails.add(waterMeterInputDetail);
				}
				waterMeterInputBuildingDao.save(waterMeterInputBuilding);
				waterMeterInputDetailDao.saveAll(waterMeterInputDetails);	
			}
			
			//-------------------水费录入楼宇明细信息--------------------
		}
	}
	
	/**
	 * 确认后生成订单
	 * @param payWaterMeterInputHeader
	 */
	@DataResolver
	public void confirm(Map<String,Object> params){
		
		String code=(String)params.get("code");
		PayWaterMeterInputHeader header= waterMeterInputHeaderDao.get(code);
		
		if(PayConstants.INPUT_DATA_STATUS_INPUT!=header.getStatus()){
			throw new BusinessException("状态不正确，不能确认！");
		}
		
		List<PayWaterMeterInputDetail> waterMeterInputDetails=waterMeterInputDetailDao.queryForCondition(params);
		
		if(CollectionUtils.isEmpty(waterMeterInputDetails)){
			throw new BusinessException("数据异常，该批次没有明细数据！");
		}
		
		List<PayOrderInfo> payOrderInfos=new ArrayList<PayOrderInfo>();
		for(PayWaterMeterInputDetail waterMeterInputDetail:waterMeterInputDetails){
			PayOrderInfo orderInfo=new PayOrderInfo();
			orderInfo.setOrderCode(waterMeterInputDetail.getCode());
			orderInfo.setBuildingCode(waterMeterInputDetail.getBuildingCode());
			orderInfo.setRoomNo(waterMeterInputDetail.getRoomNo());
			orderInfo.setMonthlyCycle(waterMeterInputDetail.getMonthlyCycle());
			orderInfo.setWaterBeforeQty(waterMeterInputDetail.getBeforeQty());
			orderInfo.setWaterCurrentQty(waterMeterInputDetail.getCurrentQty());
			orderInfo.setLastPayDate(new Date(header.getEndDate().getTime()+(1000*60*60*24)));
			PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
			buildingDetailPK.setCode(waterMeterInputDetail.getBuildingCode());
			buildingDetailPK.setRoomNo(waterMeterInputDetail.getRoomNo());
			//获取楼宇明细
			PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
			//记录该房间月度吨数
			buildingDetail.setMonthlyQty(waterMeterInputDetail.getCurrentQty());
			buildingDetailDao.update(buildingDetail);
			
			//实际用水吨数
			BigDecimal auctalQty=waterMeterInputDetail.getCurrentQty().subtract(waterMeterInputDetail.getBeforeQty());
			//用水小于1吨按1吨计算
			if(auctalQty.compareTo(new BigDecimal(1))==-1){
				auctalQty=new BigDecimal(1);
			}
			orderInfo.setActualQty(auctalQty);
			//获取分摊类型
			PayApportionType apportionType=apportionTypeDao.get(buildingDetail.getApportionTypeId());
			//计算分摊数量
			BigDecimal waterApportionQty=(auctalQty).multiply(apportionType.getPercent());
			orderInfo.setWaterApportionQty(waterApportionQty);
			//获取计价金额
			PayPricingType pricingType=pricingTypeDao.get(buildingDetail.getPricingTypeId());
			BigDecimal price=pricingType.getPrice();
			orderInfo.setPrice(price);
			
			//计算水费
			BigDecimal waterPrice=((auctalQty).multiply(price)).setScale(1,BigDecimal.ROUND_HALF_UP);
			orderInfo.setWaterPrice(waterPrice);
			//计算分摊费
			BigDecimal apportionPrice=(orderInfo.getWaterApportionQty().multiply(price)).setScale(1,BigDecimal.ROUND_HALF_UP);
			orderInfo.setApportionPrice(apportionPrice);

			orderInfo.setLateFee(new BigDecimal(0));
			orderInfo.setGarbagePrice(waterMeterInputDetail.getGarbagePrice());
			orderInfo.setNetworkPrice(waterMeterInputDetail.getNetworkPrice());
			orderInfo.setSewagePrice(waterMeterInputDetail.getSewagePrice());
			orderInfo.setOtherPrice(waterMeterInputDetail.getOtherPrice());
			//计算总价
			BigDecimal totalPrice=waterPrice
					.add(apportionPrice)
					.add(orderInfo.getLateFee())
					.add(orderInfo.getGarbagePrice())
					.add(orderInfo.getNetworkPrice())
					.add(orderInfo.getSewagePrice())
					.add(orderInfo.getOtherPrice());
			orderInfo.setTotalPrice(formatPrice(totalPrice));
			orderInfo.setStatus(PayConstants.ORDER_STATUS_UNPAY);
			orderInfo.setCreateUser(ContextHolder.getLoginUserName());
			orderInfo.setCreateTime(new Date());
			orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
			orderInfo.setLastModifyTime(new Date());
			payOrderInfos.add(orderInfo);
		}
		
		orderInfoDao.saveAll(payOrderInfos);
		
		
		header.setStatus(PayConstants.INPUT_DATA_STATUS_CONFIRM);
		header.setLastModifyUser(ContextHolder.getLoginUserName());
		header.setLastModifyTime(new Date());
		waterMeterInputHeaderDao.update(header);

		
	}
	
	/*
	 * 检查是否有小数，有小数默认进一位
	 */
	private BigDecimal formatPrice(BigDecimal price){
		String formatPrice=price.toString();
		String[] ary=formatPrice.split("\\.");
		
		if(ary.length>0){
			
			Integer before=Integer.parseInt(ary[0]);
			Integer after=Integer.parseInt(ary[1]);
			
			if(after>0){
				return new BigDecimal(before+1); 
			}
		}
		return price;
	}
	
	/**
	 * 删除批次
	 * @param payWaterMeterInputHeader
	 */
	@DataResolver
	public void delete(Map<String,Object> params){
		
		if(MapUtils.isNotEmpty(params)){
			String code=(String)params.get("code");
			PayWaterMeterInputHeader header= waterMeterInputHeaderDao.get(code);
			if(header==null){
				throw new BusinessException("该批次不存在！");
			}
			if(header.getStatus()==PayConstants.INPUT_DATA_STATUS_CONFIRM ||header.getStatus()==PayConstants.INPUT_DATA_STATUS_COMPLETE){
				throw new BusinessException("状态不正确，不能删除！");
			}
			waterMeterInputHeaderDao.delete(code);
			waterMeterInputBuildingDao.deleteByCode(code);
			waterMeterInputDetailDao.deleteByCode(code);
		}
		
	}
	

	
	/**
	 * 获取状态关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<String, String> getStatusDesc() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("0", "新单");
		mapValue.put("1", "录入中");
		mapValue.put("2", "已确认");
		return mapValue;
	}
	
	public static void main(String[] args){
		BigDecimal bd = BigDecimal.valueOf(20.00);
		System.out.println(new DecimalFormat("#.####").format(bd));
	}
}
