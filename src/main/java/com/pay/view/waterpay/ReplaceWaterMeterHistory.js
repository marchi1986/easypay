//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetReplaceHistory){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetReplaceHistory.set("parameter",entity).flushAsync();
}

//@Bind #buttonPrint.onClick
!function(self,arg,dialogEdit){
	
	window.print();
}
