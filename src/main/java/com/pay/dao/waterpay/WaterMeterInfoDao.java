package com.pay.dao.waterpay;

import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayWaterMeterInfo;

public interface WaterMeterInfoDao extends IBaseDao<PayWaterMeterInfo, String> {

	public void queryForCondition(Page<PayWaterMeterInfo> page, Map<String, Object> params) ;
}
