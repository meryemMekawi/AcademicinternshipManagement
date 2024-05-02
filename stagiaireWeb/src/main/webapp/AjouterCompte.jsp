<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Ajouter un Compte</title>
    <!-- Intégration de Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
                <a class="nav-link dropdown-toggle" href="#" id="gestionComptesDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Gestion des Comptes
                </a>
                <div class="dropdown-menu" aria-labelledby="gestionComptesDropdown">
                    <a class="dropdown-item" href="AjouterCompte.jsp">Ajouter Compte</a>
                    <a class="dropdown-item" href="supprimerCompte">Supprimer Compte</a>
                    <a class="dropdown-item" href="FindCompteById.jsp">Chercher Compte</a>
                    <a class="dropdown-item" href="modifierCompte">Modifier Compte</a>
                    <a class="dropdown-item" href="AttribuerCompteServlet">Attribuer Compte</a>
                </div>
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
                    <a class="dropdown-item" href="AjouterEncadrant.jsp" onclick="ajouterStage()">Ajouter Encadrant</a>
                    <a class="dropdown-item" href="modifierServlet" onclick="modifierStage()">Modifier Encadrant</a>
                    <a class="dropdown-item" href="supprimerServlet" onclick="supprimerStage()">Supprimer Encadrant</a>
                   <a class="dropdown-item" href="chercherEncadrant.jsp" onclick="chercherStage()">Chercher Encadrant</a>
                    
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
    <h2>Ajouter un Compte</h2>
    <div class="t">

    <form action="AjouterCompteServlet" method="get">
       
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" name="login" required>
        </div>

        <div class="form-group">
            <label for="motDePasse">Mot de Passe:</label>
            <input type="password" class="form-control" id="motDePasse" name="motDePasse" required>
        </div>

        <div class="form-group">
            <label for="typeCompte">Type de Compte:</label>
            <select class="form-control" id="typeCompte" name="typeCompte" required>
                <option value="admindrh">Admindrh</option>
                <option value="chefdrh">chefdrh</option>
            </select>
        </div>

        <!-- You may include additional fields as needed -->

        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
</div>
<!-- Bootstrap JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
