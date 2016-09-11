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
    <title>Computer List</title>
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
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand" >Computer Database</a>
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
                    <form id="page_specifications" method="post" action="listComputer">
                        <label for="page">Numero de page :  </label>
                        <input type="number" id="page" name="page" value="<c:out value="${page}"/>" size="30" maxlength="30" />
                        <br />

                        <label for="nbElements">Nombre d'ordinateurs par page :  </label>
                        <select id="nbElements" name="nbElements" form="page_specifications">

                            <c:choose>
                                <c:when test="${nbElements==25}">
                                    <option selected value="25">25</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="25">25</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${nbElements==50}">
                                    <option selected value="50">50</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="50">50</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${nbElements==100}">
                                    <option selected value="100">100</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="100">100</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${nbElements==500}">
                                    <option selected value="500">500</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="500">500</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                        <br />
                        <input type="submit" value="Valider"  />
                    </form>
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