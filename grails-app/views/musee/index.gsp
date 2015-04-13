
<%@ page import="museetoulouse.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="nom">
                            Nom Musée :
                        </label>
                        <g:textField name="nom"/>

                    </div>
                    <div class="fieldcontain">
                        <label for="codePostal">
                            Code Postale :
                        </label>
                        <g:select name="codePostal"
                                  from="${museetoulouse.Adresse.list().codePostal.unique()}" />
                    </div>
                    <div class="fieldcontain">
                        <label for="rue">
                            Le nom Rue :
                        </label>
                        <g:textField name="rue"/>
                    </div>
                    <div style="float: right">
                        <g:actionSubmit action="doSearchMusee" value="Rechercher" />
                    </div>
                </fieldset>

            </g:form>
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
                <g:each in="${museeInstanceList}" status="i" var="museeInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td>${fieldValue(bean: museeInstance, field: "nom")}</td>
                        <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>
                        <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "adresse")}</g:link></td>
                        <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
                        <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
                        <td>${fieldValue(bean: museeInstance, field: "horaireOuverture")}</td>
                        <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "gestionnaire")}</g:link></td>

                    </tr>
                </g:each>
                </tbody>
            </table>


            <div class="pagination">
				<g:paginate total="${museeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>