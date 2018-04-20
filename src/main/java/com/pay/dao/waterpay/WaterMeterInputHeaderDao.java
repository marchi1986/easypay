package com.pay.dao.waterpay;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;

public interface WaterMeterInputHeaderDao extends IBaseDao<PayWaterMeterInputHeader, String> {

	/**
	 * 按条件查询
	 * @param parameter
	 * @return
	 */
	public List<PayWaterMeterInputHeader> queryForCondition(Map<String,Object> parameter);
	
	/**
	 * 按条件查询
	 * @param parameter
	 * @return
	 */
	public PayWaterMeterInputHeader getForMonthlyAndStatus(Integer monthly,Integer status);
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputHeader> page,Map<String, Object> parameter) ;
	
	/**
	 * 获取已确认且最大的录入月度
	 * @return
	 */
	public Integer getMaxMonthlyCycle();
	
	/**
	 * 获取当月吨数
	 * @return
	 */
	public BigDecimal getQtyByMonthlyCycle(int monthlyCycle);
	
	/**
	 * 获取上次水费录入编号
	 * @return
	 */
	public String getBeforeCode();
	

}
