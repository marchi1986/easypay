package com.pay.service;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayPricingType;


public interface PricingTypeService {

	public void queryForCondition(Page<PayPricingType> page, Map<String, Object> patameter) ;
	
	public void queryForCondition(Page<PayPricingType> page) ;
	
	public List<PayPricingType> queryAll(); 
	
	public Map<Integer,PayPricingType>  queryApportionTypeForMap();
	
	public Map<Integer, String> getPricingTypeDesc() ;
	
    public void saveAll(List<PayPricingType> pricingTypes);
}
