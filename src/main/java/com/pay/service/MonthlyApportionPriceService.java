package com.pay.service;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayMonthlyApportionPrice;

public interface MonthlyApportionPriceService {

	public void queryForCondition(Page<PayMonthlyApportionPrice> page, Map<String, Object> patameter) ;
	
	public void queryForCondition(Page<PayMonthlyApportionPrice> page) ;
	
	public List<PayMonthlyApportionPrice> queryAll() ;
	
	
    public void saveAll(List<PayMonthlyApportionPrice> apportionTypes);
    
    public void refreshCache();
}
