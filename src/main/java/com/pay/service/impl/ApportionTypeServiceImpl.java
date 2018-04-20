package com.pay.service.impl;

import java.util.Date;
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
import com.pay.pojo.PayApportionType;
import com.pay.service.ApportionTypeService;

/**
 * 分摊类型业务类
 * @author marchi.ma
 *
 */
@Service("apportionTypeService")
public class ApportionTypeServiceImpl implements ApportionTypeService {

	private static final Logger logger = Logger.getLogger(ApportionTypeServiceImpl.class);
	
	@Autowired
	private ApportionTypeDao apportionTypeDao;
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayApportionType> page,
			Map<String, Object> parameter) {
		apportionTypeDao.queryForCondition(page, parameter);
		
	}
	
	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayApportionType> page) {
		
		apportionTypeDao.queryForCondition(page, null);
		
	}
	
	/**
	 * 全量查询并保存到缓存中
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public List<PayApportionType> queryAll() {
		ApplicationCache applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		List<PayApportionType> list=(List<PayApportionType>)applicationCache.getCacheObject("apportionTypeList");
		
		if(CollectionUtils.isEmpty(list)){
			list=apportionTypeDao.listAll();
			applicationCache.putCacheObject("apportionTypeList", list);
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
		
		List<PayApportionType> list=apportionTypeDao.listAll();
		
		applicationCache.putCacheObject("apportionTypeList", list);

	}
	
	/**
	 * 查询分摊类型关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<Integer, String> getApportionTypeDesc() {
		
		
		Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
		
		List<PayApportionType> apportionTypes=queryAll();
		
		for(PayApportionType apportionType:apportionTypes){
			mapValue.put(apportionType.getId(), apportionType.getApportionName());
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
    public void saveAll(List<PayApportionType> apportionTypes){
		
		for(PayApportionType apportionType:apportionTypes){
			
			EntityState state=EntityUtils.getState(apportionType);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				apportionType.setCreateUser(user.getUsername());
				apportionType.setCreateTime(new Date());
				apportionTypeDao.save(apportionType);
			}else if(EntityState.MODIFIED.equals(state)){
				apportionType.setLastModifyUser(user.getUsername());
				apportionType.setLastModifyTime(new Date());
				apportionTypeDao.update(apportionType);
			}else if(EntityState.DELETED.equals(state)){
				apportionTypeDao.deleteObject(apportionType);
			};
		}
    }
}
