<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription Stagiaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="exstyle/style.css">
    
</head>
<body>
 <header>
        <nav>
            <a href="accueil.jsp">
                <img src="images/logo.png" alt="" class="logo">
            </a>
            <ul>
                <li>
                    <a href="accueil.jsp">Accueil</a>
                </li>
                <li>
                    <a href="a_propos.jsp">À Propos de Nous</a>
                </li>
                <li>
                    <a href="nous_contacter.jsp">Nous Contacter</a>
                </li>
                <li>
                    <a href="inscription.jsp">Inscription</a>
                </li>
                <li>
                    <a href="index.jsp">Have an account ?Login</a>
                </li>
            </ul>
            <!--    <img src ="images/17973908.jpg" alt=""> -->
            <div class="overlay"></div>
        </nav>
    </header>
    <div class="titre">
        <h2 class="text-center mb-4">Inscription Stagiaire</h2></div>
        <div class="t">
        <form action="inscriptionServlet" method="GET">

            <div class="mb-3">
                <input type="hidden"  id="id" name="id" />
                
            </div>

            <div class="mb-3">
                <label for="nom" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>

            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom :</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>

            <div class="mb-3">
                <label for="cin" class="form-label">CIN :</label>
                <input type="text" class="form-control" id="cin" name="cin" required>
            </div>

            <div class="mb-3">
                <label for="etablissement" class="form-label">Établissement :</label>
                <select id="etablissement" name="etablissement" class="form-select" aria-label="Sélectionner Votre établissement" required>
        <option selected disabled value="">Sélectionner votre etablisssement</option>
        <option value="Ensakh">Ensakh</option>
        <option value="EnsaF">EnsaF</option>
        <option value="EHTP">EHTP</option>
        <option value="ENCG">ENCG</option>
    </select>
            </div>

            <div class="mb-3">
                <label for="filiere" class="form-label">Filière :</label>
<select id="filiere" name="filiere" class="form-select" aria-label="Sélectionner Votre filiere" required>
        <option selected disabled value="">Sélectionner votre filiere</option>
        <option value="gi">Génie Informatique</option>
        <option value="ge">Génie Electrique</option>
        <option value="co">Comptabilité</option>
        <option value="iid">Informatiqe et ingénieurie des données</option>
    </select>            </div>

            <div class="mb-3">
                <label for="adresse" class="form-label">Adresse :</label>
                <input type="text" class="form-control" id="adresse" name="adresse" required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email :</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="mb-3">
                <label for="dateNaissance" class="form-label">Date de Naissance :</label>
                <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
            </div>

            <div class="mb-3">
                <label for="numTelephone" class="form-label">Numéro de Téléphone :</label>
                <input type="tel" class="form-control" id="numTelephone" name="numTelephone" required>
            </div>

            <input type="hidden" id="statut" name="statut" value="Nouveau">
            <input type="hidden" id="idStage" name="idStage" value="null">
            <input type="hidden" id="idEncadrant" name="idEncadrant" value="null">
            <input type="hidden" id="idcadre" name="idcadre" value="null">
            
            

          <div class="mb-3">
    <label for="departement" class="form-label">Département :</label>
    <select id="departement" name="departement" class="form-select" aria-label="Sélectionner le département" required>
        <option selected disabled value="">Sélectionner le département</option>
        <option value="Mathematique">Mathematique Appliquées</option>
        <option value="Informatique">Informatique et traitement des données</option>
        <option value="Comptabilite">Comptabilite et marketing</option>
        <option value="Electrique">Electrique</option>
    </select>
</div>

            <div class="mb-3">
                <input type="submit" class="btn btn-primary" value="S'inscrire">
                
            </div>

        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
