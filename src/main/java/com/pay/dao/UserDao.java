package com.pay.dao;

import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayUser;


public interface UserDao extends IBaseDao<PayUser, Integer> {

	public void queryForCondition(Page<PayUser> page, Map<String, Object> params) ;
}
