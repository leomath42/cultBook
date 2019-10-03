
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Book;

/**
 * Servlet implementation class ControlBookServlet
 */
@WebServlet("/ControlBookServlet")
public class ControlBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String control = (String) request.getParameter("control");
		
		if(control.equals("Add")) {
			addBook(request, response);
		} else if(control.equals("Del")) {
			delBook(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ISBN = Integer.valueOf(request.getParameter("ISBN"));
		String Titulo = (String) request.getParameter("Titulo");
		int ano = Integer.valueOf(request.getParameter("ano"));
		String editora = (String) request.getParameter("editora");
		int edicao = Integer.valueOf(request.getParameter("edicao"));
		String autor = (String) request.getParameter("autor");
		Book book = new Book(ISBN, Titulo, ano, edicao, editora, autor);
		
		if(request.getSession().getAttribute("books") != null) {
			List<Book> books = (ArrayList<Book>) request.getSession().getAttribute("books");
			List isbns = new ArrayList();
			for (Book book2 : books) {
				isbns.add(book2.getISBN());
			}
			if(!isbns.contains(ISBN)) {
				books.add(book);
				request.getSession().setAttribute("books", books);
				request.setAttribute("adicionado", "Livro Adicionado com Sucesso!");
			}
			else
				request.setAttribute("existente", "Livro já existe!");

		} else {
			List<Book> books = new ArrayList<Book>();
			books.add(book);
			request.getSession().setAttribute("books", books);
			request.setAttribute("adicionado", "Livro adicionado com Sucesso!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("view/menu.jsp");  
		rd.forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void delBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ISBN = Integer.valueOf(request.getParameter("ISBN"));
		
		if(request.getSession().getAttribute("books") == null) {
			PrintWriter out = response.getWriter();
			out.println("Lista Vazia!");
		} else {
			List<Book> books = (ArrayList<Book>) request.getSession().getAttribute("books");
			List<Book> toRemove = new ArrayList<Book>();
			for (Book book : books) {
			    if (book.getISBN() == ISBN) {
			        toRemove.add(book);
			    }
			}
			books.removeAll(toRemove);
			request.getSession().setAttribute("books", books);
			request.setAttribute("adicionado", "Livro removido com Sucesso!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("view/menu.jsp");  
		rd.forward(request, response);
	}

}
