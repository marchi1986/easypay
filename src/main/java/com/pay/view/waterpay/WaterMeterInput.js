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
!function(self,arg,dataSetInputBuilding,dataSetInputDetail,dialogDetail){
	loadDetail(dataSetInputBuilding,dataSetInputDetail,dialogDetail);
}

//@Bind #dataGridInputBuilding.onDoubleClick
!function(self,arg,dataSetInputBuilding,dataSetInputDetail,dialogDetail){
	loadDetail(dataSetInputBuilding,dataSetInputDetail,dialogDetail);
}

function loadDetail(dataSetInputBuilding,dataSetInputDetail,dialogDetail){
	var record=dataSetInputBuilding.getData("#");
	
	var code=record.get("code");
	var monthlyCycle=record.get("monthlyCycle");
	var buildingCode=record.get("buildingCode");

	var entity={"code":code,"monthlyCycle":monthlyCycle,"buildingCode":buildingCode};

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
		arg.dom.style.color =  "blue" ;
	}else if(status==3){
		arg.dom.style.color =  "green" ;
	}else {
		arg.dom.style.color =  "red" ;
	}
	arg.processDefault = true;
}


//@Bind #dataGridInputDetail.onCurrentChange
!function(self,arg) {

	setDetailReadOnly(self);
}

//@Bind #dataGridInputDetail.onFocus
!function(self,arg) {

	setDetailReadOnly(self);
}

function setDetailReadOnly(self){
	var entity = self.get('dataSet').getData('#');

	if(entity.get('status')==3){
		self.getColumn("beforeQty").set("readOnly",true);
		self.getColumn("currentQty").set("readOnly",true);
		self.getColumn("garbagePrice").set("readOnly",true);
		self.getColumn("garbagePrice").set("readOnly",true);
		self.getColumn("networkPrice").set("readOnly",true);
		self.getColumn("otherPrice").set("readOnly",true);
	}else{
		self.getColumn("beforeQty").set("readOnly",false);
		self.getColumn("currentQty").set("readOnly",false);
		self.getColumn("garbagePrice").set("readOnly",false);
		self.getColumn("garbagePrice").set("readOnly",false);
		self.getColumn("networkPrice").set("readOnly",false);
		self.getColumn("otherPrice").set("readOnly",false);
	}
}


//@Bind #dataGridInputDetail.#currentQty.onRenderCell
!function(arg) {
	
//	var currentQty=arg.data.get("currentQty");
//	
//	var beforeQty=arg.data.get("beforeQty");
//	arg.dom.style.background = (currentQty<beforeQty) ? "red" : "";
	arg.processDefault = true;
}

