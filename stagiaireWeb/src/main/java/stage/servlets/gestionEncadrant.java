package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Encadrant;
import stage.session.EncadrantSessionLocal;

@WebServlet("/gestionEncadrants")
public class gestionEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @EJB
    EncadrantSessionLocal encadrantSession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Encadrant>encadrant=encadrantSession.getallEncadrant();
		request.getSession().setAttribute("listEncadrant", encadrant);
		response.sendRedirect("gestionEncadrant.jsp");
		
	}


}
