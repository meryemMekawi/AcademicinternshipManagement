<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Page de Login</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.20.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="exstyle/style.css">
   
</head>
<body>
    <header>
       <nav>
	<a href="accueil.jsp" >
		<img src="images/logo.png" alt="" class="logo">
	</a>
            <ul>
                <li >
                    <a href="accueil.jsp">Accueil</a>
                </li>
                <li >
                    <a href="a_propos.jsp">À Propos de Nous</a>
                </li>
                <li>
                    <a href="nous_contacter.jsp">Nous Contacter</a>
                </li>
                <li>
                    <a href="inscription.jsp">Inscription</a>
                </li>
                <li>
                    <a href="index.jsp">Have an accout ?<b>Login</b></a>
                </li>
            </ul>
        <!--    <img src ="images/17973908.jpg" alt=""> --> 
    
        <!--    <img src ="images/17973908.jpg" alt=""> --> 
       
        <div class="overlay"></div>
        
        </nav>
    </header> 

   <div class="wrapper">
        <div class="text">
            <!-- Votre texte ici -->
        </div>

        <div class="row justify-content-center align-items-center min-vh-100">
                <div class="card rounded background-form">
                        <h1 class="card-title text-center mb-4">Connectez-vous <i class="bi bi-person-fill"></i></h1>

                        <form action="LoginServlet" method="post">
                            <div class="iput-box mb-3">
                                <label for="username" class="form-label">Nom d'utilisateur <i class="bi bi-person"></i>:</label>
                                <input type="text" id="username" name="username" class="form-control" required>
                            </div>

                            <div class="iput-box mb-3">
                                <label for="password" class="form-label">Mot de passe <i class="bi bi-lock"></i>:</label>
                                <input type="password" id="password" name="password" class="form-control" required>
                            </div>

                            <div class="remember-forgot mb-3">
                                <input type="checkbox" id="rememberMe" name="rememberMe" class="form-check-input">
                                <label for="rememberMe" class="form-check-label">Se souvenir de moi</label>
                            </div>

                            <div class="text-center mt-3">
                                <button type="submit" class="btn btn-black btn-block">Se connecter</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>