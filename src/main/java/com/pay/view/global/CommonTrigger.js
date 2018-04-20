

//@Bind #datagridBuilding.onDoubleClick
!function(self,arg,dataSetBuilding){

	var autoForm=view.get("#autoFormWaterMeterInfo");
	
	alert(autoForm.get("entity"));
	
	//var dialog = self.findParent(dorado.widget.Dialog);
	//var editor = dialog.get("userData"); // 取得对应的编辑框 


	//var building= dataSetBuilding.getData("#");
	//var id=building.get("id");

	//editor.set("text", id);
}



	
//@Bind #buttonSearchBuilding.onClick
!function(self,arg,dataSetBuilding,autoFormBuildingCondition){

	//获取autoformCondition绑定的实体对象

	var entity = autoFormBuildingCondition.get("entity");

		//将实体对象作为参数传入，并异步刷新
	dataSetBuilding.set("parameter",entity).flushAsync();
}