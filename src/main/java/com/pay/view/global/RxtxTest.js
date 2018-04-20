//@Bind #buttonTest.onClick
!function(self,arg,autoFormRxtx,ajaxActionSendDisplay){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormRxtx.get("entity");

	//将实体对象作为参数传入，并异步刷新
	ajaxActionSendDisplay.set("parameter",entity).execute();
}

//@Bind #buttonSave.onClick
!function(self,arg,autoFormRxtx,ajaxActionSave){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormRxtx.get("entity");

	//将实体对象作为参数传入，并异步刷新
	ajaxActionSave.set("parameter",entity).execute();
}