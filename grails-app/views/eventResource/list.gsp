
<%@ page import="com.spark.EventResource" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventResource.label', default: 'EventResource')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventResource" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventResource" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'eventResource.description.label', default: 'Description')}" />
					
						<th><g:message code="eventResource.event.label" default="Event" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventResourceInstanceList}" status="i" var="eventResourceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventResourceInstance.id}">${fieldValue(bean: eventResourceInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: eventResourceInstance, field: "event")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventResourceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
