package com.pay.dao.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.data.provider.Page;
import com.pay.common.hibernate.BaseHibernateDAO;
import com.pay.dao.UserDao;
import com.pay.pojo.PayUser;

@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDAO<PayUser, Integer> implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public void queryForCondition(Page<PayUser> page,Map<String, Object> params) {
		String userName = "";
		String addr = "";
		String idCardNo = "";
		String mobile = "";
		if (params != null && params.size() > 0) {
			userName = (String) params.get("userName");
			addr = (String) params.get("addr");
			idCardNo = (String) params.get("addr");
			mobile = (String) params.get("mobile");
		}

		String whereCase = "";
		if (StringHelper.isNotEmpty(userName)) {
			whereCase += " AND userName = '" + userName + "' ";
		}

		if (StringHelper.isNotEmpty(addr)) {
			whereCase += " AND addr like '%" + addr + "%' ";
		}

		if (StringHelper.isNotEmpty(idCardNo)) {
			whereCase += " AND idCardNo = '" + idCardNo + "' ";
		}

		if (StringHelper.isNotEmpty(mobile)) {
			whereCase += " AND mobile = '" + mobile + "' ";
		}

		this.pagingHQLQuery(" from PayUser where 1=1 " + whereCase,
				page, null);

	}
}
