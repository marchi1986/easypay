
function setAutoFormFocus(autoForm,elementName){

    var element= autoForm.getElement(elementName);
    var dom = element.getDom();
    var inputs = dom.getElementsByTagName("INPUT");   
    window.setTimeout(function(){
	    //对其设置焦点
    	inputs[0].focus();
	},500);
}

function setFocus(dom){
	var inputs = dom.getElementsByTagName("INPUT");
	//获取用户名输入框
	var inputUsername = inputs[0];
	window.setTimeout(function(){
	    //对其设置焦点
	    inputUsername.focus();
	},500);
}


function isNotNull(obj){
	if(typeof(obj)=='undefined'){
		return false;
	}
	
	if(obj!=null&&obj!=""){
		return true;
	}else{
		return false;
	}
}

//获取当前月的第一天
function getCurrentMonthFirst(){
	var date=new Date();
	date.setDate(1);
	return date;
}
//获取当前月的最后一天	 
function getCurrentMonthLast(){
	var date=new Date();
	var currentMonth=date.getMonth();
	var nextMonth=++currentMonth;
	var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1);
	var oneDay=1000*60*60*24;
	return new Date(nextMonthFirstDay-oneDay);
}

function scale8to1(num){
	var numFormat=num+"";
	if(isNotNull(numFormat)){
		var arry= numFormat.split(".");
		if(arry.length>1){
			var decimalPlace=arry[1];
			if(decimalPlace>=8){
				return parseInt(arry[0])+1;
			}else{
				return num;
			}
		}else{
			return num;
		}
	}else{
		return 0;
	}
}