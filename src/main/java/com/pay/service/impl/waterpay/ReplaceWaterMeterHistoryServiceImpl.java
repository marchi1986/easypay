package com.pay.service.impl.waterpay;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.pay.dao.BuildingDetailDao;
import com.pay.dao.waterpay.ReplaceWaterMeterHistoryDao;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.pojo.PayReplaceWaterMeterHistory;
import com.pay.service.waterpay.ReplaceWaterMeterHistoryService;

@Service("replaceWaterMeterHistoryService")
public class ReplaceWaterMeterHistoryServiceImpl implements ReplaceWaterMeterHistoryService{

	@Autowired
	private ReplaceWaterMeterHistoryDao replaceWaterMeterHistoryDao;
	
	@Autowired
	private BuildingDetailDao buildingDetailDao;
	
	/**
	 * 保存
	 * @param payReplaceWaterMeterHistory
	 */
	@DataResolver
	public void save(PayReplaceWaterMeterHistory payReplaceWaterMeterHistory){
		
		PayBuildingDetailPK buildingDetailPK=new PayBuildingDetailPK();
		buildingDetailPK.setCode(payReplaceWaterMeterHistory.getBuildingCode());
		buildingDetailPK.setRoomNo(payReplaceWaterMeterHistory.getRoomNo());
		
		PayBuildingDetail buildingDetail= buildingDetailDao.get(buildingDetailPK);
		
		buildingDetail.setWaterMeterCode(payReplaceWaterMeterHistory.getNewWaterMeterCode());
		buildingDetail.setLastModifyUser(ContextHolder.getLoginUserName());
		buildingDetail.setLastModifyTime(new Date());
		buildingDetail.setMonthlyQty(buildingDetail.getMonthlyQty().subtract(payReplaceWaterMeterHistory.getQty()));
		buildingDetail.setRemark("水表号由'"+payReplaceWaterMeterHistory.getOldWaterMeterCode()+"'更改为'"+payReplaceWaterMeterHistory.getNewWaterMeterCode()+"'");
		buildingDetailDao.update(buildingDetail);
		
		payReplaceWaterMeterHistory.setCreateUser(ContextHolder.getLoginUserName());
		payReplaceWaterMeterHistory.setCreateTime(new Date());
		payReplaceWaterMeterHistory.setLastModifyUser(ContextHolder.getLoginUserName());
		payReplaceWaterMeterHistory.setLastModifyTime(new Date());
		replaceWaterMeterHistoryDao.save(payReplaceWaterMeterHistory);
	}
	
	/**
	 * 按条件分页查询
	 * @param page
	 * @param parameter
	 */
	@DataProvider
	public void queryForCondition(Page<PayReplaceWaterMeterHistory> page,
			Map<String, Object> parameter) {
		replaceWaterMeterHistoryDao.queryForCondition(page, parameter);
		
	}
}
