<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入外部样式表 -->
<link rel="stylesheet" href="/layui/css/layui.css"><!-- layui.css layui框架的css样式表 -->
<link rel="stylesheet" href="/css/main.css"><!-- main.css 我们自定义的公共样式表 -->
<title>书柜管理</title>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<!-- 头部 -->
		<div id = "header" class="layui-header"></div>
		<!-- 左部 -->
		<div id = "left" class="layui-side layui-bg-black"></div>
		<!-- 页面主体 -->
		<div class="layui-body">
			<div class="layui-container layui-col-md12 layui-col-lg12">
				<div class="layui-row">
					<!-- 面包屑 -->
					<span class="layui-breadcrumb"> 
						<a href="/page/main.jsp">首页</a> 
						<a><cite>通用模块</cite></a>
						<a><cite>书柜管理</cite></a>
					</span>
				</div>
				<div class="layui-row layui-margin-top20">
					<!-- 书柜列表 -->
					<div class="layui-col-md12 layui-col-lg12">
						<!-- 查询条件 -->
						<div class="layui-row layui-col-space10 queryParam layui-form">
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="number" id="number" placeholder="请输入书柜编号"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">						
								<select name="shopId" id="shopId" class="layui-input">
									<option value="">请选择店铺</option>
								</select>
							</div>
							<div class="layui-col-md3 layui-col-lg1">
								<button type="button" class="layui-btn" data-type="reload" id="reload">查询</button>
							</div>
							<div class="layui-col-md2 layui-col-lg1 layui-layout-right">
								<button type="button" class="layui-btn" data-type="save" id="save">添加书柜</button>
							</div>
						</div>
						<table class="layui-table" style="width:100%" id="table" lay-filter="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 脚部 -->
		<div id = "footer" class="layui-footer"></div>
	</div>
	<div id="info" class="layui-container layui-padding-20 layui-hide" style="width:90%;">
		<form class="layui-form" id="bookCaseForm" lay-filter="bookCaseForm" action="">
			<div class="layui-form-item layui-row">
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">书柜编号：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formNumber" name="number" required lay-verify="required"
							placeholder="请输入书柜编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">所属店铺：</label>
					<div class="layui-input-inline layui-col-sm7">
						<select name="shopId" id="formShopId">
						  <option value="">请选择店铺</option>
						</select>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/html" id="tableBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
	$(function() {
		$("#header").load("/base/header.html");
		$("#left").load("/base/left.html");
		$("#footer").load("/base/footer.html");
		$("body").ready(function(){	
			layui.use('element', function() {
				var element = layui.element;
			});
			var $ = layui.$, active,table,form;
			layui.use(['table','form'], function() {
				table=layui.table;
				form=layui.form;
				table.render({
					elem : '#table',
					limit: 20,
					url : '/BookCaseListServlet',
					method : 'POST',
					//cols 表头列
					cols : [ [ 
						{
							type : 'numbers',
							width : 80,
							title : '序号',
							fixed : 'left',
							align : 'center'
						} ,{
							field : 'number',
							width : 200,
							title : '书柜编号',
							align : 'center'
						},{
							field : 'shopName',
							width : 200,
							title : '所属店铺',
							align : 'center'
						},{
							fixed: 'right', 
							title:'操作', 
							toolbar: '#tableBar',
							width:150
						}
					] ],
					height : 'full-200',//每行高度
					page : true//是否开启分页
				});//end table render
				//初始化店铺下拉选择框
				$.ajax({
					url:'/ShopAllListServlet',
					type:'GET',
					async:false,
					success:function(data){
						var shops = [];
						data = JSON.parse(data);
						if(data.code == 200){
							shops = data.data;
						}
						var str = "";
						for(var i in shops){
							str += '<option value = "'+shops[i].id +'" '+(shopId && shopId == shops[i].id ? "selected" : "")+'>'+shops[i].shopName+'</option>';
						}
						$("#shopId option:gt(0)").remove();
						$("#shopId").append(str);
						form.render('select');
					}
				});
				//监听行工具事件
			  	table.on('tool(table)', function(obj){
				    var data = obj.data;
				    if(obj.event === 'del'){
				      layer.confirm('真的删除当前行吗？', function(index){
				        obj.del();
				        doPost("/BookCaseDeleteServlet",{id:obj.data.id},true);
				        layer.close(index);
				      });
				    } else if(obj.event === 'edit'){
				    	save('/BookCaseEditServlet',true,obj);
				    	initShop(obj.data.shopId);
				    }
			  	});
			  	//条件查询，并重新加载表格数据
			  	active = {
		  		    reload: function(){
		  		    	var number = $('#number');
		  		    	var shopId = $('#shopId');
		  		    	//执行重载
		  		    	table.reload('table', {
			  		      	page: {
			  		          curr: 1 //重新从第 1 页开始
			  		        }
			  		        ,where: {
			  		        	number: number.val(),
			  		            shopId: shopId.val()
		  		        	}
  		     			}, 'data');
	  		    	}
	  		  	};
			  	$('.queryParam .layui-btn').on('click', function(){
	  		    	var type = $(this).data('type');
	  		    	switch(type){
	  		    		case 'reload':
	  		    			active[type] ? active[type].call(this) : '';
	  		    			break;
	  		    		case 'save':
	  		    			initShop();
	  		    			save('/BookCaseAddServlet',false,false,function(){
	  		    				active.reload();
	  		    			});
	  		    			break;
	  		    	}
	  		 	});
			  	function save(url,edit,obj,func){
		  		  	$('#info').removeClass("layui-hide");
		  		  	if(edit){
		  		  		//表单赋值
		  		  		form.val('bookCaseForm',{
		  		  			"number":obj.data.number,
		  		  			"shopId":obj.data.shopId
		  		  		})
		  		  	}
			    	layer.open({
		    		  title: edit?'修改书柜':'添加书柜', 
		    		  type:1,
		    		  area:['800px','600px'],
		    		  content: $('#info'),
		    		  btn:['保存','取消'],
		    		  yes:function(index){
		    			  var data = {
	    					  number:$('#formNumber').val(),
	    					  shopId:$('#formShopId').val()
		    			  }
		    			  if(edit){
		    				  data.id = obj.data.id;
 		    				  //修改当前行的数据，避免重新刷新列表 
		    				  if(obj.data.shopName){
 		    					data.shopName = $('#formShopId option:selected').text();
 		    				  }else {
 		    					data['shopName'] = $('#formShopId option:selected').text();
 		    				  }
		    				  obj.update(data);
		    			  }
		    			  doPost(url,data,true);
		    			  $('#info').addClass("layui-hide");
		    			  form.val('bookCaseForm',{
			  		  			"number":'',
			  		  			"shopId":''
		  		  		  })
		    			  if(func){
		    				  func();
		    			  }
		    			  layer.close(index);
		    		  },
		    		  btn2:function(index){
		    			  form.val('bookCaseForm',{
			  		  			"number":'',
			  		  			"shopId":''
		  		  		  })
		    			  $('#info').addClass("layui-hide");
		    			  layer.close(index);
		    		  },
		    		  cancel:function(index){
		    			  form.val('bookCaseForm',{
			  		  			"number":'',
			  		  			"shopId":''
		  		  		  })
		    			  $('#info').addClass("layui-hide");
		    		  }
		    		});
	  		  	}//end save function
	  		  	function initShop(shopId){
		  		  	$.ajax({
						url:'/ShopAllListServlet',
						type:'GET',
						async:false,
						success:function(data){
							var shops = [];
							data = JSON.parse(data);
							if(data.code == 200){
								shops = data.data;
							}
							var str = "";
							for(var i in shops){
								str += '<option value = "'+shops[i].id +'" '+(shopId && shopId == shops[i].id ? "selected" : "")+'>'+shops[i].shopName+'</option>';
							}
							$("#bookCaseForm #formShopId option:gt(0)").remove();
							$("#bookCaseForm #formShopId").append(str);
							form.render('select');
						}
					});
	  		  	}//end initShop function
			});
		});
	});
</script>
</html>