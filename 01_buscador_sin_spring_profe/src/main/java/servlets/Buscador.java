package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogemos el parámetro de tema, le pedimos a la capa de servicio la lista
		//de páginas y se la entregamos a una JSP para que las muestre
		String tema=request.getParameter("tema");
		BuscadorService service=new BuscadorService();
		List<Pagina> paginas=service.buscar(tema);
		request.setAttribute("paginas", paginas);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listado.jsp");
		dispatcher.forward(request, response);
		
	}

}
