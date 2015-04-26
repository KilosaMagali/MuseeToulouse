
<%@ page import="museetoulouse.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <style type="text/css" media="screen">
        #index{
        margin-left: 20%;
        border: 1px solid crimson;
        width: 60%;
        }
        </style>

    </head>
	<body>
    <h1 align="center" style="color: brown"><u>Votre Demande</u></h1></br>
        <table>
            <thead>
            <tr>

                <g:sortableColumn property="code" title="${message(code: 'demandeVisite.code.label', default: 'Code')}" />

                <g:sortableColumn property="dateDebutPeriode" title="${message(code: 'demandeVisite.dateDebutPeriode.label', default: 'Date Debut Periode')}" />

                <g:sortableColumn property="dateFinPeriode" title="${message(code: 'demandeVisite.dateFinPeriode.label', default: 'Date Fin Periode')}" />

                <g:sortableColumn property="nbPersonnes" title="${message(code: 'demandeVisite.nbPersonnes.label', default: 'Nb Personnes')}" />

                <g:sortableColumn property="statut" title="${message(code: 'demandeVisite.statut.label', default: 'Statut')}" />

            </tr>
            </thead>
            <tbody>
            <g:each in="${demandeVisiteInstanceList}" status="i" var="demandeVisiteInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td><g:link action="show" id="${demandeVisiteInstance.id}">${fieldValue(bean: demandeVisiteInstance, field: "code")}</g:link></td>

                    <td><g:formatDate date="${demandeVisiteInstance.dateDebutPeriode}" /></td>

                    <td><g:formatDate date="${demandeVisiteInstance.dateFinPeriode}" /></td>

                    <td>${fieldValue(bean: demandeVisiteInstance, field: "nbPersonnes")}</td>

                    <td>${fieldValue(bean: demandeVisiteInstance, field: "statut")}</td>

                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${demandeVisiteInstanceCount ?: 0}" />
        </div>
    </div>
	</body>
</html>
