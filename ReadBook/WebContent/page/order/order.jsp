<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入外部样式表 -->
<link rel="stylesheet" href="/layui/css/layui.css"><!-- layui.css layui框架的css样式表 -->
<link rel="stylesheet" href="/css/main.css"><!-- main.css 我们自定义的公共样式表 -->
<title>订单管理</title>
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
						<a><cite>订单管理</cite></a>
					</span>
				</div>
				<div class="layui-row layui-margin-top20">
					<!-- 书柜列表 -->
					<div class="layui-col-md12 layui-col-lg12">
						<!-- 查询条件 -->
						<div class="layui-row layui-col-space10 queryParam layui-form">
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="orderCode" id="orderCode" placeholder="请输入订单编号"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="bookNumber" id="bookNumber" placeholder="请输入书籍编号"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="bookName" id="bookName" placeholder="请输入书籍名称"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">						
								<select name="shopId" id="shopId" class="layui-input" lay-filter="shopId">
									<option value="">请选择店铺</option>
								</select>
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="memberCode" id="memberCode" placeholder="请输入会员编号"
									class="layui-input">
							</div>
							<div class="layui-col-md4 layui-col-lg2">
								<input type="text" name="phone" id=phone placeholder="请输入会员联系方式"
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
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/html" id="tableBar">
  <a class="layui-btn layui-btn-xs" lay-event="info">详情</a>
  <a class="layui-btn layui-btn-xs" lay-event="send">配送</a>
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
					url : '/OrderListServlet',
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
							field : 'orderCode',
							width : 200,
							title : '订单编号',
							align : 'center'
						},{
							field : 'memberCode',
							width : 200,
							title : '会员编号',
							align : 'center'
						},{
							field : 'shopName',
							width : 200,
							title : '店铺名称',
							align : 'center'
						},{
							field : 'bookCaseNumber',
							width : 200,
							title : '书柜编号',
							align : 'center'
						},{
							field : 'bookNumber',
							width : 200,
							title : '书籍编号',
							align : 'center'
						},{
							field : 'bookName',
							width : 200,
							title : '书籍名称',
							align : 'center'
						},{
							field : 'author',
							width : 200,
							title : '作者',
							align : 'center'
						},{
							field : 'price',
							width : 200,
							title : '单价',
							align : 'center'
						},{
							field : 'payAmount',
							width : 200,
							title : '支付金额',
							align : 'center'
						},{
							field : '支付时间',
							width : 200,
							title : '店铺名称',
							align : 'center'
						},{
							field : 'state',
							width : 200,
							title : '状态',
							templet : function(state){
								/* 0：未确认1：已确认2：已支付3：已发货4：已签收5：已完成 */
								if(state == 0){
									return '未确认';
								}else if(state == 1){
									return '已确认';
								}else if(state == 2){
									return '已支付';
								}else if(state == 3){
									return '已发货';
								}else if(state == 4){
									return '已签收';
								}else if(state == 5){
									return '已完成';
								}else {
									return '未知的订单状态';
								}
							},
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
				        doPost("/OrderDeleteServlet",{id:obj.data.id},true);
				        layer.close(index);
				      });
				    }
			  	});
			  	//条件查询，并重新加载表格数据
			  	active = {
		  		    reload: function(){
		  		    	var orderCode = $('#orderCode');
		  		    	var shopId = $('#shopId');
		  		    	var bookCaseId = $('#bookCaseId');
		  		    	var bookNumber = $('#bookNumber');
		  		    	var memberCode = $('#memberCode');
		  		    	var phone = $('#phone');
		  		    	//执行重载
		  		    	table.reload('table', {
			  		      	page: {
			  		          curr: 1 //重新从第 1 页开始
			  		        }
			  		        ,where: {
				  		        orderCode: orderCode.val(),
				  		        shopId: shopId.val(),
				  		        bookCaseId: bookCaseId.val(),
				  		        bookNumber: bookNumber.val(),
			  		        	memberCode: memberCode.val(),
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