package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Encadrant;
import stage.session.EncadrantSessionLocal;

/**
 * Servlet implementation class gestionEncadrants
 */
@WebServlet("/gestionEncadrants")
public class gestionEncadrants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @EJB
  EncadrantSessionLocal encadrantsession;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Encadrant>encadrant=encadrantsession.getallEncadrant();		
		request.getSession().setAttribute("listeEncadrant", encadrant);
		response.sendRedirect("gestionEncadrant.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}