//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetOrderInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("status",0);
	//将实体对象作为参数传入，并异步刷新
	dataSetOrderInfo.set("parameter",entity).flushAsync();

}

//@Bind #buttonCharge.onClick
!function(self,arg,dialogPay,lblTotal,dataSetSelect,dataGridOrderInfo,editorAcutalAmount,lblSurplus,ajaxActionRxtx){
	
	var selectedData = dataGridOrderInfo.get("selection");
	
	var sum=0;
	selectedData.each(function(data){
		sum=sum+ data.get("totalPrice");
	});
	
	lblTotal.set("text",sum.toFixed(1));
	
	lblSurplus.set("text","应找金额：");
	
	setFocus(editorAcutalAmount.getDom());
	
	dialogPay.show();
	
	ajaxActionRxtx.set("parameter",{"state":"2","data":sum.toFixed(1)}).execute();

}

//@Bind #editorAcutalAmount.onKeyPress
!function(self,arg,lblTotal,editorAcutalAmount,lblSurplus,ajaxActionRxtx){
	
	if(arg.keyCode==13){
		var total=lblTotal.get("text");
		
		var actual=editorAcutalAmount.get("text");
		
		ajaxActionRxtx.set("parameter",{"state":"3","data":actual}).execute();
		
		var surplus=(actual-total).toFixed(1)
		
		lblSurplus.set("text","应找金额："+surplus);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"4","data":surplus}).execute(); }, 3000);
	}
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