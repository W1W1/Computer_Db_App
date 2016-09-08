
<%@ page import="Util.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/8/2016
  Time: 12:09 PM
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
    <title>Company</title>
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
            <div class="row">
                <div class="col-sm-12">
                    <%--<div>--%>
                    <%--${ computer.name } ${ computer.company.name }--%>
                    <%--</div>--%>
                    <div class="informations-pokemon ">

                        <div class="flex-container">
                            <div class="flex-item enonce">Name :</div>
                            <div class="flex-item donnee">${ company.name }</div>
                        </div>
                    </div>
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
    </div>
</div>


</body>
