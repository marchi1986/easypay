package com.pay.service;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayBuildingInfo;


public interface BuildingInfoService {

	public void queryPageForCondition(Page<PayBuildingInfo> page, Map<String, Object> patameter) ;
	
	public void queryPageForCondition(Page<PayBuildingInfo> page) ;
	
    public void saveAll(List<PayBuildingInfo> buildingInfos);
    
    public PayBuildingInfo get(String code) ;
    
    public Map<String, String> getStatusDesc() ;
}
