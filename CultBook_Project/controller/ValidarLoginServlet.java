
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Usuario;

/**
 * Servlet implementation class ValidarLoginServlet
 */
@WebServlet("/ValidarLoginServlet")
public class ValidarLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream input = getClass().getResourceAsStream("login.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		PrintWriter out = response.getWriter();
		
		Set<Usuario> listaDeUsuario  = (Set<Usuario>) request.getSession().getAttribute("listaDeUsuario");

		if(validarLogin(login, senha, br, listaDeUsuario)) {
			request.getSession().setAttribute("login", login);
			RequestDispatcher rd = request.getRequestDispatcher("view/menu.jsp");  
			rd.forward(request, response);
			
		} else {
	        request.setAttribute("invalidLogin", true);       
	        RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");          
	        rd.forward(request, response);                                
	       } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected boolean validarLogin(String login, String senha, BufferedReader file, Set<Usuario> listaDeUsuario) throws IOException {
		// Caso admin(su,su1)
		if(login != null && senha != null && login != "" && senha != "") {
			String line = null;
            while( (line=file.readLine()) != null) {
                if(login.equals(line) && senha.equals(file.readLine())) {
                	return true;
                }
            }
		}
		// caso usuário comum cadastrado
		if(!listaDeUsuario.isEmpty()) {
			Iterator<Usuario> it = listaDeUsuario.iterator();
			while (it.hasNext()) {
				Usuario usuario = it.next();
				if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
					return true;
				}
			}
 		}
		return false;
		
	}
}


