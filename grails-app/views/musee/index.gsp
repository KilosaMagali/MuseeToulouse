<%@ page import="museetoulouse.MuseePrefere" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <style type="text/css" media="screen">

    #right {
        float: right;
        border: 1px solid black;
        width: 50%;
        margin-right: 0%;
    }

    #left {
        float: left;
        border: 1px solid black;
        width: 45%;
    }
    </style>
</head>
<body>

<%

    museetoulouse.MuseePrefere mesPreferes = session.getAttribute("mesPreferes")

    if(!mesPreferes) {
        mesPreferes = new MuseePrefere(idSession: session.getId())
        session["mesPreferes"] = mesPreferes

    }

%>
<div class="nav" role="navigation">
    <ul>
        <li></br>
            <h2>Votre recherche contient <u style="color: #AA0E0E">${museeInstanceCount ?: 0}</u> résultat(s)</h2></br>
            <h4><u>Vous pouvez ajouter des musées aux Favoris</u></h4></br>
            <a href="http://localhost:8080/MuseeToulouse/"><img src="../images/icon_previous.png"> Retourner à la page de recherche</a>
        </li>
        <li id="right">
            <h1 style="color: #BE5B5B" align="center"><b><u> Liste des Musées Préféres</u></b></h1>
            <table border="1px solid #BE5B5B ">
                <thead>

                <tr>
                    <th><g:message code="musee.nom.label" default="Nom Musee" /></th>
                    <th>
                        <% if(mesPreferes?.museePreferes){ %>
                        <g:form controller="museePrefere" action="removeAllFromMesPreferes">
                            <input src="../images/close.png" placeholder="DeleteAll" value="Supprimer" type="image">
                        </g:form>
                        <% }
                        %>
                    </th>
                </tr>
                <tbody>
                <%
                    if(mesPreferes?.museePreferes){
                %>
                <g:each in="${mesPreferes.museePreferes}" status="i" var="musee">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <g:form controller="museePrefere" action="removeFromMesPreferes">
                            <input type="hidden" name="nomMusee" value="${fieldValue(bean: musee, field: "nom")}" />
                            <td>${fieldValue(bean: musee, field: "nom")}</td>
                            <td><input src="../images/delete.png" value="Supprimer" type="image"></td>
                        </g:form>
                    </tr>
                </g:each>
                <% }
                else {
                %>
                <tr>
                    <td style="color: red"> La Liste est vide <img src="../images/warning.gif"></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            <div align="right" style="margin-bottom: 10px;margin-right:10px">
                <%
                    if(mesPreferes?.museePreferes){
                %>
                <g:form controller="demandeVisiteMusee" action="renderPageSaisirDemandeVisite">
                    <th><input value="Demander Visite" type="submit" style="background-color: #999999" ></th>
                </g:form>
                <% }
                else {
                %>
                <th><input value="Demander Visite" type="submit" disabled></th>
                <% } %>
            </div>
        </li>
    </ul>
</div>
<table>
    <thead>
    <tr>

        <th><g:message code="musee.nom.label" default="Nom Musee" /></th>
        <th><g:message code="musee.telephone.label" default="Téléphone" /></th>
        <th><g:message code="musee.adresse.label" default="Adresse" /></th>
        <th><g:message code="musee.accesmetro.label" default="Metro" /></th>
        <th><g:message code="musee.accesbus.label" default="Bus" /></th>
        <th><g:message code="musee.horaire.label" default="Horaires" /></th>
        <th><g:message code="musee.gestionnaire.label" default="Gestionnaire" /></th>
        <th>Add favoris</th>

    </tr>
    </thead>
    <tbody>
    <div>
        <g:each in="${museeInstanceList}" status="i" var="museeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${fieldValue(bean: museeInstance, field: "nom")}</td>
                <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>
                <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "adresse")}</g:link></td>
                <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
                <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
                <td>${fieldValue(bean: museeInstance, field: "horaireOuverture")}</td>
                <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "gestionnaire")}</g:link></td>
                <td>
                    <%  if(mesPreferes?.museePreferes) { %>
                    <g:if test="${mesPreferes.museePreferes.asList()*.nom.contains(museeInstance.nom)}">
                        <g:form controller="museePrefere" action="addToMesPreferes">
                            <input type="hidden" name="nomMusee" value="${fieldValue(bean: museeInstance, field: "nom")}" />
                            <input type="hidden" name="previousSearchList" value="${museeInstanceList}" />
                            <input src="../images/icon-disable.png" value="Ajouter" type="image" disabled>
                        </g:form>
                    </g:if>
                    <g:else>
                        <g:form controller="museePrefere" action="addToMesPreferes">
                            <input type="hidden" name="nomMusee" value="${fieldValue(bean: museeInstance, field: "nom")}" />
                            <input type="hidden" name="previousSearchList" value="${museeInstanceList}" />
                            <input src="../images/ajouter_favoris.png" value="Ajouter" type="image">
                        </g:form>
                    </g:else>
                    <% } else {%>
                    <g:form controller="museePrefere" action="addToMesPreferes">
                        <input type="hidden" name="nomMusee" value="${fieldValue(bean: museeInstance, field: "nom")}" />
                        <input type="hidden" name="previousSearchList" value="${museeInstanceList}" />
                        <input src="../images/ajouter_favoris.png" value="Ajouter" type="image">
                    </g:form>
                    <% } %>
                </td>
            </tr>
        </g:each>
    </div>

    </tbody>
</table>

<div class="pagination">
    <g:paginate  max="5" total="${museeInstanceCount ?: 0}" />
</div>
</div>

</body>
</html>