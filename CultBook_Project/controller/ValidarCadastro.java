
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
		
		try {
			login = request.getParameter("login").equals(null) ? "" : request.getParameter("login");
			nome = request.getParameter("nome").equals(null) ? "" : request.getParameter("nome");
			email = request.getParameter("email").equals(null) ? "" : request.getParameter("email");
			telefone = request.getParameter("telefone").equals(null) ? "" : request.getParameter("telefone");
			endereco = request.getParameter("endereco").equals(null) ? "" : request.getParameter("endereco");
			senha = request.getParameter("senha").equals(null) ? "" : request.getParameter("senha");
			confirmarSenha = request.getParameter("confirmarSenha").equals(null) ? "" : request.getParameter("confirmarSenha");

		}catch (Exception e) {
			// TODO: handle exception
		}
			
	
		
		if(verificaCampoVazio(new String[]{login, nome, email, telefone, senha, confirmarSenha})) {
			System.out.println("Existem itens vazios !!!");
			
//			try{
//				throw new Exception("Existem itens vazios !!!");
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
			request.setAttribute("erroCampoVazio", "true");
			RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
			rd.include(request, response);
		}
		
		if(verificaSenha(senha, confirmarSenha)) {
			request.setAttribute("erroSenha", "true");
			RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
			if(request.getAttribute("erroCampoVazio") == null)
				rd.include(request, response);
		}
		else 
		{
		
			Usuario user = new Usuario(login, nome, email, telefone, endereco, senha);
			HttpSession session = request.getSession(false); // não irá criar uma nova sessão !
			
			//adicionado a sessao, pode ser recuperado pelo ValidarLoginServlet
			Set<Usuario>  listaDeUsuario = (Set<Usuario>) session.getAttribute("listaDeUsuario"); 
			if(!(listaDeUsuario == null))
				listaDeUsuario.add(user);
			//voltando para o menuInicial.jsp ou para login.jsp.
			
			/*Irei jogar o usuário direto para a tela de menu*/
			RequestDispatcher rd2 = request.getRequestDispatcher("view/menuInicial.jsp");
			rd2.forward(request, response);
			
		}
	
		
	}
	
	private boolean verificaSenha(String senha, String confirmarSenha) {
		//verifica a senha de acordo com os requisitos do projeto.
		if(senha == null || senha.equals("") || !senha.equals(confirmarSenha)) {
			return true;
		}
		else if(senha.length() <= 8) {
			return true;
		}
		return false;
	}
	
	private boolean verificaCampoVazio(String[] args) {
		//verifica campos inexistentes na tela de cadastro.
		
		for(String i: args) {
			if(i == null || i.equals("")) return true;
		}
		
		return false;
	}
}
