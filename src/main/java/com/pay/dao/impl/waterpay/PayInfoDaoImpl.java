package com.pay.dao.impl.waterpay;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.PayInfoDao;
import com.pay.pojo.waterpay.PayInfo;

@Repository("payInfoDao")
public class PayInfoDaoImpl extends BaseHibernateDAO<PayInfo, String> implements PayInfoDao{

	public List<PayInfo> findByPayDate(Date date){
		String hql="from PayInfo where payDate=:payDate ";
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("payDate", date);
		return this.list(hql, params);
	}
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param params
	 */
	public void queryPageForCondition(Page<PayInfo> page, Map<String, Object> params) {

	     
	     StringBuffer hql=new StringBuffer();

	     hql.append(" from PayInfo where 1=1 ");
	     StringBuffer queryCountHql=new StringBuffer();
	     if(MapUtils.isNotEmpty(params)){
	    	 Date beginDate=(Date)params.get("beginDate");
	    	 Date endDate=(Date)params.get("endDate");
	    	 if(beginDate!=null&&endDate!=null){
	    		 hql.append("and payDate between :beginDate and :endDate ");
	    	 }
	    	 String status=(String)params.get("status");
	    	 if(StringUtils.isNotEmpty(status)){
	    		 hql.append("and status=:status ");
	    	 }
	    	 queryCountHql.append("select count(*) ").append(hql);
	    	 this.pagingHQLQuery(hql.toString(),queryCountHql.toString(),page,params);
	     }else{
	    	 queryCountHql.append("select count(*) ").append(hql);
	    	 this.pagingHQLQuery(hql.toString(),queryCountHql.toString(),page,null);
	     }
	     
	     
	 }
	
	public List<PayInfo> querySummaryForCondition(Map<String, Object> params) {

	     
	     StringBuffer sql=new StringBuffer();

	     sql.append("select   ");
	     sql.append("pay_date as payDate,sum(water_price) as waterPrice,sum(garbage_price) as garbagePrice,sum(total_price)as totalPrice,sum(actual_total_price) as actualTotalPrice, ");
	     sql.append("sum(actual_garbage_price) as actualGarbagePrice,sum(network_price) as networkPrice,sum(actual_network_price) as actualNetworkPrice ,sum(sewage_price) as sewagePrice,");
	     sql.append("sum(other_price) as otherPrice ,sum(late_fee) as lateFee ");
	     sql.append("from pay_info where 1=1 ");
	     if(MapUtils.isNotEmpty(params)){
	    	 Date beginDate=(Date)params.get("beginDate");
	    	 Date endDate=(Date)params.get("endDate");
	    	 if(beginDate!=null&&endDate!=null){
	    		 sql.append("and pay_date between :beginDate and :endDate ");
	    	 }
	    	 sql.append(" group by pay_date ");
	    	 return this.listSql(sql.toString(), params,PayInfo.class);
	     }else{
	    	 sql.append(" group by pay_date ");
	    	 return this.listSql(sql.toString(), PayInfo.class);
	     }
	     
	     
	 }
	
	/**
	 * 按每人每日收费汇总
	 */
	public List<PayInfo> querySummaryForDateAndTollCollector(Map<String, Object> params) {

	     
	     StringBuffer sql=new StringBuffer();

	     sql.append("select   ");
	     sql.append("pay_date as payDate,toll_collector as tollCollector,sum(water_price) as waterPrice,sum(garbage_price) as garbagePrice,sum(total_price)as totalPrice,sum(actual_total_price) as actualTotalPrice, ");
	     sql.append("sum(actual_garbage_price) as actualGarbagePrice,sum(network_price) as networkPrice,sum(actual_network_price) as actualNetworkPrice ,sum(sewage_price) as sewagePrice,");
	     sql.append("sum(other_price) as otherPrice ,sum(late_fee) as lateFee ");
	     sql.append("from pay_info where 1=1 ");
	     if(MapUtils.isNotEmpty(params)){
	    	 Date beginDate=(Date)params.get("beginDate");
	    	 Date endDate=(Date)params.get("endDate");
	    	 if(beginDate!=null&&endDate!=null){
	    		 sql.append("and pay_date between :beginDate and :endDate ");
	    	 }
	    	 sql.append(" group by pay_date,toll_collector ");
	    	 return this.listSql(sql.toString(), params,PayInfo.class);
	     }else{
	    	 sql.append(" group by pay_date,toll_collector ");
	    	 return this.listSql(sql.toString(), PayInfo.class);
	     }
	     
	     
	 }
}
