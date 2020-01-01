<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<!-- <link rel="stylesheet" href="/assets/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/layui/css/layui.css">
<link rel="stylesheet" href="/css/main.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div id="header" class="layui-header"></div>
		<div id="left" class="layui-side layui-bg-black"></div>
		<div class="layui-body">
		
			1111
		
		</div>
		<div id="footer" class="layui-footer"></div>
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#header").load("/base/header.html");
		$("#left").load("/base/left.html");
		$("#footer").load("/base/footer.html");
		$("body").ready(function(){
			layui.use('element', function() {
				var element = layui.element;
			});
		})
	});
</script>
</html>