//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetOrderInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("status",0);
	//将实体对象作为参数传入，并异步刷新
	dataSetOrderInfo.set("parameter",entity).flushAsync();

}

//@Bind #buttonCharge.onClick
!function(self,arg,dialogPay,dataSetSelect,dataGridOrderInfo,ajaxActionRxtx,dataSetPay,autoFormPay){
	
	var selectedData = dataGridOrderInfo.get("selection");
	
	if(selectedData.length==0){
		dorado.MessageBox.alert("请至少选择一个套间！");
		return;
	}
	
	var sum=0;
	var sumWaterPayAmount=0;
	var sumGarbagePayAmount=0;
	var sumApportionPayAmount=0;
	var sumNetworkPayAmount=0;
	var sumSewagePayAmount=0;
	var sumOtherPayAmount=0;
	var sumLateFeeAmount=0;
	selectedData.each(function(data){
		sum=sum+data.get("totalPrice");
		sumWaterPayAmount=sumWaterPayAmount+ data.get("waterPrice");
		sumGarbagePayAmount=sumGarbagePayAmount+ data.get("garbagePrice");
		sumApportionPayAmount=sumApportionPayAmount+ data.get("apportionPrice");
		sumNetworkPayAmount=sumNetworkPayAmount+ data.get("networkPrice");
		sumSewagePayAmount=sumSewagePayAmount+ data.get("sewagePrice");
		sumOtherPayAmount=sumOtherPayAmount+ data.get("otherPrice");
		sumLateFeeAmount=sumLateFeeAmount+ data.get("lateFee");
	});
	dataSetPay.clear();

	var totalAmount=formatAmount(sum);

	
	dataSetPay.insert({"waterPayAmount":sumWaterPayAmount+sumApportionPayAmount,
		"garbagePayAmount":sumGarbagePayAmount,"networkPayAmount":sumNetworkPayAmount,"sewagePayAmount":sumSewagePayAmount,
		"otherPayAmount":sumOtherPayAmount,"lateFeeAmount":sumLateFeeAmount,"totalAmount":totalAmount});
	
	
	setFocus(autoFormPay.getElement("actualAmount").getDom());
	
	dialogPay.show();
	
	ajaxActionRxtx.set("parameter",{"state":"2","data":totalAmount+""}).execute();

}

//@Bind #garbagePayAmount.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		
		var data=dataSetPay.get("data:#");
		
		var totalAmount= sumAmount(data)
		
		dataSetPay.get("data:#").set("totalAmount",totalAmount);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"2","data":totalAmount+""}).execute(); }, 3000);
	}
}

//@Bind #networkPayAmount.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		
		var data=dataSetPay.get("data:#");
		
		var totalAmount= sumAmount(data)
		
		dataSetPay.get("data:#").set("totalAmount",totalAmount);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"2","data":totalAmount+""}).execute(); }, 3000);
	}
}

//@Bind #sewagePayAmount.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		
		var data=dataSetPay.get("data:#");
		
		var totalAmount= sumAmount(data)
		
		dataSetPay.get("data:#").set("totalAmount",totalAmount);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"2","data":totalAmount+""}).execute(); }, 3000);
	}
}

//@Bind #otherPayAmount.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		
		var data=dataSetPay.get("data:#");
		
		var totalAmount= sumAmount(data)
		
		dataSetPay.get("data:#").set("totalAmount",totalAmount);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"2","data":totalAmount+""}).execute(); }, 3000);
	}
}

//@Bind #actualAmount.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		
		var data=dataSetPay.get("data:#");
		
		var giveChange=data.get("actualAmount")-data.get("totalAmount");
		
		dataSetPay.get("data:#").set("giveChange",giveChange);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"4","data":giveChange+""}).execute(); }, 3000);
	}
}



function sumAmount(data){
	var sumWaterPayAmount=parseInt(data.get("waterPayAmount"));
	var sumGarbagePayAmount=parseInt(data.get("garbagePayAmount"));
	var sumNetworkPayAmount=parseInt(data.get("networkPayAmount"));
	var sumSewagePayAmount=parseInt(data.get("sewagePayAmount"));
	var sumOtherPayAmount=parseInt(data.get("otherPayAmount"));
	var sumLateFeeAmount=parseInt(data.get("lateFeeAmount"));
	
	var sum=sumWaterPayAmount+sumGarbagePayAmount+sumNetworkPayAmount+sumSewagePayAmount+sumOtherPayAmount+sumLateFeeAmount;
	
	var totalAmount=formatAmount(sum);
	return totalAmount;
}

function formatAmount(amount){

	var sum=amount;
	
	var sum2str=sum+"";

	var sum2split=sum2str.split(".");


	if(sum2split.length>0){
		sum=parseInt(sum2split[0])+1;
	}

	return sum;
}


//@Bind #buttonConfirmPay.onClick
!function(self,arg,dialogPay,updateActionPay,autoFormCondition,dataSetOrderInfo){
	
	updateActionPay.execute(function(result){
		//获取autoformCondition绑定的实体对象
		var entity = autoFormCondition.get("entity");
		entity.set("status",0);
		//将实体对象作为参数传入，并异步刷新
		dataSetOrderInfo.set("parameter",entity).flushAsync();
	});
	
	dialogPay.hide();

}

//@Bind #buttonCancel.onClick
!function(self,arg,dialogPay,dataSetOrderInfo){

	
	dialogPay.hide();

}

//@Bind #updateActionPay.onGetUpdateData
!function(self,arg,dialogPay,dataGridOrderInfo){

	arg.data = dataGridOrderInfo.get("selection");
}



//@Bind #dataGridInputHeader.#status.onRenderCell
!function(arg) {
	//arg.dom.style.background = (arg.data.get("status") ==0) ? "#d3d3d3" : "";
	arg.dom.style.color = (arg.data.get("status") ==0) ? "green" : "";
	arg.processDefault = true;
}