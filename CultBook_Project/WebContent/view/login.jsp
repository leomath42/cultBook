<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	Boolean error = (Boolean) request.getAttribute("invalidLogin");
%>
<meta charset="ISO-8859-1">
<title>Login</title>
<style><%@include file="/view/css/login.css"%></style>
</head>
<body>
	<%if(error!= null && error) {
		out.println("Usu�rio ou login inv�lido");
		request.setAttribute("invalidLogin", false);
	}
	%>
	<form action="ValidarLoginServlet" method="post">
		Login:
		<input type="text" name="login"><br>
		Senha:
		<input type="password" name="senha"><br>
		<input type="submit" value="Log-in">	
	</form>

</body>
</html>