package com.pay.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;

public class InitListener implements ServletContextListener{
	
	private ApplicationCache applicationCache;
	
	public ApplicationCache getApplicationCache(){
		applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		return applicationCache;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent context) {  
   
	}  
 
	@Override
	public void contextInitialized(ServletContextEvent context) {  
		// 上下文初始化执行  
		System.out.println("================>[ServletContextListener]自动加载启动开始.");  
		Map<String, String> rxtxParams=new HashMap<String, String>();
		rxtxParams.put("port", "COM3");
		rxtxParams.put("baudRate", "2400");
		rxtxParams.put("displayRate", "0");
		rxtxParams.put("state", "2");
		rxtxParams.put("data", "0000");
		getApplicationCache().putCacheObject("rxtxDefaultSetting", rxtxParams);
 
	} 

}
