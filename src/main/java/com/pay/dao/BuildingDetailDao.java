package com.pay.dao;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;

public interface BuildingDetailDao extends IBaseDao<PayBuildingDetail, PayBuildingDetailPK>{

	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayBuildingDetail> page, Map<String, Object> params) ;
	
	public List<PayBuildingDetail> querySqlForCondition(Map<String, Object> params);
	
	/**
	 * 按条件查询
	 * @param page
	 * @param params
	 */
	public List<PayBuildingDetail> queryForCondition(Map<String, Object> params) ;
	
	public void cleanBuildingDetailGroup(int groupId);
}
