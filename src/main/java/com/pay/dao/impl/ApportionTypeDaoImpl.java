package com.pay.dao.impl;

import java.util.Map;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.ApportionTypeDao;
import com.pay.pojo.PayApportionType;

@Repository("apportionTypeDao")
public class ApportionTypeDaoImpl extends BaseHibernateDAO<PayApportionType, Integer> implements ApportionTypeDao {

	public void queryForCondition(Page<PayApportionType> page, Map<String, Object> params) {
		 String name="";
	     if(params!=null&&params.size()>0){
	    	 name = (String)params.get("name");

	     }
	             
	     String whereCase = "";
	             
	     if (StringHelper.isNotEmpty(name)) {
	    	 whereCase += " AND name like '%" + name + "%' ";
	     }
	             
	            
	     this.pagingHQLQuery(" from PayApportionType where 1=1 " + whereCase,page,null);


	 }

}
