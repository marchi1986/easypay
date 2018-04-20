package com.pay.dao.impl.waterpay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.WaterMeterInputBuildingDao;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.pojo.waterpay.PayWaterMeterInputBuildingPK;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;



@Repository("waterMeterInputBuildingDao")
public class WaterMeterInputBuildingDaoImpl extends BaseHibernateDAO<PayWaterMeterInputBuilding, PayWaterMeterInputBuildingPK> implements WaterMeterInputBuildingDao{

	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputBuilding> page,Map<String, Object> parameter) {
		
		String hql="from PayWaterMeterInputBuilding where 1=1 ";
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthly");
		String buildingCode=(String)parameter.get("buildingCode");
		String status=(String)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(StringUtils.isNotEmpty(buildingCode)){
			hql=hql+"and buildingCode='"+buildingCode+"' ";
		}
		
		
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		
		this.pagingHQLQuery(hql, page, null);
	}
	
	/**
	 * 查询初始化数据
	 * @param beforeMonthlyCycle
	 * @return
	 */
	public List<PayWaterMeterInputBuilding> queryInitData(String beforeCode) {
		
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" a.code,ifnull(b.current_qty,0) as currentQty ");
		sql.append(" FROM pay_building_info a ");
		sql.append(" LEFT join  pay_water_meter_input_building b on a.code=b.building_code and b.code='").append(beforeCode).append("' ");
		sql.append(" WHERE ");
		sql.append(" a.status=1 ");
		
		Query query=this.getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> result=query.list();
		List<PayWaterMeterInputBuilding> waterMeterInputBuildings=new ArrayList<PayWaterMeterInputBuilding>();
		if(CollectionUtils.isNotEmpty(result)){
			for(Map<String, Object> map:result){
				PayWaterMeterInputBuilding waterMeterInputBuilding=new PayWaterMeterInputBuilding();
				waterMeterInputBuilding.setBuildingCode((String)map.get("code"));
				waterMeterInputBuilding.setBeforeQty((BigDecimal)map.get("currentQty"));
				waterMeterInputBuildings.add(waterMeterInputBuilding);
			}
		}
		return waterMeterInputBuildings;
		
	}
	
	/**
	 * 更新状态
	 * @param code
	 * @param status
	 */
	public void updateStatusByCode(String code,int status){
		String hql="update PayWaterMeterInputBuilding set status=:status,lastModifyUser=:user where code=:code ";
		Map<String, Object> parameter=new HashMap<String, Object>();
		parameter.put("status", status);
		parameter.put("code", code);
		parameter.put("user", ContextHolder.getLoginUserName());
		this.execHql(hql, parameter);
	}
	
	/**
	 * @param code
	 * @param buildingCode
	 * @return
	 */
	public PayWaterMeterInputBuilding getByCodeAndBuildCode(String code,String buildingCode) {
		
		String hql="from PayWaterMeterInputBuilding where code=:code and buildingCode=:buildingCode ";
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("code", code);
		params.put("buildingCode", buildingCode);
		
		PayWaterMeterInputBuilding waterMeterInputBuilding=this.aggregate(hql, params);
		
		return waterMeterInputBuilding;
		
	}
	
	public void deleteByCode(String code){
		String hql="delete from PayWaterMeterInputBuilding where code=:code";
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("code", code);
		this.execHql(hql, params);
	}
}
