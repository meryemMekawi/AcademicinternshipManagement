package stage.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/AjoutStagiaireServlet")
public class AjoutStagiaireServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String nom = request.getParameter("nom");
         String prenom = request.getParameter("prenom");
         String cin = request.getParameter("cin");
         String etablissement = request.getParameter("etablissement");
         String filiere = request.getParameter("filiere");
         String adresse = request.getParameter("adresse");
         String email = request.getParameter("email");
         Date dateNaissance = Date.valueOf(request.getParameter("dateNaissance"));
         long numTelephone = Long.parseLong(request.getParameter("numTelephone"));
         String statut = request.getParameter("statut");
         String departement = request.getParameter("departement");

         // Création d'un nouvel objet Stagiaire avec les données récupérées
         Stagiaire nouveauStagiaire = new Stagiaire();
         nouveauStagiaire.setNom(nom);
         nouveauStagiaire.setPrenom(prenom);
         nouveauStagiaire.setCin(cin);
         nouveauStagiaire.setEtablissement(etablissement);
         nouveauStagiaire.setFiliere(filiere);
         nouveauStagiaire.setAdresse(adresse);
         nouveauStagiaire.setEmail(email);
         nouveauStagiaire.setDateNaissance(dateNaissance);
         nouveauStagiaire.setNumTelephone(numTelephone);
         nouveauStagiaire.setStatut(statut);
         nouveauStagiaire.setDepartement(departement);

         // Appel de la méthode addStagiaire pour insérer le nouveau stagiaire
         stagiaireSession.addStagiaire(nouveauStagiaire);

         // Redirection vers une page de confirmation ou autre
         response.setContentType("text/html");
         response.getWriter().println("<script>alert('Saisie effectuée'); window.history.back();</script>");    }
 }
