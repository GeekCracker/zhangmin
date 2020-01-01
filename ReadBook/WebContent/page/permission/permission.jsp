<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<link rel="stylesheet" href="/layui/css/layui.css">
<link rel="stylesheet" href="/css/main.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div id="header" class="layui-header"></div>
		<div id="left" class="layui-side layui-bg-black"></div>
		<div class="layui-body">
			<div class="layui-container layui-col-md12 layui-col-lg12">
				<div class="layui-row">
					<!-- 面包屑 -->
					<span class="layui-breadcrumb"> <a href="">首页</a> <a><cite>基础配置</cite></a>
						<a><cite>权限管理</cite></a>
					</span>
				</div>
				<div class="layui-row layui-margin-top20">
					<!-- 权限树 -->
					<div class="layui-col-md3 layui-col-lg2">
						<div id="permissionTree" class="demo-tree demo-tree-box"></div>
					</div>
					<!-- 权限列表 -->
					<div class="layui-col-md9 layui-col-lg10">
						<!-- 查询条件 -->
						<div class="layui-row layui-col-space10 queryParam">
							<div class="layui-col-md3 layui-col-lg1">
								<input type="text" name="permissionName" id="permissionName" placeholder="请输入权限名称"
									class="layui-input">
							</div>
							<div class="layui-col-md3 layui-col-lg1">
								<input type="text" name="permissionBit" id="permissionBit" placeholder="请输入权限位"
									class="layui-input">
							</div>
							<div class="layui-col-md3 layui-col-lg1">
								<button type="button" class="layui-btn" data-type="reload" id="reload">查询</button>
							</div>
							<div class="layui-col-md4 layui-col-lg2 layui-layout-right">
								<button type="button" class="layui-btn layui-col-md5 layui-col-lg5" data-type="save" id="save">添加权限</button>
							</div>
						</div>
						<table class="layui-table" style="width:100%" id="table" lay-filter="table"></table>						
					</div>
				</div>
			</div>
		</div>
		<div id="footer" class="layui-footer"></div>
	</div>
	<div id="info" class="layui-container layui-padding-20 layui-hide" style="width:90%;">
		<form class="layui-form" id="permissionForm" action="">
			<div class="layui-form-item layui-row">
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">权限名称：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formPermissionName" name="permissionName" id="abc" required lay-verify="required"
							placeholder="请输入权限名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-sm5" style="width:120px;">权限位：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formPermissionBit" name="permissionBit" required lay-verify="required"
							placeholder="请输入权限位" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item layui-row">
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">权限URL：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formUrl" name="url" required lay-verify="required"
							placeholder="请输入权限URL" autocomplete="off" class="layui-input">
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
		$("body").ready(function() {
			layui.use('element', function() {
				var element = layui.element;
			});
			//====================
			var $ = layui.$, active,table,tree,parentId;
			layui.use('table', function() {
				table = layui.table;
				table.render({
					elem : '#table',
					limit: 20,
					url : '/PermissionListServlet',
					method : 'POST',
					height : 'full-200',
					cols : [ [ {
						type : 'numbers',
						width : 80,
						title : '序号',
						fixed : 'left',
						align : 'center'
					}, {
						field : 'permissionName',
						width : 150,
						title : '权限名称',
						align : 'center'
					}, {
						field : 'permissionBit',
						width : 200,
						title : '权限位',
						align : 'center'
					}, {
						field : 'url',
						width : 250,
						title : 'URL',
						align : 'center'
					}, {
						fixed: 'right', 
						title:'操作', 
						toolbar: '#tableBar',
						width:150
					} ] ],
					page : true
				});
				//监听行工具事件
			  	table.on('tool(table)', function(obj){
				    var data = obj.data;
				    if(obj.event === 'del'){
				      layer.confirm('真的删除当前行吗？', function(index){
				        obj.del();
				        doPost("/PermissionDeleteServlet",{id:obj.data.id},true);
				        initTree();
				        layer.close(index);
				      });
				    } else if(obj.event === 'edit'){
				    	save('/PermissionEditServlet',true,obj);	
				    }
			  	});
				
				//条件查询，并重新加载表格数据
			  	active = {
		  		    reload: function(){
		  		    	var permissionName = $('#permissionName');
		  		      	var permissionBit = $('#permissionBit');
		  		    	//执行重载
		  		    	table.reload('table', {
			  		      	page: {
			  		          curr: 1 //重新从第 1 页开始
			  		        }
			  		        ,where: {
			  		            permissionName: permissionName.val(),
			  		            permissionBit: permissionBit.val(),
			  		            parentId:parentId
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
	  		    			save('/PermissionAddServlet',false,false,function(){
	  		    				active.reload();
	  		    				initTree();
	  		    			});
	  		    			break;
	  		    	}
	  		 	});
	  		  	function save(url,edit,obj,func){
		  		  	$('#info').removeClass("layui-hide");
		  		  	if(edit){
			  		  	$('#formPermissionName').val(obj.data.permissionName);
				    	$('#formPermissionBit').val(obj.data.permissionBit);
				    	$('#formUrl').val(obj.data.url);
		  		  	}
			    	layer.open({
		    		  title: edit?'修改权限':'添加权限', 
		    		  type:1,
		    		  area:['800px','600px'],
		    		  content: $('#info'),
		    		  btn:['保存','取消'],
		    		  yes:function(index){
		    			  var data = {
		    					permissionName:$('#formPermissionName').val(),
		    					permissionBit:$('#formPermissionBit').val(),
		    					url:$('#formUrl').val(),
		    					parentId:parentId
		    			  }
		    			  if(edit){
		    				  data.id = obj.data.id;
		    				  obj.update(data);
		    			  }
		    			  doPost(url,data,true,function(){
		    				  $('#formPermissionName').val('');
					    	  $('#formPermissionBit').val('');
					    	  $('#formUrl').val('');
			    			  $('#info').addClass("layui-hide");
		    			  });
		    			  if(func){
		    				  func();
		    			  }
		    			  layer.close(index);
		    		  },
		    		  btn2:function(index){
		    			  $('#info').addClass("layui-hide");
		    			  layer.close(index);
		    		  },
		    		  cancel:function(index){
		    			  $('#info').addClass("layui-hide");
		    		  }
		    		});
	  		  	}
			});//end table use
			//====================
			function initTree(){
				layui.use(['tree'], function(){
					tree = layui.tree;
					$.ajax({
						url:'/PermissionTreeServlet',
						type:'POST',
						async:'false',
						success:function(data){
							var treeData = [];
							data = JSON.parse(data);
							if(data.code == 200){
								treeData = deep(data.data);
							}
							tree.render({
								id:'permissionTree',
							    elem: '#permissionTree', //默认是点击节点可进行收缩
							    data: treeData,
							    click: function(obj){
							    	parentId = obj.data.id;
							    	active.reload();
							    }
						  	});
						}
					});
					function deep(data){
						return $.map(data,function(item,index){
							if(item.children && item.children.length > 0){
								return {
									id: item.id,
									title: item.permissionName,
									children: deep(item.children)
								}
							}else {
								return {
									id:item.id,
									title: item.permissionName
								}
							}
						});
					}
				});//end tree use
			}
			initTree();
			//==================
		});//end body ready
	});
</script>
</html>