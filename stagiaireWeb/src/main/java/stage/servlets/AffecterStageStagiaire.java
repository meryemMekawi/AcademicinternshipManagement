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

@WebServlet("/AffecterStageStagiaire")
public class AffecterStageStagiaire extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    @EJB
    StageSessionLocal stageSession;

    @EJB
    EncadrantSessionLocal encadrantSession;

    @EJB
    CadreSessionLocal cadreSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int stagiaireId = Integer.parseInt(request.getParameter("stageId")); // Récupération de l'identifiant du stage à modifier


    	
    	        // Récupération de la liste des stages, encadrants et cadres
    	        List<Stage> stages = stageSession.getallStage();
    	        List<Encadrant> encadrants = encadrantSession.getallEncadrant();
    	        List<Cadre> cadres = cadreSession.getAllCadre();

    	        // Mise des informations dans la requête pour être récupérées dans la JSP
    	        request.setAttribute("stagiaireId", stagiaireId);
    	        request.setAttribute("stages", stages);
    	        request.setAttribute("encadrants", encadrants);
    	        request.setAttribute("cadres", cadres);

    	        // Redirection vers la page.jsp avec les informations récupérées
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("PageDeConfirmation.jsp");
    	        dispatcher.forward(request, response);
    	   
    }
}
