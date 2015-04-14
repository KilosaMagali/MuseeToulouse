
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
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
                            <input value="Ajouter" type="submit">

                        </td>
                    </tr>
                </g:each>
                </div>

                </tbody>
            </table>


            <div class="pagination">
				<g:paginate total="${museeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>