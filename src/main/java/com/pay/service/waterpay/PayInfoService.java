package com.pay.service.waterpay;


import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.pay.pojo.waterpay.PayInfo;


public interface PayInfoService {
	
	
	public void queryPageForCondition(Page<PayInfo> page,Map<String, Object> parameter);
	
	public List<PayInfo> querySummaryForCondition(Map<String, Object> params);

}
