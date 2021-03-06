package com.pay.service.impl.waterpay;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.config.BdfNamespaceHandler;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.common.rxtx.ClientDisplay;
import com.pay.common.CommonUtils;
import com.pay.common.DateUtils;
import com.pay.common.PayConstants;
import com.pay.common.print.PaymentReceiptForPrint;
import com.pay.common.print.PaymentReceiptForPrint2;
import com.pay.dao.BuildingDetailDao;
import com.pay.dao.BuildingInfoDao;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.dao.waterpay.PayInfoDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.exception.BusinessException;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayBuildingInfo;
import com.pay.pojo.waterpay.PayInfo;
import com.pay.pojo.waterpay.PayOrderInfo;
import com.pay.pojo.waterpay.PayOrderInfoPK;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;
import com.pay.service.waterpay.OrderInfoService;

@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

	private static final Logger logger = Logger.getLogger(OrderInfoServiceImpl.class);
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private BuildingDetailDao buildingDetailDao;
	
	@Autowired
	private BuildingInfoDao buildingInfoDao;
	
	@Autowired
	private PayInfoDao payInfoDao;

	
	@Autowired
	private WaterMeterInputHeaderDao waterMeterInputHeaderDao;
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayOrderInfo> page,Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			if(parameter.get("monthlyCycle")!=null){
				Date monthly=(Date)parameter.get("monthlyCycle");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
				String dateFormat= sdf.format(monthly);
				parameter.put("monthly", Integer.parseInt(dateFormat));
			}
			
		}
		

		
		orderInfoDao.queryPageForCondition(page, parameter);
		/*
		 * 暂不需要计算滞纳金
		Integer yearMonth=null;
		PayWaterMeterInputHeader inputHeader=null;
		for(PayOrderInfo orderInfo:page.getEntities()){
			Integer currentOrderMonthlyCycle=orderInfo.getMonthlyCycle();
			if(yearMonth==null||currentOrderMonthlyCycle!=yearMonth){
				inputHeader=waterMeterInputHeaderDao.getByMonthly(orderInfo.getMonthlyCycle());
			}
			Date now=new Date();
			//缴费日期大于收费结束日期，需要交纳滞纳金
			if(now.compareTo(inputHeader.getEndDate())>0){
				
				int delayDay= (int)((now.getTime()-inputHeader.getEndDate().getTime())/1000/3600/24);
				BigDecimal lateFeeForDay=orderInfo.getTotalPrice().multiply(new BigDecimal(0.0001));
				BigDecimal lateFee=new BigDecimal(delayDay).multiply(lateFeeForDay).setScale(2,RoundingMode.HALF_UP);
				orderInfo.setLateFee(lateFee);
				orderInfo.setTotalPrice(orderInfo.getTotalPrice().add(orderInfo.getLateFee()));
			}
			 
			yearMonth=currentOrderMonthlyCycle;
		}
		*/
	
	}
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public  List<PayOrderInfo> queryForCondition(Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			if(parameter.get("monthlyCycle")!=null){
				Date monthly=(Date)parameter.get("monthlyCycle");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
				String dateFormat= sdf.format(monthly);
				parameter.put("monthly", Integer.parseInt(dateFormat));
			}
			
		}
		

		
		List<PayOrderInfo> payOrders= orderInfoDao.queryForCondition(parameter);
		
/*
		Integer yearMonth=null;
		PayWaterMeterInputHeader inputHeader=null;
		for(PayOrderInfo orderInfo:payOrders){
			Integer currentOrderMonthlyCycle=orderInfo.getMonthlyCycle();
			if(yearMonth==null||currentOrderMonthlyCycle!=yearMonth){
				inputHeader=waterMeterInputHeaderDao.getByMonthly(orderInfo.getMonthlyCycle());
			}
			Date now=new Date();
			//缴费日期大于收费结束日期，需要交纳滞纳金
			if(now.compareTo(inputHeader.getEndDate())>0){
				
				int delayDay= (int)((now.getTime()-inputHeader.getEndDate().getTime())/1000/3600/24);
				BigDecimal lateFeeForDay=orderInfo.getWaterPrice().multiply(new BigDecimal(0.001));
				BigDecimal lateFee=new BigDecimal(delayDay).multiply(lateFeeForDay).setScale(1,RoundingMode.HALF_UP);
				orderInfo.setLateFee(WaterMeterInputHeaderServiceImpl.format8in1(lateFee));
				orderInfo.setTotalPrice(orderInfo.getTotalPrice().add(orderInfo.getLateFee()));
			}
			 
			yearMonth=currentOrderMonthlyCycle;
		}
	*/	
		return payOrders;
		
	
	}
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public void queryPageArrearsForCondition(Page<PayOrderInfo> page,Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			if(parameter.get("monthlyCycle")!=null){
				Date monthly=(Date)parameter.get("monthlyCycle");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
				String dateFormat= sdf.format(monthly);
				parameter.put("monthly", Integer.parseInt(dateFormat));
			}
			
		}
		parameter.put("isQueryArrears", true);
		
		
		orderInfoDao.queryPageForCondition(page, parameter);

	
	}
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public void queryPagePayForCondition(Page<PayOrderInfo> page,Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			if(parameter.get("monthlyCycle")!=null){
				Date monthly=(Date)parameter.get("monthlyCycle");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
				String dateFormat= sdf.format(monthly);
				parameter.put("monthly", Integer.parseInt(dateFormat));

			}
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			String beginDateFormat=sdf2.format(beginDate);
			String endDateFormat=sdf2.format(endDate);
			if(StringUtils.isNotEmpty(beginDateFormat)){
				parameter.put("beginPayDay", Integer.parseInt(beginDateFormat));
			}
			if(StringUtils.isNotEmpty(endDateFormat)){
				parameter.put("endPayDay", Integer.parseInt(endDateFormat));
			}

			
		}
		parameter.put("isQueryArrears", false);
		parameter.put("status", 1);
		
		
		orderInfoDao.queryPageForCondition(page, parameter);

	
	}
	
	
	
	/**
	 * 缴费
	 * @param orderInfos
	 */
	@DataResolver
	public void pay(List<PayInfo> paymentInfos,List<PayOrderInfo> orderInfos)throws BusinessException{
		
		
		
		try{
			if(CollectionUtils.isNotEmpty(paymentInfos)&& CollectionUtils.isNotEmpty(orderInfos)){
	
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
				SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
				String payCode= "WP"+sdf.format(new Date());

				
				for(PayOrderInfo orderInfo:orderInfos){

					Integer isPay=orderInfoDao.findByPay(orderInfo.getOrderCode(), orderInfo.getUserCode());
					if(isPay>0){
						throw new BusinessException("用户:"+orderInfo.getUserCode()+"该月度:"+orderInfo.getMonthlyCycle()+"已缴费!");
					}
					
					
					PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
					buildingDetailPK.setCode(orderInfo.getBuildingCode());
					buildingDetailPK.setRoomNo(orderInfo.getRoomNo());
					PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
					buildingDetail.setGarbagePrice(orderInfo.getGarbagePrice().intValue());
					buildingDetail.setNetworkPrice(orderInfo.getNetworkPrice().intValue());

					buildingDetail.setMonthlyQty(orderInfo.getWaterCurrentQty());
					

					buildingDetailDao.update(buildingDetail);
					
					orderInfo.setPayDate(new Date());
					orderInfo.setPayDay(Integer.parseInt(sdf2.format(new Date())));
					orderInfo.setTollCollector(ContextHolder.getLoginUser().getCname());
					orderInfo.setStatus(PayConstants.ORDER_STATUS_PAY);
					orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
					orderInfo.setLastModifyTime(new Date());
					orderInfo.setLastPayDate(new Date());
					orderInfo.setPayCode(payCode);
					orderInfoDao.update(orderInfo);
					if(orderInfo.getMonthlyCycle()>202009){
						print2(orderInfo);
					}else{
						print(orderInfo);
					}
					
				}
				
	
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new BusinessException(e.getMessage());
		}
	}
	
	@DataProvider
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> parameter){
		if(MapUtils.isNotEmpty(parameter)){
			if(parameter.get("monthlyCycle")!=null){
				Date monthly=(Date)parameter.get("monthlyCycle");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
				String dateFormat= sdf.format(monthly);
				parameter.put("monthly", Integer.parseInt(dateFormat));
			}
			
		}
		
		List<PayOrderInfo> result= orderInfoDao.querySummaryForCondition(parameter);
		return result;
	}
	
	@DataResolver
	public void printList(List<PayOrderInfo> orderInfos){
		for(PayOrderInfo orderInfo:orderInfos){
			if(orderInfo.getMonthlyCycle()>202009){

				print2(orderInfo);
			}else{
				print(orderInfo);
			}
			
		}
	}
	
	/**
	 * 调用顾显屏
	 * @param parameter
	 */
	@Expose
	public void sendDisplay(Map<String, Object> parameter){
		try {
			ClientDisplay.sendDisplay(parameter);
		} catch (Exception e) {
			logger.error("调用顾显屏出错！",e);
		}
	}
	
	private void print(PayOrderInfo orderInfo){
		PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
		buildingDetailPK.setCode(orderInfo.getBuildingCode());
		buildingDetailPK.setRoomNo(orderInfo.getRoomNo());
		PayBuildingDetail buildingDetail=buildingDetailDao.get(buildingDetailPK);
		
		PaymentReceiptForPrint paymentReceiptForPrint = new PaymentReceiptForPrint();
		paymentReceiptForPrint.setOrderNo(orderInfo.getOrderCode().substring(0,10)+orderInfo.getBuildingCode()+orderInfo.getRoomNo());
		paymentReceiptForPrint.setUserCode(buildingDetail.getCode()+buildingDetail.getRoomNo());
		paymentReceiptForPrint.setWaterMeterCode(buildingDetail.getWaterMeterCode());
		PayWaterMeterInputHeader inputHeader= waterMeterInputHeaderDao.get(orderInfo.getOrderCode());
		SimpleDateFormat sdf=new SimpleDateFormat("M");	
		paymentReceiptForPrint.setBillingPeriod(sdf.format(inputHeader.getBeginDate()) +"月");
		//PayBuildingInfo buildingInfo=buildingInfoDao.get(orderInfo.getBuildingCode());
		paymentReceiptForPrint.setAddr(buildingDetail.getAddr());
		paymentReceiptForPrint.setUserName(buildingDetail.getUserName());
		paymentReceiptForPrint.setBeforeQty(orderInfo.getWaterBeforeQty());
		paymentReceiptForPrint.setCurrentQty(orderInfo.getWaterCurrentQty());
		paymentReceiptForPrint.setActualQty(orderInfo.getActualQty());
		paymentReceiptForPrint.setApportionQty(orderInfo.getWaterApportionQty());
		paymentReceiptForPrint.setTotalQty(orderInfo.getActualQty().add(orderInfo.getWaterApportionQty()));
		paymentReceiptForPrint.setPrice(orderInfo.getPrice());
		paymentReceiptForPrint.setAmount(orderInfo.getWaterPrice());
		paymentReceiptForPrint.setGarbagePrice(orderInfo.getGarbagePrice());
		paymentReceiptForPrint.setNetworkPrice(orderInfo.getNetworkPrice());
		paymentReceiptForPrint.setSewagePrice(orderInfo.getSewagePrice());
		paymentReceiptForPrint.setOtherPrice(orderInfo.getOtherPrice());
		paymentReceiptForPrint.setTotalAmountCN(CommonUtils.change(orderInfo.getTotalPrice().doubleValue()));
		//杂费小计
		BigDecimal amonut2=orderInfo.getGarbagePrice().add(orderInfo.getNetworkPrice().add(orderInfo.getSewagePrice().add(orderInfo.getOtherPrice())));
		paymentReceiptForPrint.setAmonut2(amonut2);
		paymentReceiptForPrint.setOverdueAmount(orderInfo.getLateFee());
		//总计
		paymentReceiptForPrint.setTotalAmountFoot(orderInfo.getTotalPrice());
		
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		
		paymentReceiptForPrint.setYear(String.valueOf(c.get(Calendar.YEAR)));
		paymentReceiptForPrint.setMonth(String.valueOf(c.get(Calendar.MONTH)));
		paymentReceiptForPrint.setDay(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));

		
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(590, 420); // A5纸张大小
		p.setImageableArea(10, 10, 590, 420); // A5
		pf.setPaper(p);
				
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(paymentReceiptForPrint, pf);
		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		try {
			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			// boolean a=job.printDialog();
			// if(a)
				// {
			job.print();
					// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
	private void print2(PayOrderInfo orderInfo){
		PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
		buildingDetailPK.setCode(orderInfo.getBuildingCode());
		buildingDetailPK.setRoomNo(orderInfo.getRoomNo());
		PayBuildingDetail buildingDetail=buildingDetailDao.get(buildingDetailPK);
		
		PaymentReceiptForPrint2 paymentReceiptForPrint = new PaymentReceiptForPrint2();
		paymentReceiptForPrint.setOrderNo(orderInfo.getOrderCode().substring(0,10)+orderInfo.getBuildingCode()+orderInfo.getRoomNo());
		paymentReceiptForPrint.setUserCode(buildingDetail.getCode()+buildingDetail.getRoomNo());
		paymentReceiptForPrint.setWaterMeterCode(buildingDetail.getWaterMeterCode());
		PayWaterMeterInputHeader inputHeader= waterMeterInputHeaderDao.get(orderInfo.getOrderCode());
		SimpleDateFormat sdf=new SimpleDateFormat("M");	
		paymentReceiptForPrint.setBillingPeriod(sdf.format(inputHeader.getBeginDate()) +"月");
		//PayBuildingInfo buildingInfo=buildingInfoDao.get(orderInfo.getBuildingCode());
		paymentReceiptForPrint.setAddr(buildingDetail.getAddr());
		paymentReceiptForPrint.setUserName(buildingDetail.getUserName());
		paymentReceiptForPrint.setBeforeQty(orderInfo.getWaterBeforeQty());
		paymentReceiptForPrint.setCurrentQty(orderInfo.getWaterCurrentQty());
		paymentReceiptForPrint.setActualQty(orderInfo.getActualQty());
		paymentReceiptForPrint.setApportionQty(orderInfo.getWaterApportionQty());
		paymentReceiptForPrint.setTotalQty(orderInfo.getFeeQty());
		paymentReceiptForPrint.setPrice(orderInfo.getPrice());
		paymentReceiptForPrint.setAmount(orderInfo.getWaterPrice());
		paymentReceiptForPrint.setGarbagePrice(orderInfo.getGarbagePrice());
		paymentReceiptForPrint.setNetworkPrice(orderInfo.getNetworkPrice());
		paymentReceiptForPrint.setSewagePrice(orderInfo.getSewagePrice());
		paymentReceiptForPrint.setOtherPrice(orderInfo.getOtherPrice());
		paymentReceiptForPrint.setUserCount(orderInfo.getUserCount());
		paymentReceiptForPrint.setApportionPrice(orderInfo.getApportionPrice());
		paymentReceiptForPrint.setApportionAmount(orderInfo.getApportionAmount());
		paymentReceiptForPrint.setTotalAmountCN(CommonUtils.change(orderInfo.getTotalPrice().doubleValue()));
		//杂费小计
		//BigDecimal amonut2=orderInfo.getGarbagePrice().add(orderInfo.getNetworkPrice().add(orderInfo.getSewagePrice().add(orderInfo.getOtherPrice())));
		BigDecimal amonut2=orderInfo.getGarbagePrice().add(orderInfo.getApportionAmount()).add(orderInfo.getOtherPrice());
		paymentReceiptForPrint.setAmonut2(amonut2);
		paymentReceiptForPrint.setOverdueAmount(orderInfo.getLateFee());
		//总计
		paymentReceiptForPrint.setTotalAmountFoot(orderInfo.getTotalPrice());
		
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		
		paymentReceiptForPrint.setYear(String.valueOf(c.get(Calendar.YEAR)));
		paymentReceiptForPrint.setMonth(String.valueOf(c.get(Calendar.MONTH)));
		paymentReceiptForPrint.setDay(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));

		
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(590, 420); // A5纸张大小
		p.setImageableArea(10, 10, 590, 420); // A5
		pf.setPaper(p);
				
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(paymentReceiptForPrint, pf);
		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		try {
			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			// boolean a=job.printDialog();
			// if(a)
				// {
			job.print();
					// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public List<PayOrderInfo> findByPayCode(Map<String,Object> params){
		
		if(MapUtils.isNotEmpty(params)){
			String payCode=(String)params.get("payCode");
			return orderInfoDao.findByPayCode(payCode);
		}else{
			return null;
		}
		
		
	}
	@DataResolver
	public void save(List<PayOrderInfo> orderInfos){
		this.orderInfoDao.updateAll(orderInfos); 
	}
	
	@DataResolver
	public void reject(List<PayOrderInfo> list){
		if(CollectionUtils.isNotEmpty(list)){
			for(PayOrderInfo orderInfo:list){
				

				
				orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
				orderInfo.setLastModifyTime(new Date());
				orderInfo.setPayCode("");
				orderInfo.setPayDate(null);
				orderInfo.setPayDay(null);
				orderInfo.setTollCollector("");
				orderInfo.setRejectUser(ContextHolder.getLoginUser().getEname());
				orderInfo.setRejectDate(new Date());
				orderInfo.setStatus(PayConstants.ORDER_STATUS_UNPAY);
			}
			
			orderInfoDao.updateAll(list);
		}
	}
	@DataProvider
	public List<PayOrderInfo> querySummaryForDay(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			String beginDateFormat= DateUtils.format(beginDate,"yyyy-MM-dd");
			String endDateFormat= DateUtils.format(endDate,"yyyy-MM-dd");
			parameter.put("beginDate", beginDateFormat+" 00:00:00");
			parameter.put("endDate", endDateFormat+" 23:59:59");
		}
		List<PayOrderInfo> list=orderInfoDao.querySummaryDay(parameter);
		return list;
	}
	
	@DataProvider
	public List<PayOrderInfo> querySummaryForDayAndTollCollector(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			String beginDateFormat= DateUtils.format(beginDate,"yyyy-MM-dd");
			String endDateFormat= DateUtils.format(endDate,"yyyy-MM-dd");
			parameter.put("beginDate", beginDateFormat+" 00:00:00");
			parameter.put("endDate", endDateFormat+" 23:59:59");
		}
		List<PayOrderInfo> list=orderInfoDao.querySummaryForDayAndTollCollector(parameter);
		return list;
	}
	
	@DataProvider
	public List<PayOrderInfo> findByPayDayAndTollCollector(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){	
			
			List<PayOrderInfo> list=orderInfoDao.findByPayDayAndTollCollector(parameter);
			return list;
			
		}
		return null;
	}
	
	@DataProvider
	public List<PayOrderInfo> findByPayDay(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){	
			
			List<PayOrderInfo> list=orderInfoDao.findByPayDay(parameter);
			return list;
			
		}
		return null;
	}
	
	public static void main(String[] args){
		
	}
}
