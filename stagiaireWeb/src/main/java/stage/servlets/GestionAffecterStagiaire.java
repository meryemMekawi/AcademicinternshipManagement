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

import stage.entities.Cadre;
import stage.entities.Encadrant;
import stage.entities.Stage;
import stage.entities.Stagiaire;
import stage.session.CadreSessionLocal;
import stage.session.EncadrantSessionLocal;
import stage.session.StageSessionLocal;
import stage.session.StagiaireSessionLocal;

@WebServlet("/GestionAffecterStagiaire")
public class GestionAffecterStagiaire extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    @EJB
    CadreSessionLocal cadreSession;

    @EJB
    EncadrantSessionLocal encadrantSession;

    @EJB
    StageSessionLocal stageSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
  
            List<Stagiaire> stagiaires = stagiaireSession.getAllNouveauStagiaire();
            List<Stage> stages = stageSession.getallStage();
            List<Cadre> cadres = cadreSession.getAllCadre();
            List<Encadrant> encadrants = encadrantSession.getallEncadrant();

            // Mise des informations dans la requête pour être récupérées dans la JSP
            request.setAttribute("stagiaires", stagiaires);
            request.setAttribute("stages", stages);
            request.setAttribute("encadrants", encadrants);
            request.setAttribute("cadres", cadres);

            // Redirection vers la page.jsp avec les informations récupérées
            RequestDispatcher dispatcher = request.getRequestDispatcher("AffecterStageStagiaire.jsp");
            dispatcher.forward(request, response);
        
    }
}
