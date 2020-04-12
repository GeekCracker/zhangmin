<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入外部样式表 -->
<link rel="stylesheet" href="/layui/css/layui.css"><!-- layui.css layui框架的css样式表 -->
<link rel="stylesheet" href="/css/main.css"><!-- main.css 我们自定义的公共样式表 -->
<title>会员管理</title>
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
						<a><cite>会员管理</cite></a>
					</span>
				</div>
				<div class="layui-row layui-margin-top20">
					<!-- 会员列表 -->
					<div class="layui-col-md12 layui-col-lg12">
						<!-- 查询条件 -->
						<div class="layui-row layui-col-space10 queryParam layui-form">
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="memberCode" id="memberCode" placeholder="请输入会员编号"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="name" id="name" placeholder="请输入会员姓名"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="nickName" id="nickName" placeholder="请输入会员昵称"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="phone" id="phone" placeholder="请输入会员联系方式"
									class="layui-input">
							</div>
							<div class="layui-col-md3 layui-col-lg1">
								<button type="button" class="layui-btn" data-type="reload" id="reload">查询</button>
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
		<form class="layui-form" id="bookForm" lay-filter="bookForm" action="">
			<div class="layui-form-item layui-row">
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">书籍编号：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formNumber" name="number" required lay-verify="required"
							placeholder="请输入书籍编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">书籍名称：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formBookName" name="bookName" required lay-verify="required"
							placeholder="请输入书籍名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-col-sm6">
					<label class="layui-form-label layui-col-md5" style="width:120px;">书籍作者：</label>
					<div class="layui-input-inline layui-col-sm7">
						<input type="text" id="formAuthor" name="author" required lay-verify="required"
							placeholder="请输入书籍作者" autocomplete="off" class="layui-input">
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
					url : '/MemberListServlet',
					method : 'POST',
					//cols 表头列
					cols : [ [ 
						{
							type : 'numbers',
							width : 80,
							title : '序号',
							fixed : 'left',
							align : 'center'
						},{
							field : 'memberCode',
							width : 200,
							title : '会员编号',
							align : 'center'
						},{
							field : 'name',
							width : 200,
							title : '会员姓名',
							align : 'center'
						},{
							field : 'nickName',
							width : 200,
							title : '会员昵称',
							align : 'center'
						},{
							field : 'phone',
							width : 200,
							title : '联系方式',
							align : 'center'
						},{
							field : 'sex',
							width : 200,
							title : '性别',
							align : 'center'
						},{
							field : 'age',
							width : 200,
							title : '年龄',
							align : 'center'
						},{
							field : 'createTime',
							width : 200,
							title : '注册时间',
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
				//监听行工具事件
			  	table.on('tool(table)', function(obj){
				    var data = obj.data;
				    if(obj.event === 'del'){
				      layer.confirm('真的删除当前行吗？', function(index){
				        obj.del();
				        doPost("/MemberDeleteServlet",{id:obj.data.id},true);
				        layer.close(index);
				      });
				    }
			  	});
			  	//条件查询，并重新加载表格数据
			  	active = {
		  		    reload: function(){
		  		    	var memberCode = $('#memberCode');
		  		    	var name = $('#name');
		  		    	var nickName = $('#nickName');
		  		    	var phone = $('#phone');
		  		    	//执行重载
		  		    	table.reload('table', {
			  		      	page: {
			  		          curr: 1 //重新从第 1 页开始
			  		        }
			  		        ,where: {
			  		        	memberCode: memberCode.val(),
			  		        	name: name.val(),
			  		            nickName: nickName.val(),
			  		            phone: phone.val()
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
	  		    	}
	  		 	});
			});
		});
	});
</script>
</html>