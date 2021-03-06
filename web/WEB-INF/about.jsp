<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/9/2016
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>A Propos</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

    <!-- Bootstrap Material Design -->
    <link href="css/bootswatch.nested.css" rel="stylesheet">

    <link href="css/hover.css" rel="stylesheet" media="all">

    <%--Bootstrap javascrpit plugin--%>
    <script type='text/javascript' src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type='text/javascript' src="js/bootstrap.js"></script>

    <meta charset="utf-8"/>
    <title>A Propos</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" >Computer Database</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <!--Initialisation de la variable de lien aléatoire
            De cette façon pas de problème de changement continu de lien et pas d'erreur a chaque digest-->
            <ul class="nav navbar-nav" >
                <!--Différents lien d'accès-->
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ordinateur <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/listComputer">Liste d'ordinateurs</a></li>
                        <li><a href="${pageContext.request.contextPath}/createComputer">Creer un ordinateur</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Entreprise <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/listCompany">Liste d'entreprises</a></li>
                        <li><a href="${pageContext.request.contextPath}/createCompany">Creer une entreprise</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/Apropos">A propos</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container-fluid " id="Top">
    <div class="container bandeau">
        <!--Informations sur l'entreprise-->
        <div class="col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <h3 style="text-align: center">A PROPOS</h3>
                </div>
                <div class="panel-footer"></div>
            </div>
            <div class="container col-xs-12">
                <h4>Contexte</h4>
                <p>Projet réalisé dans le cadre d'un cours de programmation JAVA/JEE</p>
                <h4>Technologies utilisées</h4>
                <ul>
                    <li>JEE</li>
                    <li>Hibernate</li>
                    <li>SaSS</li>
                </ul>
                </br></br>
                <h4>Enoncé du projet</h4>
                </br>
                <h5>Problématique</h5>
                <p>Un client vous a demandé de développer une application web pour la gestion de son parc d'ordinateur. </p>
                <p>Il vous fournit une base de données et un template sur lequel s'appuyer pour tout ce qui est graphique.</p>
                </br>
                <p>Il veut pouvoir :</p>
                <ul>
                    <li>Lister les ordinateurs</li>
                    <li>Ajouter un ordinateur</li>
                </ul>
                </br>
                <p>Les ordinateur ont un nom, une date d'entrée dans le parc de l'entreprise et une date de sortie s'ils ne sont plus présents. </p>
                <p>Ils ont aussi une compagnie, qui correspond à leur constructeur.</p>
                <p>Il vous a prévenu aussi que la base de données n'est pas consistante : il faudra dons faire attention aux données.</p>
                </br>
                <h5>Contraintes</h5>
                <ul>
                    <li>L'application que vous allez développer doit être en Java/JEE et doit utiliser les technologies correspondantes.</li>
                    <li>Vous devrez proposer une architecture n-tier et utiliser les tags JSTL dans les JSP.</li>
                    <li>Vous avez le choix pour l'accès à la BDD et pourrez utiliser soit JDBC soit Hibernate.</li>
                </ul>
                </br>
                <h5>Bonus</h5>
                <ul>
                    <p>Vous pourrez proposer des fontionnalités supplémentaires utiles dans le cadre de la problématique.</p>
                    <p>Vous pourrez aussi présenter une autre interface que celle proposée.</p>
                    <p>Si vous avez une autre idée, envoyez moi un mail à malbert@excilys.com et nous verrons ensemble si c'est une bonne idée et si vous pourrez la faire.</p>
                </ul>

            </div>
        </div>
    </div>
</div>
</div>


</body>

