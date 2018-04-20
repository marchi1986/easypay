package com.pay.service;

import java.util.List;
import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.PayUser;


public interface UserService {

	public void queryForCondition(Page<PayUser> page, Map<String, Object> patameter) ;
	
	public void queryForCondition(Page<PayUser> page) ;
	
    public void saveAll(List<PayUser> users);
    

	public PayUser get(Integer id) ;
}
