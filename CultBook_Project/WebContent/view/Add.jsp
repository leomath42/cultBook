<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	
	<form action="ControlBookServlet" method="post">
		ISBN:<br>
		<input type="text" name="ISBN"><br>
		Título:<br>
		<input type="text" name="Titulo"><br>
		Ano:<br>
		<input type="text" name="ano"><br>
		Editora:<br>
		<input type="text" name="editora"><br>
		Edição:<br>
		<input type="text" name="edicao"><br>
		Autor:<br>
		<input type="text" name="autor"><br>
		<input type="hidden" name="control" value="Add">
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>