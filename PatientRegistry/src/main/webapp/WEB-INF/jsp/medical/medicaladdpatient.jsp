<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link
	href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.3/jquery-ui.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Patient Information Entry Page</title>
</head>
<body style="background-color: #e6dbc9">
	<jsp:include page='medicalHeader.jsp' />

	<section id="centerThis">

		<h4>Please enter patient information:</h4>

		<c:if test="${!errorMessage.equals('')}">
			<div class="alert alert-danger alert-dismissible fade show" style="width: 50%">
				${errorMessage}
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>

		</c:if>

		<p>Patient's:</p>
		<form:form action="/medical/processPatient" modelAttribute="patient" method="POST">
			<table id="tableOne">
				<tr>
					<td>First name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input path="dateOfBirth" type="date" /></td>
				</tr>
				<tr>
					<td>Condition:</td>
					<td><form:input path="condition" /></td>
				</tr>
				<tr>
					<td>Seriousness (Scale 1-10):</td>
					<td><form:input path="seriousnes" /></td>
				</tr>
				<tr>
					<td>Room Number:</td>
					<td><form:input path="roomNumber" /></td>
				</tr>
				<tr>
					<td>Added by:</td>
					<td><form:input path="added" /></td>
				</tr>
				<tr>
					<td>Any comments?:</td>
					<td><form:input path="comments" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="done"
						value="Submit Information" /></td>
				</tr>
			</table>

		</form:form>
	</section>


</body>
</html>