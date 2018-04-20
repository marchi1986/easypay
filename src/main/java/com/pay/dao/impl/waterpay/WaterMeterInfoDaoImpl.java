package com.pay.dao.impl.waterpay;

import java.util.Map;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.WaterMeterInfoDao;
import com.pay.pojo.waterpay.PayWaterMeterInfo;

@Repository("waterMeterInfoDao")
public class WaterMeterInfoDaoImpl extends BaseHibernateDAO<PayWaterMeterInfo, String> implements WaterMeterInfoDao{

	public void queryForCondition(Page<PayWaterMeterInfo> page, Map<String, Object> params) {
		
	     String waterMeterCode="";
	     if(params!=null&&params.size()>0){
	    	 waterMeterCode = (String) params.get("waterMeterCode");
	     }
	             
	     String whereCase = "";
	     if (StringHelper.isNotEmpty(waterMeterCode)) {
	        whereCase += " AND waterMeterCode = '" + waterMeterCode + "' ";
	     }
	             
	            
	     this.pagingHQLQuery(" from PayWaterMeterInfo where 1=1 " + whereCase,page,null);


	 }
}
