<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<form action="user" method="get">
		<input type="hidden" name="oper" value="login">
		<label>用户名：</label>
		<input type="text" name="uname" placeholder="请输入用户名" />
		<label>用户名：</label>
		<input type="password" name="pwd" placeholder="请输入密码" />
		<input type="submit" value="登录">
	</form>
	<br />


</body>
</html>