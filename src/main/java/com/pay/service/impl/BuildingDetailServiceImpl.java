package com.pay.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.pay.dao.BuildingDetailDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.service.BuildingDetailService;

@Service("buildingDetailService")
public class BuildingDetailServiceImpl implements BuildingDetailService{

	@Autowired
	private BuildingDetailDao buildingDetailDao;

	/**
	 * 按条件分页查询
	 * @param page,params
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayBuildingDetail> page,
			Map<String, Object> params) {
		buildingDetailDao.queryPageForCondition(page, params);
		
	}
	
	/**
	 * 按条件查询
	 * @param page,params
	 */
	@DataProvider
	public List<PayBuildingDetail> queryForCondition(Map<String, Object> params) {
		return buildingDetailDao.queryForCondition(params);
		
	}
	

	@DataProvider
	public PayBuildingDetail getForCondition(Map<String, Object> params) {
		
		String buildingCode=(String)params.get("buildingCode");
		String roomNo=(String)params.get("roomNo");
		
		PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
		buildingDetailPK.setCode(buildingCode);
		buildingDetailPK.setRoomNo(roomNo);
		
		return buildingDetailDao.get(buildingDetailPK);
		
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param buildingDetails
	 * @return
	 * @exception
	 */
	@DataResolver
    public void saveAll(List<PayBuildingDetail> buildingDetails){
		
		for(PayBuildingDetail buildingDetail:buildingDetails){
			
			EntityState state=EntityUtils.getState(buildingDetail);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				buildingDetail.setStatus(1);
				buildingDetail.setGroupId(0);
				buildingDetail.setMonthlyQty(new BigDecimal(0));
				buildingDetail.setLastModifyUser(user.getUsername());
				buildingDetail.setLastModifyTime(new Date());
				buildingDetail.setCreateUser(user.getUsername());
				buildingDetail.setCreateTime(new Date());
				buildingDetailDao.save(buildingDetail);
			}else if(EntityState.MODIFIED.equals(state)){
				buildingDetail.setLastModifyUser(user.getUsername());
				buildingDetail.setLastModifyTime(new Date());
				buildingDetailDao.update(buildingDetail);
			}else if(EntityState.DELETED.equals(state)){
				buildingDetailDao.deleteObject(buildingDetail);
			};
		}
    }
	
	
}
