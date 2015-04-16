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
            println ("Allocation!")
            mesPreferes = new MuseePrefere(idSession: session.getId())
            session["mesPreferes"] = mesPreferes

    }

        %>
    <a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li id="left">
                <g:form controller="musee" action="doSearchMusee">
                    <h1> Rechercher un musée</h1>
                <fieldset class="form">
                            Nom Musée :
                        <g:textField name="nom" placeholder=" Entrer nom"/><br><br>
                            Code Postale :
                        <g:select name="codePostal"
                                  from="${museetoulouse.Adresse.list().codePostal.unique()}"/><br><br>
                            Le nom Rue :
                        <g:textField name="rue" placeholder=" Entrer rue"/><br><br>
                        <div style="float:right"><input value="Rechercher" type="submit"></div>
                </fieldset>
            </g:form>
            </li>
            <li id="right">
                <h1> Mes Musées Préférés</h1>
                <table>
                    <thead>

                    <tr>
                        <th><g:message code="musee.nom.label" default="Nom Musee" /></th>
                        <%
                            if(mesPreferes?.museePreferes){
                        %>
                        <g:form controller="demandeVisiteMusee" action="renderPageSaisirDemandeVisite">
                            <th><input value="Demander Visite" type="submit" ></th>
                        </g:form>
                        <g:form controller="museePrefere" action="removeAllFromMesPreferes">
                            <th><input value="Vider" type="submit" ></th>
                        </g:form>
                        <% }
                        else {
                        %>
                            <th><input value="Demander Visite" type="submit" disabled></th>
                        <% } %>


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
                                <td><input value="Supprimer" type="submit"></td>
                            </g:form>
                            </tr>
                        </g:each>
                <% }
                    else {
                %>
                <tr>
                    <td> La Liste vide!!</td>
                </tr>
                <%
                    }
                %>
                    </tbody>
                </table>
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
                                <input value="Ajouter" type="submit" disabled>
                            </g:form>
                            </g:if>
                            <g:else>
                                <g:form controller="museePrefere" action="addToMesPreferes">
                                    <input type="hidden" name="nomMusee" value="${fieldValue(bean: museeInstance, field: "nom")}" />
                                    <input type="hidden" name="previousSearchList" value="${museeInstanceList}" />
                                    <input value="Ajouter" type="submit">
                                </g:form>
                            </g:else>
                            <% } else {%>
                            <g:form controller="museePrefere" action="addToMesPreferes">
                                <input type="hidden" name="nomMusee" value="${fieldValue(bean: museeInstance, field: "nom")}" />
                                <input type="hidden" name="previousSearchList" value="${museeInstanceList}" />
                                <input value="Ajouter" type="submit">
                            </g:form>
                            <% } %>
                        </td>
                    </tr>
                </g:each>
                </div>

                </tbody>
            </table>

           <div class="pagination">
				<g:paginate  total="${museeInstanceCount ?: 0}" />
			</div>
		</div>

	</body>
</html>
