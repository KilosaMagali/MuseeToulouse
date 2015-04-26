
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
        <h1 align="center" style="color: brown">Entrer le code de votre demande </h1>
        <g:form controller="demandeVisite" action="searchDemande" method="post">
            <fieldset class="form">
                <div class="fieldcontain">
                    <label for="code">
                        <b>Code:</b>
                    </label>
                    <g:textField name="code"  style="color: darkred"/>
                </div>
                <br>
                <div style="float: right">
                    <input value="Rechercher" action="searchDemande" src="./images/rechercher.png" type="image" style="height: 40px" >
                </div>
            </fieldset>
        </g:form>
    </div>

	</body>
</html>
