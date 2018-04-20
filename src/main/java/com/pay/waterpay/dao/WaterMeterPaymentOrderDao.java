package com.pay.waterpay.dao;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.exception.BusinessException;


public interface WaterMeterPaymentOrderDao  {

//	/**
//	 * 按条件分页查询
//	 * @param page
//	 * @param params
//	 * @throws BusinessException
//	 */
//	public void queryForCondition(Page<WaterMeterPaymentOrder> page, Map<String, Object> params) throws BusinessException ;
//	
//	/**
//	 * 生成本季度水费订单
//	 * @param currentMonthly,beforeMonthlyCycle
//	 * @return
//	 */
//	public List<WaterMeterPaymentOrder> genOrderList(int currentMonthlyCycle, int beforeMonthlyCycle);
//	
//	/**
//	 * 根据月度周期查询水费录入列表
//	 * @param monthlyCycle
//	 * @return
//	 */
//	public List<WaterMeterPaymentOrder> queryInputListByMonthCycle(int monthlyCycle);
//	
//	/**
//	 * 查询该月度订单记录数
//	 * @param monthlyCycle
//	 * @return
//	 */
//	public long queryCountByMonthlyCycle(int monthlyCycle);
//	
//	/**
//	 * 更新状态
//	 * @param monthlyCycle
//	 * @param oldStatus
//	 * @param newStatus
//	 */
//	public void updateStatus(int monthlyCycle, int oldStatus,int newStatus);
}
