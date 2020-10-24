package com.pay.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.pay.dao.ApportionTypeDao;
import com.pay.dao.MonthlyApportionPriceDao;
import com.pay.pojo.PayApportionType;
import com.pay.pojo.PayMonthlyApportionPrice;
import com.pay.service.ApportionTypeService;
import com.pay.service.MonthlyApportionPriceService;

/**
 * 分摊类型业务类
 * @author marchi.ma
 *
 */
@Service("monthlyApportionPriceService")
public class MonthlyApportionPriceServiceImpl implements MonthlyApportionPriceService {

	private static final Logger logger = Logger.getLogger(MonthlyApportionPriceServiceImpl.class);
	
	@Autowired
	private MonthlyApportionPriceDao monthlyApportionPriceDao;
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayMonthlyApportionPrice> page,
			Map<String, Object> parameter) {
		monthlyApportionPriceDao.queryForCondition(page, parameter);
		
	}
	
	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayMonthlyApportionPrice> page) {
		
		monthlyApportionPriceDao.queryForCondition(page, null);
		
	}
	
	/**
	 * 全量查询并保存到缓存中
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public List<PayMonthlyApportionPrice> queryAll() {
		ApplicationCache applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		List<PayMonthlyApportionPrice> list=(List<PayMonthlyApportionPrice>)applicationCache.getCacheObject("apportionTypeList");
		
		if(CollectionUtils.isEmpty(list)){
			list=monthlyApportionPriceDao.listAll();
			applicationCache.putCacheObject("apportionPriceList", list);
		}
		
		return list;
		
	}
	

	
	/**
	 * 刷新缓存
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@Expose
	public void refreshCache(){
		ApplicationCache applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		
		List<PayMonthlyApportionPrice> list=monthlyApportionPriceDao.listAll();
		
		applicationCache.putCacheObject("apportionPriceList", list);

	}
	
	/**
	 * 查询分摊类型关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<Integer, BigDecimal> getApportionTypeDesc() {
		
		
		Map<Integer, BigDecimal> mapValue = new LinkedHashMap<Integer, BigDecimal>();
		
		List<PayMonthlyApportionPrice> apportionTypes=queryAll();
		
		for(PayMonthlyApportionPrice apportionType:apportionTypes){
			mapValue.put(apportionType.getMonthly(), apportionType.getPrice());
		}
		
		
		
		return mapValue;
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param apportionTypes
	 * @return
	 * @exception
	 */
	@DataResolver
    public void saveAll(List<PayMonthlyApportionPrice> apportionTypes){
		
		for(PayMonthlyApportionPrice apportionType:apportionTypes){
			
			EntityState state=EntityUtils.getState(apportionType);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				apportionType.setCreateUser(user.getUsername());
				apportionType.setCreateTime(new Date());
				monthlyApportionPriceDao.save(apportionType);
			}else if(EntityState.MODIFIED.equals(state)){
				monthlyApportionPriceDao.update(apportionType);
			}else if(EntityState.DELETED.equals(state)){
				monthlyApportionPriceDao.deleteObject(apportionType);
			};
		}
    }
}
