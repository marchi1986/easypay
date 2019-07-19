package com.pay.processor.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.stereotype.Service;
import com.bstek.bdf2.importexcel.exception.InterceptorException;
import com.bstek.bdf2.importexcel.interceptor.impl.RequiredInterceptor;





@Service("bdf2.CheckMonthly")
public class CheckMonthly extends RequiredInterceptor {
	

	
    public Object execute(Object cellValue) throws Exception {
    	super.execute(cellValue);
    	boolean bool = checkData(cellValue);
        if (bool) {
            return cellValue;
        } else {
        	throw new InterceptorException("月度周期格式不正确:"+cellValue);
        }
    }
    public String getName() {
        return "月度周期格式不正确";
    }
    
	public boolean checkData(Object cellValue){
    	boolean bool = false;
    	String monthly=(String)cellValue;
    	if(monthly.length()!=6){
    		return bool;
    	}
    	
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");

    	try{
    		Date date= sdf.parse(monthly);
    		bool=true;
    	}catch (Exception e) {
			bool=false;
		}

		return bool;
    }
}
