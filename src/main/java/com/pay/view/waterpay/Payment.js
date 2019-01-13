//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetOrderInfo){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	entity.set("status",0);
	//将实体对象作为参数传入，并异步刷新
	dataSetOrderInfo.set("parameter",entity).flushAsync();

}

//@Bind #buttonCharge.onClick
!function(self,arg,dialogPay,dataGridOrderInfo,ajaxActionRxtx,dataSetPay,autoFormPay,dataSetSelected){
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
	dataSetSelected.clear();
	selectedData.each(function(data){
		dataSetSelected.insert(data);
		sum=sum+data.get("totalPrice");
		sumWaterPayAmount=sumWaterPayAmount+ (data.get("waterPrice"));
		sumGarbagePayAmount=sumGarbagePayAmount+ data.get("garbagePrice");
		sumNetworkPayAmount=sumNetworkPayAmount+ data.get("networkPrice");
		sumSewagePayAmount=sumSewagePayAmount+ data.get("sewagePrice");
		sumOtherPayAmount=sumOtherPayAmount+ data.get("otherPrice");
		sumLateFeeAmount=sumLateFeeAmount+ data.get("lateFee");
		
	});
	
	dataSetPay.clear();
	var totalWaterPrice=sumWaterPayAmount;
	var totalPrice=sum;

	dataSetPay.insert({"waterPrice":totalWaterPrice,
		"garbagePrice":sumGarbagePayAmount,"actualGarbagePrice":sumGarbagePayAmount,
		"networkPrice":sumNetworkPayAmount,"actualNetworkPrice":sumNetworkPayAmount,
		"sewagePrice":sumSewagePayAmount,"otherPrice":sumOtherPayAmount,
		"lateFee":sumLateFeeAmount,"totalPrice":totalPrice,"shouldTotalPrice":totalPrice});
	
	

	dialogPay.show();
	
	
	
	ajaxActionRxtx.set("parameter",{"state":"2","data":totalPrice+""}).execute();
	
	setFocus(autoFormPay.getElement("actualPrice").getDom());

}

//@Bind #actualGarbagePrice.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		paymentForKeyPress(dataSetPay,ajaxActionRxtx,"2");
	}
}

//@Bind #actualNetworkPrice.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){
	if(arg.keyCode==13){
		paymentForKeyPress(dataSetPay,ajaxActionRxtx,"2");
	}
}

//@Bind #sewagePrice.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		paymentForKeyPress(dataSetPay,ajaxActionRxtx,"2");
	}
}

//@Bind #otherPrice.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){
		paymentForKeyPress(dataSetPay,ajaxActionRxtx,"2");
	}
}

//@Bind #actualPrice.onKeyPress
!function(self,arg,dataSetPay,ajaxActionRxtx){

	if(arg.keyCode==13){

		var data=dataSetPay.get("data:#");
		
		var giveChange=data.get("actualPrice")-data.get("shouldTotalPrice");

		dataSetPay.get("data:#").set("actualTotalPrice",data.get("shouldTotalPrice"));
		dataSetPay.get("data:#").set("giveChange",giveChange);
		
		setTimeout(function(){ ajaxActionRxtx.set("parameter",{"state":"4","data":giveChange+""}).execute(); }, 2000);
	}
}

function paymentForKeyPress(dataSetPay,ajaxActionRxtx,state){
	
		
		var data=dataSetPay.get("data:#");
		
		var totalAmount= sumAmount(data)
		
		dataSetPay.get("data:#").set("shouldTotalPrice",totalAmount);
		dataSetPay.get("data:#").set("actualPrice","0");
		dataSetPay.get("data:#").set("giveChange","0");
		
		setTimeout(function(){ 
			ajaxActionRxtx.set("parameter",{"state":state,"data":totalAmount+""}).execute(); 
			
		}, 2000);
		
		setTimeout(function(){ 
			setFocus(autoFormPay.getElement("actualPrice").getDom());
		}, 2000);
		
		
	
}





function sumAmount(data){
	var sumWaterPayAmount=parseInt(data.get("waterPrice"));
	var sumGarbagePayAmount=parseInt(data.get("actualGarbagePrice"));
	var sumNetworkPayAmount=parseInt(data.get("actualNetworkPrice"));
	var sumSewagePayAmount=parseInt(data.get("sewagePrice"));
	var sumOtherPayAmount=parseInt(data.get("otherPrice"));
	var sumLateFeeAmount=parseInt(data.get("lateFee"));
	
	var sum=sumWaterPayAmount+sumGarbagePayAmount+sumNetworkPayAmount+sumSewagePayAmount+sumOtherPayAmount+sumLateFeeAmount;
	
	var totalAmount=formatAmount(sum);
	return totalAmount;
}

function formatAmount(amount){
	//alert(amount);
	var sum=amount;
	
	var sum2str=sum+"";

	var sum2split=sum2str.split(".");

	//alert(sum2split.length);
	if(sum2split.length>1){
		sum=parseInt(sum2split[0])+1;
	}

	return sum;
}


//@Bind #buttonConfirmPay.onClick
!function(self,arg,dialogPay,updateActionPaymen,autoFormCondition,dataSetPay,dataSetOrderInfo){
	
	var data=dataSetPay.get("data:#");
	if(!isNotNull(data.get("actualTotalPrice"))){
		dorado.MessageBox.alert("请输入实际收款金额!");
		return;
	}
	
	
	updateActionPaymen.execute(function(result){

		//获取autoformCondition绑定的实体对象
		var entityCondition = autoFormCondition.get("entity");

		//将实体对象作为参数传入，并异步刷新
		dataSetOrderInfo.set("parameter",entityCondition).flushAsync();

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
	//防止系统自动的添加一行
	arg.processDefault = true;
}
