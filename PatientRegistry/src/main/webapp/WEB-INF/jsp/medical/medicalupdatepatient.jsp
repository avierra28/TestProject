<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Patient</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.bs-example {
	margin: 20px;
}
</style>
</head>
<body style="background-color: #e6dbc9">
<jsp:include page='medicalHeader.jsp' />

<h5>Enter Patient id to collapse an editable table for editing.</h5>
	<div class="bs-example">
		<table class="table table-striped table-sm table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Date of Birth</th>
					<th>Condition</th>
					<th>Seriousness</th>
					<th>Room #</th>
					<th>Added by</th>
					<th>Comments</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${myPatients}' var="item">
					<tr>
						<td>${item.getId()}</td>
						<td>${item.getFirstName()}</td>
						<td>${item.getLastName()}</td>
						<td>${item.getAge()}</td>
						<td>${item.getDateOfBirth()}</td>
						<td>${item.getCondition()}</td>
						<td>${item.getSeriousnes()}</td>
						<td>${item.getRoomNumber()}</td>
						<td>${item.getAdded()}</td>
						<td>${item.getComments()}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

		<form action="/medical/patientUpdate2" method="POST">
			<label for="fName">Enter id:</label> <input type="text" id="fName"
				name="idNumber" value="${uniquePatient.getId()}" /> <br /> <input type=submit name="submit"
				value="Gather Patient">

		</form>
		<br />

		<c:if test="${!errorMessage.equals('')}">
			<div class="alert alert-danger alert-dismissible fade show" style="width: 50%">
				${errorMessage}
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>

		</c:if>

		<c:if test="${uniquePatient != null}">
			<form:form action="/medical/finalUpdate" modelAttribute="patient"
				method="POST">
				<table class="table table-striped table-sm table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>Date of Birth</th>
							<th>Condition</th>
							<th>Seriousness</th>
							<th>Room #</th>
							<th>Added by</th>
							<th>Comments</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${uniquePatient.getId()}</td>
							<td><form:input path="firstName"
									value="${uniquePatient.getFirstName()}" /></td>
							<td><form:input path="lastName"
									value="${uniquePatient.getLastName()}" /></td>
							<td><form:input path="age"
									value="${uniquePatient.getAge()}" /></td>
							<td><form:input path="dateOfBirth" type="date"
									value="${uniquePatient.getDateOfBirth()}" /></td>
							<td><form:input path="condition"
									value="${uniquePatient.getCondition()}" /></td>
							<td><form:input path="seriousnes"
									value="${uniquePatient.getSeriousnes()}" /></td>
							<td><form:input path="roomNumber"
									value="${uniquePatient.getRoomNumber()}" /></td>
							<td><form:input path="added"
									value="${uniquePatient.getAdded()}" /></td>
							<td><form:input path="comments"
									value="${uniquePatient.getComments()}" /></td>
						</tr>
					</tbody>
				</table>
				<td><input type="submit" name="done" value="Update Patient" /></td>
			</form:form>

		</c:if>
	</div>
</body>
</html>