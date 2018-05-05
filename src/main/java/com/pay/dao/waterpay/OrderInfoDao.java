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
	
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> params);
	
	public List<PayOrderInfo> findByPayCode(String payCode);
}
