<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
#sectionone {
	text-align: center;
}
</style>
<head>
<meta charset="UTF-8">
<title>Medical Sign in</title>
</head>
<body style="background-color: #e6dbc9">
	<jsp:include page='mainheader.jsp' />

	<section id="sectionone">

		<h4>Medical Staff Sign in</h4>

		<p style="color: red">${errorMessage}</p>


		<form action="/medicaltwo" method="POST">
			<div>
				<label for="inputEmail">Email</label> <input type="text"
					 name="email" placeholder="Email">
			</div>
			<div class="form-group">
				<label for="inputPassword">Password</label> <input type="password"
					 name="password" placeholder="Password">
			</div>
			
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>
	
	<br /> <br />
		<h5 style="font-style: italic">
			If you just created an account, sign in using the email and password
			<br /> you entered in on the previous screen.
		</h5>

		<h5>Don't have an account with us yet? No problem. Click button
			below to sign up</h5>
		<form action="/medicalthree" method="POST">
			<input type=submit name="submit" value="Register">
		</form>
	</section>

</body>
</html>