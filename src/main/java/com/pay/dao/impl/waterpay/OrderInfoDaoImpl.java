package com.pay.dao.impl.waterpay;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.pay.common.DateUtils;
import com.pay.common.PayConstants;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.OrderInfoDao;
import com.pay.pojo.waterpay.PayOrderInfo;
import com.pay.pojo.waterpay.PayOrderInfoPK;

@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends BaseHibernateDAO<PayOrderInfo, PayOrderInfoPK> implements
		OrderInfoDao {

	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayOrderInfo> page, Map<String, Object> params) {
		 String buildingCode="";
		 String roomNo="";
		 Integer monthlyCycle=null;
		 Integer status=null;
		 String groupId=null;
		 //是否查询欠费
		 Boolean isQueryArrears=false;
	     if(MapUtils.isNotEmpty(params)){
	    	 buildingCode = (String)params.get("buildingCode");
	    	 roomNo = (String)params.get("roomNo");
	    	 monthlyCycle = (Integer)params.get("monthly");
	    	 status = (Integer)params.get("status");
	    	 groupId=(String)params.get("groupId");
	    	 isQueryArrears=(Boolean)params.get("isQueryArrears");
	     }
	     
	     StringBuffer hql=new StringBuffer();

	     hql.append("from PayOrderInfo as a,PayBuildingDetail as b ");
	     hql.append("where a.buildingCode=b.code and a.roomNo=b.roomNo ");
	     
	     
	     if (monthlyCycle!=null) {
	    	 hql.append(" AND a.monthlyCycle=").append(monthlyCycle);
	     }
	             
	     if (StringHelper.isNotEmpty(buildingCode)) {
	    	 hql.append(" AND a.buildingCode='").append(buildingCode).append("'");
	     }
	     
	     if (StringHelper.isNotEmpty(roomNo)) {

	    	 hql.append(" AND a.roomNo='").append(roomNo).append("'");
	     }
	     
	     if (status!=null) {

	    	 hql.append(" AND a.status=").append(status);
	     }
	     
	     if(isQueryArrears!=null&&isQueryArrears){
	    	 
	    	 hql.append(" AND a.lastPayDate<'").append(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")).append("'");
	     }
	     
	     if (StringUtils.isNotEmpty(groupId)) {
	    	 hql.append(" AND b.groupId=").append(groupId);
	     }
	     hql.append(" order by a.monthlyCycle ");
	     
	     StringBuffer queryHql=new StringBuffer();
	     StringBuffer queryCountHql=new StringBuffer();
	     queryHql.append("select a ").append(hql);
	     queryCountHql.append("select count(*) ").append(hql);
	     
	            
	     this.pagingHQLQuery(queryHql.toString(),queryCountHql.toString(),page,null);


	 }
	
	public List<PayOrderInfo>  querySummaryForCondition(Map<String, Object> params){
		Integer monthlyCycle=null;
		Date payDate=null;
		StringBuffer selCase=new StringBuffer(" select ");
		StringBuffer whereCase=new StringBuffer(" where 1=1 ");
		StringBuffer groupByCase=new StringBuffer(" group by ");
		if(MapUtils.isNotEmpty(params)){
			
			if(params.get("summaryType")!=null){
				String summaryType=(String)params.get("summaryType");
				if("monthly".equals(summaryType)){
					selCase.append("monthly_cycle as monthlyCycle, ");
					groupByCase.append("monthly_cycle ");
				}else if("day".equals(summaryType)){
					selCase.append("pay_date as payDate, ");
					groupByCase.append("pay_date ");
				}
			}
			
			if(params.get("monthly")!=null){
				monthlyCycle=(Integer)params.get("monthly");
				whereCase.append(" and monthly_Cycle=").append(monthlyCycle);
			}
			if(params.get("payDate")!=null){
				payDate=(Date)params.get("payDate");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String format=sdf.format(payDate);
				whereCase.append(" and date(pay_Date)='").append(format).append("' ");
			}
		}
		selCase.append("sum(water_current_qty) as waterCurrentQty,");
		selCase.append("sum(water_before_qty) as waterBeforeQty,");
		selCase.append("sum(water_apportion_qty)as waterApportionQty,");
		selCase.append("sum(water_price) as waterPrice,");
		selCase.append("sum(garbage_price) as garbagePrice,");
		selCase.append("sum(apportion_price) as apportionPrice,");
		selCase.append("sum(late_fee) as lateFee,");
		selCase.append("sum(network_price) as networkPrice,");
		selCase.append("sum(sewage_price) as sewagePrice,");
		selCase.append("sum(other_price) as otherPrice, ");
		selCase.append("sum(actual_qty) as actualQty, ");
		selCase.append("sum(total_price) as totalPrice ");
		selCase.append("from Pay_Order_Info ");
		whereCase.append(" and status=").append(PayConstants.ORDER_STATUS_PAY);
		selCase.append(whereCase).append(groupByCase);
		
		Query query=this.getSession().createSQLQuery(selCase.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> resultMap=query.list();
		
		List<PayOrderInfo> orderInfos=new ArrayList<PayOrderInfo>();
		if(CollectionUtils.isNotEmpty(resultMap)){
			for(Map<String,Object> map:resultMap){
				PayOrderInfo orderInfo=new PayOrderInfo();
				if(map.get("monthlyCycle")!=null){
					orderInfo.setMonthlyCycle((Integer)map.get("monthlyCycle"));
				}
				if(map.get("payDate")!=null){
					orderInfo.setPayDate((Date)map.get("payDate"));
				}

				orderInfo.setWaterCurrentQty((BigDecimal)map.get("waterCurrentQty"));
				orderInfo.setWaterBeforeQty((BigDecimal)map.get("waterBeforeQty"));
				orderInfo.setWaterApportionQty((BigDecimal)map.get("waterApportionQty"));
				orderInfo.setWaterPrice((BigDecimal)map.get("waterPrice"));
				orderInfo.setGarbagePrice((BigDecimal)map.get("garbagePrice"));
				orderInfo.setApportionPrice((BigDecimal)map.get("apportionPrice"));
				orderInfo.setLateFee((BigDecimal)map.get("lateFee"));
				orderInfo.setNetworkPrice((BigDecimal)map.get("networkPrice"));
				orderInfo.setSewagePrice((BigDecimal)map.get("sewagePrice"));
				orderInfo.setOtherPrice((BigDecimal)map.get("otherPrice"));
				orderInfo.setActualQty((BigDecimal)map.get("actualQty"));
				orderInfo.setTotalPrice((BigDecimal)map.get("totalPrice"));
				orderInfos.add(orderInfo);
			}
		}
		
		return orderInfos;
		
		
	}
	
	public List<PayOrderInfo> findByPayCode(String payCode){
		String hql="from PayOrderInfo where payCode=:payCode ";
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("payCode", payCode);
		return this.list(hql, params);
	}
}
