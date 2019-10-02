<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String user = (String) request.getSession().getAttribute("login"); 
   String adicionado = (String) request.getAttribute("adicionado");
   String deletado = (String) request.getAttribute("deletado");
   String existente = (String) request.getAttribute("existente");
%>
<title>Menu Principal</title>
<style><%@include file="/view/css/menu.css"%></style>
</head>
<body>
	<h1>
	Bem-vindo(a) - <%=user %>!
	</h1>
	<p>
	<%
	if(adicionado != null) {
		out.println(adicionado);
	}else if(deletado != null) {
		out.println(deletado);
	}else if(existente != null) {
		out.println(existente);
	}
	%>
	</p>
	
	<form action="ValidarEscolhaServlet" method="get">
		<button type="submit" name="book" value="Add">Adicionar Livro</button><br>
		<button type="submit" name="book" value="Del">Remover Livro</button><br>
		<button type="submit" name="book" value="List">Listar Livros</button>
	</form>
</body>
</html>