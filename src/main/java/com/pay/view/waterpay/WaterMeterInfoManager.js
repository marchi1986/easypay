//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetWaterMeterInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetWaterMeterInfo.set("parameter",entity).flushAsync();
}

//@Bind #buttonSave.onClick
!function(self,arg,updateActionSave,dialogEdit){
	updateActionSave.execute(function(){
	    dialogEdit.hide();
	})
}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogEdit,dataSetWaterMeterInfo){
	
	dataSetWaterMeterInfo.get("data:#").cancel();
	dialogEdit.hide();
}

//@Bind #buttonAdd.onClick
!function(self,arg,dialogEdit,dataSetWaterMeterInfo){
	dataSetWaterMeterInfo.insert();
	dialogEdit.show();
}

//@Bind #buttonEdit.onClick
!function(self,arg,dialogEdit,dataSetWaterMeterInfo){
	

	var formData= dataSetWaterMeterInfo.getData("#");
	
	formData.set("buildingName",formData.get("buildingInfo").get("name"));

	formData.set("buildingCode",formData.get("buildingInfo").get("code"));
	
	formData.set("waterMeterUserName",formData.get("waterMeterUser").get("userName"));
	
	dialogEdit.show();
}

//@Bind #buttonDel.onClick
!function(self,arg,dataSetWaterMeterInfo,updateActionSave){
	
	var entity = dataSetWaterMeterInfo.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSave.execute();
	    })
	}
}


//@Bind #buttonPrint.onClick
!function(self,arg,dialogEdit){
	
	window.print();
}

//@Bind #buttonSearchBuilding.onClick
!function(self,arg,dialogEdit,autoFormBuildingCondition,dataSetBuilding){
	//获取autoformCondition绑定的实体对象
	var entity = autoFormBuildingCondition.get("entity");
	//将实体对象作为参数传入，并异步刷新
	dataSetBuilding.set("parameter",entity).flushAsync();
}

//@Bind #buttonSearchUser.onClick
!function(self,arg,dialogEdit,autoFormUserCondition,dataSetUser){
	//获取autoformCondition绑定的实体对象
	var entity = autoFormUserCondition.get("entity");
	//将实体对象作为参数传入，并异步刷新
	dataSetUser.set("parameter",entity).flushAsync();
}

//@Bind #datagridBuilding.onDoubleClick
!function(self,arg,dataSetWaterMeterInfo,dialogBuildingCode){

	var entity=self.get("currentEntity");

	var formData= dataSetWaterMeterInfo.getData("#");
	
	formData.set("buildingCode",entity.get("code"));
	
	formData.set("buildingName",entity.get("name"));

	formData.get("buildingInfo").set("name",entity.get("name"));
	

	dialogBuildingCode.hide();
}

//@Bind #datagridUser.onDoubleClick
!function(self,arg,dataSetWaterMeterInfo,dialogUserCode){

	var entity=self.get("currentEntity");

	var formData= dataSetWaterMeterInfo.getData("#");

	formData.set("waterMeterUserId",entity.get("id"));
	
	formData.set("waterMeterUserName",entity.get("userName"));

	

	dialogUserCode.hide();
}
