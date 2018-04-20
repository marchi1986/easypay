package com.pay.service.waterpay;

import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;

public interface WaterMeterInputHeaderService {
	

	/**
	 * 创建水费录入记录
	 * @param params
	 */
	public void create(Map<String,Object> params);
	
	public void queryPageForCondition(Page<PayWaterMeterInputHeader> page,Map<String, Object> parameter);
	
	public Map<String, String> getStatusDesc() ;
	
	/**
	 * 确认后生成订单
	 * @param payWaterMeterInputHeader
	 */
	public void confirm(Map<String,Object> params);
	
	/**
	 * 删除批次
	 * @param params
	 */
	public void delete(Map<String,Object> params);
}
