


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.util.URI;

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
	@SuppressWarnings({ "unused", "unchecked", "resource" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Set<Usuario> listaDeUsuario = new HashSet<Usuario>();
		
		if(session == null) {
			session = request.getSession();
			/*Irei inserir a persistência da lista de usuários aqui
			 * deixei session.settribute por enquanto::
			 * */
			try {
				String relativeWebPath = "/WEB-INF/classes/users.dat";
				String usersDataFilePath = getServletContext().getRealPath(relativeWebPath);
				usersDataFilePath.substring(0, usersDataFilePath.indexOf("."));
				
				String realPath = usersDataFilePath.substring(0, usersDataFilePath.indexOf("."));
				realPath+= "cultBook/CultBook_Project/controller/users.dat";
				
				File fileToRead = new File(realPath);
				FileInputStream file = new FileInputStream(fileToRead); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            ObjectInputStream in = new ObjectInputStream(file); p				
	            ObjectInputStream in = new ObjectInputStream(file);  	            
				Object obj = in.readObject();
				listaDeUsuario = (Set<Usuario>) obj;
				in.close();
			}
			catch (Exception e) {

				e.printStackTrace();

			}
			session.setAttribute("listaDeUsuario", listaDeUsuario);
		}
		
		
		//session.setAttribute("listaDeUsuario", listaDeUsuario);

		
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
			System.out.println("new account");
			RequestDispatcher rd = request.getRequestDispatcher("view/cadastro.jsp");
			rd.forward(request, response);
		}

	} 
	

}
