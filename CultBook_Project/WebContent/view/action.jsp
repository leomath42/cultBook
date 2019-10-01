<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String choice = (String) request.getAttribute("escolha"); %>
<title><%=choice %> Book</title>
</head>
<body>

<%if(choice != null) { 
	choice = choice + ".jsp";%>
	<jsp:include page="<%= choice %>" ></jsp:include>
 <%}%>



</body>
</html>