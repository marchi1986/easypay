package com.pay.dao.impl.waterpay;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;

@Repository("waterMeterInputHeaderDao")
public class WaterMeterInputHeaderDaoImpl extends BaseHibernateDAO<PayWaterMeterInputHeader, String> implements WaterMeterInputHeaderDao{

	
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	public void queryPageForCondition(Page<PayWaterMeterInputHeader> page,Map<String, Object> parameter) {
		
		String hql="from PayWaterMeterInputHeader where 1=1 ";
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthly");
		Integer status=(Integer)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		
		this.pagingHQLQuery(hql, page, null);
	}
	
	
	
	/**
	 * 按条件查询
	 * @param parameter
	 * @return
	 */
	public List<PayWaterMeterInputHeader> queryForCondition(Map<String,Object> parameter){
		String hql="from PayWaterMeterInputHeader where 1=1 ";
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthlyCycle");
		Integer status=(Integer)parameter.get("status");
		
		if(StringUtils.isNotEmpty(code)){
			hql=hql+"and code='"+code+"' ";
		}
		
		if(monthlyCycle!=null){
			hql=hql+"and monthlyCycle="+monthlyCycle+" ";
		}
		
		if(status!=null){
			hql=hql+"and status="+status+" ";
		}
		
		List<PayWaterMeterInputHeader> result=this.list(hql);
		
		return result;
	}
	
	/**
	 * 按条件查询
	 * @param monthly
	 * @param status
	 * @return
	 */
	public PayWaterMeterInputHeader getByMonthlyAndStatus(Integer monthly,Integer status){
		String hql="from PayWaterMeterInputHeader where monthlyCycle=:monthly and status=:status ";
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("monthly", monthly);
		params.put("status", status);
		
		PayWaterMeterInputHeader payWaterMeterInputHeader=this.aggregate(hql, params);
		
		return payWaterMeterInputHeader;
	}
	
	/**
	 * 按条件查询
	 * @param monthly
	 * @return
	 */
	public PayWaterMeterInputHeader getByMonthly(Integer monthly){
		String hql="from PayWaterMeterInputHeader where monthlyCycle=:monthly ";
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("monthly", monthly);
		
		PayWaterMeterInputHeader payWaterMeterInputHeader=this.aggregate(hql, params);
		
		return payWaterMeterInputHeader;
	}
	
	/**
	 * 获取已确认且最大的录入月度
	 * @return
	 */
	public Integer getMaxMonthlyCycle(){
		String hql="select max(monthlyCycle) from PayWaterMeterInputHeader where status=2 ";
		Integer monthlyCycle=(Integer)this.aggregate(hql);
		if(monthlyCycle==null){
			monthlyCycle=0;
		}
		return monthlyCycle;
	}
	
	/**
	 * 获取上次水费录入编号
	 * @return
	 */
	public String getBeforeCode(){
		int monthlyCycle= getMaxMonthlyCycle();
		if(monthlyCycle!=0){
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("monthlyCycle", monthlyCycle);
			
			String hql="select code from PayWaterMeterInputHeader where monthlyCycle=:monthlyCycle and status=2 ";
			
			String code=(String)this.aggregate(hql,params);
			return code;
		}else{
			return "";
		}
	}
	
	/**
	 * 获取当月吨数
	 * @return
	 */
	public BigDecimal getQtyByMonthlyCycle(int monthlyCycle){
		String hql="select currentQty from PayWaterMeterInputHeader where monthlyCycle=:monthlyCycle and  status=1 ";
		Map<String,Object> parameter=new HashMap<String, Object>();
		parameter.put("monthlyCycle", monthlyCycle);
		BigDecimal montylyCycle=(BigDecimal)this.aggregate(hql,parameter);
		if(montylyCycle==null){
			montylyCycle=new BigDecimal(0);
		}
		return montylyCycle;
	}
	
	
}
