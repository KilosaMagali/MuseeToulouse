<%@ page import="museetoulouse.DemandeVisiteMusee" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'dateDemandeVisite', 'error')} required">
	<label for="dateDemandeVisite">
		<g:message code="demandeVisiteMusee.dateDemandeVisite.label" default="Date Demande Visite" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDemandeVisite" precision="day"  value="${demandeVisiteMuseeInstance?.dateDemandeVisite}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'demandeVisite', 'error')} required">
	<label for="demandeVisite">
		<g:message code="demandeVisiteMusee.demandeVisite.label" default="Demande Visite" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="demandeVisite" name="demandeVisite.id" from="${museetoulouse.DemandeVisite.list()}" optionKey="id" required="" value="${demandeVisiteMuseeInstance?.demandeVisite?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'musee', 'error')} required">
	<label for="musee">
		<g:message code="demandeVisiteMusee.musee.label" default="Musee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musee" name="musee.id" from="${museetoulouse.Musee.list()}" optionKey="id" required="" value="${demandeVisiteMuseeInstance?.musee?.id}" class="many-to-one"/>

</div>

