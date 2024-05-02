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

import stage.entities.Encadrant;
import stage.session.EncadrantSessionLocal;


@WebServlet("/ajouterEncadrantServlet")
public class ajouterEncadrantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB
	EncadrantSessionLocal encadrantSession;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cin = request.getParameter("cin");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String departement= request.getParameter("departement");
		String statut = request.getParameter("statut");
		
		// création d'un nouveau encadrant
		
		Encadrant Nouveauencadrant = new Encadrant();
		Nouveauencadrant.setCin(cin);
		Nouveauencadrant.setNom(nom);
		Nouveauencadrant.setPrenom(prenom);
		Nouveauencadrant.setEmail(email);
		Nouveauencadrant.setDepartement(departement);
		Nouveauencadrant.setStatut(statut);
		
		// ajout d'un nouveau encadrant à la base de donnée
		
		encadrantSession.addEncadrant(Nouveauencadrant);
		List<Encadrant>listEncadrant = encadrantSession.getallEncadrant();
		request.setAttribute("liste", listEncadrant);
		
		response.sendRedirect("gestionEncadrants");

		
	}

	
	

}
