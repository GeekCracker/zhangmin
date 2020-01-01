function doGet(url,param,dlg,func){
	$.ajax({
		url:url,
		data:param,
		type:'get',
		success:function(data){
			data = JSON.parse(data);
			var icon = 1;
			if(data.code == 200){
				if(func){
					func(data);
				}
			}else {
				icon = 2;
			}
			if(dlg){
				layer.alert(data.msg,{icon: icon})
			}
		},
		error:function(err){
			layer.alert("系统异常",{icon: 2})
		}
	});
}
function doPost(url,data,dlg,func){
	$.ajax({
		url:url,
		data:data,
		type:'post',
		success:function(data){
			data = JSON.parse(data);
			var icon = 1;
			if(data.code == 200){
				if(func){
					func(data);
				}
			}else {
				icon = 2;
			}
			if(dlg){
				layer.alert(data.msg,{icon: icon})
			}
		},
		error:function(err){
			layer.alert("系统异常",{icon: 2})
		}
	});
}