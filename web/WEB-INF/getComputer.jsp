<%@ page import="Util.Computer" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Richard-DT
  Date: 08/09/2016
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${ computer.name }</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

    <!-- Bootstrap Material Design -->
    <link href="css/bootstrap.css" rel="stylesheet">


    <link href="css/pokemon.css" rel="stylesheet">
    <link href="css/custom-nav.css" rel="stylesheet">
    <link href="css/hover.css" rel="stylesheet" media="all">

    <%--Bootstrap javascrpit plugin--%>
    <script type='text/javascript' src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type='text/javascript' src="js/bootstrap.js"></script>

    <meta charset="utf-8"/>
    <title>Test</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-responsive-collapse"><span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand">Computer Database</a>
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
<div class="container-fluid main" id="Top">
    <div class="container cadre">
        <div id="Pokemon">
            <ul class="pager">
                <!--Bouton d'accès rapide aux pokemons suivants, précédents et nom du pokemon courant-->
                <li class="{{pokemonCtrl.classPrevious}}"><a href="${pageContext.request.contextPath}/getComputer?id=${computer.id-1}">&lsaquo;</a></li>
                <li class="title-container"><h1>Information de l'ordinateur </h1></li>
                <li class="{{pokemonCtrl.classNext}}"><a href="${pageContext.request.contextPath}/getComputer?id=${computer.id+1}">&rsaquo;</a></li>
            </ul>
            <!--Image, description du pokemon, taille, poids et types-->
            <div class="row">
                <div class="col-sm-12">
                    <div class="informations-pokemon ">
                        <div class="flex-container">
                            <div class="flex-item enonce">Nom :</div>
                            <div class="flex-item donnee">${ computer.name }</div>
                        </div>
                        <!--Separator pour que les deux items soient écartés d'un certain espacement-->
                        <div class="separator-taille-poids"></div>

                        <a class="flex-container" href="${pageContext.request.contextPath}/getCompany?id=${ computer.company.id }">
                            <div class="flex-item enonce">Company :</div>
                            <div class="flex-item donnee">${ computer.company.name }</div>
                        </a>
                        <div class="flex-container">
                            <div class="flex-item enonce">Entré le :</div>
                            <div class="flex-item donnee">
                                ${ computer.introduced }
                            </div>
                        </div>
                        <div class="flex-container">
                            <div class="flex-item enonce">Sortie le :</div>
                            <div class="flex-item donnee">
                                ${ computer.discontinued }
                            </div>
                        </div>


                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
