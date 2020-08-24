
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Specialized Search</title>
<jsp:include page='../header.jsp' />
<h2 style="text-align: center">Search Page</h2>
</head>
<style>
#myTable {
	border-collapse: collapse;
}

thead {
	padding: 2px;
	border: 10px;
}

#myTable, #myTable2 thead tr td {
	border: 1px solid black;
}

td {
	border-collapse: collapse;
	border: 1px solid black;
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
	<ul>
		Database table column names for hql syntax exactness.
		<li>record_id (key)</li>
		<li>first_name</li>
		<li>last_name</li>
		<li>middle_name</li>
		<li>gender</li>
		<li>address</li>
		<li>city</li>
		<li>state</li>
		<li>country</li>
		<li>phone_number</li>
		<li>bank_name</li>
		<li>accountNumber</li>
		<li>socialNumber</li>
	</ul>
	<p>Example hql query: "from Bean where record_id > 15" etc..</p>

	<form action="/AddressBook/finalSearch" method="GET">
		<label for="search">Enter hql query:</label> <input type="text"
			id="query" name="search" /> <br /> <input type=submit name="submit"
			value="Submit">

	</form>

	<h4>Records Table:</h4>
	<table id="myTable" cellpadding="0" cellspacing="10" width="50%">
		<thead>
			<td>Id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Middle Name</td>
			<td>Gender</td>
			<td>Address</td>
			<td>City</td>
			<td>State</td>
			<td>Country</td>
			<td>Phone</td>
			<td>Bank</td>
			<td>Account #</td>
			<td>Social</td>
		</thead>
		<c:forEach items='${myBean}' var="item">
			<tr>
				<td>${item.getIdString()}</td>
				<td>${item.getFirstName()}</td>
				<td>${item.getLastName()}</td>
				<td>${item.getMiddleName()}</td>
				<td>${item.getGender()}</td>
				<td>${item.getAddress()}</td>
				<td>${item.getCity()}</td>
				<td>${item.getState()}</td>
				<td>${item.getCountry()}</td>
				<td>${item.getPhone()}</td>
				<td>${item.getBank()}</td>
				<td>${item.getAccountNumber()}</td>
				<td>${item.getSocialNumber()}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>