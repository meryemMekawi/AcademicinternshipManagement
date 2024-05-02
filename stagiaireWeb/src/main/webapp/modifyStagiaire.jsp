<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier le stagiaire</title>
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
        <h2>Modifier le stagiaire</h2></div>
        <div class="t">
        <h2>Stagiaire ID = ${stagiaire.identifiant}</h2>
        
        <form action="MStagiaireServlet" method="post" >
            <input type="hidden" name="stagiaireId" value="${stagiaire.identifiant}">
            
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" value="${stagiaire.nom}">
            </div>
            
            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="${stagiaire.prenom}">
            </div>
            
            <div class="form-group">
                <label for="cin">CIN:</label>
                <input type="text" class="form-control" id="cin" name="cin" value="${stagiaire.cin}">
            </div>
            
            <div class="form-group">
                <label for="etablissement">Etablissement:</label>
                <input type="text" class="form-control" id="etablissement" name="etablissement" value="${stagiaire.etablissement}">
            </div>
            
            <div class="form-group">
                <label for="filiere">Filière:</label>
                <input type="text" class="form-control" id="filiere" name="filiere" value="${stagiaire.filiere}">
            </div>
            
            <div class="form-group">
                <label for="adresse">Adresse:</label>
                <input type="text" class="form-control" id="adresse" name="adresse" value="${stagiaire.adresse}">
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${stagiaire.email}">
            </div>
            
            <div class="form-group">
                <label for="dateNaissance">Date de naissance:</label>
                <input type="text" class="form-control" id="dateNaissance" name="dateNaissance" value="${stagiaire.dateNaissance}">
            </div>
            
            <div class="form-group">
                <label for="numTelephone">Numéro de téléphone:</label>
                <input type="text" class="form-control" id="numTelephone" name="numTelephone" value="${stagiaire.numTelephone}">
            </div>
            
            <div class="form-group">
                <label for="statut">Statut:</label>
                <input type="text" class="form-control" id="statut" name="statut" value="${stagiaire.statut}">
            </div>
            
            <div class="form-group">
                <label for="departement">Département:</label>
                <input type="text" class="form-control" id="departement" name="departement" value="${stagiaire.departement}">
            </div>
            
            <!-- Ajoutez les autres champs ici -->
            
            <button type="submit" class="btn btn-primary">Modifier le stagiaire</button>
        </form>
    </div>

    <!-- Bootstrap JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
