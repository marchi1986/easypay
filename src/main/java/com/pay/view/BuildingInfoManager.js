var change="";

//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetBuildingInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetBuildingInfo.set("parameter",entity).flushAsync();
}

//@Bind #buttonSave.onClick
!function(self,arg,updateActionSave,dialogEdit){
	updateActionSave.execute(function(){
	    dialogEdit.hide();
	})
}

//@Bind #buttonSaveDetail.onClick
!function(self,arg,updateActionSaveDetail,dialogDetailEdit){
	updateActionSaveDetail.execute(function(){
		dialogDetailEdit.hide();
	})
}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogEdit,dataSetBuildingInfo){
	
	dataSetBuildingInfo.get("data:#").cancel();
	dialogEdit.hide();
}

//@Bind #buttonCancelDetail.onClick
!function(self,arg,dialogDetailEdit,dataSetBuildingDetail){
	
	dataSetBuildingDetail.get("data:#").cancel();
	dialogDetailEdit.hide();
}

//@Bind #buttonAdd.onClick
!function(self,arg,dialogEdit,dataSetBuildingInfo,autoFormBuildingInfo){
	
	dataSetBuildingInfo.insert({"status":1});
	
	
	dialogEdit.show();

//	window.setTimeout(function(){
//	//对其设置焦点
//		autoFormBuildingInfo.getElement("code").setFocus();
//	},500);
	
	
	setFocus(autoFormBuildingInfo.getElement("code").getDom());
}

//@Bind #buttonAddDetail.onClick
!function(self,arg,dataSetBuildingInfo,dataSetBuildingDetail,dialogDetailEdit,autoFormDetail){
	
	dataSetBuildingDetail.insert({code:dataSetBuildingInfo.get("data:#").get("code"),"pricingTypeId":1,"apportionTypeId":1,"status":1});
	autoFormDetail.get("#waterMeterCode").set("readOnly",false);
	dialogDetailEdit.show();
	setFocus(autoFormDetail.getElement("roomNo").getDom());
}

//@Bind #buttonEdit.onClick
!function(self,arg,dialogEdit){
	
	dialogEdit.show();
}

//@Bind #buttonEditDetail.onClick
!function(self,arg,dialogDetailEdit,autoFormDetail,dataSetBuildingInfo){
	autoFormDetail.get("#waterMeterCode").set("readOnly",true);
	
	dialogDetailEdit.show();
}


//@Bind #buttonDel.onClick
!function(self,arg,dataSetBuildingInfo,updateActionSave){
	
	var entity = dataSetBuildingInfo.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSave.execute();
	    })
	}
}

//@Bind #buttonDelDetail.onClick
!function(self,arg,dataSetBuildingDetail,updateActionSaveDetail){
	
	var entity = dataSetBuildingDetail.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSaveDetail.execute();
	    })
	}
}

//@Bind #datagridBuilding.onDoubleClick
!function(self,arg,dataSetBuildingInfo,dialogDetail,dataSetBuildingDetail){
	var entity={"code":dataSetBuildingInfo.get("data:#").get("code")};
	//将实体对象作为参数传入，并异步刷新
	dataSetBuildingDetail.set("parameter",entity).flushAsync();
	
	dialogDetail.show();

}

//@Bind #buttonDetail.onClick
!function(self,arg,dialogDetail,dataSetBuildingInfo,dataSetBuildingDetail){
	var entity={"code":dataSetBuildingInfo.get("data:#").get("code")};
	//将实体对象作为参数传入，并异步刷新
	dataSetBuildingDetail.set("parameter",entity).flushAsync();
	
	dialogDetail.show();
}

//@Bind #buttonReplaceWaterMeter.onClick
!function(self,arg,dataSetReplaceWaterMeter,dialogUpdateWaterMeter,dataSetBuildingDetail){
	var buildingCode=dataSetBuildingDetail.get("data:#").get("code");
	var roomNo=dataSetBuildingDetail.get("data:#").get("roomNo");
	var oldWaterMeterCode=dataSetBuildingDetail.get("data:#").get("waterMeterCode");
	dataSetReplaceWaterMeter.clear();
	dataSetReplaceWaterMeter.insert({"buildingCode":buildingCode,"roomNo":roomNo,"oldWaterMeterCode":oldWaterMeterCode});

	dialogUpdateWaterMeter.show();
}

//@Bind #buttonSaveReplaceHistory.onClick
!function(self,arg,dataSetReplaceWaterMeter,dialogUpdateWaterMeter,updateActionReplaceWaterMeter,dataSetBuildingDetail){
	updateActionReplaceWaterMeter.execute(function(){
		dataSetBuildingDetail.set("parameter",{"code":dataSetBuildingDetail.get("data:#").get("code")}).flushAsync();
		dialogUpdateWaterMeter.hide();
	});

}





//@Bind #datagridUser.onDoubleClick
!function(self,arg,dataSetBuildingDetail,dialogUserCode){

	var entity=self.get("currentEntity");

	var formData= dataSetBuildingDetail.getData("#");
	
	if(change=="userId"){
		formData.set("userId",entity.get("id"));
		
		formData.set("userName",entity.get("userName"));
	}else{
		formData.set("contractorId",entity.get("id"));
		
		formData.set("contractorName",entity.get("userName"));
	}

	dialogUserCode.hide();
}

//@Bind #triggerUserCode.onExecute
!function(slef,arg,dialogUserCode){
	

	change=arg.editor.get("parent").get("name");

	dialogUserCode.set("userData", arg.editor);
	dialogUserCode.show();
}


//@Bind #buttonPrint.onClick
!function(self,arg,dialogEdit){
	
	window.print();
}


