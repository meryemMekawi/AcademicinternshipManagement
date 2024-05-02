<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajout de Stage</title>
    <!-- Liens CSS Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
        <h2 class="mb-4">Ajout de Stage</h2></div>
        <div class="t">
        <form action="AjoutStageServlet" method="GET">
             <div class="mb-3">
                <label for="sujet" class="form-label">Sujet :</label>
                <select class="form-select" id="sujet" name="sujet" required>
                    <option value="">Sélectionnez un sujet</option>
                    <optgroup label="Informatique">
                        <option value="Dev">Développement Web</option>
                        <option value="AnalyseData">Analyse de Données</option>
                        <option value="Securite">Sécurité Informatique</option>
                    </optgroup>
                    <optgroup label="Comptabilité">
                        <option value="Audit">Audit et Contrôle</option>
                        <option value="Finance ">Finance d'Entreprise</option>
                        <option value="Comptable">Gestion Comptable</option>
                    </optgroup>
                    <optgroup label="Électrique">
                        <option value="Energie ">Énergie Renouvelable</option>
                        <option value=" SysElectriques">Systèmes Électriques</option>
                        <option value="Electronique">Électronique</option>
                    </optgroup>
                </select>
            </div>
            <div class="mb-3">
                <label for="dateDebut" class="form-label">Date de début :</label>
                <input type="date" class="form-control" id="dateDebut" name="dateDebut" required>
            </div>

            <div class="mb-3">
                <label for="dateFin" class="form-label">Date de fin :</label>
                <input type="date" class="form-control" id="dateFin" name="dateFin" required>
                
            </div>

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
                <label for="typestage" class="form-label">Type de stage :</label>
                <select id="typestage" name="typestage" class="form-select" aria-label="Sélectionner votre type de stage " required>
        <option selected disabled value="">Sélectionner le type de stage</option>
        <option value="pfa">Stage de fin d'année</option>
        <option value="pfe">Stage de fin d'étude</option>
        </select>
            </div>

            <div class="mb-3">
                <input type="hidden"  id="statut" name="statut" value="Non Affecte" required>
            </div>

            <input type="hidden" id="cadre" name="cadre" value="null">
            <input type="hidden" id="stagiaires" name="stagiaires" value="null">

            <!-- Ajoutez ici d'autres champs de formulaire nécessaires pour le stage -->

            <button type="submit" class="btn btn-primary">Ajouter le Stage</button>
        </form>
        </div>

    <!-- Scripts Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
