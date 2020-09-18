<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Sat Sep 12 2020 17:37:21 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="5f5c6b81a768b887eb7d1976"
	data-wf-site="5f5c5ca99430f22d12e4c5ec">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta charset="utf-8">
<title>medicalregister</title>
<meta content="medicalregister" property="og:title">
<meta content="medicalregister" property="twitter:title">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta content="Webflow" name="generator">
<link href="css/normalize.css" rel="stylesheet" type="text/css">
<link href="css/webflow.css" rel="stylesheet" type="text/css">
<link href="css/patient-registry.webflow.css" rel="stylesheet"
	type="text/css">
<!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
<script type="text/javascript">
	!function(o, c) {
		var n = c.documentElement, t = " w-mod-";
		n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch
				&& c instanceof DocumentTouch)
				&& (n.className += t + "touch")
	}(window, document);
</script>
<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="images/webclip.png" rel="apple-touch-icon">
</head>
<body class="body-3">
<jsp:include page='mainnavbar.jsp' />
	<div class="w-container">
		<h1 class="heading-2">Medical Register Page</h1>
	</div>
	<div class="w-container">
		<ul role="list">
			<li>First name, Last name are required</li>
			<li>Years of experience will be processed as an integer</li>
			<li>Username and password are vital to the logging in process.</li>
			<li>Comments may be left blank.</li>
		</ul>
	</div>
	<div class="w-container">
		<div modelattribute="medicalStaff" class="form-block-2 w-form">
			<form:form id="wf-form-Registration-Form"
				name="wf-form-Registration-Form" data-name="Registration Form"
				method="post" action="/medicalfour" class="form-2"
				modelAttribute="medicalStaff">
				<label for="name-2">First Name</label>
				<form:input type="text" class="w-input" path="firstName"
					maxlength="256" name="name-2" data-name="Name 2" id="name-2"
					required="" />
				<label for="email-2">Last Name</label>
				<form:input type="email" class="w-input" path="lastName"
					maxlength="256" name="email-2" data-name="Email 2" id="email-2"
					required="" />
				<label>Position</label>
				<form:input type="text" class="w-input" path="position"
					maxlength="256" name="field-2" data-name="Field 2" id="field-2"
					required="" />
				<label>Years of Experience</label>
				<form:input type="text" class="w-input" path="yearsExp"
					maxlength="256" name="field-2" data-name="Field 2" id="field-2"
					required="" />
				<label>Username</label>
				<form:input type="text" class="w-input" path="emailId"
					maxlength="256" name="field-2" data-name="Field 2" id="field-2"
					required=""/>
					<label>Password</label>
					<form:input type="text" class="w-input" path="password"
						maxlength="256" name="field-4" data-name="Field 4" id="field-4"
						required="" />
					<label>Any Comments?</label>
					<form:textarea name="field-3" maxlength="5000" id="field-3"
						path="comments" class="w-input" />
					</textarea>
					<input type="submit" value="Submit" data-wait="Please wait..."
						class="w-button" />
			</form:form>
			<div class="w-form-done">
				<div>Thank you! Your submission has been received!</div>
			</div>
			<div class="w-form-fail">
				<div>Oops! Something went wrong while submitting the form.</div>
			</div>
		</div>
	</div>
	<script
		src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=5f5c5ca99430f22d12e4c5ec"
		type="text/javascript"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script src="js/webflow.js" type="text/javascript"></script>
	<!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>