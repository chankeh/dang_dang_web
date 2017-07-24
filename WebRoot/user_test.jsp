<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
    <%@page import="com.tarena.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user</title>
</head>
<body>
<form method="post">
	<input name="name"/>
	<br/>
	<input type="submit" value="confirm"/>
	<%
		User user= new User();
		user.setNickname("张三");
		user.setEmail("email");
		user.setPassword("123");
		request.setAttribute("user",user);
	request.setCharacterEncoding("utf-8");
	 %>
	<table>
		<tr>
			<td>nickname</td>
			<td>email</td>
			<td>password</td>
		</tr>
		<tr>
			<td>${user.nickname}</td>
			<td>${user.email}</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td colspan="3">
				<span>${param.name}</span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>