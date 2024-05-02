package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Compte;
import stage.session.CompteSessionLocal;

/**
 * Servlet implementation class MCompteServlet
 */
@WebServlet("/MCompteServlet")
public class MCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@EJB
	CompteSessionLocal compteSession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int compteId = Integer.parseInt(request.getParameter("compteId"));
		Compte compte = compteSession.getCompteById(compteId);
		
		if(compte !=null) {
			String login = request.getParameter("login");
			String motDePasse = request.getParameter("motDePasse");
			String typeCompte = request.getParameter("typeCompte");
		
			
			compte.setLogin(login);
			compte.setMotDePasse(motDePasse);
			compte.setTypeCompte(typeCompte);
			compteSession.updateCompte(compte);
	        response.sendRedirect("gestionComptes");

		}
	
        response.sendRedirect("gestionComptes");

	
	}	


	


}
