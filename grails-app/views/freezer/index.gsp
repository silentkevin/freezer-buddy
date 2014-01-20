
<%@ page import="net.sksi.freezerbuddy.Freezer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'freezer.label', default: 'Freezer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-freezer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-freezer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="location" title="${message(code: 'freezer.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'freezer.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'freezer.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${freezerInstanceList}" status="i" var="freezerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${freezerInstance.id}">${fieldValue(bean: freezerInstance, field: "location")}</g:link></td>
					
						<td>${fieldValue(bean: freezerInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: freezerInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${freezerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
