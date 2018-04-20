package com.pay.dao;

import java.util.Map;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.IBaseDao;
import com.pay.pojo.PayApportionType;

public interface ApportionTypeDao extends IBaseDao<PayApportionType, Integer> {

	public void queryForCondition(Page<PayApportionType> page, Map<String, Object> params) ;
}
