package com.pay.dao.waterpay;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;
import com.pay.pojo.waterpay.PayWaterMeterInputDetailPK;


public interface WaterMeterInputDetailDao extends IBaseDao<PayWaterMeterInputDetail, PayWaterMeterInputDetailPK> {

	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputDetail> page,Map<String, Object> parameter) ;
	
	/**
	 * 按条件查询
	 * @param parameter
	 */
	public List<PayWaterMeterInputDetail> queryForCondition(Map<String, Object> parameter) ;
	
	/**
	 * 获取录入单某状态的数量
	 * @param parameter
	 * @return
	 */
	public Long getCountForCondition(Map<String, Object> parameter);
	
	/**
	 * 初始化录入数据
	 * @param beforeCode
	 * @return
	 */
	public List<PayWaterMeterInputDetail> queryInitData(String beforeCode);
	
	public BigDecimal getSum(String code,String buildingCode);
	
	/**
	 * 更新状态
	 * @param code
	 * @param status
	 */
	public void updateStatusByCode(String code,int status);
	
	public void deleteByCode(String code);
	
	/**
	 * 
	 * @param userCode
	 * @return
	 */
	public List<PayWaterMeterInputDetail> getByUserCode(String userCode) ;
	
	/**
	 * Get By Code And UserCode
	 * @param code
	 * @param userCode
	 * @return
	 */
	public PayWaterMeterInputDetail getByCodeAndUserCode(String code,String userCode);
}
