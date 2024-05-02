package stage.servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import stage.entities.Stagiaire;
import stage.session.StagiaireSessionLocal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/generatePDF")
public class generateAttestation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StagiaireSessionLocal stagiaireSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stagiaireId = Integer.parseInt(request.getParameter("stageId"));

        Stagiaire stagiaire = stagiaireSession.getStagiaireById(stagiaireId);
        if (stagiaire != null) {
            String nomStagiaire = stagiaire.getNom();
            String prenomStagiaire = stagiaire.getPrenom();
            String cinStagiaire = stagiaire.getCin();
            String departement=stagiaire.getDepartement();

            generateAttestationPDF(response, nomStagiaire, prenomStagiaire, cinStagiaire ,departement);
        }
    }

    private void generateAttestationPDF(HttpServletResponse response, String nom, String prenom, String cin, String departement) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=attestation.pdf");

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Génération du contenu de l'attestation
            String contenuAttestation = generateContenuAttestation(nom, prenom, cin , departement);
            document.add(new Paragraph(contenuAttestation));

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String generateContenuAttestation(String nom, String prenom, String cin ,String departement) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        StringBuilder contenu = new StringBuilder();
        contenu.append("Attestation de stage en entreprise\n\n")
                .append("Je soussigné(e) Raihana Lahsinia, agissant en qualité de Responsable RH, certifie par la présente que Monsieur/Madame/Mademoiselle ")
                .append(prenom).append(" ").append(nom).append(", D'un Cin :").append(cin).append("Au sein du département :").append(departement)
                .append(" a effectué un stage au sein de notre entreprise en qualité d’ingénieur.\n\n")
            
                .append("Cette attestation est délivrée à l’intéressé(e) pour servir et valoir ce que de droit.\n\n")
                .append("Fait le : ").append(dateFormat.format(date)).append("\n")
                .append("Signature : _________");

        return contenu.toString();
    }
}
