//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetPayInfo){
	
	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetPayInfo.set("parameter",entity).flushAsync();

}

//@Bind #dataSetCondition.onReady
!function(self,arg){

	var d = new Date();

	self.insert({"beginDate":d,"endDate":d});

}


//@Bind #dataGridSummary.onDataRowDoubleClick
!function(self,arg,dialogOrder,dataSetOrderList){

	var payDay= self.get("currentEntity").get("payDay");

	
	dataSetOrderList.set("parameter",{"payDay":payDay}).flushAsync();
	
	dialogOrder.show();

}

//@Bind #dataGridSummary.#totalPrice.onRenderFooterCell
!function(arg) {
	arg.dom.innerText = "总计："
			+ dorado.util.Common.formatFloat(arg.data.get("totalPrice"), "#,##0");
}
//@Bind #dataGridSummary.#actualTotalPrice.onRenderFooterCell
!function(arg) {
	arg.dom.innerText = "总计："
			+ dorado.util.Common.formatFloat(arg.data.get("actualTotalPrice"), "#,##0");
}