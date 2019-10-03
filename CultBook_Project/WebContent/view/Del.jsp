<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/view/css/login.css"%></style>
</head>
<body>
	<%request.setAttribute("control", "Del");%>
	<form action="ControlBookServlet" method="post">
		ISBN:<br>
		<input type="text" name="ISBN"><br>
		<input type="hidden" name="control" value="Del">
		<input type="submit" value="Remover">
	</form>
</body>
</html>