<%@page import="java.util.Random"%>
<%@page import="classes.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/view/css/list.css"%></style>
</head>
<body>

	 <%
 		List<Book> books = (ArrayList<Book>) request.getSession().getAttribute("books");
	 %>
	<%
		if(books != null && !books.isEmpty()) {
			if(books.size() <=5) {
				for (Book book : books) {
				    String isbn = "ISBN: " + book.getISBN();
				    %><a href='view/Show.jsp?ISBN=<%=book.getISBN()%>'><%=isbn%></a><%
				    out.println("<br>");
				}
			} else {
				List<Book> books1 = listarRandomBooks(books);
				for (Book book : books1) {
				    String isbn = "ISBN: " + book.getISBN();
				    %><a href='view/Show.jsp?ISBN=<%=book.getISBN()%>'><%=isbn%></a><%
				    out.println("<br>");
				}
			}
		} else {
			out.println("Lista Vazia!");
		}
	%>
	<%! 
	private static List<Book> listarRandomBooks(List<Book> books) {
		Random rand = new Random();
	    List<Book> randBooks = new ArrayList<Book>();
	    while(randBooks.size() < 5) {
	    	int randomNum = rand.nextInt(books.size());
	    	if(!randBooks.contains(books.get(randomNum)))
	    		randBooks.add(books.get(randomNum));
	    }
	    return randBooks;
	}
	
	
	
	%>
</body>
</html>