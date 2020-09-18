<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Home</title>
</head>
<body style="background-color: #e6dbc9">
	<jsp:include page='medicalHeader.jsp' />

	<p style="color: green">Welcome ${staffMember.getFirstName()},
		${staffMember.getLastName()}.</p>

	<c:if test="${!succes.equals(null)}">
		<div class="alert alert-success alert-dismissible fade show"
			style="width: 50%;">
			${success}
			<button type="button" class="close" data-dismiss="alert">&times;</button>
		</div>
	</c:if>


	<h5>Please choose from any of the option that are above.</h5>
	<section style="font-style: italic">
		<li>Add Patient: Adds a patient to the database. (Must fill all
			text fields out).</li>
		<li>View Patients: View all patients, as well as other options
			that will be given.</li>
		<li>Update Patient: Select one patient from the list to modify.</li>
		<li>Remove Patient: Remove patient only if they are healthy and
			have gone home.</li>
		<li>View Profile: View your own profile with other options.</li>
		<li>Log out: Log out of the system.</li>
	</section>
</body>
</html>