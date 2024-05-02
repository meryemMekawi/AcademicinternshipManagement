package stage.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AttribuerCompteActionServlet
 */
@WebServlet("/AttribuerCompteActionServlet")
public class AttribuerCompteActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Cadre> getUnassignedCadres() {
        List<Cadre> allCadres = cadreSession.getAllCadre();
        List<Cadre> unassignedCadres = new ArrayList<>();

        for (Cadre Cadre : allCadres) {
            if (Cadre.getCompte() == null) {
         	   unassignedCadres.add(Cadre);
            }
        }

        return unassignedCadres;}
    
    @EJB
    CompteSessionLocal compteSession;

    @EJB
    CadreSessionLocal cadreSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        try {
            int compteId = Integer.parseInt(request.getParameter("compteId"));

            Compte compte = compteSession.getCompteById(compteId);
            if (compte != null) {
                // Set the selected compte to a request attribute
                request.setAttribute("selectedCompte", compte);

                // Set the unassigned cadres in the request attribute
                List<Cadre> unassignedCadres = getUnassignedCadres();
                request.setAttribute("unassignedCadres", unassignedCadres);

                // Forward the request to listeCadres.jsp
                request.getRequestDispatcher("listeCadres.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
       
     

        // Redirect to an error page if the attribution fails
        response.sendRedirect("gestionComptes.jsp");
    }

    

// Other methods...
}
