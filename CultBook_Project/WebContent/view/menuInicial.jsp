<%@page import="classes.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>		Biblioteca CultBook		</title>
		<style><%@include file="/view/css/menuInicial.css"%></style>
	</head>
	<body background="grey">
		<h1> Biblioteca CultBook </h1>
		<form action="Main" method="post">
			Login: <button type="submit" name="login" value="login">Login</button><br>
			Nova Conta: <button type="submit" name="novaConta" value="novaConta">Nova Conta</button>
			<%
			if(request.getAttribute("validUser") != null){ 
				out.print("<p>Usuario "+request.getAttribute("validUser")+" cadastrado com sucesso!<p>");
			}
			%>
		</form>
	</body>
</html>