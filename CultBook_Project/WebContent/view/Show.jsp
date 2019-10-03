<%@page import="classes.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
<style><%@include file="/view/css/show.css"%></style>
</head>
<body>

	 <%
 		List<Book> books = (ArrayList<Book>) request.getSession().getAttribute("books");
	 %>
	<%
		int isbn = Integer.valueOf(request.getParameter("ISBN"));
		if(books != null && !books.isEmpty()) {
			for (Book book : books) {
				if(book.getISBN() == isbn) {
			    	out.println(book.toString());
			    	out.println("<br>");
				}
			}
		} else {
			out.println("Livro não Existente!");
		}
	%>
</body>
</html>