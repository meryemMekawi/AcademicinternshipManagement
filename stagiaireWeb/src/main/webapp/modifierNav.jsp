<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Liste des Encadrants</title>
    <!-- Intégration de Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

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
   
    <h2>Modification Des Encadrants</h2>
    </div>

    <!-- Lister tous les encadrants -->
    <table class="table table-bordered">
        <thead class="thead-light">
            <tr>
           	    <th>cin</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Département</th>
                <th>Statut</th>
                <th>email</th>
                <!-- Autres colonnes à ajouter selon votre entité Encadrant -->
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="encadrant" items="${listEncadrant}">
                <tr>
                	<td>${encadrant.cin}</td>
                    <td>${encadrant.nom}</td>
                    <td>${encadrant.prenom}</td>
                    <td>${encadrant.departement}</td>
                    <td>${encadrant.statut}</td>
                    <td>${encadrant.email}</td>
                    <td>
                        <form action="ModifierEncadrantServlet" method="get">
                            <input type="hidden" name="encadrantId" value="${encadrant.identifiant}">
                            <input type="hidden" name="encadrantCin" value="${encadrant.cin}">
                            <input type="hidden" name="encadrantNom" value="${encadrant.nom}">
                            <input type="hidden" name="encadrantPrenom" value="${encadrant.prenom}">
                            <input type="hidden" name="encadrantDepartement" value="${encadrant.departement}">
                            <input type="hidden" name="encadrantStatut" value="${encadrant.statut}">
                            <input type="hidden" name="encadrantEmail" value="${encadrant.email}">
                            <!-- Autres champs à ajouter selon votre entité Encadrant -->
                            <button type="submit" class="btn btn-primary btn-sm">Modifier</button>
                        </form>
                    </td>
                    <!-- Autres colonnes à ajouter selon votre entité Encadrant -->
                </tr>
            </c:forEach>
        </tbody>
    </table></body>
<!-- Intégration de Bootstrap JS et jQuery (nécessaires pour certaines fonctionnalités de Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</html>
