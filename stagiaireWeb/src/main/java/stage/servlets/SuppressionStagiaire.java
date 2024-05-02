package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;


@WebServlet("/SuppressionStagiaire")
public class SuppressionStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@EJB
	StagiaireSessionLocal stagiairesession;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idP = request.getParameter("id");
		    int id = Integer.parseInt(idP);

		    // Supprime le stage avec l'ID spécifié
		    stagiairesession.deleteStagiaire(id);

		    // Récupère le stage supprimé (si existant)
		    Stagiaire deleteStagiaire = stagiairesession.getStagiaireById(id);

		    // Définit le type de contenu de la réponse
		    response.setContentType("text/html");

		    if (deleteStagiaire == null) {
		        // Si le stage a été supprimé avec succès, redirige vers la même page avec un message de réussite
		        response.getWriter().println("<script>alert('Suppression effectuée'); window.location='accueil_chef.jsp';</script>");
		    } else {
		        // Si la suppression a échoué, redirige vers la même page avec un message d'erreur
		        response.getWriter().println("<script>alert('Suppression échouée'); window.location='accueil_chef.jsp';</script>");
		    }
		}
	
}
