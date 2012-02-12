<%@ page import="com.spark.EventResource" %>



<div class="fieldcontain ${hasErrors(bean: eventResourceInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="eventResource.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${eventResourceInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventResourceInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="eventResource.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${com.spark.Event.list()}" optionKey="id" required="" value="${eventResourceInstance?.event?.id}" class="many-to-one"/>
</div>

