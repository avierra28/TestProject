<html>

<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>Personal Information</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="../css/myStyles.css" />
</head>
<style>
#errorMessage {
	color: red;
}

body {
	background-color: #ffffee;
}

#myForm {
	text-align: center;
}

#tableOne {
	margin: 0 auto;
}
</style>

<body id="pageOne">
	<jsp:include page='../header.jsp' />

	<section id="myForm">
		<h3>First, Last, Middle and gender submission</h3>
		<p>Kindly fill out the information below:</p>
		<br />

		<form:form action="/AddressBook/personaldo" modelAttribute="bean" method="POST">
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
					<td>Enter middle name:</td>
					<td><form:input path="middleName" /></td>
				</tr>
				<tr>
					<td>Enter gender:</td>
					<td><form:input path="gender" /></td>
				</tr>
				<tr>
					<td>Enter address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Enter city:</td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>Enter state:</td>
					<td><form:input path="state" /></td>
				</tr>
				<tr>
					<td>Enter country:</td>
					<td><form:input path="country" /></td>
				</tr>
				<tr>
					<td>Enter phone number:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>Enter bank:</td>
					<td><form:input path="bank" /></td>
				</tr>
				<tr>
					<td>Enter account number:</td>
					<td><form:input path="accountNumber" /></td>
				</tr>
				<tr>
					<td>Enter social:</td>
					<td><form:input path="socialNumber" /></td>
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