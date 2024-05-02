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


@WebServlet("/supprimerEncadrant")
public class supprimerEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @EJB
    private EncadrantSessionLocal encadrantSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de l'encadrant à supprimer depuis la requête
        int encadrantId = Integer.parseInt(request.getParameter("id"));

        // Supprimer l'encadrant
        encadrantSession.deleteEncadrant(encadrantId);
        
        Encadrant deletedEncadrant=encadrantSession.getEncadrantById(encadrantId);
        if (deletedEncadrant == null) {


	            response.sendRedirect("gestionEncadrants");

	        	    } else {
	        // Si la suppression a échoué, redirige vers une autre page ou affiche un message d'erreur
	        	        // Réponse JavaScript pour afficher une boîte de dialogue

	        	            response.sendRedirect("gestionEncadrants");


    }
}}
