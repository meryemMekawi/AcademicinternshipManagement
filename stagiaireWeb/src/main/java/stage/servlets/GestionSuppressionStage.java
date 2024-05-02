package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stage;
import stage.session.StageSessionLocal;

@WebServlet("/GestionSuppressionStage")
public class GestionSuppressionStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	StageSessionLocal stagesession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stage>stage= stagesession.getallStageNonAffecter();
		request.getSession().setAttribute("ListeStage", stage);
        response.sendRedirect("supprimerStage.jsp");
	}


}
