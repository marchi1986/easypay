package com.pay.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.pay.dao.UserDao;
import com.pay.pojo.PayUser;
import com.pay.service.UserService;

/**
 * 水表用户业务表
 * @author marchi.ma
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayUser> page,Map<String, Object> parameter) {
		userDao.queryForCondition(page, parameter);
		
	}
	
	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param page
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayUser> page) {
		
		userDao.queryForCondition(page, null);
		
	}
	
	/**
	 * 按主键获取对象
	 * @author marchi.ma
	 * @param id
	 * @return
	 * @exception
	 */
	@DataProvider
	public PayUser get(Integer id) {
		
		return userDao.get(id);
		
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param waterMeterUsers
	 * @return
	 * @exception
	 */
	@DataResolver
    public void saveAll(List<PayUser> waterMeterUsers){
		
		for(PayUser waterMeterUser:waterMeterUsers){
			
			EntityState state=EntityUtils.getState(waterMeterUser);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				waterMeterUser.setStatus(1);
				waterMeterUser.setCreateUser(user.getUsername());
				waterMeterUser.setCreateTime(new Date());
				userDao.save(waterMeterUser);
			}else if(EntityState.MODIFIED.equals(state)){
				waterMeterUser.setLastModifyUser(user.getUsername());
				waterMeterUser.setLastModifyTime(new Date());
				userDao.update(waterMeterUser);
			}else if(EntityState.DELETED.equals(state)){
				userDao.deleteObject(waterMeterUser);
			};
		}
    }
	
	/**
	 * 获取性别关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<String, String> getSexDesc() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("0", "女");
		mapValue.put("1", "男");
		return mapValue;
	}
}
