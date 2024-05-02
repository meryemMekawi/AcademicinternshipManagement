package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stage;
import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;

/**
 * Servlet implementation class modifyStagiaireServlet
 */
@WebServlet("/modifyStagiaireServlet")
public class modifyStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	StagiaireSessionLocal stagiairesession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stagiaireId = Integer.parseInt(request.getParameter("stageId")); // Récupération de l'identifiant du stage à modifier
        Stagiaire stagiaire = stagiairesession.getStagiaireById(stagiaireId);
     // Placer le stage en tant qu'attribut de la requête pour le transférer à la page JSP
        request.setAttribute("stagiaire", stagiaire);
     // Redirection vers la page JSP où vous pouvez afficher les détails du stage
        request.getRequestDispatcher("modifyStagiaire.jsp").forward(request, response);
	
	}

	

}
