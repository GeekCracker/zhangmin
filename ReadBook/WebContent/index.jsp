<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>借书吧平台</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
<script type="text/javascript" src="assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<style type="text/css">
	body {
		background-repeat: no-repeat;
		background-size: cover;
		background-image: url(/img/bg.jpeg);
	}
	form{
		margin: 30% auto;
	}
</style>
</head>
<body>
	<div class="container">
		<form action="/UserLoginServlet" method="POST">
			<h2>借书吧平台-后台管理系统</h2><br /><br />
			<div class="form-group row col-sm-4"> 
				<label for="username">用户名：</label> 
				<input type="text" class="form-control col-sm-8 inline" id="username" name="username">
			</div>
			<div class="form-group row col-sm-4">
				<label for="password">密&emsp;码：</label> 
				<input type="password" class="form-control col-sm-8 inline" id="password" name="password">
			</div>
			<div class="form-group col-sm-3 text-right">
				<button type="submit" class="btn btn-primary">立即登录</button>&emsp;
				<button type="submit" class="btn btn-secondary">忘记密码?</button>
			</div>
			<span style="color:red;">${data.msg}</span>	
		</form>
	</div>
</body>
</html>