
<%@ page import="com.spark.Event" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list event">
			
				<g:if test="${eventInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="event.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${eventInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="event.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${eventInstance}" field="location"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.venue}">
				<li class="fieldcontain">
					<span id="venue-label" class="property-label"><g:message code="event.venue.label" default="Venue" /></span>
					
						<span class="property-value" aria-labelledby="venue-label"><g:fieldValue bean="${eventInstance}" field="venue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="event.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${eventInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.directions}">
				<li class="fieldcontain">
					<span id="directions-label" class="property-label"><g:message code="event.directions.label" default="Directions" /></span>
					
						<span class="property-value" aria-labelledby="directions-label"><g:formatDate date="${eventInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.organizer}">
				<li class="fieldcontain">
					<span id="organizer-label" class="property-label"><g:message code="event.organizer.label" default="Organizer" /></span>
					
						<span class="property-value" aria-labelledby="organizer-label"><g:link controller="user" action="show" id="${eventInstance?.organizer?.id}">${eventInstance?.organizer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="event.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${eventInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.directions}">
				<li class="fieldcontain">
					<span id="direction-label" class="property-label"><g:message code="event.directions.label" default="Directions" /></span>
					
						<span class="property-value" aria-labelledby="directions-label"><g:fieldValue bean="${eventInstance}" field="directions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.createdAt}">
				<li class="fieldcontain">
					<span id="createdAt-label" class="property-label"><g:message code="event.createdAt.label" default="Created At" /></span>
					
						<span class="property-value" aria-labelledby="createdAt-label"><g:formatDate date="${eventInstance?.createdAt}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.eventResources}">
				<li class="fieldcontain">
					<span id="eventResources-label" class="property-label"><g:message code="event.eventResources.label" default="Event Resources" /></span>
					
						<g:each in="${eventInstance.eventResources}" var="e">
						<span class="property-value" aria-labelledby="eventResources-label"><g:link controller="eventResource" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.volunteers}">
				<li class="fieldcontain">
					<span id="volunteers-label" class="property-label"><g:message code="event.volunteers.label" default="Volunteers" /></span>
					
						<g:each in="${eventInstance.volunteers}" var="v">
						<span class="property-value" aria-labelledby="volunteers-label"><g:link controller="user" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${eventInstance?.id}" />
					<g:link class="edit" action="edit" id="${eventInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
