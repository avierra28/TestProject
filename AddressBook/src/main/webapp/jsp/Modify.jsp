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
	<form action="/AddressBook/modify1" method="POST">
		<label for="fName">Enter Id number:</label> 
		<input type="text" name="idNumber"/> <br /> 
		<input type=submit name="submit" value="Submit">
	</form>

	<c:if test="${myBean != null}">
	<form:form action="/AddressBook/modify2" method="POST" modelAttribute="myBean">
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
				<td><form:input type="text" name="firstName" path="firstName" value="${myBean.getFirstName()}"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input type="text" name="lastName" path="lastName" value="${myBean.getLastName()}"/></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><form:input type="text" name="middleName" path="middleName" value="${myBean.getMiddleName()}"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input type="text" name="gender" path="gender" value="${myBean.getGender()}"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input type="text" name="address" path="address" value="${myBean.getAddress()}"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input type="text" name="city" path="city" value="${myBean.getCity()}"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input type="text" name="state" path="state" value="${myBean.getState()}"/></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input type="text" name="country" path="country" value="${myBean.getCountry()}"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input type="text" name="phoneNo" path="phone" value="${myBean.getPhone()}"/></td>
			</tr>
			<tr>
				<td>Bank</td>
				<td><form:input type="text" name="bank" path="bank" value="${myBean.getBank()}"/></td>
			</tr>
			<tr>
				<td>Account Number</td>
				<td><form:input type="text" name="accountNo" path="accountNumber" value="${myBean.getAccountNumber()}"/></td>
			</tr>
			<tr>
				<td>Social</td>
				<td><form:input type="text" name="socialNo" path="socialNumber" value="${myBean.getSocialNumber()}"/></td>
			</tr>

			</table>
		</div>
		
		

			<input type=submit name="submit" value="Finalize Modification">

		</form:form>

	</c:if>


</body>
</html>