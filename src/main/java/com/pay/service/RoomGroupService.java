package com.pay.service;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayRoomGroup;

public interface RoomGroupService {

	public void queryPageForCondition(Page<PayRoomGroup> page, Map<String, Object> params); 
	
	public void saveAll(List<PayRoomGroup> roomGroups);
	
	public void updateGroup(List<Map<String,Object>> item,int groupId)throws Exception;
	
	public void deleteGroup(Map<String,Object> item) throws Exception;
	
	public List<PayRoomGroup> listAll() ;
}
