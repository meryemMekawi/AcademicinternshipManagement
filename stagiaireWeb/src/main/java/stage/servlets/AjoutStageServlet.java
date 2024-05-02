package stage.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stage;
import stage.session.StageSessionLocal;

@WebServlet("/AjoutStageServlet")
public class AjoutStageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StageSessionLocal stagesession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sujet = request.getParameter("sujet");
        String departement = request.getParameter("departement");
        String typeStage = request.getParameter("typestage");
        String statut = request.getParameter("statut");
        Date dateDebutStr = Date.valueOf(request.getParameter("dateDebut"));
        Date dateFinStr = Date.valueOf(request.getParameter("dateFin"));

        
            // Création d'un nouvel objet Stage avec les données récupérées
            Stage nouveauStage = new Stage();
            nouveauStage.setSujet(sujet);
            nouveauStage.setDate_debut(dateDebutStr);
            nouveauStage.setDate_fin(dateFinStr);
            nouveauStage.setDepartement(departement);
            nouveauStage.setTypestage(typeStage);
            nouveauStage.setStatut(statut);

            // Ajout du stage à la base de données via la méthode addStage
            stagesession.addStage(nouveauStage);
            List<Stage>listStage= stagesession.getallStage();
			request.setAttribute("liste" , listStage);


            // Réponse JavaScript pour afficher une boîte de dialogue
           response.setContentType("text/html");
            response.getWriter().println("<script>alert('Saisie effectuée'); window.location='accueil_chef.jsp';</script>");

        
    }
}
