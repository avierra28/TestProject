<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Staff</title>
</head>
<body style="background-color: #e6dbc9">
	<jsp:include page='mainheader.jsp' />

	<section id="first">

		<h3>Medical Staff Account Creation</h3>

		<p style="color: red">*All fields are required</p>
		
		<p style="color: red">${errorString}</p>
		
		<form:form action="/medicalfour" modelAttribute="medicalStaff" method="POST">
			<table id="tableOne">
				<tr>
					<td>Enter first name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Enter last name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Enter Position:</td>
					<td><form:input path="position" /></td>
				</tr>
				<tr>
					<td>Enter years of experience:</td>
					<td><form:input path="yearsExp" /></td>
				</tr>
				<tr>
					<td>Enter Email address:</td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td>Any comments?:</td>
					<td><form:input path="comments" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="done" value="Submit Information" /></td>
				</tr>
			</table>

		</form:form>
	</section>

</body>
</html>