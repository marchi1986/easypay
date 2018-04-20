package com.pay.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.PayConstants;
import com.pay.dao.BuildingDetailDao;
import com.pay.dao.RoomGroupDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayRoomGroup;
import com.pay.service.RoomGroupService;

@Service("roomGroupService")
public class RoomGroupServiceImpl implements RoomGroupService{

	@Autowired
	private RoomGroupDao roomGroupDao;
	
	@Autowired
	private BuildingDetailDao buildingDetailDao;
	
	@DataProvider
	public void queryPageForCondition(Page<PayRoomGroup> page,
			Map<String, Object> params) {
		
		roomGroupDao.queryPageForCondition(page, params);
	}
	
	@DataProvider
	public List<PayRoomGroup> listAll() {
		
		return roomGroupDao.listAll();
	}
	
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param roomGroups
	 */
	@DataResolver
    public void saveAll(List<PayRoomGroup> roomGroups){
		
		for(PayRoomGroup roomGroup:roomGroups){
			
			EntityState state=EntityUtils.getState(roomGroup);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				roomGroup.setCreateUser(user.getUsername());
				roomGroup.setCreateTime(new Date());
				roomGroup.setStatus(PayConstants.ENABLED_STATUS);
				roomGroupDao.save(roomGroup);
			}else if(EntityState.MODIFIED.equals(state)){
				roomGroupDao.update(roomGroup);
			}else if(EntityState.DELETED.equals(state)){
				roomGroupDao.deleteObject(roomGroup);
			};
		}
    }
	
	@Expose
	public void updateGroup(List<Map<String,Object>> items,int groupId)throws Exception{
		
		for(Map<String,Object> map:items){
			PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
			buildingDetailPK.setCode((String)map.get("code"));
			buildingDetailPK.setRoomNo((String)map.get("roomNo"));
			PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
			buildingDetail.setGroupId(groupId);
			buildingDetailDao.update(buildingDetail);
		}
		
	}
	
	@Expose
	public void deleteGroup(Map<String,Object> item) throws Exception{

		PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
		buildingDetailPK.setCode((String)item.get("code"));
		buildingDetailPK.setRoomNo((String)item.get("roomNo"));
		PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
		buildingDetail.setGroupId(0);
		buildingDetailDao.update(buildingDetail);

	}
}
