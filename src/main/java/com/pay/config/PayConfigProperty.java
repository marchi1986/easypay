package com.pay.config;

import java.util.Map.Entry;

import org.springframework.beans.factory.InitializingBean;

import com.bstek.dorado.core.Configure;
import com.bstek.dorado.core.ConfigureStore;
import com.bstek.dorado.spring.RemovableBean;

public class PayConfigProperty implements InitializingBean,RemovableBean {

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		ConfigureStore configureStore = Configure.getStore();
		for(Entry<Object, Object> entry: LocaleConfig.hibernateProps.entrySet()){
			configureStore.set(entry.getKey().toString(), entry.getValue());
		}
		
		for(Entry<Object, Object> entry: LocaleConfig.jdbcProps.entrySet()){
			configureStore.set(entry.getKey().toString(), entry.getValue());
		}
		
	}

	
}
