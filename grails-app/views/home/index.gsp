	<head>
		<meta name="layout" content="main">
		<title><g:message code="default.welcome.label"  /></title>
	</head>
<body>
  
<div id="welcome" >
<h3>Welcome to GEvents.com</h3>
<p>GEvents.com is a site dedicated to assisting individuals and communities
to organize technology conferences. To bring great minds with common
interests and passions together for the good of greater geekdom!
</p>
</div>
  
<div id="homeSearch" >
<g:form controller="Event" action="search" >
<label>Search:</label>
<input id="query" type="text" name="query" />
<input type=submit value="Go" />
</g:form>
</div>
  
<div class="homeCell" >
<h3>Find an Event</h3>
<p>
See if there's a technical event in the works that strikes your fancy.
If there is, you can volunteer to help or just let the organizers know
that you'd be interested in attending. Everybody has a role to play.
</p>
<span class="buttons" >
<g:link controller="event" action="list" >Find an Event</g:link>
</span> 
</div>
  <div id="news">
<g:each in="${eventInstanceList}" status="i" var="eventInstance" >

  <g:postit message="${eventInstance}"/>
</g:each>
</div>