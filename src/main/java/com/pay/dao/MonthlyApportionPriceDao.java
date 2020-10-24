package com.pay.dao;

import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayMonthlyApportionPrice;

public interface MonthlyApportionPriceDao extends IBaseDao<PayMonthlyApportionPrice, Integer>{

	public void queryForCondition(Page<PayMonthlyApportionPrice> page, Map<String, Object> params) ;
}
