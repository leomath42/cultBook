<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tela de cadastro do CultBook</title>
	</head>
	<body>
		<h1>Insira seus dados:</h1>
		<form action="ValidarCadastro" method="post">
			login: <input type="text" name="login" ><br><br>
			nome: <input type="text" name="nome"><br><br>
			email: <input type="text" name="email"><br><br>
			telefone: <input type="text" name="telefone"><br><br>
			endereço: <input type="text" name="endereco"><br><br>
			senha: <input type="password" name="senha"><br><br>
			confirmar senha: <input type="password" name="confirmarSenha"><br><br>
			<button type="submit" name="confirmar" value="confirmarButton">confirmar</button>
			
			<%  if(request.getAttribute("erroCampoVazio") != null && request.getAttribute("erroCampoVazio").equals("true")){
					out.print("<br><br><h1> Preencha todos os campos. </h1>");
				}
				else if(request.getAttribute("erroSenha") != null && request.getAttribute("erroSenha").equals("true")){ 
					out.print("<br><br><h1> Senha não corresponde ou possui tamanho menor que 8.</h1>");
				}
			%>
		</form>	
	</body>
</html>