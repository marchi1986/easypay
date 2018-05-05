//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetOrderInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("status",1);
	//将实体对象作为参数传入，并异步刷新
	dataSetOrderInfo.set("parameter",entity).flushAsync();

}

//@Bind #buttonPrint.onClick
!function(self,arg,updateActionPrint,dataGridOrderInfo,dataSetSelected){

	var selectedData = dataGridOrderInfo.get("selection");
	
	if(selectedData.length==0){
		dorado.MessageBox.alert("请至少选择一个套间！");
		return;
	}
	
	dataSetSelected.clear();
	selectedData.each(function(data){
		dataSetSelected.insert(data);
		
	});
	
	
	updateActionPrint.execute();

}


//@Bind #updateActionPay.onGetUpdateData
!function(self,arg,dialogPay,dataGridOrderInfo){

	arg.data = dataGridOrderInfo.get("selection");
}


