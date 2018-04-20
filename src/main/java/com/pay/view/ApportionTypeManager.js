//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetApportionType){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetApportionType.set("parameter",entity).flushAsync();
}

//@Bind #buttonSave.onClick
!function(self,arg,updateActionSave,dialogEdit){
	updateActionSave.execute(function(){
	    dialogEdit.hide();
	})
}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogEdit,dataSetApportionType){
	
	dataSetApportionType.get("data:#").cancel();
	dialogEdit.hide();
}

//@Bind #buttonAdd.onClick
!function(self,arg,dialogEdit,dataSetApportionType){
	dataSetApportionType.insert();
	dialogEdit.show();
}

//@Bind #buttonEdit.onClick
!function(self,arg,dialogEdit){
	
	dialogEdit.show();
}

//@Bind #buttonDel.onClick
!function(self,arg,dataSetApportionType,updateActionSave){
	
	var entity = dataSetApportionType.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSave.execute();
	    })
	}
}


//@Bind #buttonPrint.onClick
!function(self,arg,dialogEdit){
	
	window.print();
}
