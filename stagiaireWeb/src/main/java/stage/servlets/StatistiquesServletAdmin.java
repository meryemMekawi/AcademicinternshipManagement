package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.session.StatistiquesSessionBeanLocal;

/**
 * Servlet implementation class StatistiquesServletAdmin
 */
@WebServlet("/StatistiquesServletAdmin")
public class StatistiquesServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		
		@EJB
		StatistiquesSessionBeanLocal  statistiquesSession;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		    List<Long> nombreStagiairesParStatut = statistiquesSession.getNombreStagiairesParStatut();
		    List<Long> nombreStagesParStatut = statistiquesSession.getNombreStagesParStatut();

		    request.setAttribute("nombreStagiairesParStatut", nombreStagiairesParStatut);
		    request.setAttribute("nombreStagesParStatut", nombreStagesParStatut);

		    // Redirigez vers la page JSP des statistiques
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/statistiquesAdmin.jsp");
		    dispatcher.forward(request, response);


		}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
