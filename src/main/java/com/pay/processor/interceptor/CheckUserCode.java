package com.pay.processor.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bstek.bdf2.importexcel.exception.InterceptorException;
import com.bstek.bdf2.importexcel.interceptor.impl.RequiredInterceptor;
import com.pay.pojo.PayBuildingDetail;
import com.pay.pojo.PayBuildingDetailPK;
import com.pay.service.BuildingDetailService;




@Service("bdf2.CheckUserCode")
public class CheckUserCode extends RequiredInterceptor {
	
	@Autowired
	private BuildingDetailService buildingDetailService;
	
    public Object execute(Object cellValue) throws Exception {
    	super.execute(cellValue);
    	boolean bool = checkData(cellValue);
        if (bool) {
            return cellValue;
        } else {
        	throw new InterceptorException("用户编号不存在:"+cellValue);
        }
    }
    public String getName() {
        return "验证用户编号是否存在";
    }
    
	public boolean checkData(Object cellValue){
    	boolean bool = false;
    	String userCode=(String)cellValue;
    	if(userCode.length()!=9){
    		return bool;
    	}
    	PayBuildingDetailPK pk=new PayBuildingDetailPK();
    	pk.setCode(userCode.substring(0,6));
    	pk.setRoomNo(userCode.substring(6,9));
    	PayBuildingDetail detail=buildingDetailService.get(pk);
    	if(detail!=null&&detail.getStatus()==1){
    		bool=true;
    	}
		return bool;
    }
}
