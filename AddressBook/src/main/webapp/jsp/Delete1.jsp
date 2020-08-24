<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete entry here</title>
</head>

<style>
body {
	background-color: #ffffee;
}

#sectone {
	float: left;
}

#secttwo {
	float: left;
}

#sectthree {
	float: left;
}
</style>
<body>
	<jsp:include page='../header.jsp' />
	<h3 style="text-align: center">Delete Entry Page</h3>
	<form action="/AddressBook/deleteRecord1" method="POST">
		<div id="myDiv">
			<table cellpadding="0" cellspacing="10" width="50%">
				<tr>
					<td>Enter id:</td>
					<td><input type="text" name="number"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="Submit" value="Get Entry" /></td>
				</tr>
			</table>
		</div>
	</form>
	
	<c:if test="${bean != null}">
	<form action="/AddressBook/FinalDelete" method="POST" modelAttribute="bean">
		<p>Are you sure you want to delete this entry?</p>
		<input type="submit" name="Submit" value="Delete Entry" />
	</form>
	<section id="sectone">
		<ul>
			Personal Information:
			<li>First Name: ${bean.getFirstName()}</li>
			<li>Last Name: ${bean.getLastName()}</li>
			<li>Middle Name: ${bean.getMiddleName()}</li>
			<li>Gender: ${bean.getGender()}</li>
		</ul>
	</section>
	<section id="secttwo">
		<ul>
			Address Information:
			<li>Address: ${bean.getAddress()}</li>
			<li>City: ${bean.getCity()}</li>
			<li>State: ${bean.getState()}</li>
			<li>Country: ${bean.getCountry()}</li>
			<li>Phone number: ${bean.getPhone()}</li>
		</ul>

	</section>
	<section id="sectthree">
		<ul>
			Bank Information:
			<li>Bank Name: ${bean.getBank()}</li>
			<li>Account number: ${bean.getAccountNumber()}</li>
			<li>Social: ${bean.getSocialNumber()}</li>
		</ul>
	</section>
	<c:remove var="bean" />
	</c:if>



</body>
</html>