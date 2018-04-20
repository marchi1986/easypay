package com.pay.waterpay.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.PayConstants;
import com.pay.exception.BusinessException;
import com.pay.waterpay.dao.WaterMeterPaymentOrderDao;
import com.pay.waterpay.service.WaterMeterPaymentOrderService;

/**
 * 水费缴费订单业务
 * @author marchi.ma
 *
 */
@Service("waterMeterPaymentOrderService")
public class WaterMeterPaymentOrderServiceImpl implements WaterMeterPaymentOrderService{

	private static final Logger logger = Logger.getLogger(WaterMeterPaymentOrderServiceImpl.class);
	
//	@Autowired
//	private WaterMeterPaymentOrderDao waterMeterPaymentOrderDao;
//
//	/**
//	 * 按条件分页查询
//	 * @author marchi.ma
//	 * @param page,params
//	 */
//	@DataProvider
//	public void queryForCondition(Page<WaterMeterPaymentOrder> page,Map<String, Object> params) {
//		try{
//			waterMeterPaymentOrderDao.queryForCondition(page, params);
//		}catch(Exception e){
//			e.printStackTrace();
//			logger.error("分页查询缴费订单出错！",e);
//		}
//		
//	}
//	
//	/**
//	 * 分页查询
//	 * @author marchi.ma
//	 * @param page,params
//	 */
//	@DataProvider
//	public void queryForCondition(Page<WaterMeterPaymentOrder> page) {
//		try{
//			waterMeterPaymentOrderDao.queryForCondition(page, null);
//		}catch(Exception e){
//			e.printStackTrace();
//			logger.error("分页查询缴费订单出错！",e);
//		}
//		
//	}
//	
//
//	
//	/**
//	 * 生成月度水费单
//	 * @param params
//	 */
//	@DataResolver
//	public void createMonthlyOrder(Map<String, Object> params)throws BusinessException{
//		
//		Date monthlyCycle=(Date)params.get("monthlyCycle");
//		
//		if(monthlyCycle==null){
//			logger.error("生成水费月度周期不能为空!");
//			throw new BusinessException("生成水费月度周期不能为空!");
//		}
//			
//		Calendar c=Calendar.getInstance();
//		c.setTime(monthlyCycle);
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
//		int currentMonthlyCycle =Integer.parseInt(sdf.format(c.getTime()));
//		
//		long count=waterMeterPaymentOrderDao.queryCountByMonthlyCycle(currentMonthlyCycle);
//		
//		if(count!=0){
//			logger.error("当前月度周期已生成订单!");
//			throw new BusinessException("当前月度周期已生成订单!");
//		}
//		
//		
//		c.add(Calendar.MONTH, -1);
//		int beforeMonthlyCycle =Integer.parseInt(sdf.format(c.getTime()));
//		
//			
//		List<WaterMeterPaymentOrder> waterMeterPaymentOrders=waterMeterPaymentOrderDao.genOrderList(currentMonthlyCycle, beforeMonthlyCycle);
//		if(CollectionUtils.isEmpty(waterMeterPaymentOrders)){
//			logger.error("数据异常!");
//			throw new BusinessException("数据异常!");
//		}
//		
//		waterMeterPaymentOrderDao.saveAll(waterMeterPaymentOrders);
//		
//
//	}
//	
//	/**
//	 * 根据月度周期查询水费录入列表
//	 * @param params
//	 * @return
//	 */
//	@DataProvider
//	public List<WaterMeterPaymentOrder> queryInputListByMonthCycle(Map<String, Object> params){
//		Date monthlyCycle=(Date)params.get("monthlyCycle");
//		
//		if(monthlyCycle==null){
//			logger.error("查询条件月度周期不能为空!");
//			throw new BusinessException("查询条件月度周期不能为空!");
//			
//		}
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
//		int currentMonthlyCycle =Integer.parseInt(sdf.format(monthlyCycle.getTime()));
//		
//		List<WaterMeterPaymentOrder> waterMeterPaymentOrders=waterMeterPaymentOrderDao.queryInputListByMonthCycle(currentMonthlyCycle);
//		
//		return waterMeterPaymentOrders;
//	}
//	
//	/**
//	 * 保存
//	 * @param params
//	 * @return
//	 */
//	@DataResolver
//	public void saveAll(List<WaterMeterPaymentOrder> waterMeterPaymentOrders){
//		
//		for(WaterMeterPaymentOrder waterMeterPaymentOrder:waterMeterPaymentOrders){
//			waterMeterPaymentOrder.setLastModifyUser(ContextHolder.getLoginUserName());
//			waterMeterPaymentOrder.setLastModifyTime(new Date());
//			waterMeterPaymentOrderDao.update(waterMeterPaymentOrder);
//		}
//		
//	}
//	
//	/**
//	 * 确认订单
//	 * @param params
//	 */
//	@DataResolver
//	public void confirmOrder(Map<String, Object> params){
//		Date monthlyCycle=(Date)params.get("monthlyCycle");
//		
//		if(monthlyCycle==null){
//			logger.error("查询条件月度周期不能为空!");
//			throw new BusinessException("查询条件月度周期不能为空!");
//			
//		}
//		
//		Calendar c=Calendar.getInstance();
//		c.setTime(monthlyCycle);
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
//		int currentMonthlyCycle =Integer.parseInt(sdf.format(c.getTime()));
//		
//		this.waterMeterPaymentOrderDao.updateStatus(currentMonthlyCycle, PayConstants.PAYMENT_ORDER_STATUS_NEW, PayConstants.PAYMENT_ORDER_STATUS_UNPAY);
//	}
}
