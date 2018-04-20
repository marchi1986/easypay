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



//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetPaymentOrder){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	if(entity.monthlyCycle==undefined||entity.monthlyCycle==null){
		dorado.MessageBox.alert("请选择月度周期！");
		return;
	}

	//将实体对象作为参数传入，并异步刷新
	dataSetPaymentOrder.set("parameter",entity).flushAsync(function(result){
		if(result.isEmpty()){
			dorado.MessageBox.alert("未生成该月度记录或已打印！");
		}
	});

}

//@Bind #buttonPrint.onClick
!function(self,arg,updateActionPrint,autoFormCondition){
	var entity = autoFormCondition.get("entity");

	var monthly=entity.get("monthly");
	var buildCode=entity.get("buildCode");
	if(isNotNull(monthly)){
		updateActionPrint.set("parameter",{"monthly":monthly,"buildCode":buildCode}).execute();
	}else{
		dorado.MessageBox.alert("月度不能为空！");
	}
	
}

