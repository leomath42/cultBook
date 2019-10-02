


import java.io.IOException;
import java.util.HashSet;
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
 * Servlet implementation class MainServlet
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Set<Usuario> listaDeUsuario = new HashSet<Usuario>();
		
		if(session == null) {
			session = request.getSession();
			/*Irei inserir a persistência da lista de usuários aqui
			 * deixei session.settribute por enquanto::
			 * */
			session.setAttribute("listaDeUsuario", listaDeUsuario);
		}
		else {
			//session.setAttribute("listaDeUsuario", listaDeUsuario);
		}
		

		
		RequestDispatcher rd = request.getRequestDispatcher("view/menuInicial.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String novaConta = request.getParameter("novaConta");
		
		if( !(login == null || login.equals(null))) {
			System.out.println("login");
			RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");
			rd.forward(request, response);
		}
		else if( !(novaConta == null || novaConta.equals(null))) {
			System.out.println("new accont");
			RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
			rd.forward(request, response);
		}

	}


}
