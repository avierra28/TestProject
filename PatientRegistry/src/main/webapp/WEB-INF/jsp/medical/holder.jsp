<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="main-body">
          <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="../../images/medicalLogo.jpg" alt="Profile Picture" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>${staff.getFirstName()} ${staff.getLastName()}</h4>
                      <p class="text-secondary mb-1">${staff.getPosition()}</p>
                      <p class="text-muted font-size-sm">${staff.getAddress()}, Years: ${stadd.getYearsExp()}</p>
                    </div>
                  </div>
                </div>
              </div>
              
               <div class="col-md-8">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Full Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="firstName" value="${staff.getFirstName()}" /> <form:input path="lastName" value="${staff.getLastName()}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="userName" value="${staff.getEmailId()}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Password</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="password" value="${staff.getPassword()}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Position</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="yearsExp" value="${staff.getPosition()}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Years Exp</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="yearsExp" value="${staff.getYearsExp()}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Phone</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="phone_number" value="${staff.getPhone_number()}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Pager Number</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="pager_number" value="${staff.getPager_number()}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Address</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="address" value="${staff.getAddress()}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Comments</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="comments" value="${staff.getComments()}" />
                    </div>
                  </div>
                  
                </div>
              </div>

            </div>
          </div>
        </div>
    </div>

</body>
</html>