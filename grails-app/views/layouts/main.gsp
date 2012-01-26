<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <link href='http://fonts.googleapis.com/css?family=Oldenburg' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'all.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'default.css')}" type="text/css">
    <style type="text/css">
      /* Override some defaults */
      body {
        padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
      }
      .container > footer p {
        text-align: center; /* center align it with the container */
      }

      /* The white background content wrapper */
      .content {

        padding: 20px;
        margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */
        -webkit-border-radius: 0 0 6px 6px;
        -moz-border-radius: 0 0 6px 6px;
        border-radius: 0 0 6px 6px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
        box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }

      /* Page header tweaks */
      .page-header {
        background-color: #f5f5f5;
        padding: 20px 20px 10px;
        margin: -20px -20px 20px;
      }

      /* Give a quick and non-cross-browser friendly divider */
      .content .span4 {
        margin-left: 0;
        padding-left: 19px;
        border-left: 1px solid #eee;
      }

      .topbar .btn {
        border: 0;
      }

    </style>
  <g:layoutHead/>
  <r:layoutResources />
</head>
<body>
  <div class="container">
    <div id="blahLogo" role="banner">
      <a href="http://este.linux.it"><img src="${resource(dir: 'images', file: 'blah_logo.png')}" alt="Blah"/>
      </a>
    </div>
<g:layoutBody/>
    <div class="footer" role="contentinfo">
      <div id="copyright">&#169; 2012, <a href="https://github.com/pfoletto/GEvents/wiki/GEventsContributors" rel="external">GEvents Team</a> <br/><a href="mailto:info@grailsworkshop.com">info@grailsworkshop.com</a></div>

      <div id="GrailsLogo" role="banner" align="right">
      <a href="http://www.grails.org">Powered by Grails<img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Powered by Grails"/>
      </a>
      </div>    
  </div>
<g:javascript library="application"/>
<r:layoutResources />

</body>
</html>