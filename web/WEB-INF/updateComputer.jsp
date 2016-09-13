<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/13/2016
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Computer Creation</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

    <!-- Bootstrap Material Design -->
    <!--<link href="css/bootswatch.nested.css" rel="stylesheet">-->
    <link href="../css/bootswatch.nested.css" rel="stylesheet">
    <link href="css/bootswatch.nested.css" rel="stylesheet">


    <link href="css/hover.css" rel="stylesheet" media="all">

    <%--Bootstrap javascrpit plugin--%>
    <script type='text/javascript' src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type='text/javascript' src="../js/bootstrap.js"></script>
    <script type='text/javascript' src="js/bootstrap.js"></script>
    <script type='text/javascript' src="js/inputVerification.js"></script>
    <script type='text/javascript' src="../js/inputVerification.js"></script>
    <!--<script type='text/javascript' src="js/bootstrap.js"></script>-->

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
<div class="container-fluid" id="Top">
    <div class="container bandeau">
        <div id="Pokemon">
            <!--Informations sur l'entreprise-->
            <div class="col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">

                    </div>
                    <div class="panel-body">
                        <form method="post" action="createComputer" id="computer_input">
                            <div class="form-group item-container ">
                                <div class="item"><label for="computerName">Nom de l'ordinateur : </label></div>
                                <div class="item"><input id="computerName" type="text" onkeypress="verfyText(this)"
                                                         class="form-control" name="computerName" value="<c:out value="${computer.name}"/>"
                                                         size="20" maxlength="20"/></div>
                            </div>

                            <div class="item-container form-group">
                                <div class="item"><label for="companyName">Nom de l'entreprise : </label></div>
                                <div class="item"><select id="companyName" class="form-control"
                                                          name="companyName" form="computer_input">
                                    <c:forEach var="company" items="${companies}">
                                        <c:choose>
                                            <c:when test="${company.id==computer.company.id}">
                                                <option selected value="<c:out value=" ${company.id}"/>"><c:out value="${company.name}"/></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value=" ${company.id}"/>"><c:out value="${company.name}"/></option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                </div>
                            </div>

                            <div class="form-group item-container ">
                                <div class="item"><label  for="introduced">Date d'entree : </label></div>
                                <div class="item"><input class="form-control" type="date" id="introduced"
                                                         name="introduced" onkeyup="VerifyDate(this)"
                                                         value="<c:out value="${computer.introduced}"/>" size="20"
                                                         maxlength="20"/></div>
                            </div>
                            <div class="form-group item-container">
                                <div class="item"><label for="discontinued">Date de sortie : </label></div>
                                <div class="item"><input class="form-control" type="date" id="discontinued"
                                                         name="discontinued" onkeyup="VerifyDate(this)"
                                                         value="<c:out value="${computer.discontinued}"/>" size="20"
                                                         maxlength="20"/></div>
                            </div>
                            <div class="item-container">
                                <div class="item"><input type="submit" value="Mettre a jour" onsubmit="verifyAll()" class="btn-success"/></div>
                            </div>
                            <input type="hidden" name="form_use" value="update"/>
                        </form>
                        <form id="computerDelete">
                            <div class="item-container">
                                <div class="item"><input type="submit" value="Supprimer"
                                                         onsubmit="confirmDelete()" class="btn-success"/></div>
                            </div>
                            <input type="hidden" name="form_use" value="delete"/>
                        </form>

                    </div>
                    <div class="panel-footer">

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>