
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
    <div id="index" >
    <form controller="demandeVisite" action="doSearchMusee" method="post">
    <div class="fieldcontain">
        <label for="codeDemande">
            <b>Votre code :</b>
        </label>
        <g:textField name="codeDemande"  style="color: darkred"/>
    </div>
        <div style=" float: right">
            <input value="Valider" action="searchMesDemandes" src="./images/rechercher.png" type="image" style="height: 40px" >
        </div>
    </form>
    </div>
	</body>
</html>
