<%@ page import="museetoulouse.MuseePrefere" %>



<div class="fieldcontain ${hasErrors(bean: museePrefereInstance, field: 'museePreferes', 'error')} ">
	<label for="museePreferes">
		<g:message code="museePrefere.museePreferes.label" default="Musee Preferes" />
		
	</label>
	<g:select name="museePreferes" from="${museetoulouse.Musee.list()}" multiple="multiple" optionKey="id" size="5" value="${museePrefereInstance?.museePreferes*.id}" class="many-to-many"/>

</div>

