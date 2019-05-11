package com.pay.service.impl.waterpay;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.common.rxtx.ClientDisplay;
import com.pay.common.CommonUtils;
import com.pay.common.PayConstants;
import com.pay.common.print.PaymentReceiptForPrint;
import com.pay.dao.BuildingDetailDao;
import com.pay.dao.BuildingInfoDao;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.dao.waterpay.PayInfoDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayBuildingInfo;
import com.pay.pojo.waterpay.PayInfo;
import com.pay.pojo.waterpay.PayOrderInfo;
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
		

		
		return orderInfoDao.queryForCondition(parameter);
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
	 * 缴费
	 * @param orderInfos
	 */
	@DataResolver
	public void pay(List<PayInfo> paymentInfos,List<PayOrderInfo> orderInfos){
		
		
		
		
		if(CollectionUtils.isNotEmpty(paymentInfos)&& CollectionUtils.isNotEmpty(orderInfos)){

			PayInfo payInfo=paymentInfos.get(0);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
			String payCode= "WP"+sdf.format(new Date());
			payInfo.setPayCode(payCode);
			payInfo.setPayDate(new Date());
			payInfo.setStatus(0);
			payInfo.setTollCollector(ContextHolder.getLoginUser().getCname());
			payInfo.setCreateUser(ContextHolder.getLoginUserName());
			payInfo.setCreateTime(new Date());
			payInfo.setLastModifyUser(ContextHolder.getLoginUserName());
			payInfo.setLastModifyTime(new Date());

			
			payInfoDao.save(payInfo);
			
			for(PayOrderInfo orderInfo:orderInfos){
				orderInfo.setPayDate(new Date());
				orderInfo.setTollCollector(ContextHolder.getLoginUser().getCname());
				orderInfo.setStatus(PayConstants.ORDER_STATUS_PAY);
				orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
				orderInfo.setLastModifyTime(new Date());
				orderInfo.setPayCode(payCode);
				orderInfoDao.update(orderInfo);
				print(orderInfo);
			}
			

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
			print(orderInfo);
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
	
	public static void main(String[] args){
		
	}
}
