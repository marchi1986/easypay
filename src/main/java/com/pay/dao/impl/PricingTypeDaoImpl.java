package com.pay.dao.impl;

import java.util.Map;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.PricingTypeDao;
import com.pay.pojo.PayPricingType;


@Repository("pricingTypeDao")
public class PricingTypeDaoImpl extends BaseHibernateDAO<PayPricingType, Integer> implements PricingTypeDao{

	public void queryForCondition(Page<PayPricingType> page, Map<String, Object> params) {
		 String name="";
	     if(params!=null&&params.size()>0){
	    	 name = (String)params.get("name");

	     }
	             
	     String whereCase = "";
	             
	     if (StringHelper.isNotEmpty(name)) {
	    	 whereCase += " AND name like '%" + name + "%' ";
	     }
	             
	            
	     this.pagingHQLQuery(" from PayPricingType where 1=1 " + whereCase,page,null);


	 }
}
