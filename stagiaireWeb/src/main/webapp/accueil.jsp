<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion de Stagiaires</title>
    <!-- Ajout de Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="exstyle/style.css">
    <!-- Ajout de styles personnalisés -->
    
</head>
<body>
    <header>
        <nav>
            <a href="accueil.jsp">
                <img src="images/logo.png" alt="" class="logo">
            </a>
            <ul>
                <li>
                    <a href="accueil.jsp">Accueil</a>
                </li>
                <li>
                    <a href="a_propos.jsp">À Propos de Nous</a>
                </li>
                <li>
                    <a href="nous_contacter.jsp">Nous Contacter</a>
                </li>
                <li>
                    <a href="inscription.jsp">Inscription</a>
                </li>
                <li>
                    <a href="index.jsp">Have an account ?Login</a>
                </li>
            </ul>
            <!--    <img src ="images/17973908.jpg" alt=""> -->
            <div class="overlay"></div>
        </nav>
    </header>

   <section class="text">
        <h1>Ellipse - <span class="auto-typing"></span> </h1>
   	<p>Ellipse est une plateforme sophistiquée de gestion des stagiaires conçue pour simplifier et optimiser le processus d'inscription, de suivi et de gestion des stages au sein de votre organisation. Avec une interface conviviale et sécurisée, Ellipse offre une expérience fluide pour les administrateurs DRH et les Chefs de la DRH, leur permettant de gérer avec précision les informations des stagiaires, de suivre les stages en cours et de conserver un historique détaillé des stages passés.

Cette application polyvalente permet aux utilisateurs d'accéder à des fonctionnalités robustes, notamment la création de profils de stagiaires, l'inscription en ligne, la gestion des autorisations d'accès en fonction des rôles, ainsi que la documentation complète des détails des stages, y compris les informations sur les encadrants, les dates de début et de fin, et bien plus encore.

Avec Ellipse, simplifiez votre processus de gestion des stagiaires, gagnez en efficacité et en précision dans la gestion des stages, tout en conservant un suivi complet des activités passées. Rejoignez-nous dès aujourd'hui pour une gestion des stages sans effort et une expérience utilisateur optimale</p>
   </section>
<!-- Ajout de Bootstrap JS et Popper.js (requis pour le fonctionnement du navbar) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
 <script>
        let types = new Typed('.auto-typing', {
            strings: ['Gestion intelligente des Stagiaires','Innover par la supervision des stages'],
            typeSpeed: 100,
            backSpeed: 100,
            loop: true,
            fadeOut: true,
            fadeOutClass: 'typed-fade-out',
            fadeOutDelay: 500
        });

</script>
</body>
</html>