package com.pay.service.impl.waterpay;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
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
import com.pay.dao.UserDao;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayBuildingInfo;
import com.pay.pojo.PayUser;
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
	private UserDao userDao;
	
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

		

		
	}
	
	/**
	 * 缴费
	 * @param orderInfos
	 */
	@DataResolver
	public void updatePaymentInfo(List<PayOrderInfo> orderInfos){
		if(CollectionUtils.isNotEmpty(orderInfos)){
			for(PayOrderInfo orderInfo:orderInfos){
				orderInfo.setPayDate(new Date());
				orderInfo.setTollCollector(ContextHolder.getLoginUserName());
				orderInfo.setStatus(PayConstants.ORDER_STATUS_PAY);
				orderInfo.setLastModifyUser(ContextHolder.getLoginUserName());
				orderInfo.setLastModifyTime(new Date());
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
		paymentReceiptForPrint.setOrderNo(orderInfo.getOrderCode());
		paymentReceiptForPrint.setWaterMeterCode(buildingDetail.getWaterMeterCode());
		PayWaterMeterInputHeader inputHeader= waterMeterInputHeaderDao.get(orderInfo.getOrderCode());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");	
		paymentReceiptForPrint.setBillingPeriod(sdf.format(inputHeader.getBeginDate()) +"至" +sdf.format(inputHeader.getEndDate()));
		PayBuildingInfo buildingInfo=buildingInfoDao.get(orderInfo.getBuildingCode());
		paymentReceiptForPrint.setAddr(buildingInfo.getAddr()+"("+buildingDetail.getRoomNo()+")");
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
}
