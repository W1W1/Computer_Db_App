<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/9/2016
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Computer List</title>
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
    <title>Test</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-responsive-collapse"><span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand">Computer Database</a>
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
            <form id="company_search" class="navbar-form navbar-right" role="search" method="post">
                <div class="form-group">
                    <input id="searchMe" name="searchMe" class="form-control" placeholder="Chercher une entreprise..."
                           type="text">
                </div>
                <button type="submit" class="btn btn-default">Rechercher</button>
                <input type="hidden" name="form_use" value="search"/>
            </form>
        </div>
    </div>
</div>
<div class="container bandeau col-md-10 col-sm-12 col-md-offset-1">

    <div class="">

        <div>
            <div class="row container-fluid" id="params">
                <div class="row container-fluid">
                    <div style="text-align: center">
                        <span style="color:red;"><strong><c:out value="${searchEmpty}"/></strong></span>
                    </div>
                    <form id="page_specifications" method="post" action="listComputer">
                        <div class="item-container">
                            <div class="item"><label for="page">Numero de page : </label></div>
                            <div class="item"><input type="number" id="page" name="page"
                                                     value="<c:out value="${page}"/>"
                                                     size="30" maxlength="30"/>
                            </div>
                            <div class="item"><label for="nbElements">Nombre d'ordinateurs par page : </label></div>
                            <div class="item"><select id="nbElements" class="form-control"
                                                      name="nbElements" form="page_specifications">
                                <c:choose>
                                    <c:when test="${nbElements==10}">
                                        <option selected value="10">10</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="10">10</option>
                                    </c:otherwise>
                                </c:choose>
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

                            </select>
                            </div>
                            <div class="item"><input type="submit" class="btn-success" value="Valider"/></div>
                            <input type="hidden" name="form_use" value="pagination"/>
                        </div>
                    </form>
                </div>
            </div>


            <div class="row container-fluid">
                <c:forEach var="company" items="${companies}">
                    <div class="col-sm-12 col-md-6 ">
                        <div class="panel panel-default ">
                            <div class="panel-heading">
                            </div>
                            <div class="panel-body item-container">
                                <a href="${pageContext.request.contextPath}/getCompany?id=${company.id}">${company.name}</a>
                            </div>
                            <div class="panel-footer">
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


</body>
</html>
