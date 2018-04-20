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
import com.pay.common.PayConstants;
import com.pay.dao.BuildingInfoDao;
import com.pay.pojo.PayBuildingInfo;
import com.pay.service.BuildingInfoService;


/**
 * 楼宇信息业务类
 * @author marchi.ma
 *
 */
@Service("buildingInfoService")
public class BuildingInfoServiceImpl implements BuildingInfoService {

	private static final Logger logger = Logger.getLogger(BuildingInfoServiceImpl.class);
	
	@Autowired
	private BuildingInfoDao buildingInfoDao;
	
	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayBuildingInfo> page,
			Map<String, Object> parameter) {
		buildingInfoDao.queryPageForCondition(page, parameter);
		
	}
	
	/**
	 * 分页查询
	 * @author marchi.ma
	 * @param page
	 * @return
	 * @exception
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayBuildingInfo> page) {
		
		buildingInfoDao.queryPageForCondition(page, null);
		
	}
	
	/**
	 * 按主键获取对象
	 * @author marchi.ma
	 * @param id
	 * @return
	 * @exception
	 */
	@DataProvider
	public PayBuildingInfo get(String code) {
		
		return buildingInfoDao.get(code);
		
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param buildingInfos
	 * @return
	 * @exception
	 */
	@DataResolver
    public void saveAll(List<PayBuildingInfo> buildingInfos){
		
		for(PayBuildingInfo buildingInfo:buildingInfos){
			
			EntityState state=EntityUtils.getState(buildingInfo);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				buildingInfo.setStatus(PayConstants.ENABLED_STATUS);
				buildingInfo.setCreateUser(user.getUsername());
				buildingInfo.setCreateTime(new Date());
				buildingInfoDao.save(buildingInfo);
			}else if(EntityState.MODIFIED.equals(state)){
				buildingInfo.setLastModifyUser(user.getUsername());
				buildingInfo.setLastModifyTime(new Date());
				buildingInfoDao.update(buildingInfo);
			}else if(EntityState.DELETED.equals(state)){
				buildingInfoDao.deleteObject(buildingInfo);
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
	
}
