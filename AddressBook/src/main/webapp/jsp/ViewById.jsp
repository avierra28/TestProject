<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
<jsp:include page='../header.jsp' />
</head>
<style>
#myDiv {
margin-left: auto;
    margin-right: auto;
}
#idTable tr td {
	border: 1px solid black;
}

#idTable {
	border-collapse: collapse;
}

thead {
	background-color: bisque;
	border: 2px solid black;
}

td {
	padding: 5px;
}
</style>
<body style="background-color: #ffffee">
	<h4 style="text-align: center">Modify Page</h4>
	<form action="/AddressBook/view" method="POST">
		<label for="fName">Enter Id number:</label> 
		<input type="text" name="idNumber"/> <br /> 
		<input type=submit name="submit" value="Submit">
	</form>

	<c:if test="${myBean != null}">
		<div id="myDiv">
			<table cellpadding="0" cellspacing="10" width="50%" id="idTable">
				<thead>
					<tr>
						<td>Column Name</td>
						<td>Value</td>
					</tr>
				</thead>
				<tr>
				<td>First Name</td>
				<td>${myBean.getFirstName()}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${myBean.getLastName()}</td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td>${myBean.getMiddleName()}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${myBean.getGender()}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${myBean.getAddress()}</td>
			</tr>
			<tr>
				<td>City</td>
				<td>${myBean.getCity()}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${myBean.getState()}</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>${myBean.getCountry()}</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>${myBean.getPhone()}</td>
			</tr>
			<tr>
				<td>Bank</td>
				<td>${myBean.getBank()}</td>
			</tr>
			<tr>
				<td>Account Number</td>
				<td>${myBean.getAccountNumber()}</td>
			</tr>
			<tr>
				<td>Social</td>
				<td>${myBean.getSocialNumber()}</td>
			</tr>

			</table>
		</div>
	</c:if>


</body>
</html>