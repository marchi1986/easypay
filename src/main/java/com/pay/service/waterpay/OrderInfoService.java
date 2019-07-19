package com.pay.service.waterpay;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayInfo;
import com.pay.pojo.waterpay.PayOrderInfo;

public interface OrderInfoService {
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	public void queryPageForCondition(Page<PayOrderInfo> page,Map<String, Object> parameter) ;
	
	/**
	 * 缴费
	 * @param orderInfos
	 */
	public void pay(List<PayInfo> paymentInfos,List<PayOrderInfo> orderInfos);
	
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> parameter);
	
	/**
	 * 打印
	 * @param orderInfos
	 */
	public void printList(List<PayOrderInfo> orderInfos);
	
	public List<PayOrderInfo> findByPayCode(Map<String,Object> params);
	
	public List<PayOrderInfo> findByPayDayAndTollCollector(Map<String, Object> parameter);
	

	public List<PayOrderInfo> findByPayDay(Map<String, Object> parameter) ;
	
	public void reject(List<PayOrderInfo> list);
	
	public List<PayOrderInfo> querySummaryForDayAndTollCollector(Map<String, Object> parameter) ;
	
	public List<PayOrderInfo> querySummaryForDay(Map<String, Object> parameter) ;
}
