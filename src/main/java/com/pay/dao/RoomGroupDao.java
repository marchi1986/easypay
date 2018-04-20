package com.pay.dao;

import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayRoomGroup;

public interface RoomGroupDao extends IBaseDao<PayRoomGroup, Integer> {

	public void queryPageForCondition(Page<PayRoomGroup> page, Map<String, Object> params) ;
}
