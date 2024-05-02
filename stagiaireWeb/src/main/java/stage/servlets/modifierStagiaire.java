package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;

/**
 * Servlet implementation class modifierStagiaire
 */
@WebServlet("/modifierStagiaire")
public class modifierStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   StagiaireSessionLocal stagiairesession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Stagiaire>stagiaire = stagiairesession.getallStagiaire();
	request.getSession().setAttribute("listeStagiaire", stagiaire);
	response.sendRedirect("modifierStagiaire.jsp");
	}

}
