
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
    <a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li id="left">
                <g:form controller="musee" action="doSearchMusee">
                    <h1> Rechercher un musée</h1>
                <fieldset class="form">
                            Nom Musée :
                        <g:textField name="nom" placeholder=" Entrer nom"/></br></br>
                            Code Postale :
                        <g:select name="codePostal"
                                  from="${museetoulouse.Adresse.list().codePostal.unique()}" /></br></br>
                            Le nom Rue :
                        <g:textField name="rue" placeholder=" Entrer rue"/></br></br>
                        <div style="float:right"><input value="Rechercher" type="submit"></div>
                </fieldset>
            </g:form>
            </li>
            <li id="right">
                <h1> Liste des Musées Préféres</h1>
                <table>
                    <thead>

                    <tr>

                        <th><g:message code="musee.nom.label" default="Nom Musee" /></th>
                        <th><g:message code="musee.nom.label" default="Favoris" /></th>
                        <th><g:message code="musee.nom.label" default="Demande de visite" /></th>
                        </tr>
                    <tbody>
                <td>${fieldValue(bean: museeInstance, field: "nom")}</td>
                <td><input value="Delete" type="submit"></td>
                <td><input value="DemandeVisite" type="submit"></td>

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
                    <th>Add Favoris</th>

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
                            <input value="Ajouter" type="submit">

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