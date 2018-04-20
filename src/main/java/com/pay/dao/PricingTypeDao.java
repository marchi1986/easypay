package com.pay.dao;

import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayPricingType;


public interface PricingTypeDao extends IBaseDao<PayPricingType, Integer> {

	public void queryForCondition(Page<PayPricingType> page, Map<String, Object> params) ;
}
