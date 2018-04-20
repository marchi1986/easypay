package com.pay.service.waterpay;

import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;

public interface WaterMeterInputBuildingService {

	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputBuilding> page,Map<String, Object> parameter) ;
	
	/**
	 * 获取状态关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	public Map<String, String> getStatusDesc() ;
}
