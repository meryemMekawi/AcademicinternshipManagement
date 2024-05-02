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

@WebServlet("/MStagiaireServlet")
public class MStagiaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stagiaireId = Integer.parseInt(request.getParameter("stagiaireId"));
        Stagiaire stagiaire = stagiaireSession.getStagiaireById(stagiaireId);

        if (stagiaire != null) {
            // Récupération des données du formulaire
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String cin = request.getParameter("cin");
            String etablissement = request.getParameter("etablissement");
            String filiere = request.getParameter("filiere");
            String adresse = request.getParameter("adresse");
            String email = request.getParameter("email");
            String dateNaissanceStr = request.getParameter("dateNaissance");
            String statut = request.getParameter("statut");
            String departement = request.getParameter("departement");
            // Ajoutez d'autres champs ici si nécessaire

            // Conversion de la date de String à Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissance = null;
            try {
                dateNaissance = dateFormat.parse(dateNaissanceStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Gérer l'erreur de conversion de la date
            }

            // Mettre à jour les détails du stagiaire avec les nouvelles valeurs du formulaire
            stagiaire.setNom(nom);
            stagiaire.setPrenom(prenom);
            stagiaire.setCin(cin);
            stagiaire.setEtablissement(etablissement);
            stagiaire.setFiliere(filiere);
            stagiaire.setAdresse(adresse);
            stagiaire.setEmail(email);
            stagiaire.setDateNaissance(dateNaissance);
            stagiaire.setStatut(statut);
            stagiaire.setDepartement(departement);
            // Mettre à jour d'autres attributs si nécessaire

            // Appel de la méthode updateStagiaire pour mettre à jour le stagiaire
            stagiaireSession.updateStagiaire(stagiaire);
        }

        // Redirection vers une page de confirmation ou une autre page appropriée
        response.setContentType("text/html");
        response.getWriter().println("<script>alert('Saisie effectuée'); window.history.back();</script>");    }
    }

