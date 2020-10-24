package com.pay.service.impl.waterpay;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
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
import com.pay.dao.waterpay.WaterMeterInfoDao;
import com.pay.pojo.waterpay.PayWaterMeterInfo;
import com.pay.service.waterpay.WaterMeterInfoService;


/**
 * 水表信息业务表
 * @author marchi.ma
 *
 */
@Service("waterMeterInfoService")
public class WaterMeterInfoServiceImpl implements WaterMeterInfoService {

	private static final Logger logger = Logger.getLogger(WaterMeterInfoServiceImpl.class);
	
	@Autowired
	private WaterMeterInfoDao waterMeterInfoDao;
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayWaterMeterInfo> page,
			Map<String, Object> patameter) {
		waterMeterInfoDao.queryForCondition(page, patameter);
		
	}

	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param page
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryForCondition(Page<PayWaterMeterInfo> page) {
		waterMeterInfoDao.queryForCondition(page,null);
		
	}
	
	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 */
	@DataProvider
	public PayWaterMeterInfo get(String code) {
		return waterMeterInfoDao.get(code);
		
	}

	/**
	 * 保存
	 * @author marchi.ma
	 * @param waterMeterInfos
	 * @return
	 * @exception
	 */
	@DataResolver
	public void saveAll(List<PayWaterMeterInfo> waterMeterInfos) {
		for(PayWaterMeterInfo waterMeterInfo:waterMeterInfos){
			
			EntityState state=EntityUtils.getState(waterMeterInfo);
			
			IUser user= ContextHolder.getLoginUser();
			
			
			if(EntityState.NEW.equals(state)){
				waterMeterInfo.setStatus(1);
				waterMeterInfo.setCreateUser(user.getUsername());
				waterMeterInfo.setCreateTime(new Date());
				waterMeterInfoDao.save(waterMeterInfo);
			}else if(EntityState.MODIFIED.equals(state)){
				waterMeterInfo.setLastModifyUser(user.getUsername());
				waterMeterInfo.setLastModifyTime(new Date());
				waterMeterInfoDao.update(waterMeterInfo);
			}else if(EntityState.DELETED.equals(state)){
				waterMeterInfoDao.deleteObject(waterMeterInfo);
			};
		}
		
	}
	
	/**
	 * 获取状态关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<String, String> getStatusDesc() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("0", "停用");
		mapValue.put("1", "启用");
		return mapValue;
	}
	
	@DataProvider
	public Map<String, String> getIsCountApportionDesc() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("0", "否");
		mapValue.put("1", "是");
		return mapValue;
	}
	
	/**
	 * 获取是否主表关联
	 * @author marchi.ma
	 * @param 
	 * @return
	 * @exception
	 */
	@DataProvider
	public Map<String, String> getIsMainDesc() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("0", "否");
		mapValue.put("1", "是");
		return mapValue;
	}

}
