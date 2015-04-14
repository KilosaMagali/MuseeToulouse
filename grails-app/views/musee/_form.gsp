<%@ page import="museetoulouse.Musee" %>



<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="musee.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${museeInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'horaireOuverture', 'error')} required">
	<label for="horaireOuverture">
		<g:message code="musee.horaireOuverture.label" default="Horaire Ouverture" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="horaireOuverture" required="" value="${museeInstance?.horaireOuverture}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'telephone', 'error')} required">
	<label for="telephone">
		<g:message code="musee.telephone.label" default="Telephone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telephone" required="" value="${museeInstance?.telephone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'accesMetro', 'error')} ">
	<label for="accesMetro">
		<g:message code="musee.accesMetro.label" default="Acces Metro" />
		
	</label>
	<g:textField name="accesMetro" value="${museeInstance?.accesMetro}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'accesBus', 'error')} ">
	<label for="accesBus">
		<g:message code="musee.accesBus.label" default="Acces Bus" />
		
	</label>
	<g:textField name="accesBus" value="${museeInstance?.accesBus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'adresse', 'error')} required">
	<label for="adresse">
		<g:message code="musee.adresse.label" default="Adresse" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="adresse" name="adresse.id" from="${museetoulouse.Adresse.list()}" optionKey="id" required="" value="${museeInstance?.adresse?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'demandesVisite', 'error')} ">
	<label for="demandesVisite">
		<g:message code="musee.demandesVisite.label" default="Demandes Visite" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${museeInstance?.demandesVisite?}" var="d">
    <li><g:link controller="demandeVisiteMusee" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="demandeVisiteMusee" action="create" params="['musee.id': museeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'gestionnaire', 'error')} required">
	<label for="gestionnaire">
		<g:message code="musee.gestionnaire.label" default="Gestionnaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="gestionnaire" name="gestionnaire.id" from="${museetoulouse.Gestionnaire.list()}" optionKey="id" required="" value="${museeInstance?.gestionnaire?.id}" class="many-to-one"/>

</div>

