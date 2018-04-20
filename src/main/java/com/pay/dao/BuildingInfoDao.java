package com.pay.dao;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayBuildingInfo;

public interface BuildingInfoDao extends IBaseDao<PayBuildingInfo, String>{

	public void queryPageForCondition(Page<PayBuildingInfo> page, Map<String, Object> params) ;
	
	public List<PayBuildingInfo> queryForCondition(Map<String, Object> params);
}
