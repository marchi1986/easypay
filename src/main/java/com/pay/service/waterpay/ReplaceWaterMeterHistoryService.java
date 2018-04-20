package com.pay.service.waterpay;

import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayReplaceWaterMeterHistory;

public interface ReplaceWaterMeterHistoryService {
	
	/**
	 * 保存
	 * @param payReplaceWaterMeterHistory
	 */
	public void save(PayReplaceWaterMeterHistory payReplaceWaterMeterHistory);
	
	public void queryForCondition(Page<PayReplaceWaterMeterHistory> page, Map<String, Object> params) ;
}
