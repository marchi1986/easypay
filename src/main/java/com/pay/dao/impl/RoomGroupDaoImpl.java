package com.pay.dao.impl;

import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.RoomGroupDao;
import com.pay.pojo.PayRoomGroup;

@Repository("roomGroupDao")
public class RoomGroupDaoImpl extends BaseHibernateDAO<PayRoomGroup, Integer> implements RoomGroupDao {

	public void queryPageForCondition(Page<PayRoomGroup> page, Map<String, Object> params) {
        String name="";

        if(MapUtils.isNotEmpty(params)){

        	name = (String) params.get("name");
        }
             
        String whereCase = "";
        if (StringHelper.isNotEmpty(name)) {
        	whereCase += " AND code like '%" + name + "%' ";
        }
              
        this.pagingHQLQuery(" from PayRoomGroup where 1=1 " + whereCase,page,null);


    }

}
