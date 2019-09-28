<%@page import="classes.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	 <%
 		List<Book> books = (ArrayList<Book>) request.getSession().getAttribute("books");
	 %>
	<%
		if(books != null && !books.isEmpty()) {
			for (Book book : books) {
			    out.println(book.toString());
			    out.println("<br>");
			}
		} else {
			out.println("Lista Vazia!");
		}
	%>
</body>
</html>