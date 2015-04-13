<%@ page import="museetoulouse.DemandeVisite" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'statut', 'error')} required">
	<label for="statut">
		<g:message code="demandeVisite.statut.label" default="Statut" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="statut" from="${demandeVisiteInstance.constraints.statut.inList}" required="" value="${demandeVisiteInstance?.statut}" valueMessagePrefix="demandeVisite.statut"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonnes', 'error')} required">
	<label for="nbPersonnes">
		<g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nbPersonnes" type="number" min="1" max="6" value="${demandeVisiteInstance.nbPersonnes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateDebutPeriode', 'error')} required">
	<label for="dateDebutPeriode">
		<g:message code="demandeVisite.dateDebutPeriode.label" default="Date Debut Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDebutPeriode" precision="day"  value="${demandeVisiteInstance?.dateDebutPeriode}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateFinPeriode', 'error')} required">
	<label for="dateFinPeriode">
		<g:message code="demandeVisite.dateFinPeriode.label" default="Date Fin Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFinPeriode" precision="day"  value="${demandeVisiteInstance?.dateFinPeriode}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="demandeVisite.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${demandeVisiteInstance?.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'musees', 'error')} ">
	<label for="musees">
		<g:message code="demandeVisite.musees.label" default="Musees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${demandeVisiteInstance?.musees?}" var="m">
    <li><g:link controller="demandeVisiteMusee" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="demandeVisiteMusee" action="create" params="['demandeVisite.id': demandeVisiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee')])}</g:link>
</li>
</ul>


</div>

