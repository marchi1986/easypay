package com.pay.dao.impl.waterpay;

import java.util.Map;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.ReplaceWaterMeterHistoryDao;
import com.pay.pojo.PayReplaceWaterMeterHistory;

@Repository("replaceWaterMeterHistoryDao")
public class ReplaceWaterMeterHistoryDaoImpl extends BaseHibernateDAO<PayReplaceWaterMeterHistory, Integer>
		implements ReplaceWaterMeterHistoryDao { 
	
	
	public void queryForCondition(Page<PayReplaceWaterMeterHistory> page, Map<String, Object> params) {
		 String buildingCode="";
		 String roomNo="";
		 
	     if(params!=null&&params.size()>0){
	    	 buildingCode = (String)params.get("buildingCode");
	    	 roomNo = (String)params.get("roomNo");
	     }
	             
	     String whereCase = "";
	             
	     if (StringHelper.isNotEmpty(buildingCode)) {
	    	 whereCase += " AND buildingCode='"+buildingCode+"' ";
	     }
	     
	     if (StringHelper.isNotEmpty(roomNo)) {
	    	 whereCase += " AND roomNo='"+buildingCode+"' ";
	     }
	             
	            
	     this.pagingHQLQuery(" from PayReplaceWaterMeterHistory where 1=1 " + whereCase,page,null);


	 }
}
