package com.pay.dao.waterpay;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayOrderInfo;
import com.pay.pojo.waterpay.PayOrderInfoPK;

public interface OrderInfoDao extends IBaseDao<PayOrderInfo, PayOrderInfoPK> {

	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayOrderInfo> page, Map<String, Object> params) ;
	
	public List<PayOrderInfo> queryForCondition(Map<String, Object> params) ;
	
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> params);
	
	public List<PayOrderInfo> findByPayCode(String payCode);
	
	/**
	 * 按每人每日收费汇总
	 */
	public List<PayOrderInfo> querySummaryForDayAndTollCollector(Map<String, Object> params);
	
	public List<PayOrderInfo> findByPayDayAndTollCollector(Map<String,Object> params);
	
	public List<PayOrderInfo> findByPayDay(Map<String,Object> params);
	
	public List<PayOrderInfo> querySummaryDay(Map<String, Object> params) ;
}
