<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Util.Computer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Richard-DT
  Date: 07/09/2016
  Time: 21:18
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
<div class="container-fluid main" >
    <!--Utilisation du Infinite Scroll pour limiter les chargements d'image
    distance mise à 0.5 pour mettre en exergue la fonctionalité,
    sa valeur en production serait de 2 pour qu'on ne touche jamais le bas de la page-->
    <div class="container cadre" >
        <div>
            <!--Paramètre de filtre et recherche avancés-->
            <div class="row container-fluid recherche-avance">
                <div class ="row container-fluid">
                    <button id="hideBtn" >Paramètres avancés</button>
                </div>
                <div class="row container-fluid" ng-show="main.click">
                    <div class="row">
                        <img class="btn-close" />
                    </div>
                    <!--Ajout de ng-class pour lier l'ordre à la flèche allant vers le haut ou le bas
                    Utilisation de ng-click-->
                    <div class="row container col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-3 param-recherche"><span class="tri"> Trier par :   </span>
                        <a class="btn btn-default param-button" ng-click="main.setParams('id')">Numéro</a>
                        <span ng-show="main.Params === 'id'" ng-class="main.reverse==false? 'glyphicon glyphicon-arrow-up':'glyphicon glyphicon-arrow-down'"></span>
                        <a class="btn btn-default param-button" ng-click="main.setParams('taille')">Taille</a>
                        <span ng-show="main.Params === 'taille'" ng-class="main.reverse==false? 'glyphicon glyphicon-arrow-up':'glyphicon glyphicon-arrow-down'"></span>
                        <a class="btn btn-default param-button" ng-click="main.setParams('poids')">Poids</a>
                        <span ng-show="main.Params === 'poids'" ng-class="main.reverse==false? 'glyphicon glyphicon-arrow-up':'glyphicon glyphicon-arrow-down'"></span>
                        <a class="btn btn-default param-button" ng-click="main.setParams('nom')">Alphabétique</a>
                        <span ng-show="main.Params === 'nom'" ng-class="main.reverse==false? 'glyphicon glyphicon-arrow-up':'glyphicon glyphicon-arrow-down'"></span>
                    </div>
                </div>
            </div>
            <!--Affichage des Pokemon-->
            <div class ="row container-fluid">
                <c:forEach var="computer" items="${computers}">
                    <a href="${pageContext.request.contextPath}/getComputer?id=${computer.id}"
                       class="pokeliste container col-sm-4 col-xs-8 col-sm-offset-0 col-xs-offset-2 slide">
                        <!--Utilisation du filtre custom pour récupérer les pokemons voulus dans l'ordre voulu-->
                        <div class="separator"></div>
                        <div class="img-circle-container hvr-bob hvr-float-shadow">
                        </div>
                        <!--Nom et numéro du pokemon-->
                        <h4><c:out value="${computer.name}"/></h4>
                        <!--Types-->
                        <div class="flex-container">
                            <div class="flex-item type">
                                <c:out value="${computer.introduced}"/>
                            </div>
                            <div class="flex-item type">
                                <c:out value="${computer.discontinued}"/>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


</body>
</html>
