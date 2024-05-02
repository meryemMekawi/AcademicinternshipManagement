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

import stage.entities.Compte;
import stage.session.CadreSessionLocal;
import stage.session.CompteSessionLocal;

/**
 * Servlet implementation class AttribuerCompteServlet
 */
@WebServlet("/AttribuerCompteServlet")
public class AttribuerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



    @EJB
    CompteSessionLocal compteSession;

    @EJB
    CadreSessionLocal cadreSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 List<Compte> unassignedComptes = getUnassignedComptes();
         request.getSession().setAttribute("unassignedComptes", unassignedComptes);
         request.getRequestDispatcher("attribuerCompte.jsp").forward(request, response);

    }

    private List<Compte> getUnassignedComptes() {
        List<Compte> allComptes = compteSession.getallCompte();
        List<Compte> unassignedComptes = new ArrayList<>();

        for (Compte compte : allComptes) {
            if (compte.getCadre() == null) {
                unassignedComptes.add(compte);
            }
        }

        return unassignedComptes;
    }

}
