package stage.servlets;

import java.io.IOException;
import java.util.Collections;
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



/**
 * Servlet implementation class ChercherEncadrant
 */
@WebServlet("/ChercherEncadrant")
public class ChercherEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB
	EncadrantSessionLocal encadrantSession;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String cin = request.getParameter("cin");

        List<Encadrant> resultats = Collections.emptyList();
        String erreurMessage = null;

        if (nom != null && !nom.isEmpty()) {
            // Recherche par nom
            resultats = encadrantSession.chercherParNom(nom);
            if (resultats.isEmpty()) {
                erreurMessage = "Aucun encadrant trouvé avec le nom : " + nom;
            }
        } else if (cin != null && !cin.isEmpty()) {
            // Recherche par CIN
            resultats = encadrantSession.chercherParCIN(cin);
            if (resultats.isEmpty()) {
                erreurMessage = "Aucun encadrant trouvé avec le CIN : " + cin;
            }
        }
        if (erreurMessage != null) {
        	request.setAttribute("erreurMessage", erreurMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("gestionEncadrant.jsp");
            dispatcher.forward(request, response);}
        else {

        	request.setAttribute("resultats", resultats);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultatRecherche.jsp");
            dispatcher.forward(request, response);}
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
