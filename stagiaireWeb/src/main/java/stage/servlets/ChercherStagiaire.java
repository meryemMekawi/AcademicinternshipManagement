package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;

/**
 * Servlet implementation class ChercherStagiaire
 */
@WebServlet("/ChercherStagiaire")
public class ChercherStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	StagiaireSessionLocal stagiairesession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
	    Stagiaire stagiaire = stagiairesession.getStagiaireById(id);
	    request.setAttribute("stagiaire", stagiaire);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Chercher_Stagiaire.jsp");
        dispatcher.forward(request, response);
	}

	

}
