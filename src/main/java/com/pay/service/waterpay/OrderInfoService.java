package com.pay.service.waterpay;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
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
	public void updatePaymentInfo(List<PayOrderInfo> orderInfos);
	
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> parameter);
}
