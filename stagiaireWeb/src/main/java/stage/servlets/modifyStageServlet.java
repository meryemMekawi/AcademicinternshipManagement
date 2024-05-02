package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stage;
import stage.session.StageSessionLocal;

/**
 * Servlet implementation class modifyStageServlet
 */
@WebServlet("/modifyStageServlet")
public class modifyStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    StageSessionLocal stageSession;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
		int stageId = Integer.parseInt(request.getParameter("stageId")); // Récupération de l'identifiant du stage à modifier
        Stage stage = stageSession.getStageById(stageId);
     // Placer le stage en tant qu'attribut de la requête pour le transférer à la page JSP
        request.setAttribute("stage", stage);
     // Redirection vers la page JSP où vous pouvez afficher les détails du stage
        request.getRequestDispatcher("modifyStage.jsp").forward(request, response);
	
	}


}
