<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recherche Stagiaire</title>
    <!-- Intégration des styles Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                            <link rel="stylesheet" href="exstyle/style.css">
    
</head>
<body>
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
        <h2>Recherche d'un Stagiaire</h2></div>
        <div class="t">
        <form action="ChercherStagiaire" method="GET">
            <div class="form-group">
                <label for="idInput">ID :</label>
                <input type="text" class="form-control" id="id" name="id">
            </div>
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
        
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Identifiant</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Département</th>
                    <th>Statut</th>
                    <th>Attestation</th>
                </tr>
            </thead>
            <tbody>

<c:choose>
    <c:when test="${not empty stagiaire}">
        <!-- Affichage des détails du stagiaire -->
        <tr>
            <td>${stagiaire.identifiant}</td>
            <td>${stagiaire.nom}</td>
            <td>${stagiaire.prenom}</td>
            <td>${stagiaire.departement}</td>
            <td>${stagiaire.statut}</td>
            <td>
                <form action="generatePDF" method="get">
                    <input type="hidden" name="stageId" value="${stagiaire.identifiant}">
                    <button type="submit" class="btn btn-primary btn-sm">Imprimer attestation</button>
                </form>
            </td>
        </tr>
    </c:when>
    <c:otherwise>
        <!-- Aucun stagiaire trouvé ou stagiaire vide -->
        <tr>
            <td colspan="6">Aucun stagiaire trouvé.</td>
        </tr>
    </c:otherwise>
</c:choose>
            </tbody>
        </table>
    </div>
</div>
    <!-- Intégration du script Bootstrap (jQuery + Popper.js + Bootstrap JS) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
