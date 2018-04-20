package com.pay.service.impl.waterpay;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.pay.dao.waterpay.WaterMeterInputBuildingDao;
import com.pay.dao.waterpay.WaterMeterInputDetailDao;
import com.pay.dao.waterpay.WaterMeterInputHeaderDao;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.pojo.waterpay.PayWaterMeterInputBuildingPK;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;
import com.pay.pojo.waterpay.PayWaterMeterInputHeader;
import com.pay.service.waterpay.WaterMeterInputDetailService;

@Service("waterMeterInputDetailService")
public class WaterMeterInputDetailServiceImpl implements
		WaterMeterInputDetailService {
	
	@Autowired
	private WaterMeterInputDetailDao waterMeterInputDetailDao;
	
	@Autowired
	private WaterMeterInputBuildingDao waterMeterInputBuildingDao;
	
	@Autowired
	private WaterMeterInputHeaderDao waterMeterInputHeaderDao;

	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayWaterMeterInputDetail> page,Map<String, Object> parameter) {	
		waterMeterInputDetailDao.queryPageForCondition(page, parameter);
	}
	
	/**
	 * 保存录入明细
	 * @param waterMeterInputDetails
	 */
	@DataResolver
	public void saveInputDetail(List<PayWaterMeterInputDetail> waterMeterInputDetails,Map<String,Object> parameter){
		
		String code=(String)parameter.get("code");
		Integer monthlyCycle=(Integer)parameter.get("monthlyCycle");
		String buildingCode=(String)parameter.get("buildingCode");
		String totalQty=(String)parameter.get("totalQty");
		

		
		for(PayWaterMeterInputDetail waterMeterInputDetail:waterMeterInputDetails){
			
			waterMeterInputDetail.setStatus(PayConstants.INPUT_DATA_DETAIL_STATUS_INPUT);
			waterMeterInputDetail.setLastModifyUser(ContextHolder.getLoginUserName());
			waterMeterInputDetail.setLastModifyTime(new Date());
			waterMeterInputDetailDao.update(waterMeterInputDetail);
		}
		
		
		//更新录入汇总状态
		PayWaterMeterInputHeader waterMeterInputHeader=waterMeterInputHeaderDao.get(code);
		if(waterMeterInputHeader!=null){
			if(waterMeterInputHeader.getStatus()==PayConstants.INPUT_DATA_STATUS_NEW){
				waterMeterInputHeader.setStatus(PayConstants.INPUT_DATA_STATUS_INPUT);
			}
			BigDecimal headerTotalQty=waterMeterInputDetailDao.getSum(code, "");
			waterMeterInputHeader.setCurrentQty(headerTotalQty);
			waterMeterInputHeader.setLastModifyUser(ContextHolder.getLoginUserName());
			waterMeterInputHeader.setLastModifyTime(new Date());
			waterMeterInputHeaderDao.update(waterMeterInputHeader);
		}
		
		//更新楼宇录入状态
		PayWaterMeterInputBuildingPK waterMeterInputBuildingPK=new PayWaterMeterInputBuildingPK();
		waterMeterInputBuildingPK.setCode(code);
		waterMeterInputBuildingPK.setMonthlyCycle(monthlyCycle);
		waterMeterInputBuildingPK.setBuildingCode(buildingCode);
		
		PayWaterMeterInputBuilding waterMeterInputBuilding=waterMeterInputBuildingDao.get(waterMeterInputBuildingPK);
		
		if(waterMeterInputBuilding!=null){
			
			Map<String,Object> getTotalCountParams=new HashMap<String, Object>();
			getTotalCountParams.put("code", code);
			getTotalCountParams.put("buildingCode", buildingCode);
			Long totalCount= waterMeterInputDetailDao.getCountForCondition(getTotalCountParams);
			Map<String,Object> getInputCountParams=new HashMap<String, Object>();
			getInputCountParams.put("code", code);
			getInputCountParams.put("buildingCode", buildingCode);
			getInputCountParams.put("status", PayConstants.INPUT_DATA_DETAIL_STATUS_INPUT);
			Long totalInputCount= waterMeterInputDetailDao.getCountForCondition(getInputCountParams);
			
			if(totalInputCount/totalCount==1){
				waterMeterInputBuilding.setStatus(PayConstants.INPUT_DATA_BUILDING_STATUS_ALLINPUT);
			}else{
				if(waterMeterInputBuilding.getStatus()==PayConstants.INPUT_DATA_BUILDING_STATUS_NEW){
					waterMeterInputBuilding.setStatus(PayConstants.INPUT_DATA_BUILDING_STATUS_INPUT);
				}
			}
			
			BigDecimal buildingTotalQty=waterMeterInputDetailDao.getSum(code, buildingCode);
			waterMeterInputBuilding.setCurrentQty(buildingTotalQty);
			waterMeterInputBuildingDao.update(waterMeterInputBuilding);
		}
	}
	
	/**
	 * 保存
	 * @author marchi.ma
	 * @param waterMeterInputDetails
	 */
	@DataResolver
    public void saveAll(List<PayWaterMeterInputDetail> waterMeterInputDetails){
		
		for(PayWaterMeterInputDetail waterMeterInputDetail:waterMeterInputDetails){
			
			EntityState state=EntityUtils.getState(waterMeterInputDetail);
			
			IUser user= ContextHolder.getLoginUser();
			
			if(EntityState.NEW.equals(state)){
				waterMeterInputDetail.setCreateUser(user.getUsername());
				waterMeterInputDetail.setCreateTime(new Date());
				waterMeterInputDetailDao.save(waterMeterInputDetail);
			}else if(EntityState.MODIFIED.equals(state)){

				waterMeterInputDetail.setStatus(PayConstants.INPUT_DATA_STATUS_COMPLETE);
				waterMeterInputDetail.setLastModifyUser(user.getUsername());
				waterMeterInputDetail.setLastModifyTime(new Date());
				waterMeterInputDetailDao.update(waterMeterInputDetail);
			}else if(EntityState.DELETED.equals(state)){
				waterMeterInputDetailDao.deleteObject(waterMeterInputDetail);
			};
		}
    }
}
