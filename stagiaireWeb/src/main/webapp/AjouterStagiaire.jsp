<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un stagiaire</title>
    <!-- Ajout des liens vers les fichiers CSS de Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="exstyle/style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg custom-navbar">
    <a href="accueil_chef.jsp">
        <img src="images/logo.png" alt="" class="logo">
    </a>
    <a class="navbar-brand" href="#">
        Bienvenue <%= session.getAttribute("nom")%> ! 
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
        <li>
                    <a href="accueil_chef.jsp">Accueil</a>
                </li>
                
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownStage" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Stage
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownStage">
                    <a class="dropdown-item" href="Ajouter_Stage.jsp" onclick="ajouterStage()">Ajouter Stage</a>
                    <a class="dropdown-item" href="modifierStages" onclick="modifierStage()">Modifier Stage</a>
                    <a class="dropdown-item" href="GestionSuppressionStage" onclick="supprimerStage()">Supprimer Stage</a>
                   <a class="dropdown-item" href="Chercher_stage.jsp" onclick="chercherStage()">Chercher Stage</a>
                    
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownStagiaire" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Stagiaire
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownStagiaire">
                    <a class="dropdown-item" href="AjouterStagiaire.jsp" onclick="ajouterStage()">Ajouter Stagiaire</a>
                    <a class="dropdown-item" href="modifierStagiaire" onclick="modifierStage()">Modifier Stagiaire</a>
                    <a class="dropdown-item" href="GestionSuppressionStagiaire" onclick="supprimerStage()">Supprimer Stagiaire</a>
                    <a class="dropdown-item" href="Chercher_Stagiaire.jsp" onclick="supprimerStage()">Chercher Stagiaire</a>
                    <a class="dropdown-item" href="GestionAffecterStagiaire" onclick="supprimerStage()">Affecter stage-Stagiaire</a>
                    <a class="dropdown-item" href="Attestation" onclick="chercherStage()">Attestation</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownStage" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Encadrant
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownStage">
                    <a class="dropdown-item" href="Ajouter_Stage.jsp" onclick="ajouterStage()">Ajouter Stage</a>
                    <a class="dropdown-item" href="modifierStages" onclick="modifierStage()">Modifier Stage</a>
                    <a class="dropdown-item" href="GestionSuppressionStage" onclick="supprimerStage()">Supprimer Stage</a>
                   <a class="dropdown-item" href="Chercher_stage.jsp" onclick="chercherStage()">Chercher Stage</a>
                    
                </div>
            </li>
            <li>
                    <a href="a_propos.jsp">À Propos de Nous</a>
                </li>
             <li>
                    <a href="accueil.jsp">Log Out </a>
                </li>
        </ul>
    </div>
</nav>


   <div class="titre centered">
        <h2>Ajouter un stagiaire</h2>
    </div>
         <div class="t">
        <form action="AjoutStagiaireServlet" method="get">
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
        <option selected disabled value="">Sélectionner votre établissement</option>
        <option value="Ensakh">Ensakh</option>
        <option value="EnsaF">EnsaF</option>
        <option value="EHTP">EHTP</option>
        <option value="ENCG">ENCG</option>
    </select>
</div>

           <div class="mb-3">
    <label for="filiere" class="form-label">Filière :</label>
    <select id="filiere" name="filiere" class="form-select" aria-label="Sélectionner Votre filière" required>
        <option selected disabled value="">Sélectionner votre filière</option>
        <option value="gi">Génie Informatique</option>
        <option value="ge">Génie Électrique</option>
        <option value="co">Comptabilité</option>
        <option value="iid">Informatique et Ingénierie des Données</option>
    </select>
</div>     

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
        <option value="Mathematique">Mathématiques Appliquées</option>
        <option value="Informatique">Informatique et Traitement des Données</option>
        <option value="Comptabilite">Comptabilité et Marketing</option>
        <option value="Electrique">Électrique</option>
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
