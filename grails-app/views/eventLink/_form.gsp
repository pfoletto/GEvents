<%@ page import="com.spark.EventLink" %>



<div class="fieldcontain ${hasErrors(bean: eventLinkInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="eventLink.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${eventLinkInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventLinkInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="eventLink.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${com.spark.Event.list()}" optionKey="id" required="" value="${eventLinkInstance?.event?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventLinkInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="eventLink.url.label" default="Url" />
		
	</label>
	<g:textField name="url" value="${eventLinkInstance?.url}"/>
</div>

