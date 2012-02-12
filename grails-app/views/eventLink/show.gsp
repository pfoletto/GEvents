
<%@ page import="com.spark.EventLink" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventLink.label', default: 'EventLink')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-eventLink" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-eventLink" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list eventLink">
			
				<g:if test="${eventLinkInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="eventLink.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${eventLinkInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventLinkInstance?.event}">
				<li class="fieldcontain">
					<span id="event-label" class="property-label"><g:message code="eventLink.event.label" default="Event" /></span>
					
						<span class="property-value" aria-labelledby="event-label"><g:link controller="event" action="show" id="${eventLinkInstance?.event?.id}">${eventLinkInstance?.event?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventLinkInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="eventLink.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${eventLinkInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${eventLinkInstance?.id}" />
					<g:link class="edit" action="edit" id="${eventLinkInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
