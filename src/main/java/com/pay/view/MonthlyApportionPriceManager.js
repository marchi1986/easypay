//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetApportionPrice){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetApportionPrice.set("parameter",entity).flushAsync();
}

//@Bind #buttonSave.onClick
!function(self,arg,updateActionSave,dialogEdit){
	updateActionSave.execute(function(){
	    dialogEdit.hide();
	})
}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogEdit,dataSetApportionPrice){
	
	dataSetApportionPrice.get("data:#").cancel();
	dialogEdit.hide();
}

//@Bind #buttonAdd.onClick
!function(self,arg,dialogEdit,dataSetApportionPrice,autoFormApportionPrice){
	dataSetApportionPrice.insert();
	autoFormApportionPrice.get("#monthly").set("readOnly",false);
	dialogEdit.show();
}

//@Bind #buttonEdit.onClick
!function(self,arg,dialogEdit,autoFormApportionPrice){
	autoFormApportionPrice.get("#monthly").set("readOnly",true);
	dialogEdit.show();
}

//@Bind #buttonDel.onClick
!function(self,arg,dataSetApportionPrice,updateActionSave){
	
	var entity = dataSetApportionPrice.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSave.execute();
	    })
	}
}


