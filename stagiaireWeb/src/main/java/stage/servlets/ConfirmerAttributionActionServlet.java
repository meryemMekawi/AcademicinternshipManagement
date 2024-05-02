package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Cadre;
import stage.entities.Compte;
import stage.session.CadreSessionLocal;
import stage.session.CompteSessionLocal;

/**
 * Servlet implementation class ConfirmerAttributionActionServlet
 */
@WebServlet("/ConfirmerAttributionActionServlet")
public class ConfirmerAttributionActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	    @EJB
	    CompteSessionLocal compteSession;

	    @EJB
	    CadreSessionLocal cadreSession;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            // Retrieve parameters from the form
	            int compteId = Integer.parseInt(request.getParameter("compteId"));
	            int cadreId = Integer.parseInt(request.getParameter("cadreId"));

	            // Get the selected compte and cadre
	            Compte compte = compteSession.getCompteById(compteId);
	            Cadre cadre = cadreSession.getCadreById(cadreId);

	            // Check if the compte and cadre are not null
	            if (compte != null && cadre != null) {
	                // Set the compte for the cadre
	                cadre.setCompte(compte);

	                // Update the entities in the database
	                cadreSession.updateCadre(cadre);

	                // Redirect to a success page or perform other actions
	                response.sendRedirect("gestionComptes.jsp");
	                return;
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Log or handle the exception as needed
	        }

	        // Redirect to an error page if the attribution fails
	        response.sendRedirect("gestionComptes.jsp");
	    }

	
	}


