package com.pay.waterpay.dao.impl;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.h2.result.ResultTarget;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.PayConstants;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.impl.UserDaoImpl;
import com.pay.exception.BusinessException;
import com.pay.waterpay.dao.WaterMeterPaymentOrderDao;


@Repository("waterMeterPaymentOrderDao")
public class WaterMeterPaymentOrderDaoImpl  {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

//	/**
//	 * 按条件分页查询
//	 * @param page
//	 * @param params
//	 * @throws BusinessException
//	 */
//	public void queryForCondition(Page<WaterMeterPaymentOrder> page, Map<String, Object> params)  {
//		
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("b.water_meter_code as waterMeterCode,d.addr1 as addr,b.room_no as roomNo,a.current_qty , ");
//		sql.append("a.before_qty ,a.actual_qty ,a.apportion_qty ,a.price, ");
//		sql.append("a.total_amount ,a.monthly_cycle ,a.closing_date ,a.order_code ");
//		sql.append("c.user_name as userName,a.remark,a.order_id,a.create_time, ");
//		sql.append("a.create_user,a.last_modify_user,a.last_modify_time,a.status, ");
//		sql.append("a.water_meter_id ");
//		sql.append("FROM water_meter_payment_order a ");
//		sql.append("INNER JOIN water_meter_info b on a.water_meter_id=b.id ");
//		sql.append("INNER JOIN water_meter_user c on b.water_meter_user_id=c.id ");
//		sql.append("INNER JOIN building_info d on b.building_id=d.id ");
//		sql.append("WHERE 1=1 ");
//		
//		
//		if(MapUtils.isNotEmpty(params)){
//			String waterMeterCode=(String)params.get("waterMeterCode");
//			if(StringUtils.isNotEmpty(waterMeterCode)){
//				sql.append("AND b.water_meter_code='").append(waterMeterCode).append("' ");;
//			}
//			
//			String buildingCode=(String)params.get("buildingCode");
//			if(StringUtils.isNotEmpty(buildingCode)){
//				sql.append("AND d.code='").append(buildingCode).append("' ");;
//			}
//			
//			String userName=(String)params.get("userName");
//			if(StringUtils.isNotEmpty(userName)){
//				sql.append("AND c.user_name='").append(userName).append("' ");;
//			}
//			
//			String addr=(String)params.get("addr");
//			if(StringUtils.isNotEmpty(addr)){
//				sql.append("AND d.addr1 like '%").append(addr).append("%' ");;
//			}
//			
//			String roomNo=(String)params.get("roomNo");
//			if(StringUtils.isNotEmpty(roomNo)){
//				sql.append("AND b.room_no='").append(roomNo).append("' ");;
//			}
//		}
//		
//		
//	        
//	    this.pagingSqlQuery(page, sql.toString(), this.getCountSql(sql.toString()), WaterMeterPaymentOrder.class);
//
//
//	 }
//	
//	/**
//	 * 生成本季度水费订单
//	 * @param currentMonthly,beforeMonthlyCycle
//	 * @return
//	 */
//	public List<WaterMeterPaymentOrder> genOrderList(int currentMonthlyCycle, int beforeMonthlyCycle){
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("concat(date_format(now(),'%Y%c%d'),a.water_meter_code,a.room_no) as orderCode,");
//		sql.append("ifnull(b.actual_qty,0) as beforeQty , ");
//		sql.append("c.percent as apportionQty ,d.price as price, ");
//		sql.append("a.water_meter_code as waterMeterCode ");
//		sql.append("FROM water_meter_info a ");
//		sql.append("left join water_meter_payment_order b on a.water_meter_code=b.water_meter_code and b.status=2 and b.monthly_cycle=? ");
//		sql.append("inner join apportion_type c on a.apportion_type_id=c.id ");
//		sql.append("inner join pricing_type d on a.pricing_type_id=d. id ");
//		sql.append("where ");
//		sql.append("a.status=1 ");
//		
//		
//		Query query=this.getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//		query.setParameter(0, beforeMonthlyCycle);
//		List<Map<String,Object>> result=query.list();
//		List<WaterMeterPaymentOrder> waterMeterPaymentOrders=new ArrayList<WaterMeterPaymentOrder>();
//		if(CollectionUtils.isNotEmpty(result)){
//			for(Map<String,Object> map:result){
//				WaterMeterPaymentOrder order=new WaterMeterPaymentOrder();
//				order.setOrderCode((String)map.get("orderCode"));
//				order.setBeforeQty((BigDecimal)map.get("beforeQty"));
//				order.setCurrentQty(new BigDecimal(0));
//				order.setActualQty(new BigDecimal(0));
//				order.setApportionQty((BigDecimal)map.get("apportionQty"));
//				order.setPrice((BigDecimal)map.get("price"));
//				order.setGarbagePrice(new BigDecimal(0));
//				order.setOtherPrice(new BigDecimal(0));
//				
//				Calendar c=Calendar.getInstance();
//				
//				String currentDateStr=currentMonthlyCycle+"01";
//				SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
//				Date currentDate=null;
//				try {
//					currentDate = sdf2.parse(currentDateStr);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//						
//				c.setTime(currentDate);
//				c.add(Calendar.MONTH, 1);
//				c.add(Calendar.DAY_OF_MONTH, -1);
//				c.set(Calendar.HOUR_OF_DAY, 23);
//				
//				order.setClosingDate(c.getTime());
//				order.setCreateUser(ContextHolder.getLoginUserName());
//				order.setCreateTime(new Date());
//				order.setMonthlyCycle(currentMonthlyCycle);
//				order.setTotalAmount(new BigDecimal(0) );
//				order.setWaterMeterCode((String)map.get("waterMeterCode"));
//				order.setStatus(PayConstants.PAYMENT_ORDER_STATUS_NEW);
//				waterMeterPaymentOrders.add(order);
//			}
//		}
//		
//		
//		return waterMeterPaymentOrders;
//	}
//	
//	/**
//	 * 根据月度周期查询水费录入列表
//	 * @param monthlyCycle
//	 * @return
//	 */
//	public List<WaterMeterPaymentOrder> queryInputListByMonthCycle(int monthlyCycle){
//		String hql="from WaterMeterPaymentOrder where monthlyCycle=:monthlyCycle and status=0 ";
//		Map<String,Object> parameter=new HashMap<String, Object>();
//		parameter.put("monthlyCycle", monthlyCycle);
//		List<WaterMeterPaymentOrder> result=this.list(hql, parameter);
//		return result;
//	}
//	
//	/**
//	 * 查询该月度订单记录数
//	 * @param monthlyCycle
//	 * @return
//	 */
//	public long queryCountByMonthlyCycle(int monthlyCycle){
//		String hql="select count(*) from WaterMeterPaymentOrder where monthlyCycle=:monthlyCycle and status<>3 ";
//		Map<String,Object> parameter=new HashMap<String, Object>();
//		parameter.put("monthlyCycle", monthlyCycle);
//		long count=this.aggregate(hql, parameter);
//		return count;
//	}
//	
//	/**
//	 * 更新状态
//	 * @param monthlyCycle
//	 * @param oldStatus
//	 * @param newStatus
//	 */
//	public void updateStatus(int monthlyCycle, int oldStatus,int newStatus){
//		StringBuffer hql=new StringBuffer();
//		hql.append("UPDATE WaterMeterPaymentOrder ");
//		hql.append("SET ");
//		hql.append("status=:newStatus,lastModifyUser=:user,lastModifyTime=CURRENT_TIMESTAMP() ");
//		hql.append("where  ");
//		hql.append("monthlyCycle=:monthlyCycle and status=:oldStatus ");
//		
//		
//		Map<String,Object> parameterMap=new HashMap<String, Object>();
//		parameterMap.put("monthlyCycle", monthlyCycle);
//		parameterMap.put("newStatus", newStatus);
//		parameterMap.put("oldStatus", oldStatus);
//		parameterMap.put("user", ContextHolder.getLoginUserName());
//		this.execHql(hql.toString(), parameterMap);
//	}
}
