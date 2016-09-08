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

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Computer Creation</title>
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
            <!--Informations sur l'entreprise-->
            <div class="row">
                <div class="col-sm-12">
                    <form method="post" action="createCompany" id="computer_input">

                        <label for="computerName">Nom de l'ordinateur :  </label>
                        <input type="text" id="computerName" name="computerName" value="" size="20" maxlength="20"/>
                        <br />

                        <label for="companyName">Nom de l'entreprise :  </label>

                        <%--TODO: make list dynamic, get company list, input here--%>
                        <select id="companyName" name="companyName" form="computer_input">
                            <option value="1">Apple Inc.</option>
                            <option value="2">Thinking Machines</option>
                            <option value="3">RCA</option>
                            <option value="4">Netronics</option>
                        </select>
                        <br />

                        <label for="introduced">Date d'entree :  </label>
                        <input type="date" id="introduced" name="introduced" value="" size="20" maxlength="20"/>
                        <br />

                        <label for="discontinued">Date de sortie :  </label>
                        <input type="date" id="discontinued" name="discontinued" value="" size="20" maxlength="20"/>
                        <br />



                        <input type="submit" value="Valider" class="button"  />
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>


</body>

