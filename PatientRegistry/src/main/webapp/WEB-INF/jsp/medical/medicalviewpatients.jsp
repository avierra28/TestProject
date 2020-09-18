<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
table.dataTable thead .sorting:after, table.dataTable thead .sorting:before,
	table.dataTable thead .sorting_asc:after, table.dataTable thead .sorting_asc:before,
	table.dataTable thead .sorting_asc_disabled:after, table.dataTable thead .sorting_asc_disabled:before,
	table.dataTable thead .sorting_desc:after, table.dataTable thead .sorting_desc:before,
	table.dataTable thead .sorting_desc_disabled:after, table.dataTable thead .sorting_desc_disabled:before
	{
	bottom: .5em;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Patient Viewer</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" language="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
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

	<h5>Choose below how the table should be ordered:</h5>

	<div class="bs-example">
		<table id="dtBasicExample"
			class="table table-striped table-bordered table-sm" cellspacing="0">
			<thead>
				<tr>
					<th class="th-sm">Id <a href="/medical/patientSort1">↑</a> | <a
						href="/medical/patientSort2">↓</a></th>
					<th class="th-sm">First Name <a href="/medical/patientSort3">↑</a>
						| <a href="/medical/patientSort4">↓</a></th>
					<th class="th-sm">Last Name <a href="/medical/patientSort5">↑</a>
						| <a href="/medical/patientSort6">↓</a></th>
					<th class="th-sm">Age <a href="/medical/patientSort7">↑</a> |
						<a href="/medical/patientSort8">↓</a></th>
					<th class="th-sm">Date of Birth <a
						href="/medical/patientSort9">↑</a> | <a
						href="/medical/patientSort10">↓</a></th>
					<th class="th-sm">Condition <a href="/medical/patientSort11">↑</a>
						| <a href="/medical/patientSort12">↓</a></th>
					<th class="th-sm">Seriousness <a href="/medical/patientSort13">↑</a>
						| <a href="/medical/patientSort14">↓</a></th>
					<th class="th-sm">Room # <a href="/medical/patientSort15">↑</a>
						| <a href="/medical/patientSort16">↓</a></th>
					<th class="th-sm">Added by <a href="/medical/patientSort17">↑</a>
						| <a href="/medical/patientSort18">↓</a></th>
					<th class="th-sm">Comments <a href="/medical/patientSort19">↑</a>
						| <a href="/medical/patientSort20">↓</a></th>
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
						<td>
							<form action="/medical/viewDelete">
								<input type="hidden" name="identification"
									value="${item.getId()}" /> <input type="submit" value="Delete" />
							</form>
							<form action="/medical/viewEdit">
								<input type="hidden" name="identification"
									value="${item.getId()}" /> <input type="submit"
									value="Edit    ." />
							</form>
						</td>
					</tr>
					<!-- 							Do a c:if check here if the object is null upon coming back from /medical/viewEdit -->
					<c:if test="${uniquePatient != null}">
						<tr>
							<form:form action="/medical/finalUpdatePatient" modelAttribute="patientperson"
								method="POST">
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

							</form:form>


						</tr>

					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#dtBasicExample').DataTable();
		$('.dataTables_length').addClass('bs-select');
	});
</script>
</html>