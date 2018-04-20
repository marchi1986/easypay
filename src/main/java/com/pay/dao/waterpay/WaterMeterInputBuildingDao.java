package com.pay.dao.waterpay;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.pojo.waterpay.PayWaterMeterInputBuildingPK;



public interface WaterMeterInputBuildingDao extends IBaseDao<PayWaterMeterInputBuilding, PayWaterMeterInputBuildingPK> {

	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputBuilding> page,Map<String, Object> parameter) ;
	
	/**
	 * 查询初始化数据
	 * @param beforeCode
	 * @return
	 */
	public List<PayWaterMeterInputBuilding> queryInitData(String beforeCode) ;
	
	/**
	 * 更新状态
	 * @param code
	 * @param status
	 */
	public void updateStatusByCode(String code,int status);
	
	/**
	 * @param code
	 * @param buildingCode
	 * @return
	 */
	public PayWaterMeterInputBuilding getByCodeAndBuildCode(String code,String buildingCode);
	
	public void deleteByCode(String code);
}
