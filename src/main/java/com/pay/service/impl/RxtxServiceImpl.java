package com.pay.service.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.common.rxtx.ClientDisplay;
import com.common.rxtx.RxtxPortModel;
import com.pay.service.RxtxService;

import gnu.io.CommPortIdentifier;

@Service("rxtxService")
public class RxtxServiceImpl implements RxtxService {

	private static final Logger logger = Logger.getLogger(RxtxServiceImpl.class);
	
	private ApplicationCache applicationCache;
	
	public ApplicationCache getApplicationCache(){
		applicationCache= ContextHolder.getBean("bdf2.applicationCache");
		return applicationCache;
	}
	
	@DataProvider
	public List<RxtxPortModel> listAvailableCommPorts() {
        // TODO code application logic here
        CommPortIdentifier portId;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();
        // iterate through the ports.
        List<RxtxPortModel> ports=new ArrayList<RxtxPortModel>();
        while (en.hasMoreElements()) {
        	
        	portId = (CommPortIdentifier) en.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            	
            	System.out.println(portId.getName());
            	RxtxPortModel rxtxPortModel=new RxtxPortModel();
            	rxtxPortModel.setPortName(portId.getName());
            	rxtxPortModel.setCurrentOwner(portId.getCurrentOwner());
            	rxtxPortModel.setPortType(portId.getPortType());
            	ports.add(rxtxPortModel);
            }
            
        }
        return ports;
    }
	
	@Expose
	public void sendDisplayTest(Map<String,String> params){
		try {
			ClientDisplay.sendDisplay(params);
		} catch (Exception e) {
			logger.error("调用顾显屏异常！",e);
		}
	}
	
	@Expose
	public void sendDisplay(Map<String,String> params){
		try {
			String state= params.get("state");
			String data= params.get("data");
			Map<String, String> rxtxParams=null;
			try{
				rxtxParams=(Map<String, String>)applicationCache.getCacheObject("rxtxDefaultSetting");
			}catch(NullPointerException e){
				logger.error("没有缓存顾显屏设置");
			}
			
			if(rxtxParams!=null){
				rxtxParams.put("state", state);
				rxtxParams.put("data", data);
				ClientDisplay.sendDisplay(rxtxParams);
			}else{
				rxtxParams=new HashMap<String, String>();
				rxtxParams.put("port", "COM3");
				rxtxParams.put("baudRate", "2400");
				rxtxParams.put("displayRate", "0");
				rxtxParams.put("state", state);
				rxtxParams.put("data", data);
				ClientDisplay.sendDisplay(rxtxParams);
			}
			
			
		} catch (Exception e) {
			logger.error("调用顾显屏异常！",e);
		}
	}
	
	@Expose
	public void save(Map<String,String> params){
		getApplicationCache().putCacheObject("rxtxDefaultSetting", params);
	}
}
