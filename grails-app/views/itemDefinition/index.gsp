
<%@ page import="net.sksi.freezerbuddy.ItemDefinition" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemDefinition.label', default: 'ItemDefinition')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itemDefinition" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itemDefinition" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="pluralName" title="${message(code: 'itemDefinition.pluralName.label', default: 'Plural Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'itemDefinition.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="singularName" title="${message(code: 'itemDefinition.singularName.label', default: 'Singular Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemDefinitionInstanceList}" status="i" var="itemDefinitionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemDefinitionInstance.id}">${fieldValue(bean: itemDefinitionInstance, field: "pluralName")}</g:link></td>
					
						<td>${fieldValue(bean: itemDefinitionInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: itemDefinitionInstance, field: "singularName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemDefinitionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
