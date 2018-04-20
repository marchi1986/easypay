//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetOrderInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("status",0);
	//将实体对象作为参数传入，并异步刷新
	dataSetOrderInfo.set("parameter",entity).flushAsync();

}

//@Bind #buttonCharge.onClick
!function(self,arg,dialogPay,lblTotal,dataSetSelect,dataGridOrderInfo){
	
	var selectedData = dataGridOrderInfo.get("selection");
	
	var sum=0;
	selectedData.each(function(data){
		sum=sum+ data.get("totalPrice");
	});
	
	lblTotal.set("text",sum.toFixed(2));
	
	dialogPay.show();

}


//@Bind #buttonConfirmPay.onClick
!function(self,arg,dialogPay,updateActionPay,autoFormCondition,dataSetOrderInfo){
	
	updateActionPay.execute(function(result){
		//获取autoformCondition绑定的实体对象
		var entity = autoFormCondition.get("entity");
		entity.set("status",0);
		//将实体对象作为参数传入，并异步刷新
		dataSetOrderInfo.set("parameter",entity).flushAsync();
	});
	
	dialogPay.hide();

}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogPay,dataSetOrderInfo){

	
	dialogPay.hide();

}

//@Bind #updateActionPay.onGetUpdateData
!function(self,arg,dialogPay,dataGridOrderInfo){

	arg.data = dataGridOrderInfo.get("selection");
}



//@Bind #dataGridInputHeader.#status.onRenderCell
!function(arg) {
	//arg.dom.style.background = (arg.data.get("status") ==0) ? "#d3d3d3" : "";
	arg.dom.style.color = (arg.data.get("status") ==0) ? "green" : "";
	arg.processDefault = true;
}