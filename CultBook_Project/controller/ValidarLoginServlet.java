

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		InputStream input = getClass().getResourceAsStream("login.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(validarLogin(login, senha, br)) {
			request.getSession().setAttribute("login", login);
			RequestDispatcher rd = request.getRequestDispatcher("view/menu.jsp");  
			rd.forward(request, response);
			
		} else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected boolean validarLogin(String login, String senha, BufferedReader file) throws IOException {
		if(login != null && senha != null && login != "" && senha != "") {
			String line = null;
            while( (line=file.readLine()) != null) {
                if(login.equals(line) && senha.equals(file.readLine())) {
                	return true;
                }
            }
		}
		return false;
		
	}
}