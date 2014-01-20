<%@ page import="net.sksi.freezerbuddy.ItemDefinition" %>



<div class="fieldcontain ${hasErrors(bean: itemDefinitionInstance, field: 'pluralName', 'error')} ">
	<label for="pluralName">
		<g:message code="itemDefinition.pluralName.label" default="Plural Name" />
		
	</label>
	<g:textField name="pluralName" value="${itemDefinitionInstance?.pluralName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemDefinitionInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="itemDefinition.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${itemDefinitionInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemDefinitionInstance, field: 'singularName', 'error')} ">
	<label for="singularName">
		<g:message code="itemDefinition.singularName.label" default="Singular Name" />
		
	</label>
	<g:textField name="singularName" value="${itemDefinitionInstance?.singularName}"/>
</div>

