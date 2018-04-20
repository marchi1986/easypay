//@Bind #buttonQuery.onClick
!function(self,arg,autoFormCondition,dataSetGroup){

	//获取autoformCondition绑定的实体对象
	var entity = autoFormCondition.get("entity");

	//将实体对象作为参数传入，并异步刷新
	dataSetGroup.set("parameter",entity).flushAsync();
}

//@Bind #buttonSaveGroup.onClick
!function(self,arg,updateActionSave,dialogEdit){
	updateActionSave.execute(function(){
	    dialogEdit.hide();
	})
}

//@Bind #buttonCancelGroup.onClick
!function(self,arg,dialogEdit,dataSetGroup){
	
	dataSetGroup.get("data:#").cancel();
	dialogEdit.hide();
}

//@Bind #buttonAddGroup.onClick
!function(self,arg,dialogEdit,dataSetGroup,autoFormGroup){
	dataSetGroup.insert();
	setAutoFormFocus(autoFormGroup,"name");
	dialogEdit.show();
}

//@Bind #buttonEditGroup.onClick
!function(self,arg,dialogEdit){
	
	dialogEdit.show();
}

//@Bind #buttonDelGroup.onClick
!function(self,arg,dataSetGroup,updateActionSave){
	
	var entity = dataSetGroup.get("data:#");
	if(entity){
	    dorado.MessageBox.confirm("确认要删除记录吗？", function(){
	        entity.remove();
	        updateActionSave.execute();
	    })
	}
}

//@Bind #dataPilotRoom.onSubControlAction
!function(self,arg){
	var data=view.id("dataSetGroup").getData("#");
	if(!data){
		dorado.MessageBox.alert("请先选中组别!");
		arg.processDefault=false;
		return;
	}
	switch(arg.code){
	case "+":
		var dialog=view.id("dialogRoomSelect");	
		dialog.$show({
			caption:"选择套间",
			width:700,
			callback:function(rooms){
				var list=[];
				
				for(var i=0;i<rooms.length;i++){
					var room=rooms[i];
					var item={"code":room["code"],"roomNo":room["roomNo"]}
					list[i]=item;
				}
				var action=view.id("ajaxActionUpdateGroup");
				action.set("parameter",{"items":list,groupId:data.get("id")});
				action.execute(function(error){
					if(error){
						alert(error);
					}else{
						dialog.hide();
						data.reset("buildingDetail");
						view.id("dataSetGroupSelected").clear();
					}
					
					//data.reset("users");
					

				});
			}
		});
		arg.processDefault=false;
		break;
	case "-":
		dorado.MessageBox.confirm("真的要删除当前套间吗？",function(){
			var action=view.id("ajaxActionDeleteGroup");
			var dataSetGroup=view.id("dataSetGroup");
			var code=dataSetGroup.getData("#.#buildingDetail.code");
			var roomNo=dataSetGroup.getData("#.#buildingDetail.roomNo");
			
			action.set("parameter",{code:code,roomNo:roomNo});
			action.execute(function(){
				data.reset("buildingDetail");
			});		
		});
		arg.processDefault=false;
		break;
	}
}
