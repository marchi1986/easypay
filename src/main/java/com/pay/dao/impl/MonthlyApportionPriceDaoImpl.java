package com.pay.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;

import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.MonthlyApportionPriceDao;
import com.pay.pojo.PayMonthlyApportionPrice;

@Repository("monthlyApportionPriceDao")
public class MonthlyApportionPriceDaoImpl extends BaseHibernateDAO<PayMonthlyApportionPrice, Integer> implements MonthlyApportionPriceDao{

	public void queryForCondition(Page<PayMonthlyApportionPrice> page, Map<String, Object> params) {
		String monthlyFormat="";
	     if(params!=null&&params.size()>0){
	    	 if(params.get("monthly")!=null){
	    		 Date monthly=(Date)params.get("monthly");
	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
	    		 monthlyFormat= sdf.format(monthly);
	    	 }

	     }
	             
	     String whereCase = "";
	             
	     if (monthlyFormat!=null&&!monthlyFormat.equals("")) {
	    	 whereCase += " AND monthly =" + monthlyFormat + " ";
	     }
	             
	            
	     this.pagingHQLQuery(" from PayMonthlyApportionPrice where 1=1 " + whereCase,page,null);


	 }
}
