//@Bind #dataSetCondition.onReady
!function(self,arg){
	
	var d = new Date();
	self.insert({"monthlyCycle":d});
}

//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetInputHeader){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetInputHeader.set("parameter",entity).flushAsync();

}

//@Bind #buttonConfirm.onClick
!function(self,arg,updateActionConfirm,dataSetInputHeader,autoFormCondition){
	
	var record=dataSetInputHeader.getData("#");
	
	var status=record.get("status");
	var code=record.get("code");
	if(status==2){
		dorado.MessageBox.alert("该单据已确认！");
		return;
	}
	if(status==3){
		dorado.MessageBox.alert("该单据已完成！");
		return;
	}
	
	var inputPercent=record.get("inputPercent");
	
	if(inputPercent!="100.00"){
		dorado.MessageBox.confirm("该批次录入未完成,是否还要确认?",function(){
			updateActionConfirm.set("parameter",{"code":code}).execute();
		});
	}else{
		updateActionConfirm.set("parameter",{"code":code}).execute();
	}
	

}
//@Bind #updateActionConfirm.onSuccess
!function(self,arg,autoFormCondition,dataSetInputHeader){
	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	//将实体对象作为参数传入，并异步刷新
	dataSetInputHeader.set("parameter",entity).flushAsync();
}

//@Bind #buttonDelete.onClick
!function(self,arg,updateActionDelete,dataSetInputHeader){
	
	var entity = dataSetInputHeader.get("data:#");
	
	var status=entity.get("status");
	var code=entity.get("code");
	
	if(status==2||status==3){
		dorado.MessageBox.alert("该单据已确认或已完成！");
		return;
	}
	
	if(status==1){
		dorado.MessageBox.confirm("该批次正在录入,是否还要删除?",function(){
			entity.remove();
			updateActionDelete.set("parameter",{"code":code}).execute();
		});
	}else{
		entity.remove();
		updateActionDelete.set("parameter",{"code":code}).execute();
	}
	

	

}





//@Bind #dataGridInputHeader.#status.onRenderCell
!function(arg) {
	var status=arg.data.get("status");
	var inputPercent=arg.data.get("inputPercent");
	
	if(status==1){
		arg.dom.style.color =  "orange" ;
	}else if(status==2){
		arg.dom.style.color =  "green" ;
	}
	

	arg.processDefault = true;
}