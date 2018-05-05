package com.pay.dao.waterpay;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.waterpay.PayInfo;



public interface PayInfoDao extends IBaseDao<PayInfo, String> {
	
	public List<PayInfo> findByPayDate(Date date);
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayInfo> page, Map<String, Object> params) ;
	
	public List<PayInfo> querySummaryForCondition(Map<String, Object> params) ;
}
