package com.pay.service.impl.waterpay;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.pay.dao.waterpay.WaterMeterInputBuildingDao;
import com.pay.dao.waterpay.WaterMeterInputDetailDao;
import com.pay.pojo.waterpay.PayWaterMeterInputBuilding;
import com.pay.service.waterpay.WaterMeterInputBuildingService;

@Service("waterMeterInputBuildingService")
public class WaterMeterInputBuildingServiceImpl implements
		WaterMeterInputBuildingService {
	
	@Autowired
	private WaterMeterInputDetailDao waterMeterInputDetailDao;
	
	@Autowired
	private WaterMeterInputBuildingDao waterMeterInputBuildingDao;

	/**
	 * 根据条件分页查询
	 * @author marchi.ma
	 * @param page,parameter
	 */
	@DataProvider
	public void queryPageForCondition(Page<PayWaterMeterInputBuilding> page,Map<String, Object> parameter) {
			
		if(MapUtils.isNotEmpty(parameter)){
			Date monthly=(Date)parameter.get("monthlyCycle");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			String dateFormat= sdf.format(monthly);
			parameter.put("monthly", Integer.parseInt(dateFormat));
		}
		
		waterMeterInputBuildingDao.queryPageForCondition(page, parameter);
		
		List<PayWaterMeterInputBuilding> waterMeterInputBuildings= (List<PayWaterMeterInputBuilding>)page.getEntities();
		
		if(CollectionUtils.isNotEmpty(waterMeterInputBuildings)){
			//计算录入比
			for(PayWaterMeterInputBuilding waterMeterInputBuilding:waterMeterInputBuildings){
				Map<String,Object> params =new HashMap<String, Object>();
				params.put("code", waterMeterInputBuilding.getCode());
				params.put("buildingCode", waterMeterInputBuilding.getBuildingCode());
				Long totalCount=waterMeterInputDetailDao.getCountForCondition(params);
				
				params.put("status", 1);
				
				Long inputCount=waterMeterInputDetailDao.getCountForCondition(params);
				
				if(totalCount!=0){
					BigDecimal percent=new BigDecimal(inputCount).divide(new BigDecimal(totalCount),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
					waterMeterInputBuilding.setInputPercent(percent.toString()+"%");
				}else{
					waterMeterInputBuilding.setInputPercent("0%");
				}
				
				
				
				
			}
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
		mapValue.put("", "");
		mapValue.put("0", "新单");
		mapValue.put("1", "录入中");
		mapValue.put("2", "录入完成");
		mapValue.put("3", "已确认");
		return mapValue;
	}
}
