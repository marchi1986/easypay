//@Bind #dataSetCondition.onReady
!function(self,arg){
	var d = new Date();
	self.insert({"monthlyCycle":d});
}

//@Bind #buttonImport.onClick
!function(self,arg) {
	var importExcelAction=view.get("#importExcelAction");
	importExcelAction.execute(function(arg){
		dorado.MessageBox.alert("成功解析导入[" + arg + "]数据！");
	});
};

//@Bind #downloadAction.beforeExecute
!function(self, fileEditor){
	var fileName = "WaterMeterImport.xlsx";
	self.set("parameter",{
		file: fileName
	});
};

//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetInputBuilding){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	
	if(!isNotNull(entity.get("monthlyCycle"))){
		dorado.MessageBox.alert("请选择月度！");
		return
	}

	//将实体对象作为参数传入，并异步刷新
	dataSetInputBuilding.set("parameter",entity).flushAsync();

}
//@Bind #buttonDetail.onClick
!function(self,arg,autoFormCondition,dataSetInputBuilding,dataSetInputDetail,dialogDetail){
var record=dataSetInputBuilding.getData("#");
	
	var code=record.get("code");
	var monthlyCycle=record.get("monthlyCycle");
	var buildingCode=record.get("buildingCode");

	var entity={"code":code,"monthlyCycle":monthlyCycle,"buildingCode":buildingCode};

	if(record.get("status")==2){
		dataSetInputDetail.set("readOnly",true);
	}else{
		dataSetInputDetail.set("readOnly",false);
	}
	
	//将实体对象作为参数传入，并异步刷新
	dataSetInputDetail.set("parameter",entity).flushAsync();
	
	
	dialogDetail.show();

	
}

//@Bind #buttonCancelDetail.onClick
!function(self,arg,autoFormCondition,dataSetInputBuilding,dataSetInputDetail,dialogDetail){

	dialogDetail.hide();
	
}

//@Bind #buttonSaveDetail.onClick
!function(self,arg,updateActionSaveDetail,dataSetInputBuilding,dataGridInputDetail,autoFormCondition,dialogDetail){
	


	var code=dataSetInputBuilding.getData("#").get("code");
	var monthlyCycle=dataSetInputBuilding.getData("#").get("monthlyCycle");
	var buildingCode=dataSetInputBuilding.getData("#").get("buildingCode");
	var totalQty=dataGridInputDetail.get("footerEntity").get("currentQty")+"";
	
	var entity={"code":code,"monthlyCycle":monthlyCycle,"buildingCode":buildingCode,"totalQty":totalQty};
	updateActionSaveDetail.set("parameter",entity).execute(function(result){
		
		var parameter = autoFormCondition.get("entity");
		
		dataSetInputBuilding.set("parameter",parameter).flushAsync();
		dialogDetail.hide();
	});
	
}

//@Bind #dataGridInputBuilding.#status.onRenderCell
!function(arg) {
	var status=arg.data.get("status");
	var inputPercent=arg.data.get("inputPercent");
	
	if(status==1){
		arg.dom.style.color =  "orange" ;
	}else if(status==2){
		arg.dom.style.color =  "green" ;
	}else{
		arg.dom.style.color =  "red" ;
	}
	arg.processDefault = true;
}


//@Bind #dataGridInputDetail.#currentQty.onRenderCell
!function(arg) {
	
//	var currentQty=arg.data.get("currentQty");
//	
//	var beforeQty=arg.data.get("beforeQty");
//	arg.dom.style.background = (currentQty<beforeQty) ? "red" : "";
	arg.processDefault = true;
}

