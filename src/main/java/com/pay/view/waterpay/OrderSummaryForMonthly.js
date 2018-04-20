//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetSummary){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("summaryType","monthly");
	//将实体对象作为参数传入，并异步刷新
	dataSetSummary.set("parameter",entity).flushAsync();

}