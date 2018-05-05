

//@Bind #dataSetCondition.onReady
!function(self,arg){

	self.insert();
}




//@Bind #buttonPrint.onClick
!function(self,arg,updateActionPrint,autoFormCondition){
	var entity = autoFormCondition.get("entity");

	var buildCode=entity.get("buildCode");

	updateActionPrint.set("parameter",{"buildCode":buildCode}).execute();
	
	
}

