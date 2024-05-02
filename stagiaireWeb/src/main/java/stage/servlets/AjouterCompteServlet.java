package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Compte;
import stage.session.CompteSessionLocal;

/**
 * Servlet implementation class AjouterCompteServlet
 */
@WebServlet("/AjouterCompteServlet")
public class AjouterCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 	@EJB
	    CompteSessionLocal compteSession;
	 	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	            String login = request.getParameter("login");
	            String motDePasse = request.getParameter("motDePasse");
	            String typeCompte = request.getParameter("typeCompte");

	            // Create a new Compte object
	            
	            
	            Compte newCompte = new Compte();
	            newCompte.setLogin(login);
	            newCompte.setMotDePasse(motDePasse);
	            newCompte.setTypeCompte(typeCompte);

	            // Persist the new Compte
	            compteSession.addCompte(newCompte);
	            List<Compte> listCompte = compteSession.getallCompte();
	            request.setAttribute("listCompte", listCompte);

	            // Redirect to a success page or perform other actions
	            response.sendRedirect("gestionComptes");
	        
	    }}

