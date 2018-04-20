package com.pay.service;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayApportionType;

public interface ApportionTypeService {

	public void queryForCondition(Page<PayApportionType> page, Map<String, Object> patameter) ;
	
	public void queryForCondition(Page<PayApportionType> page) ;
	
	public List<PayApportionType> queryAll() ;
	
	public Map<Integer, String> getApportionTypeDesc() ;
	
    public void saveAll(List<PayApportionType> apportionTypes);
    
    public void refreshCache();
}
