//@Bind #buttonCreate.onClick
!function(self,arg,updateActionCreate,autoFormCondition){
	var entity = autoFormCondition.get("entity");

	var monthly=entity.get("monthly");
	var beginDate=entity.get("beginDate");
	var endDate=entity.get("endDate");
	
	if(isNotNull(monthly)&&isNotNull(beginDate)&&isNotNull(endDate)){
		if(beginDate>endDate){
			dorado.MessageBox.alert("结束日期不能小于开始日期");
		}else{
			var firstDate=monthly;
			firstDate.setDate(1);
			if(beginDate<firstDate){
				dorado.MessageBox.alert("开始日期不能小于该月第一天");
			}else{
				updateActionCreate.set("parameter",entity).execute();
			}
			
		}
		
	}else{
		dorado.MessageBox.alert("月度、开始日期、结束日期不能为空");
	}
	
	
}

//@Bind #dataSetCondition.onReady
!function(self,arg){
	var d = new Date();
	var first=getCurrentMonthFirst();
	var end=getCurrentMonthLast();
	self.insert({"monthly":d,"beginDate":first,"endDate":end});
}

//@Bind #dataSetConditionForBuilding.onReady
!function(self,arg){
	var d = new Date();

	self.insert({"monthly":d});
}

//@Bind #buttonCreateForBuilding.onClick
!function(self,arg,updateActionCreateForBuilding,autoFormConditionForBuilding){
	var entity = autoFormConditionForBuilding.get("entity");
	
	updateActionCreateForBuilding.set("parameter",entity).execute();
	
	
}