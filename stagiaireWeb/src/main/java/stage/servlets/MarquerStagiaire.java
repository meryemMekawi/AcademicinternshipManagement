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

@WebServlet("/MarquerStagiaire")
public class MarquerStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    StagiaireSessionLocal stagiairesession;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stagiaireId = Integer.parseInt(request.getParameter("stagiaireId")); // Récupération de l'identifiant du stagiaire à modifier
        Stagiaire stagiaire = stagiairesession.getStagiaireById(stagiaireId);
        
        if (stagiaire != null) {
            int abs = stagiaire.getAbsence();
            int absNV = abs + 1;
            stagiaire.setAbsence(absNV);
            stagiairesession.updateStagiaire(stagiaire);
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Modification effectuée'); window.location='accueil_chef.jsp';</script>");
        } else {
            // Gérer le cas où le stagiaire avec l'ID donné n'est pas trouvé
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Stagiaire introuvable avec cet identifiant");
        }
    }
  

	
}
