<%@ page import="net.sksi.freezerbuddy.ItemDefinition" %>



<div class="fieldcontain ${hasErrors(bean: itemDefinitionInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="itemDefinition.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${itemDefinitionInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemDefinitionInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="itemDefinition.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${itemDefinitionInstance?.name}"/>
</div>

