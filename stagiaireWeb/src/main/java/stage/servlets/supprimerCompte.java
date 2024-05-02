package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Compte;
import stage.session.CompteSessionLocal;

@WebServlet("/supprimerCompte")
public class supprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	CompteSessionLocal compteSession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String compteIdParam = request.getParameter("compteId");

	        // Check if the parameter is not null and not empty
	        if (compteIdParam != null && !compteIdParam.isEmpty()) {
	            try {
	                int compteId = Integer.parseInt(compteIdParam);

	                // Supprimer le compte
	                compteSession.deleteCompte(compteId);

	                Compte deletedCompte = compteSession.getCompteById(compteId);
	                if (deletedCompte == null) {
	                    // La suppression a réussi, redirige vers la page de gestion des comptes
	                    response.sendRedirect("gestionComptes");
	                } else {
	                    // Si la suppression a échoué, configure un cookie et redirige vers la page de gestion des comptes
	                    Cookie cookie = new Cookie("suppressionEchouee", "true");
	                    response.addCookie(cookie);

	                    response.sendRedirect("gestionComptes");
	                }
	            } catch (NumberFormatException e) {
	                // Handle the case where the parameter is not a valid integer
	                // You might want to redirect to an error page or handle it differently
	                response.sendRedirect("gestionComptes");
	            }
	        } else {
	            // Handle the case where the parameter is null or empty
	            // You might want to redirect to an error page or handle it differently
	            response.sendRedirect("gestionComptes");
	        }

	
	}

	

}
