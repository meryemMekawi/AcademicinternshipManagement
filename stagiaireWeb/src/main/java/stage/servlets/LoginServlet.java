package stage.servlets;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.session.CompteSessionLocal;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private CompteSessionLocal compteSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValid = compteSession.verifyLogin(username, password);
        int compteId = compteSession.getIdCadreByNom(username); // Récupérer l'ID du compte
        String nom =compteSession.getCadreNomByCompteId(username);
        if (isValid) {
            String accountType = compteSession.getAccountType(username);


            if (accountType != null) {
                if (accountType.equals("admindrh")) {
                    request.getSession().setAttribute("nom", nom);

                    response.sendRedirect("accueil_admin.jsp");

                } else if (accountType.equals("chefdrh")) {
                    request.getSession().setAttribute("nom", nom);
                    response.sendRedirect("accueil_chef.jsp");
                } 
                else if (accountType.equals("superuser")) {
                    request.getSession().setAttribute("nom", nom);
                    response.sendRedirect("espaceAdminApp.jsp");
                } 
                else {
                    response.sendRedirect("index.jsp"); // Redirection par défaut si le type de compte n'est pas géré
                }
            } 
                
            } else {
                response.sendRedirect("index.jsp"); // Redirection par défaut si le type de compte n'est pas défini
            }
        
        // Création du cookie avant les redirections
        if (request.getParameter("rememberMe") != null) {
            Cookie cookie = new Cookie("username", username); // Création d'un cookie avec le nom d'utilisateur
            cookie.setMaxAge(7 * 24 * 60 * 60); // Durée de vie du cookie (7 jours dans cet exemple)
            response.addCookie(cookie); // Ajout du cookie à la réponse
        }
    }
}
