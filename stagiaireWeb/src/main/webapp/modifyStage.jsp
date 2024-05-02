<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier le stage</title>
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
    
    <h2>Modifier le stage</h2></div>
    <div class="t">
        <h2>Stage ID = ${stage.identifiant}</h2>
        
        
        <form action="MStageServlet" method="get">
            <input type="hidden" name="stageId" value="${stage.identifiant}">
            
            <div class="form-group">
                <label for="sujet">Sujet:</label>
                <input type="text" class="form-control" id="sujet" name="sujet" value="${stage.sujet}">
            </div>
            
            <div class="form-group">
                <label for="dateDebut">Date de début:</label>
                <input type="text" class="form-control" id="dateDebut" name="dateDebut" value="${stage.date_debut}">
            </div>
            
            <div class="form-group">
                <label for="dateFin">Date de fin:</label>
                <input type="text" class="form-control" id="dateFin" name="dateFin" value="${stage.date_fin}">
            </div>
            
            <div class="form-group">
                <label for="departement">Département:</label>
                <input type="text" class="form-control" id="departement" name="departement" value="${stage.departement}">
            </div>
            
            <div class="form-group">
                <label for="typestage">Type de stage:</label>
                <input type="text" class="form-control" id="typestage" name="typestage" value="${stage.typestage}">
            </div>
            
            <div class="form-group">
                <label for="statut">Statut:</label>
                <input type="text" class="form-control" id="statut" name="statut" value="${stage.statut}">
            </div>
            
            <div class="form-group">
                <label for="cadre">Cadre:</label>
                <input type="text" class="form-control" id="cadre" name="cadre" value="${stage.cadre.nom}">
            </div>
            
            <!-- Ajoutez les autres champs ici -->
            
            <button type="submit" class="btn btn-primary">Modifier le stage</button>
        </form></div>
    </div>

    <!-- Bootstrap JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
