
<%@ page import="net.sksi.freezerbuddy.ItemDefinition" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemDefinition.label', default: 'ItemDefinition')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itemDefinition" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itemDefinition" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list itemDefinition">
			
				<g:if test="${itemDefinitionInstance?.pluralName}">
				<li class="fieldcontain">
					<span id="pluralName-label" class="property-label"><g:message code="itemDefinition.pluralName.label" default="Plural Name" /></span>
					
						<span class="property-value" aria-labelledby="pluralName-label"><g:fieldValue bean="${itemDefinitionInstance}" field="pluralName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemDefinitionInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="itemDefinition.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${itemDefinitionInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemDefinitionInstance?.singularName}">
				<li class="fieldcontain">
					<span id="singularName-label" class="property-label"><g:message code="itemDefinition.singularName.label" default="Singular Name" /></span>
					
						<span class="property-value" aria-labelledby="singularName-label"><g:fieldValue bean="${itemDefinitionInstance}" field="singularName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:itemDefinitionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${itemDefinitionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
