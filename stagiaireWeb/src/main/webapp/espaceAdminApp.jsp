<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Tableau de bord de Gestion des Comptes</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="exstyle/style.css">
    
   
</head>
<body>
<nav class="navbar navbar-expand-lg custom-navbar">
    <a href="espaceAdminApp.jsp">
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
                    <a href="espaceAdminApp.jsp">Accueil</a>
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
                    <a href="accueil.jsp">Log Out </a>
                </li>
        </ul>
    </div>
</nav>



     <div class="bonjour">
    <p>Bienvenue, <%= session.getAttribute("nom")%></p></div>
    <div class="lead">
    <!-- Introduction Paragraph -->
    <p class="lead">Bienvenue sur le tableau de bord de gestion des Comptes. Vous pouvez accéder aux fonctionnalités principales à partir des liens ci-dessous :</p>
</div>
<div class="ALL">

    <!-- Centered Quick Links using Bootstrap Grid System -->
    <div class="row justify-content-center">
        <!-- Gérer les Stages -->
        <div class="col-md-3">
            <a href="gestionComptes" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Comptes</h5>
                    <p class="card-text">Gérez et modifiez les informations des Comptes.</p>
                </div>
            </a>
        </div>

        <!-- Gérer les Encadrants -->
        <div class="col-md-3">
            <a href="gestionEncadrants" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Encadrants</h5>
                    <p class="card-text">Gérez et modifiez les informations des Encadrants.</p>
                </div>
            </a>
        </div>

    <!-- Gérer les Stages -->
        <div class="col-md-3">
            <a href="manageStagesServlet" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Stages</h5>
                    <p class="card-text">Gérez et modifiez les informations des Encadrants.</p>
                </div>
            </a>
        </div>
        <!-- Gérer les Stagiaires -->
        <div class="col-md-3">
            <a href="gestionStagiaire" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Stagiaires</h5>
                    <p class="card-text">Gérez et modifiez les informations des Stagiaires.</p>
                </div>
            </a>
        </div>

        <!-- Visualiser les Statistiques -->
        <div class="col-md-3">
            <a href="StatistiquesServlet" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Visualiser les Statistiques</h5>
                    <p class="card-text">Analysez et visualisez les données statistiques des Stagiaires et des Stages.</p>
                </div>
            </a>
        </div>
    </div>

    <!-- Logout Button -->
    <div class="text-center">
        <form action="logoutServlet" method="post">
            <button type="submit" class="btn btn-danger btn-logout">Déconnexion</button>
        </form>
    </div>
    </div>

<!-- Include Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
