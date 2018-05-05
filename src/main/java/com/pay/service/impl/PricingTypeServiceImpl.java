package com.pay.service.impl;

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
import com.pay.dao.PricingTypeDao;
import com.pay.pojo.PayApportionType;
import com.pay.pojo.PayPricingType;
import com.pay.service.PricingTypeService;

/**
 * 计价类型业务类
 * @author marchi.ma
 *
 */
@Service("pricingTypeService")
public class PricingTypeServiceImpl implements PricingTypeService {

	private static final Logger logger = Logger.getLogger(PricingTypeServiceImpl.class);
	
	@Autowired
	private PricingTypeDao pricingTypeDao;
	
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayPricingType> page,
			Map<String, Object> parameter) {
		pricingTypeDao.queryForCondition(page, parameter);
		
	}
	
	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param page
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayPricingType> page) {
		
		pricingTypeDao.queryForCondition(page, null);
		
	}
	
	/**
	 * 查询全部并保存到缓存
	 * @author marchi.ma
	 * @param page
	 * @return
	 * @exception
	 */
	@DataProvider
	public List<PayPricingType> queryAll() {
		ApplicationCache applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		List<PayPricingType> list=(List<PayPricingType>)applicationCache.getCacheObject("pricingTypeList");
		
		if(CollectionUtils.isEmpty(list)){
			list=pricingTypeDao.listAll();
			applicationCache.putCacheObject("pricingTypeList", list);
		}
		
		return list;
		
	}
	
	public Map<Integer,PayPricingType>  queryApportionTypeForMap(){
		List<PayPricingType> list=queryAll();
		Map<Integer,PayPricingType> map=new HashMap<Integer, PayPricingType>();
		for(PayPricingType apportionType:list){
			map.put(apportionType.getId(), apportionType);
		}
		return map;
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
		
		List<PayPricingType> list=pricingTypeDao.listAll();
		
		applicationCache.putCacheObject("pricingTypeList", list);

	}
	
	/**
	 * 查询计价类型关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<Integer, String> getPricingTypeDesc() {
		
		
		Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
		
		List<PayPricingType> pricingTypes=queryAll();
		
		for(PayPricingType pricingType:pricingTypes){
			mapValue.put(pricingType.getId(), pricingType.getPricingName());
		}
		
		
		
		return mapValue;
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param pricingTypes
	 * @return
	 * @exception
	 */
	@DataResolver
    public void saveAll(List<PayPricingType> pricingTypes){
		
		for(PayPricingType pricingType:pricingTypes){
			
			EntityState state=EntityUtils.getState(pricingType);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				pricingType.setCreateUser(user.getUsername());
				pricingType.setCreateTime(new Date());
				pricingTypeDao.save(pricingType);
			}else if(EntityState.MODIFIED.equals(state)){
				pricingType.setLastModifyUser(user.getUsername());
				pricingType.setLastModifyTime(new Date());
				pricingTypeDao.update(pricingType);
			}else if(EntityState.DELETED.equals(state)){
				pricingTypeDao.deleteObject(pricingType);
			};
		}
    }
}
