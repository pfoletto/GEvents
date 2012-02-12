<%@ page import="com.spark.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="event.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${eventInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="event.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${eventInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'venue', 'error')} ">
	<label for="venue">
		<g:message code="event.venue.label" default="Venue" />
		
	</label>
	<g:textField name="venue" value="${eventInstance?.venue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="event.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
<g:customDatePicker name="startDate" precision="day"  value="${eventInstance?.startDate}" style="width:50px" />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'organizer', 'error')} required">
	<label for="organizer">
		<g:message code="event.organizer.label" default="Organizer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organizer" name="organizer.id" from="${com.spark.User.list()}" optionKey="id" required="" value="${eventInstance?.organizer?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="event.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${eventInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'direction', 'error')} ">
	<label for="direction">
		<g:message code="event.direction.label" default="Direction" />
		
	</label>
	<g:textField name="direction" value="${eventInstance?.direction}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'volunteers', 'error')} ">
	<label for="volunteers">
		<g:message code="event.volunteers.label" default="Volunteers" />
		
	</label>
	<g:select name="volunteers" from="${com.spark.User.list()}" multiple="multiple" optionKey="id" size="5" value="${eventInstance?.volunteers*.id}" class="many-to-many"/>
</div>

