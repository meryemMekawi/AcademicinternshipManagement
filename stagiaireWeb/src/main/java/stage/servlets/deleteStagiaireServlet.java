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

@WebServlet("/deleteStagiaireServlet")
public class deleteStagiaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("stageId");
        
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);

            try {
                stagiaireSession.deleteStagiaire(id);
                Stagiaire deletedStagiaire = stagiaireSession.getStagiaireById(id);

                if (deletedStagiaire == null) {
                    response.setContentType("text/html");
                    response.getWriter().println("<script>alert('Suppression effectuée'); window.location='accueil_chef.jsp';</script>");
                } else {
                    response.setContentType("text/html");
                    response.getWriter().println("<script>alert('Suppression échouée'); window.location='accueil_chef.jsp';</script>");
                }
            } catch (Exception e) {
                // Gérer toute exception ici, par exemple, une exception de base de données
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('Une erreur s'est produite lors de la suppression'); window.location='accueil_chef.jsp';</script>");
                e.printStackTrace(); // Affiche l'erreur dans la console (pour le débogage)
            }
        } else {
            // Gérer le cas où le paramètre est absent ou vide
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('ID du stagiaire absent ou invalide'); window.location='accueil_chef.jsp';</script>");
        }
    }
}
