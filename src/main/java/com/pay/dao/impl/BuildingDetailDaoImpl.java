package com.pay.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.BuildingDetailDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;



@Repository("buildingInfoDetail")
public class BuildingDetailDaoImpl extends BaseHibernateDAO<PayBuildingDetail, PayBuildingDetailPK> implements BuildingDetailDao{

	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayBuildingDetail> page, Map<String, Object> params) {
        String code="";
        Integer groupId=null;
        Integer status=null;

        if(params!=null&&params.size()>0){
        	code = (String)params.get("code");
        	if(params.get("status")!=null){
        		status=(Integer)params.get("status");
        	}
        	if(params.get("groupId")!=null){
        		groupId=Integer.parseInt(((String)params.get("groupId")));
        	}

        }
             
        String whereCase = "";
        if (StringHelper.isNotEmpty(code)) {
        	whereCase += " AND code = '" + code + "' ";
        }
        if(status!=null){
        	whereCase += " AND status = " + status + " ";
    	}
        if(groupId!=null){
        	whereCase += " AND groupId = " + groupId + " ";
    	}

             
            
        this.pagingHQLQuery(" from PayBuildingDetail where 1=1 " + whereCase,page,null);


    }
	
	/**
	 * 按条件查询
	 * @param page
	 * @param params
	 */
	public List<PayBuildingDetail> queryForCondition(Map<String, Object> params) {
        String code="";
        int status=1;
        Integer groupId=null;
 
        if(MapUtils.isNotEmpty(params)){
        	code = (String)params.get("code");
        	
        	if(params.get("status")!=null){
        		status=(Integer)params.get("status");
        	}
        	if(params.get("groupId")!=null){
        		groupId=(Integer)params.get("groupId");
        	}
        }
             
        String whereCase = "";
        if (StringHelper.isNotEmpty(code)) {
        	whereCase += " AND code = '" + code + "' ";
        }
        if (groupId!=null) {
        	whereCase += " AND groupId = " + groupId + " ";
        }

        whereCase += " AND status = " + status + " ";    
            
        List<PayBuildingDetail> result=  this.list(" from PayBuildingDetail where 1=1 " + whereCase);

        return result;
    } 
	
    public List<PayBuildingDetail> querySqlForCondition(Map<String, Object> params){
    	
    	StringBuffer sql=new StringBuffer();
    	sql.append("SELECT ");
    	sql.append("b.code,a.name,a.addr1,b.room_no as roomNo,b.water_meter_code as waterMeterCode, ");
    	sql.append("b.apportion_type_id as apportionTypeId,b.pricing_type_id as pricingTypeId,b.user_name as userName,b.contractor_name as contractorName ");
    	sql.append("FROM pay_building_info a ");
    	sql.append("INNER JOIN pay_building_detail b on a.code=b.code ");
    	sql.append("WHERE a.status=1 and b.status=1 ");
    	if(MapUtils.isNotEmpty(params)){
    		String code=(String)params.get("code");
    		String roomNo=(String)params.get("roomNo");
    		String waterMeterCode=(String)params.get("waterMeterCode");
    		
    		if(StringUtils.isNotEmpty(code)){
    			sql.append("AND b.code='").append(code).append("' ");
    		}
    		if(StringUtils.isNotEmpty(roomNo)){
    			sql.append("AND b.roomNo='").append(code).append("' ");
    		}
    		if(StringUtils.isNotEmpty(waterMeterCode)){
    			sql.append("AND b.waterMeterCode='").append(waterMeterCode).append("' ");
    		}
    	}
    	sql.append("ORDER BY b.code,b.room_no ");
    	Query query=this.getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	List<Map<String,Object>> resultMap=query.list();
    	List<PayBuildingDetail> result=new ArrayList<PayBuildingDetail>();
    	if(CollectionUtils.isNotEmpty(resultMap)){
    		for(Map<String,Object> map:resultMap){
    			PayBuildingDetail buildingDetail=new PayBuildingDetail();
    			buildingDetail.setCode((String)map.get("code"));
    			buildingDetail.setRoomNo((String)map.get("roomNo"));
    			buildingDetail.setName((String)map.get("name"));
    			buildingDetail.setAddr((String)map.get("addr1"));
    			buildingDetail.setWaterMeterCode((String)map.get("waterMeterCode"));
    			buildingDetail.setApportionTypeId((Integer)map.get("apportionTypeId"));
    			buildingDetail.setPricingTypeId((Integer)map.get("pricingTypeId"));
    			buildingDetail.setUserName((String)map.get("userName"));
    			buildingDetail.setContractorName((String)map.get("contractorName"));
    			result.add(buildingDetail);
    		}
    	}
    	return result;
    }
    
    public void cleanBuildingDetailGroup(int groupId){
    	String hql="update PayBuildingDetail set groupId=0 where groupId=:groupId";
    	Map<String,Object> parameter=new HashMap<String, Object>();
    	parameter.put("groupId", groupId);
    	
    	this.execHql(hql, parameter);
    			
    }
}
