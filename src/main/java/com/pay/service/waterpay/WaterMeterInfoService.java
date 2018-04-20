package com.pay.service.waterpay;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayWaterMeterInfo;


public interface WaterMeterInfoService {
	public void queryForCondition(Page<PayWaterMeterInfo> page, Map<String, Object> patameter) ;
	
	public void queryForCondition(Page<PayWaterMeterInfo> page) ;
	
    public void saveAll(List<PayWaterMeterInfo> waterMeterInfos);
    
    /**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 */
	public PayWaterMeterInfo get(String code) ;
    
    public Map<String, String> getStatusDesc() ;

	public Map<String, String> getIsMainDesc(); 
}
