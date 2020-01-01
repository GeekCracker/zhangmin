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
			<div class="layui-container layui-col-md12">
				<div class="layui-row">
					<!-- 面包屑 -->
					<span class="layui-breadcrumb"> <a href="">首页</a> <a><cite>基础配置</cite></a>
						<a><cite>权限管理</cite></a>
					</span>
				</div>
				<div class="layui-row layui-margin-top20">
					<!-- 权限树 -->
					<div class="layui-col-md4">
						<div id="permissionTree" class="demo-tree demo-tree-box"></div>
					</div>
					<!-- 权限列表 -->
					<div class="layui-col-md8">
						<!-- 查询条件 -->
						<div class="layui-row layui-col-space10 queryParam">
							<div class="layui-col-md2">
								<input type="text" name="permissionName" id="permissionName" placeholder="请输入权限名称"
									class="layui-input">
							</div>
							<div class="layui-col-md2">
								<input type="text" name="permissionBit" id="permissionBit" placeholder="请输入权限位"
									class="layui-input">
							</div>
							<div class="layui-col-md2">
								<button type="button" class="layui-btn" data-type="reload" id="reload">查询</button>
							</div>
						</div>
						<table class="layui-table" id="table" lay-filter="table"></table>						
					</div>
				</div>
			</div>
		</div>
		<div id="footer" class="layui-footer"></div>
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/html" id="tableBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
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

			layui.use('table', function() {
				var table = layui.table;
				table.render({
					elem : '#table',
					limit: 20,
					url : '/PermissionListServlet',
					method : 'POST',
					width : 1300,
					height : 750,
					cols : [ [ {
						type : 'checkbox',
						fixed : 'left',
						align : 'center'
					}, {
						field : 'id',
						width : 80,
						title : 'ID',
						sort : true,
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
				    console.log(data)
				    if(obj.event === 'del'){
				      layer.confirm('真的删除当前行吗？', function(index){
				        obj.del();
				        
				        
				        layer.close(index);
				      });
				    } else if(obj.event === 'edit'){
				      layer.prompt({
				        formType: 2
				        ,value: data.email
				      }, function(value, index){
				        obj.update({
				          email: value
				        });
				        layer.close(index);
				      });
				    }
			  	});
				
				//条件查询，并重新加载表格数据
			  	var $ = layui.$, active = {
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
			  		            permissionBit: permissionBit.val()
		  		        	}
  		     			}, 'data');
	  		    	}
	  		  	};
	  		  	$('.queryParam .layui-btn').on('click', function(){
	  		    	var type = $(this).data('type');
	  		    	active[type] ? active[type].call(this) : '';
	  		 	});
			});//end table use
			//====================
			layui.use(['tree', 'util'], function(){
				var tree = layui.tree,
					layer = layui.layer,
					util = layui.util;
				$.ajax({
					url:'/PermissionTreeServlet',
					type:'POST',
					success:function(data){
						var treeData = [];
						data = JSON.parse(data);
						if(data.code == 200){
							treeData = deep(data.data);
						}
						tree.render({
						    elem: '#permissionTree' //默认是点击节点可进行收缩
						    ,data: treeData
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
			//==================
		});//end body ready
	});
</script>
</html>