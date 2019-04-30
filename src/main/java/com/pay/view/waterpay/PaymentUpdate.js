//@Bind #datasetPayOrder.onReady
!function(self,arg,autoFormCondition,datasetCondition){
	
	datasetCondition.insert();
}

//@Bind #buttonSearch.onClick
!function(self,arg,autoFormCondition,datasetPayOrder){
	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");
	var userCode=entity.get("userCode");
	if(isNotNull(userCode)){
		datasetPayOrder.set("parameter",{"userCode":userCode,"status":0}).flushAsync();
	}else{
		dorado.MessageBox.alert("请输入用户编码！");
	}
	

}

//@Bind #buttonEdit.onClick
!function(self,arg,dialogDetail){
	dialogDetail.show();
}

//@Bind #dataGridPayOrder.onDoubleClick
!function(self,arg,dialogDetail){
	dialogDetail.show();
}

//@Bind #buttonRecount.onClick
!function(self,arg,datasetPayOrder){

	var data=datasetPayOrder.get("data:#");
	var waterBeforeQty= data.get("waterBeforeQty");
	var waterCurrentQty= data.get("waterCurrentQty");
	var garbagePrice=data.get("garbagePrice");
	var lateFee=data.get("lateFee");
	var networkPrice=data.get("networkPrice");
	var sewagePrice=data.get("sewagePrice");
	var otherPrice=data.get("otherPrice");
	
	if(isNotNull(waterCurrentQty)){
		if(waterCurrentQty<waterBeforeQty){
			dorado.MessageBox.alert("当前吨数不能少于上月吨数！");
		}
		var actualQty=waterCurrentQty-waterBeforeQty;

		data.set("actualQty",actualQty);
		var price=data.get("price");
		data.set("waterPrice",(actualQty*price).toFixed(1));
	}
	var totalPrice=data.get("waterPrice");
	if(isNotNull(garbagePrice)){
		totalPrice=totalPrice+garbagePrice;
	}
	if(isNotNull(lateFee)){
		totalPrice=totalPrice+lateFee;
	}
	if(isNotNull(networkPrice)){
		totalPrice=totalPrice+networkPrice;
	}
	if(isNotNull(sewagePrice)){
		totalPrice=totalPrice+sewagePrice;
	}
	if(isNotNull(otherPrice)){
		totalPrice=totalPrice+otherPrice;
	}


		
	data.set("totalPrice",scale8to1(totalPrice.toFixed(1)));

}

//@Bind #buttonClose.onClick
!function(self,arg,dialogDetail){
	dialogDetail.hide();

}