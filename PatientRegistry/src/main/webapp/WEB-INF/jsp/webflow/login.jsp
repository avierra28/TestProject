<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Sat Sep 12 2020 17:27:15 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="5f5c6999a10d236e497e3387" data-wf-site="5f5c5ca99430f22d12e4c5ec">
<head>
  <meta charset="utf-8">
  <title>login</title>
  <meta content="login" property="og:title">
  <meta content="login" property="twitter:title">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/patient-registry.webflow.css" rel="stylesheet" type="text/css">
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
  <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="images/webclip.png" rel="apple-touch-icon">
</head>
<body class="body-2">
<jsp:include page='mainnavbar.jsp' />
  <section id="subscribe-form" class="subscribe-form">
    <div class="centered-container w-container">
      <h2>Log in Page</h2>
      <p> Enter in a username and password below: </p>
    </div>
    <div class="form-block w-form">
      <form id="email-form" name="email-form" data-name="Email Form" action="/medicaltwo" method="post" class="form"><label for="email-2">User Name</label><input type="text" class="w-input" maxlength="256" name="email" data-name="email" placeholder="" id="email-2" required=""><label for="password">Password</label><input type="password" class="w-input" maxlength="256" name="password" data-name="password" placeholder="" id="password" required=""><input type="submit" value="Submit" data-wait="Please wait..." class="w-button"></form>
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form.</div>
      </div>
    </div>
    <p class="paragraph">Both User name and password are required fields.</p>
  </section>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=5f5c5ca99430f22d12e4c5ec" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>