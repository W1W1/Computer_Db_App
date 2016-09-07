<%@ page import="Util.Computer" %><%--
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

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Pokédex</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

    <!-- Bootstrap Material Design -->
    <link href="css/bootstrap.css" rel="stylesheet">


    <link href="css/pokemon.css" rel="stylesheet">
    <link href="css/custom-nav.css" rel="stylesheet">
    <link href="css/hover.css" rel="stylesheet" media="all">

    <meta charset="utf-8"/>
    <title>Test</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" >Projet Des Enfer</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <!--Initialisation de la variable de lien aléatoire
            De cette façon pas de problème de changement continu de lien et pas d'erreur a chaque digest-->
            <ul class="nav navbar-nav" >
                <!--Différents lien d'accès-->
                <li><a >Ordinateur</a></li>
                <li><a >Entreprise</a></li>
                <li><a >A propos</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <!--Différents lien d'accès aux ancrages-->
                <li><a >Listing</a></li>
                <li><a >Ajout</a></li>
                <li><a >Suppression</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container-fluid main" id="Top">
    <div class="container cadre" >
        <div id = "Pokemon">
            <!--Image, description du pokemon, taille, poids et types-->
            <div class="row">
                <div class="col-sm-12">
                    <%--<div>--%>
                        <%--pzpepcv--%>
                        <%--<%--%>
                            <%--String attribut = ((Computer) request.getAttribute("computer")).toString();--%>
                            <%--out.println(attribut);--%>
                        <%--%>--%>
                    <%--</div>--%>
                    <div class="informations-pokemon flex-container  slideanim">
                        <div class="flex-container">
                            <div class="flex-item enonce">Nom :</div>
                            <div class="flex-item donnee">${ computer.name }</div>
                        </div>
                        <!--Separator pour que les deux items soient écartés d'un certain espacement-->
                        <div class="separator-taille-poids"></div>

                        <div class="flex-container">
                            <div class="flex-item enonce">Company :</div>
                            <div class="flex-item donnee">${ computer.company.name }</div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
