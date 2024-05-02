package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Cadre;
import stage.entities.Encadrant;
import stage.entities.Stage;
import stage.entities.Stagiaire;
import stage.session.CadreSessionLocal;
import stage.session.EncadrantSessionLocal;
import stage.session.StageSessionLocal;
import stage.session.StagiaireSessionLocal;

@WebServlet("/ServletDeTraitement")
public class ServletDeTraitement extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    @EJB
    EncadrantSessionLocal encadrantSession;

    @EJB
    StageSessionLocal stageSession;

    @EJB
    CadreSessionLocal cadreSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des identifiants depuis les paramètres de la requête
    	int idStagiaire = Integer.parseInt(request.getParameter("stagiaireId"));
    	int idEncadrant = Integer.parseInt(request.getParameter("encadrantId"));
    	int idStage = Integer.parseInt(request.getParameter("stageId"));
    	int idCadre = Integer.parseInt(request.getParameter("cadreId"));


        // Récupération des entités à partir des identifiants
        Stagiaire stagiaire = stagiaireSession.getStagiaireById(idStagiaire);
        Encadrant encadrant = encadrantSession.getEncadrantById(idEncadrant);
        Stage stage = stageSession.getStageById(idStage);
        Cadre cadre = cadreSession.getCadreById(idCadre);

        // Ajout du stage au stagiaire
       
        stagiaireSession.addStageStagiaire(stagiaire, encadrant, stage, cadre);
        // Envoi de la réponse au client avec un message d'alerte
        response.setContentType("text/html");
        response.getWriter().println("<script>alert('Ajout effectué'); window.history.back();</script>");
    }
}
