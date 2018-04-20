package com.pay.service.waterpay;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;

public interface WaterMeterInputDetailService {

	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputDetail> page,Map<String, Object> parameter) ;
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param waterMeterInputDetails
	 */
    public void saveAll(List<PayWaterMeterInputDetail> waterMeterInputDetails);
    
    /**
	 * 保存录入明细
	 * @param waterMeterInputDetails
	 */
	@DataResolver
	public void saveInputDetail(List<PayWaterMeterInputDetail> waterMeterInputDetails,Map<String,Object> parameter);
}
