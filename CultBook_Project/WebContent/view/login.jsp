<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style><%@include file="/view/css/login.css"%></style>
</head>
<body>
	<form action="ValidarLoginServlet" method="post">
		Login:
		<input type="text" name="login"><br>
		Senha:
		<input type="password" name="senha"><br>
		<input type="submit" value="Log-in">	
	</form>

</body>
</html>