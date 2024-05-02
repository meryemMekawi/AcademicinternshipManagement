package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Encadrant;
import stage.session.EncadrantSessionLocal;

/**
 * Servlet implementation class MEncadrantServlet
 */
@WebServlet("/MEncadrantServlet")
public class MEncadrantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@EJB
	EncadrantSessionLocal encadrantSession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int encadrantId = Integer.parseInt(request.getParameter("encadrantId"));
		Encadrant encadrant = encadrantSession.getEncadrantById(encadrantId);
		
		if(encadrant !=null) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String statut = request.getParameter("statut");
			String departement = request.getParameter("departement");
			String email = request.getParameter("email");
			
			encadrant.setCin(cin);
			encadrant.setNom(nom);
			encadrant.setPrenom(prenom);
			encadrant.setStatut(statut);
			encadrant.setDepartement(departement);
			encadrant.setEmail(email);
			
			encadrantSession.updateEncadrant(encadrant);
		}
		response.setContentType("test/html");
        response.getWriter().println("<script>alert('Saisie effectuée'); window.location='gestionEncadrants';</script>");
        response.sendRedirect("gestionEncadrants");

	
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
