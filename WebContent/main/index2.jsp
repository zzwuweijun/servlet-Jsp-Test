<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.sz.pojo.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<p>登录成功</p>
	<span><%=((User) session.getAttribute("user")).getUname()%></span>
	<span>,你好</span>
	<a href="http://localhost:8088/myServlet1/user?oper=out">退出</a>
	<br />


	</script>
</body>
</html>