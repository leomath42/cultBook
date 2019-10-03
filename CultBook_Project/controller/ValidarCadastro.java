
import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Usuario;

/**
 * Servlet implementation class ValidarCadastro
 */
@WebServlet("/ValidarCadastro")
public class ValidarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String login;
    private String nome;
    private String email;
    private String telefone;
	private String endereco;
	private String senha;
	private String confirmarSenha;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
		if(!response.isCommitted())
			rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login = request.getParameter("login").equals(null) ? "" : request.getParameter("login");
		nome = request.getParameter("nome").equals(null) ? "" : request.getParameter("nome");
		email = request.getParameter("email").equals(null) ? "" : request.getParameter("email");
		telefone = request.getParameter("telefone").equals(null) ? "" : request.getParameter("telefone");
		endereco = request.getParameter("endereco").equals(null) ? "" : request.getParameter("endereco");
		senha = request.getParameter("senha").equals(null) ? "" : request.getParameter("senha");
		confirmarSenha = request.getParameter("confirmarSenha").equals(null) ? "" : request.getParameter("confirmarSenha");

		if(verificaCampoVazio(new String[]{login, nome, email, telefone, senha, confirmarSenha})) {
			request.setAttribute("camposVazios", "Existem campos nao preenchidos!");
		}

		request.setAttribute("erroSenha", verificaSenha(senha, confirmarSenha,login));
		request.setAttribute("erroUser", verificaUsuario(nome, email));

		if(request.getAttribute("erroSenha").equals("") && request.getAttribute("erroUser").equals("") && request.getAttribute("camposVazios") == null) {
			Usuario user = new Usuario(login, nome, email, telefone, endereco, senha);
			HttpSession session = request.getSession(false); // não irá criar uma nova sessão !
			
			//adicionado a sessao, pode ser recuperado pelo ValidarLoginServlet
			Set<Usuario>  listaDeUsuario = (Set<Usuario>) session.getAttribute("listaDeUsuario"); 
			if(!(listaDeUsuario == null))
				listaDeUsuario.add(user);
			//voltando para o menuInicial.jsp ou para login.jsp.
			request.setAttribute("validUser", user.getNome());
			/*Irei jogar o usuário direto para a tela de menu*/
			RequestDispatcher rd2 = request.getRequestDispatcher("view/menuInicial.jsp");
			rd2.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
			rd.forward(request, response);			
		}
	}
	
	private String verificaUsuario(String nome, String email) {
		//verifica as informacoes do usuario
		String errosUser = "";
		if(nome.split(" ").length < 2) {
			String erroUser = "Campo Nome deve ter no minimo um sobrenome!<br>";
			errosUser += erroUser;
		}
		if(!email.contains("@")) {
			String erroUser = "Email invalido, @ nao encontrado!<br>";
			errosUser += erroUser;
		}
		if(errosUser != null) {
			return errosUser;
		}
		return null;
	}

	private String verificaSenha(String senha, String confirmarSenha, String login) {
		//verifica a senha de acordo com os requisitos do projeto.
		String erros = "";
		if(senha == null || senha.equals("")) {
			String erro = "Campo de senha vazio!<br>";
			erros += erro;
		}
		if (!senha.equals(confirmarSenha)) {
			String erro = "\nConfirmação da senha é diferente da senha!<br>";
			erros += erro;
		}
		if(senha.length() < 6 || senha.length() > 10) {
			String erro = "\nSenha deve ter de 6 a 10 caracteres!<br>";
			erros += erro;
		}
		if(senha == login) {
			String erro = "Senha não pode ser igual ao login!<br>";
			erros += erro;
		}
		if(erros != null) {
			return erros;
		}
		return null;
	}
	
	private boolean verificaCampoVazio(String[] args) {
		//verifica campos inexistentes na tela de cadastro.
		
		for(String i: args) {
			if(i == null || i.equals("")) return true;
		}
		
		return false;
	}
}
