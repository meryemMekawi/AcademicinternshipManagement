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

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;


@WebServlet("/Attestation")
public class Attestation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	StagiaireSessionLocal stagiairesession;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stagiaire> stagiaires=stagiairesession.getAllArchiveStagiaire();
        request.setAttribute("stagiaires", stagiaires);
     // Redirection vers la page.jsp avec les informations récupérées
        RequestDispatcher dispatcher = request.getRequestDispatcher("PageAttestation.jsp");
        dispatcher.forward(request, response);
   

	}

	

}
