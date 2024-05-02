<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tableau de bord de Gestion des Stagiaires</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                    <a href="accueil_admin.jsp">Accueil</a>
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
            
            <li>
                    <a href="a_propos.jsp">À Propos de Nous</a>
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
    <p>En tant que Administrateur DRH de cette application, vous détenez un ensemble puissant de responsabilités pour faciliter la gestion efficace des ressources humaines. Vous avez la possibilité de vous authentifier en toute sécurité, assurant ainsi l'accès privilégié à des fonctionnalités essentielles. La gestion des comptes utilisateurs est simplifiée, vous permettant de superviser et de réguler les autorisations avec précision. Vous pouvez gérer les stagiaires et les stages/encadrants, les répertoriant, les recherchant et marquant leurs absences au besoin. De plus, vous avez la capacité d'imprimer des attestations importantes et d'envoyer des emails pour une communication rapide et efficace. Enfin, l'affichage des statistiques vous donne une vue d'ensemble claire pour évaluer et améliorer les processus internes de manière éclairée.</p></div>
<!--  <div class="ALL">-->
    <div class="row justify-content-center">

        <!-- Gérer les Stages -->
        <div class="col-md-3">
            <a href="manageStagesAdmin" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Stages</h5>
                    <p class="card-text">Gérez et modifiez les informations des Stages.</p>
                </div>
            </a>
        </div>

      

        <!-- Gérer les Stagiaires -->
        <div class="col-md-3">
            <a href="gestionStagiaireAdmin" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Gérer les Stagiaires</h5>
                    <p class="card-text">Gérez et modifiez les informations des Stagiaires.</p>
                </div>
            </a>
        </div>

        <!-- Visualiser les Statistiques -->
        <div class="col-md-3">
            <a href="StatistiquesServletAdmin" class="card mb-4">
                <div class="card-body text-center">
                    <h5 class="card-title">Visualiser les Statistiques</h5>
                    <p class="card-text">Analysez et visualisez les données statistiques des Stagiaires et des Stages.</p>
                </div>
            </a>
        </div>

    </div>

  
</div>
<!-- Include Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>