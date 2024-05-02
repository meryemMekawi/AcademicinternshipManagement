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

@WebServlet("/ModifierEncadrantServlet")
public class modifierencadrantServlet extends HttpServlet {
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
		int encadrantId = Integer.parseInt(request.getParameter("encadrantId")); 
		
		Encadrant encadrant = encadrantSession.getEncadrantById(encadrantId);
		request.setAttribute("encadrant", encadrant);
		request.getRequestDispatcher("modifierEncadrant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
