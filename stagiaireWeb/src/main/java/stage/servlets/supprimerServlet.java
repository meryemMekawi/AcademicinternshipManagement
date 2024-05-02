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

@WebServlet("/supprimerServlet")
public class supprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    EncadrantSessionLocal encadrantSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Encadrant>encadrant=encadrantSession.getallEncadrantNonAffecter();
		request.getSession().setAttribute("listEncadrant", encadrant);
		response.sendRedirect("SupprimerNav.jsp");

	
	}

	

}
