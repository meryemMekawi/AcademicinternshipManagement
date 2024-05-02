<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
    <title>Affectation de Stages pour Stagiaire</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <div class="titre">
        <h2>Affectation de Stages pour Stagiaire</h2></div>
        <div class="t">
        <form id="form" action="ServletDeTraitement" method="get" class="background-form">
            <div class="form-group">
                <label for="stagiaireId">Liste des Stagiaires</label>
                <select class="form-control" id="stagiaireId" name="stagiaireId">
                    <option value="">Sélectionnez un stagiaire</option>
                    <!-- Boucle pour afficher chaque stagiaire -->
                    <c:forEach items="${stagiaires}" var="stagiaire">
                        <option value="${stagiaire.identifiant}">${stagiaire.nom} ${stagiaire.prenom}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="stageId">Liste des Stages</label>
                <select class="form-control" id="stageId" name="stageId">
                    <option value="">Sélectionnez un stage</option>
                    <!-- Boucle pour afficher chaque stage -->
                    <c:forEach items="${stages}" var="stage">
                        <option value="${stage.identifiant}">${stage.sujet}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="encadrantId">Liste des Encadrants</label>
                <select class="form-control" id="encadrantId" name="encadrantId">
                    <option value="">Sélectionnez un encadrant</option>
                    <!-- Boucle pour afficher chaque encadrant -->
                    <c:forEach items="${encadrants}" var="encadrant">
                        <option value="${encadrant.identifiant}">${encadrant.nom} ${encadrant.prenom}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="cadreId">Liste des Cadres</label>
                <select class="form-control" id="cadreId" name="cadreId">
                    <option value="">Sélectionnez un cadre</option>
                    <!-- Boucle pour afficher chaque cadre -->
                    <c:forEach items="${cadres}" var="cadre">
                        <option value="${cadre.id}">${cadre.nom} ${cadre.prenom}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
</div>
</div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
