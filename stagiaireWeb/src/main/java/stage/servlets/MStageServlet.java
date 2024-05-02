package stage.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stage.entities.Cadre;
import stage.entities.Stage;
import stage.session.CadreSessionLocal;
import stage.session.StageSessionLocal;

@WebServlet("/MStageServlet")
public class MStageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StageSessionLocal stageSession;

    @EJB
    CadreSessionLocal cadreSession;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stageId = Integer.parseInt(request.getParameter("stageId"));
        Stage stage = stageSession.getStageById(stageId);

        if (stage != null) {
            // Récupération des données du formulaire
            String sujet = request.getParameter("sujet");
            String dateDebutStr = request.getParameter("dateDebut");
            String dateFinStr = request.getParameter("dateFin");
            String departement = request.getParameter("departement");
            String typestage = request.getParameter("typestage");
            String statut = request.getParameter("statut");
            String cadreNom = request.getParameter("cadre");

            // Conversion des dates de String à Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = null;
            Date dateFin = null;
            try {
                dateDebut = dateFormat.parse(dateDebutStr);
                dateFin = dateFormat.parse(dateFinStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Gérer l'erreur de conversion de la date
            }

            // Récupération du cadre par son nom
            Cadre cadre = cadreSession.getCadreByNom(cadreNom);

            // Mettre à jour les détails du stage avec les nouvelles valeurs du formulaire
            stage.setSujet(sujet);
            stage.setDate_debut(dateDebut);
            stage.setDate_fin(dateFin);
            stage.setDepartement(departement);
            stage.setTypestage(typestage);
            stage.setStatut(statut);
            stage.setCadre(cadre);

            // Appel de la méthode updateStage pour mettre à jour le stage
            stageSession.updateStage(stage);
        }

        // Redirection vers une page de confirmation ou une autre page appropriée
        // Réponse JavaScript pour afficher une boîte de dialogue
        response.setContentType("text/html");

        response.getWriter().println("<script>alert('Saisie effectuée'); window.location='accueil_chef.jsp';</script>");

         }

  
}
