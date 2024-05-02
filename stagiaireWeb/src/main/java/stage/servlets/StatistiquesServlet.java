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


@WebServlet("/StatistiquesServlet")
public class StatistiquesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@EJB
	StatistiquesSessionBeanLocal  statistiquesSession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    List<Long> nombreStagiairesParStatut = statistiquesSession.getNombreStagiairesParStatut();
	    List<Long> nombreStagesParStatut = statistiquesSession.getNombreStagesParStatut();
	    List<Long> nombreEncadrantsParStatut = statistiquesSession.getNombreEncadrantsParStatut();

	    request.setAttribute("nombreStagiairesParStatut", nombreStagiairesParStatut);
	    request.setAttribute("nombreStagesParStatut", nombreStagesParStatut);
	    request.setAttribute("nombreEncadrantsParStatut", nombreEncadrantsParStatut);

	    // Redirigez vers la page JSP des statistiques
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/statistiques.jsp");
	    dispatcher.forward(request, response);


	}


}
