package com.pay.service;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;


public interface BuildingDetailService {
	
	public PayBuildingDetail get(PayBuildingDetailPK pk);

	public void queryPageForCondition(Page<PayBuildingDetail> page, Map<String, Object> params) ;
	
	public List<PayBuildingDetail> queryForCondition(Map<String, Object> params) ;
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param buildingDetails
	 * @return
	 * @exception
	 */
    public void saveAll(List<PayBuildingDetail> buildingDetails);
    
    public PayBuildingDetail getForCondition(Map<String, Object> params) ;
}
