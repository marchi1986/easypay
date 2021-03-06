package com.pay.service.impl.waterpay;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
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
import com.pay.dao.MonthlyApportionPriceDao;
import com.pay.dao.PricingTypeDao;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.dao.waterpay.WaterMeterInputBuildingDao;
import com.pay.dao.waterpay.WaterMeterInputDetailDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.exception.BusinessException;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayBuildingInfo;
import com.pay.pojo.PayMonthlyApportionPrice;
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
	
	@Autowired
	private MonthlyApportionPriceDao monthlyApportionPriceDao;
	
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
				String waterMeterCode=buildingDetail.getWaterMeterCode();
				
				List<PayWaterMeterInputDetail> printDetails = new ArrayList<PayWaterMeterInputDetail>();
				//获取每个房号1-12月的抄表记录
				int[] monthlyAry={1,3,5,7,9,11};
				for(int i = 0; i < monthlyAry.length; i++){
					String month = "0"+String.valueOf(monthlyAry[i]);
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
				detailMap.put(buildingDetail.getAddrShortDesc()+"|"+waterMeterCode, printDetails);
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
			createInputInfo(header.getCode(),header.getMonthlyCycle(),buildingInfos);
			
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
			String roomNo=(String)params.get("roomNo");
			
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			Integer monthly2Int=Integer.parseInt(sdf.format(monthly));
			
			
			//查看该月度是否已初始化数据
			PayWaterMeterInputHeader waterMeterInputHeader=waterMeterInputHeaderDao.getByMonthly(monthly2Int);
			
			
			
			if(waterMeterInputHeader!=null){
				if(PayConstants.INPUT_DATA_STATUS_CONFIRM==waterMeterInputHeader.getMonthlyCycle()){
					throw new BusinessException("该批次已确认开始收费！");
				}else{
					if(StringUtils.isNotEmpty(buildingCode)){
						if(StringUtils.isNotEmpty(roomNo)){
							PayWaterMeterInputDetail payWaterMeterInputDetail=waterMeterInputDetailDao.getByCodeAndUserCode(waterMeterInputHeader.getCode(), buildingCode+roomNo);
							if(payWaterMeterInputDetail!=null){
								throw new BusinessException("该批次已存在该楼宇明细信息！");
							}else{
								PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
								buildingDetailPK.setCode(buildingCode);
								buildingDetailPK.setRoomNo(roomNo);
								PayBuildingDetail buildingDetail=buildingDetailDao.get(buildingDetailPK);
								if(buildingDetail!=null){
									payWaterMeterInputDetail=getDetail(waterMeterInputHeader.getCode(),monthly2Int,buildingDetail);
									waterMeterInputDetailDao.save(payWaterMeterInputDetail);
								}else{
									throw new BusinessException("该楼宇房间不存在！");
								}
							}
						}else{
							//查询该批次是否存在该楼宇录入记录
							PayWaterMeterInputBuilding waterMeterInputBuilding=waterMeterInputBuildingDao.getByCodeAndBuildCode(waterMeterInputHeader.getCode(), buildingCode);
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
								createInputInfo(waterMeterInputHeader.getCode(),waterMeterInputHeader.getMonthlyCycle(),buildingInfos);
							}
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
	private void createInputInfo(String code,Integer monthly, List<PayBuildingInfo> buildingInfos){
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
				//Map<Integer,PayPricingType> pricingTypeMap=pricingTypeService.queryApportionTypeForMap();
				for(PayBuildingDetail buildingDetail:buildingDetails){
					if(PayConstants.ENABLED_STATUS==buildingDetail.getStatus()){
						waterMeterInputDetails.add(getDetail(code,monthly,buildingDetail));
					}
				}
				waterMeterInputBuildingDao.save(waterMeterInputBuilding);
				waterMeterInputDetailDao.saveAll(waterMeterInputDetails);	
			}
			
			//-------------------水费录入楼宇明细信息--------------------
		}
	}
	
	private PayWaterMeterInputDetail getDetail(String code,Integer monthly,PayBuildingDetail buildingDetail){
		PayWaterMeterInputDetail waterMeterInputDetail=new PayWaterMeterInputDetail();
		waterMeterInputDetail.setCode(code);
		waterMeterInputDetail.setMonthlyCycle(monthly);
		waterMeterInputDetail.setBuildingCode(buildingDetail.getCode());
		waterMeterInputDetail.setRoomNo(buildingDetail.getRoomNo());
		waterMeterInputDetail.setWaterMeterCode(buildingDetail.getWaterMeterCode());
		waterMeterInputDetail.setBeforeQty(buildingDetail.getMonthlyQty()==null?new BigDecimal(0):buildingDetail.getMonthlyQty());
		waterMeterInputDetail.setCurrentQty(new BigDecimal(0));
		waterMeterInputDetail.setSewagePrice(new BigDecimal(0));
		waterMeterInputDetail.setOtherPrice(new BigDecimal(0));
		waterMeterInputDetail.setStatus(PayConstants.INPUT_DATA_STATUS_NEW);
		waterMeterInputDetail.setCreateUser(ContextHolder.getLoginUserName());
		waterMeterInputDetail.setCreateTime(new Date());
		waterMeterInputDetail.setLastModifyUser(ContextHolder.getLoginUserName());
		waterMeterInputDetail.setLastModifyTime(new Date());
		waterMeterInputDetail.setNetworkPrice(new BigDecimal(buildingDetail.getNetworkPrice()==null?0:buildingDetail.getNetworkPrice()));
		waterMeterInputDetail.setGarbagePrice(new BigDecimal(buildingDetail.getGarbagePrice()==null?0:buildingDetail.getGarbagePrice()));
		waterMeterInputDetail.setUserCode(buildingDetail.getUserCode());
		
		return waterMeterInputDetail;
	}
	
	/**
	 * 确认后生成订单
	 * @param payWaterMeterInputHeader
	 */
	@DataResolver
	public void confirm(Map<String,Object> params)throws BusinessException{
		try{
		
			String code=(String)params.get("code");
			PayWaterMeterInputHeader header= waterMeterInputHeaderDao.get(code);
			
			if(PayConstants.INPUT_DATA_STATUS_INPUT!=header.getStatus()){
				throw new BusinessException("状态不正确，不能确认！");
			}
			
			List<PayWaterMeterInputDetail> waterMeterInputDetails=waterMeterInputDetailDao.queryForCondition(params);
			
			if(CollectionUtils.isEmpty(waterMeterInputDetails)){
				throw new BusinessException("数据异常，该批次没有明细数据！");
			}
			PayMonthlyApportionPrice monthlyApportionPrice=null;
			if(header.getMonthlyCycle()>202009){
				monthlyApportionPrice= monthlyApportionPriceDao.get(header.getMonthlyCycle());
				if(monthlyApportionPrice==null){
					throw new BusinessException("请先维护月度摊分单价！");
				}
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
				orderInfo.setUserCode(waterMeterInputDetail.getUserCode());
				
				PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
				buildingDetailPK.setCode(waterMeterInputDetail.getBuildingCode());
				buildingDetailPK.setRoomNo(waterMeterInputDetail.getRoomNo());
				//获取楼宇明细
				PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
				if(buildingDetail==null){
					throw new BusinessException(waterMeterInputDetail.getBuildingCode()+"-"+waterMeterInputDetail.getRoomNo()+"不存在！");
				}
				orderInfo.setUserName(buildingDetail.getUserName());
				orderInfo.setAddr(buildingDetail.getAddr());
				orderInfo.setWaterMeterCode(buildingDetail.getWaterMeterCode());
				//记录该房间月度吨数
				buildingDetail.setMonthlyQty(waterMeterInputDetail.getCurrentQty());
				buildingDetail.setGarbagePrice(waterMeterInputDetail.getGarbagePrice()==null?0:waterMeterInputDetail.getGarbagePrice().intValue());
				buildingDetail.setNetworkPrice(waterMeterInputDetail.getNetworkPrice()==null?0:waterMeterInputDetail.getNetworkPrice().intValue());
				buildingDetailDao.update(buildingDetail);
				BigDecimal auctalQty=BigDecimal.ZERO;
				//实际用水吨数
				if(waterMeterInputDetail.getCurrentQty().compareTo(BigDecimal.ZERO)!=0){
					auctalQty=waterMeterInputDetail.getCurrentQty().subtract(waterMeterInputDetail.getBeforeQty());
					//用水小于1吨按1吨计算
					if(auctalQty.compareTo(BigDecimal.ZERO)!=0&&auctalQty.compareTo(new BigDecimal(1))==-1){
						auctalQty=new BigDecimal(1);
					}else{
						orderInfo.setActualQty(BigDecimal.ZERO);
					}
				}
				orderInfo.setActualQty(auctalQty);
				
				//水费金额已包含损耗费，所以不再另计
				//获取分摊类型
				//PayApportionType apportionType=apportionTypeDao.get(buildingDetail.getApportionTypeId());
				//计算分摊数量
				//BigDecimal waterApportionQty=(auctalQty).multiply(apportionType.getPercent());
				//orderInfo.setWaterApportionQty(waterApportionQty);
				orderInfo.setWaterApportionQty(new BigDecimal(0));
				//获取计价金额
				PayPricingType pricingType=pricingTypeDao.get(buildingDetail.getPricingTypeId());
				BigDecimal price=pricingType.getPrice();
				orderInfo.setPrice(price);
				
				//计算水费
				//BigDecimal waterPrice=((auctalQty.add(waterApportionQty)).multiply(price)).setScale(1,BigDecimal.ROUND_HALF_UP);
				//计费用水量 实际用水+实际用水的16.31%
				BigDecimal feeQty=auctalQty.add(auctalQty.multiply(new BigDecimal("0.1631")).setScale(4,BigDecimal.ROUND_HALF_UP));
				orderInfo.setFeeQty(feeQty);
				BigDecimal waterPrice=((feeQty).multiply(price)).setScale(1,BigDecimal.ROUND_HALF_UP);
				//int i = (int)Math.ceil(waterPrice.doubleValue());
				//修改为逢8进1
				orderInfo.setWaterPrice(format8in1(waterPrice));
				//计算分摊费
				//BigDecimal apportionPrice=(orderInfo.getWaterApportionQty().multiply(price)).setScale(1,BigDecimal.ROUND_HALF_UP);
				if(monthlyApportionPrice!=null){
					orderInfo.setApportionPrice(monthlyApportionPrice.getPrice());
					orderInfo.setApportionAmount(BigDecimal.ZERO);
					if(buildingDetail.getIsCountApportion()==1){
						
						if(buildingDetail.getUserCount()!=null){
							BigDecimal apportionAmount=new BigDecimal(buildingDetail.getUserCount()).multiply(monthlyApportionPrice.getPrice());
							orderInfo.setApportionAmount(apportionAmount);
							orderInfo.setUserCount(buildingDetail.getUserCount());
						}
	
					}
				}else{
					orderInfo.setApportionAmount(BigDecimal.ZERO);
				}
				
				orderInfo.setLateFee(new BigDecimal(0));
				orderInfo.setGarbagePrice(waterMeterInputDetail.getGarbagePrice());
				orderInfo.setNetworkPrice(waterMeterInputDetail.getNetworkPrice());
				orderInfo.setSewagePrice(waterMeterInputDetail.getSewagePrice());
				orderInfo.setOtherPrice(waterMeterInputDetail.getOtherPrice());
				//计算总价
				BigDecimal totalPrice=waterPrice
						//.add(apportionPrice)
						.add(orderInfo.getLateFee())
						.add(orderInfo.getGarbagePrice())
						.add(orderInfo.getNetworkPrice())
						.add(orderInfo.getSewagePrice())
						.add(orderInfo.getOtherPrice())
						.add(orderInfo.getApportionAmount());
				orderInfo.setTotalPrice(format8in1(totalPrice) );
				orderInfo.setStatus(PayConstants.ORDER_STATUS_UNPAY);
				orderInfo.setCreateUser(ContextHolder.getLoginUserName());
				orderInfo.setCreateTime(new Date());
				orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
				orderInfo.setLastModifyTime(new Date());
				if(orderInfo.getTotalPrice().compareTo(BigDecimal.ZERO)!=0){
					payOrderInfos.add(orderInfo);
				}
				
			}
			
			orderInfoDao.saveAll(payOrderInfos);
			
			
			header.setStatus(PayConstants.INPUT_DATA_STATUS_CONFIRM);
			header.setLastModifyUser(ContextHolder.getLoginUserName());
			header.setLastModifyTime(new Date());
			waterMeterInputDetailDao.updateStatusByCode(code, PayConstants.INPUT_DATA_BUILDING_STATUS_CONFIRM);
			waterMeterInputBuildingDao.updateStatusByCode(code, PayConstants.INPUT_DATA_BUILDING_STATUS_CONFIRM);
			waterMeterInputHeaderDao.update(header);
			
			
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new BusinessException(e.getMessage());
		}
		
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
	
	public static BigDecimal format8in1(BigDecimal number){
		
		String strNumber=number.setScale(1,BigDecimal.ROUND_HALF_UP).toString();
		if(strNumber.indexOf(".")>0){
			String[] splitAry=strNumber.split("\\.");
			//System.out.println(splitAry.length);
			//System.out.println(splitAry[1]);
			
			if(Integer.parseInt(splitAry[1])>=8){
				BigDecimal newNumber=new BigDecimal(splitAry[0]);
				newNumber=newNumber.add(new BigDecimal(1));
				return newNumber;
			}else{
				BigDecimal newNumber=new BigDecimal(splitAry[0]);
				return newNumber;
			}
			
		}
		return number;
	}
	
	public static void main(String[] args){
		WaterMeterInputHeaderServiceImpl impl=new WaterMeterInputHeaderServiceImpl();
		System.out.println(impl.format8in1(new BigDecimal("872")));
	}
}
