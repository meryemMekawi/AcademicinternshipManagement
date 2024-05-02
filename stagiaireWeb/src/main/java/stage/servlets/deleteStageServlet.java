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
 * Servlet implementation class deleteStageServlet
 */
@WebServlet("/deleteStageServlet")
public class deleteStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	StageSessionLocal stagesession;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idParam = request.getParameter("stageId");
	    int id = Integer.parseInt(idParam);
	    
	    // Supprimer le stage
	    stagesession.deleteStage(id);

	    // Vérification de la suppression
	    Stage deletedStage = stagesession.getStageById(id);
	    if (deletedStage == null) {
	        // Si le stage a été supprimé avec succès, redirige vers la même page
	        // Réponse JavaScript pour afficher une boîte de dialogue
	           response.setContentType("text/html");
	            response.getWriter().println("<script>alert('Supression effectuée'); window.location='Stage.jsp';</script>");

	        	    } else {
	        // Si la suppression a échoué, redirige vers une autre page ou affiche un message d'erreur
	        	        // Réponse JavaScript pour afficher une boîte de dialogue
	        	           response.setContentType("text/html");
	        	            response.getWriter().println("<script>alert('Suppression echouée'); window.location='accueil_chef.jsp';</script>");

	        	        	    }
	}

}
