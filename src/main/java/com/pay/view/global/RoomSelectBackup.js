//@Bind #dialogRoomSelect.onCreate
!function(self,arg){
	self.show=function(config){
		if(!config.callback){
			dorado.MessageBox.alert("请先为当前dialog添加一个名为callback的函数");
			return;
		}
		self.callback=config.callback;
		if(config.width){
			self.set("width",config.width);
		}
		
		if(config.maxSelect){
			self.maxSelect=config.maxSelect;
		}
		
		if(config.height){
			self.set("height",config.height);
		}
		if(config.caption){
			self.set("caption",config.caption);
		}
		if(config.selected){
			self.selected=config.selected;
		}
		if(config.cache==undefined){
			self.cache=true;
		}else{
			self.cache=config.cache;
		}
		self.show();
	}

}

//@Bind #dialogRoomSelect.onShow
!function(self,arg){
	if(!self.cache){
		view.id("dataSetRoomForSelect").flushAsync();	
		view.id("dataSetRoomSelected").clear();
	}
}

//@Bind #dataSetRoomForSelect.onReady
!function(self,arg){
	self.move=function(){
		var ds=view.id("dataSetRoomForSelect");
		var data=ds.getData("#");
		if(data){
			var targetData=view.id("dataSetRoomSelected").getData();
			var insertAble=true;
			targetData.each(function(room){
				if(room.get("code")==data.get("code")&&room.get("roomNo")==data.get("roomNo")){
					insertAble=false;
					return false;
				}
			});
			if(insertAble){
				var max=view.id("dialogRoomSelect").maxSelect;
				if(max && targetData.toArray().length>=max){
					dorado.MessageBox.alert("当前最多只允许选择["+max+"]个用户！");
					return;
				}
				targetData.insert(data.toJSON());
				data.remove();
			}else{
				dorado.MessageBox.alert("当前套间已存在！")
			}
		}else{
			dorado.MessageBox.alert("当前没有选中的套间信息！")
		}	
	}
}

//@Bind #dataSetRoomSelected.onReady
!function(self,arg){
	self.remove=function(){
		var data=view.id("dataSetRoomSelected").getData("#");
		if(data){
			data.remove();
			view.id("dataSetRoomForSelect").flushAsync();
		}else{
			dorado.MessageBox.alert("当前没有选中的套间信息！")
		}	
	}
}

//@Bind #dataSetRoomForSelect.onDataLoad
!function(self,arg){
	var movedData=view.id("dataSetRoomSelected").getData();
	var data=self.getData();
	if(movedData){
		data.each(function(entity){
			movedData.each(function(movedEntity){
				if(entity.get("code")==movedEntity.get("code")&&entity.get("roomNo")==movedEntity.get("roomNo")){
					entity.remove();
				}
			});
		});
	}
	var dialog=view.id("dialogRoomSelect");
	var selected=dialog.selected

	if(selected){
		data.each(function(entity){
			for(var i=0;i<selected.length;i++){
				if(selected[i].get("code")==entity.get("code")&&selected[i].get("roomNo")==entity.get("roomNo")){
					entity.remove();
					break;
				}
			}
		});
	}

}

//@Bind #buttonAdd.onClick
!function(self,arg){

	view.id("dataSetRoomForSelect").move();
}

//@Bind #buttonDel.onClick
!function(self,arg){

	view.id("dataSetRoomSelected").remove();
}

//@Bind #dataGridRoomForSelect.onDoubleClick
!function(self,arg,dataSetBuilding){
	view.id("dataSetRoomForSelect").move();
}

//@Bind #dataGridRoomForSelect.onDoubleClick
!function(self,arg,dataSetBuilding){
	view.id("dataGridRoomSelected").remove();
}

//@Bind #buttonConfirm.onClick
!function(self,arg){

	var data=view.id("dataSetRoomSelected").getData();
	if(data.isEmpty()){
		dorado.MessageBox.alert("请选择一个用户后再进行此操作");
		return;
	}
	view.id("dialogRoomSelect").callback(data.toJSON());
}

//@Bind #buttonCancel.onClick
!function(self,arg){

	view.id("dialogRoomSelect").hide();
}

