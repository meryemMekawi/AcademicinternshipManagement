package stage.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;


@WebServlet("/MStagiairesModifier")
public class MStagiairesModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   StagiaireSessionLocal stagiairesession;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stagiaireId = Integer.parseInt(request.getParameter("stagiaireId"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("cin");
        String etablissement = request.getParameter("etablissement");
        String filiere = request.getParameter("filiere");
        String adresse = request.getParameter("adresse");
        String email = request.getParameter("email");
        String dateNaissanceStr = request.getParameter("dateNaissance");
        String numTelephoneStr = request.getParameter("numTelephone");
        String statut = request.getParameter("statut");
        String departement = request.getParameter("departement");

        // Conversion de la date de naissance en objet Date
        Date dateNaissance = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateNaissance = sdf.parse(dateNaissanceStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Gérer l'erreur de conversion de la date si nécessaire
        }

        // Conversion du numéro de téléphone en long
        long numTelephone = 0;
        try {
            numTelephone = Long.parseLong(numTelephoneStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Gérer l'erreur de conversion du numéro de téléphone si nécessaire
        }

        // Obtenir le stagiaire à modifier depuis la session bean
        Stagiaire stagiaire = stagiairesession.getStagiaireById(stagiaireId);
     // Mettre à jour les informations du stagiaire
        stagiaire.setNom(nom);
        stagiaire.setPrenom(prenom);
        stagiaire.setCin(cin);
        stagiaire.setEtablissement(etablissement);
        stagiaire.setFiliere(filiere);
        stagiaire.setAdresse(adresse);
        stagiaire.setEmail(email);
        stagiaire.setDateNaissance(dateNaissance);
        stagiaire.setNumTelephone(numTelephone);
        stagiaire.setStatut(statut);
        stagiaire.setDepartement(departement);
        // Mettre à jour le stagiaire dans la session bean
        stagiairesession.updateStagiaire(stagiaire);
        response.setContentType("text/html");

        response.getWriter().println("<script>alert('Modification effectuée'); window.location='accueil_chef.jsp';</script>");


	}

	
}
