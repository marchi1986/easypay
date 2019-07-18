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
import com.pay.dao.waterpay.WaterMeterInputDetailDao;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;
import com.pay.pojo.waterpay.PayWaterMeterInputDetailPK;


@Repository("waterMeterInputDetailDao")
public class WaterMeterInputDetailDaoImpl extends BaseHibernateDAO<PayWaterMeterInputDetail, PayWaterMeterInputDetailPK> implements WaterMeterInputDetailDao{

	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputDetail> page,Map<String, Object> parameter) {
		
		String hql="from PayWaterMeterInputDetail where 1=1 ";
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthlyCycle");
		String buildingCode=(String)parameter.get("buildingCode");
		String roomNo=(String)parameter.get("roomNo");
		Integer status=(Integer)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(StringUtils.isNotEmpty(buildingCode)){
			hql=hql+"and buildingCode='"+buildingCode+"' ";
		}
		
		if(StringUtils.isNotEmpty(roomNo)){
			hql=hql+"and roomNo='"+roomNo+"' ";
		}
		
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		
		this.pagingHQLQuery(hql, page, null);
	}
	
	/**
	 * 按条件查询
	 * @param parameter
	 */
	public List<PayWaterMeterInputDetail> queryForCondition(Map<String, Object> parameter) {
		
		String hql="from PayWaterMeterInputDetail where 1=1 ";
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthlyCycle");
		String buildingCode=(String)parameter.get("buildingCode");
		String roomNo=(String)parameter.get("roomNo");
		Integer status=(Integer)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(StringUtils.isNotEmpty(buildingCode)){
			hql=hql+"and buildingCode='"+buildingCode+"' ";
		}
		
		if(StringUtils.isNotEmpty(roomNo)){
			hql=hql+"and roomNo='"+roomNo+"' ";
		}
		
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		
		List<PayWaterMeterInputDetail> result= this.list(hql);
		return result;
	}
	
	/**
	 * 获取录入单某状态的数量
	 * @param parameter
	 * @return
	 */
	public Long getCountForCondition(Map<String, Object> parameter){
		String hql="select count(*) from PayWaterMeterInputDetail where 1=1 "; 
		String code=(String)parameter.get("code");
		String buildingCode=(String)parameter.get("buildingCode");
		String roomNo=(String)parameter.get("roomNo");
		Integer monthlyCycle=(Integer)parameter.get("monthlyCycle");
		Integer status=(Integer)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(StringUtils.isNotEmpty(buildingCode)){
			hql=hql+"and buildingCode='"+buildingCode+"' ";
		}
		if(StringUtils.isNotEmpty(roomNo)){
			hql=hql+"and roomNo='"+roomNo+"' ";
		}				
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		Long count= (Long)this.aggregate(hql);
		return count;
	}
	
	/**
	 * 初始化录入数据
	 * @param beforeCode
	 * @return
	 */
	public List<PayWaterMeterInputDetail> queryInitData(String beforeCode){
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" b.code,b.room_no as roomNo,b.water_meter_code as waterMeterCode,ifnull(ifnull(b.monthly_qty,c.current_qty),0) as currentQty ");
		sql.append(" FROM pay_building_info a ");
		sql.append(" INNER JOIN pay_building_detail b on a.code=b.code ");
		sql.append(" LEFT JOIN  pay_water_meter_input_detail c on b.code=c.building_code ");
		sql.append(" AND b.room_no=c.room_no AND c.code='").append(beforeCode).append("' ");
		sql.append(" WHERE ");
		sql.append(" a.status=1 and b.status=1 ");
		
		Query query=this.getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> result=query.list();
		List<PayWaterMeterInputDetail> waterMeterInputDetails=new ArrayList<PayWaterMeterInputDetail>();
		if(CollectionUtils.isNotEmpty(result)){
			for(Map<String, Object> map:result){
				PayWaterMeterInputDetail waterMeterInputDetail=new PayWaterMeterInputDetail();
				waterMeterInputDetail.setBuildingCode((String)map.get("code"));
				waterMeterInputDetail.setRoomNo((String)map.get("roomNo"));
				waterMeterInputDetail.setWaterMeterCode((String)map.get("waterMeterCode"));
				waterMeterInputDetail.setBeforeQty((BigDecimal)map.get("currentQty"));
				waterMeterInputDetails.add(waterMeterInputDetail);
			}
		}
		return waterMeterInputDetails;
	}
	
	public BigDecimal getSum(String code,String buildingCode){
		String hql="select sum(currentQty) as currentQty from PayWaterMeterInputDetail where 1=1 ";
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		if(StringUtils.isNotEmpty(buildingCode)){
			hql=hql+"and buildingCode='"+buildingCode+"' ";
		}
		
		BigDecimal total=(BigDecimal)this.aggregate(hql);
		
		return total;
	}
	
	/**
	 * 更新状态
	 * @param code
	 * @param status
	 */
	public void updateStatusByCode(String code,int status){
		String hql="update PayWaterMeterInputDetail set status=:status,lastModifyUser=:user where code=:code ";
		Map<String, Object> parameter=new HashMap<String, Object>();
		parameter.put("status", status);
		parameter.put("code", code);
		parameter.put("user", ContextHolder.getLoginUserName());
		this.execHql(hql, parameter);
	}
	
	public void deleteByCode(String code){
		String hql="delete from PayWaterMeterInputDetail where code=:code";
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("code", code);
		this.execHql(hql, params);
	}
	

	/**
	 * Query By UserCode
	 * @param userCode
	 * @return
	 */
	public List<PayWaterMeterInputDetail> getByUserCode(String userCode) {
		
		String hql="from PayWaterMeterInputDetail where userCode=:userCode ";
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("userCode", userCode);
		
		List<PayWaterMeterInputDetail> list=this.list(hql, params);
		
		return list;
		
	}
	
	/**
	 * Get By Code And UserCode
	 * @param code
	 * @param userCode
	 * @return
	 */
	public PayWaterMeterInputDetail getByCodeAndUserCode(String code,String userCode) {
		
		String hql="from PayWaterMeterInputDetail where code=:code and userCode=:userCode ";
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("code", code);
		params.put("userCode", userCode);
		
		PayWaterMeterInputDetail waterMeterInputDetail=this.aggregate(hql, params);
		
		return waterMeterInputDetail;
		
	}
}
