<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
Created by IntelliJ IDEA.
User: Alex
Date: 9/8/2016
Time: 8:52 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
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
                            <div class="form-group item-container has-error">
                                <div class="item"><label for="computerName">Nom de l'ordinateur : </label></div>
                                <div class="item"><input type="text" id="computerName" name="computerName" value=""
                                                         size="20"
                                                         maxlength="20"/></div>
                            </div>

                            <div class="item-container form-group has-error">
                                <div class="item"><label for="companyName">Nom de l'entreprise : </label></div>
                                <div class="item"><select id="companyName" name="companyName" form="computer_input">
                                    <c:forEach var="company" items="${companies}">
                                        <option value="<c:out value=" ${company.id}
                                        "/>">
                                        <c:out
                                                value="${company.name}"/>
                                        </option>
                                    </c:forEach>
                                    <%--
                                    <option value="1">Apple Inc.</option>
                                    --%>
                                    <%--
                                    <option value="2">Thinking Machines</option>
                                    --%>
                                    <%--
                                    <option value="3">RCA</option>
                                    --%>
                                    <%--
                                    <option value="4">Netronics</option>
                                    --%>

                                </select>
                                </div>
                            </div>
                            <div class="form-group item-container has-error">
                                <div class="item"><label  for="introduced">Date d'entree : </label></div>
                                <div class="item"><input  type="date" id="introduced"
                                                         name="introduced" value="" size="20"
                                                         maxlength="20"/></div>
                            </div>
                            <div class="item-container">
                                <div class="item"><label for="discontinued">Date de sortie : </label></div>
                                <div class="item"><input class="has-error" type="date" id="discontinued"
                                                         name="discontinued" value="" size="20"
                                                         maxlength="20"/></div>
                            </div>
                            <div class="item-container">
                                <div class="item"><input type="submit" value="Valider" class="btn-success"/></div>
                            </div>
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

