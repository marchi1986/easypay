package com.pay.service.impl.waterpay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.DateUtils;
import com.pay.dao.waterpay.PayInfoDao;
import com.pay.pojo.waterpay.PayInfo;
import com.pay.service.waterpay.PayInfoService;





@Service("payInfoService")
public class PayInfoServiceImpl implements PayInfoService {
	
	@Autowired
	private PayInfoDao payInfoDao;
	
	@DataProvider
	public void queryPageForCondition(Page<PayInfo> page,Map<String, Object> parameter){
		
		if(MapUtils.isNotEmpty(parameter)){
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String beginDateFormat= sdf.format(beginDate);
			String endDateFormat= sdf.format(endDate);
			parameter.put("beginDate", beginDateFormat);
			parameter.put("endDate", endDateFormat);
		}
		
		payInfoDao.queryPageForCondition(page, parameter);
	}
	
	@DataProvider
	public List<PayInfo> querySummaryForCondition(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			String beginDateFormat= DateUtils.format(beginDate,"yyyy-MM-dd");
			String endDateFormat= DateUtils.format(endDate,"yyyy-MM-dd");
			parameter.put("beginDate", beginDateFormat);
			parameter.put("endDate", endDateFormat);
		}
		List<PayInfo> list=payInfoDao.querySummaryForCondition(parameter);
		return list;
	}
	
	@DataProvider
	public List<PayInfo> querySummaryForDateAndTollCollector(Map<String, Object> parameter) {
		if(MapUtils.isNotEmpty(parameter)){
			Date beginDate=(Date)parameter.get("beginDate");
			Date endDate=(Date)parameter.get("endDate");
			String beginDateFormat= DateUtils.format(beginDate,"yyyy-MM-dd");
			String endDateFormat= DateUtils.format(endDate,"yyyy-MM-dd");
			parameter.put("beginDate", beginDateFormat);
			parameter.put("endDate", endDateFormat);
		}
		List<PayInfo> list=payInfoDao.querySummaryForDateAndTollCollector(parameter);
		return list;
	}



	
}
