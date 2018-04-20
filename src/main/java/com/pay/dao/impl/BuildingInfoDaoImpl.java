package com.pay.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.BuildingInfoDao;
import com.pay.pojo.PayBuildingInfo;


@Repository("buildingInfoDao")
public class BuildingInfoDaoImpl extends BaseHibernateDAO<PayBuildingInfo, String> implements BuildingInfoDao{

	
    public void queryPageForCondition(Page<PayBuildingInfo> page, Map<String, Object> params) {
        String code="";
        String addr="";
        if(params!=null&&params.size()>0){
        	code = (String)params.get("code");
        	addr = (String) params.get("addr");
        }
             
        String whereCase = "";
        if (StringHelper.isNotEmpty(code)) {
        	whereCase += " AND code = '" + code + "' ";
        }
             
        if (StringHelper.isNotEmpty(addr)) {
           whereCase += " AND addr like '%" + addr + "%' ";
        }
             
            
        this.pagingHQLQuery(" from PayBuildingInfo where 1=1 " + whereCase,page,null);


    }
    
    public List<PayBuildingInfo> queryForCondition(Map<String, Object> params){
    	String code="";
        String addr="";
        int status=1;
        if(MapUtils.isNotEmpty(params)){
        	code = (String)params.get("code");
        	addr = (String) params.get("addr");
        	if(params.get("status")!=null){
        		status=(Integer) params.get("status");
        	}
        }
             
        String whereCase = "";
        if (StringHelper.isNotEmpty(code)) {
        	whereCase += " AND code = '" + code + "' ";
        }
             
        if (StringHelper.isNotEmpty(addr)) {
           whereCase += " AND addr1 like '%" + addr + "%' ";
        }
        whereCase += " AND status = " + status + " ";     
            
        List<PayBuildingInfo> list=  this.list(" from PayBuildingInfo where 1=1 " + whereCase);
        return list;
    }
    


}
