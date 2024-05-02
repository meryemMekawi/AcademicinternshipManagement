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


@WebServlet("/ChercherStagiaireServlet")
public class ChercherStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    StagiaireSessionLocal stagiairesession;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idStagiaire"));
		Stagiaire stagiaire =stagiairesession.getStagiaireById(id);
		 request.setAttribute("stagiaire", stagiaire);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Modifier_stagiaire.jsp");
	        dispatcher.forward(request, response);
		
	}

}
