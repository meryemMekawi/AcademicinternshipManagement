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

@WebServlet("/gestionStagiaireAdmin")
public class gestionStagiaireAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	StagiaireSessionLocal stagiairesession;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Stagiaire>stagiaire=stagiairesession.getallStagiaire();
	request.getSession().setAttribute("listStagiaire", stagiaire);
	response.sendRedirect("StagiaireAdmin.jsp");
}
}