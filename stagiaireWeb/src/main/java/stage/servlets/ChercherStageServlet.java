package stage.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stage;
import stage.session.StageSessionLocal;

/**
 * Servlet implementation class ChercherStageServlet
 */
@WebServlet("/ChercherStageServlet")
public class ChercherStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @EJB
	    StageSessionLocal stagesession;
	  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("idStage"));
			Stage stage=stagesession.getStageById(id);
			 request.setAttribute("stage", stage);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("modifyStage.jsp");
		        dispatcher.forward(request, response);
			
		}

	}
