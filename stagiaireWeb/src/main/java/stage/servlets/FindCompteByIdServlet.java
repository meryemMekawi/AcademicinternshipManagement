package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Compte;
import stage.session.CompteSessionLocal;

@WebServlet("/FindCompteByIdServlet")
public class FindCompteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  @EJB
	    CompteSessionLocal compteSession;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            // Retrieve Compte ID from the request parameter
	            int compteId = Integer.parseInt(request.getParameter("compteId"));

	            // Find Compte by ID
	            Compte foundCompte = compteSession.getCompteById(compteId);

	            // Set the found Compte as a request attribute
	            request.setAttribute("compte", foundCompte);

	            // Forward the request to the JSP page for displaying the details
	            RequestDispatcher dispatcher = request.getRequestDispatcher("displayCompteDetails.jsp");
	            dispatcher.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exceptions and redirect to an error page if needed
	            response.sendRedirect("gestionComptes.jsp");
	        }
	    }

}
