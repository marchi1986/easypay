package com.pay.dao.waterpay;

import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayReplaceWaterMeterHistory;

public interface ReplaceWaterMeterHistoryDao extends IBaseDao<PayReplaceWaterMeterHistory, Integer> {

	public void queryForCondition(Page<PayReplaceWaterMeterHistory> page, Map<String, Object> params) ;
}
