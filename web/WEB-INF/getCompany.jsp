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

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${ company.name }</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

    <!-- Bootstrap Material Design -->
    <link href="css/bootswatch.nested.css" rel="stylesheet">
    <link href="../css/bootswatch.nested.css" rel="stylesheet">


    <link href="css/hover.css" rel="stylesheet" media="all">

    <%--Bootstrap javascrpit plugin--%>
    <script type='text/javascript' src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type='text/javascript' src="js/bootstrap.js"></script>
    <script type='text/javascript' src="../js/bootstrap.js"></script>

    <meta charset="utf-8"/>
    <title>Company</title>
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
            <ul class="nav navbar-nav">
                <!--Différents lien d'accès-->
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ordinateur
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/listComputer">Liste d'ordinateurs</a></li>
                        <li><a href="${pageContext.request.contextPath}/createComputer">Creer un ordinateur</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Entreprise
                        <span class="caret"></span></a>
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
        <div class="row">
            <div class="col-sm-12">
                <%--<div>--%>
                <%--${ computer.name } ${ computer.company.name }--%>
                <%--</div>--%>
                <div class="panel-heading">
                    <div class="item-container">
                        <c:choose>
                            <c:when test="${id>1}">
                                <a class="item" href="${pageContext.request.contextPath}/getCompany?id=${id-1}"><h1>&larr;</h1></a>
                            </c:when>
                            <c:otherwise>
                                <a class="item"></a>
                            </c:otherwise>
                        </c:choose>
                        <h1 class="item">${company.name} </h1>
                        <a class="item" href="${pageContext.request.contextPath}/getCompany?id=${id+1}"><h1>&rarr;</h1></a>
                    </div>
                </div>

                <c:forEach var="computer" items="${computers}">
                    <div class="col-sm-12 col-md-6 ">
                        <div class="panel panel-default ">
                            <div class="panel-heading">
                                <div class="item-container">
                                    <a href="${pageContext.request.contextPath}/getComputer?id=${ computer.id }"
                                       class="item">${ computer.name }</a>
                                </div>
                            </div>

                            <!--Separator pour que les deux items soient écartés d'un certain espacement-->
                            <div class="separator-taille-poids"></div>

                            <a class="item-container"
                               href="${pageContext.request.contextPath}/getCompany?id=${ computer.company.id }">
                                <div class="item">Company :</div>
                                <div class="item">${ computer.company.name }</div>
                            </a>
                            <div class="item-container">
                                <div class="item">Entré le :</div>
                                <div class="item">
                                        ${ computer.introduced }
                                </div>
                            </div>
                            <div class="item-container">
                                <div class="item">Sortie le :</div>
                                <div class="item">${computer.discontinued }
                                </div>
                            </div>
                            <div class="panel-footer">

                            </div>
                        </div>
                    </div>
                </c:forEach>
                <%--<div class ="row container-fluid">--%>
                <%--<c:forEach var="computer" items="${computers}">--%>
                <%--<a href="${pageContext.request.contextPath}/getComputer?id=${computer.id}"--%>
                <%--class="pokeliste container col-sm-4 col-xs-8 col-sm-offset-0 col-xs-offset-2 slide">--%>
                <%--<!--Utilisation du filtre custom pour récupérer les pokemons voulus dans l'ordre voulu-->--%>
                <%--<div class="separator"></div>--%>
                <%--<div class="img-circle-container hvr-bob hvr-float-shadow">--%>
                <%--</div>--%>
                <%--<!--Nom et numéro du pokemon-->--%>
                <%--<h4><c:out value="${computer.name}"/></h4>--%>
                <%--<!--Types-->--%>
                <%--<div class="flex-container">--%>
                <%--<div class="flex-item type">--%>
                <%--<c:out value="${computer.introduced}"/>--%>
                <%--</div>--%>
                <%--<div class="flex-item type">--%>
                <%--<c:out value="${computer.discontinued}"/>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</a>--%>
                <%--</c:forEach>--%>
                <%--</div>--%>
            </div>
        </div>

    </div>
</div>
</div>


</body>
