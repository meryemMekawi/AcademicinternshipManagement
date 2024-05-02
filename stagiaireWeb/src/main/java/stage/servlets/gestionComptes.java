package stage.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Compte;
import stage.session.CompteSessionLocal;


@WebServlet("/gestionComptes")
public class gestionComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	CompteSessionLocal compteSession;
	
			
		
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				List<Compte>compte=compteSession.getallCompte();
				request.getSession().setAttribute("listCompte", compte);
				response.sendRedirect("gestionComptes.jsp");
				
			}
	
	


}
