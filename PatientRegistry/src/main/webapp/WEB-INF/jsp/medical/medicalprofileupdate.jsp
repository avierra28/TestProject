<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile View</title>
</head>
<style>
body{
    margin-top:20px;
    color: #1a202c;
    text-align: left;
    background-color: #e2e8f0;    
}
.main-body {
    padding: 15px;
}
.card {
    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
}

.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: .25rem;
}

.card-body {
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1rem;
}

.gutters-sm {
    margin-right: -8px;
    margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
    padding-right: 8px;
    padding-left: 8px;
}
.mb-3, .my-3 {
    margin-bottom: 1rem!important;
}

.bg-gray-300 {
    background-color: #e2e8f0;
}
.h-100 {
    height: 100%!important;
}
.shadow-none {
    box-shadow: none!important;
}

#textareaone {

}

</style>
<body style="background-color: #e6dbc9">
<jsp:include page='medicalHeader.jsp' />
<form:form action="/medical/processMedical" modelAttribute="medicalStaff" method="POST">
<div class="container">
    <div class="main-body">
    
          <div class="row gutters-sm">
            
            
            
<!--    First card with picture.          -->
            
            <div class="col-md-4 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="../../images/medicalLogo.jpg" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>${staff.getFirstName()} ${staff.getLastName()}</h4>
                      <p class="text-secondary mb-1">${staff.getPosition()}</p>
                      <p class="text-muted font-size-sm">${staff.getAddress()}, Years: ${staff.getYearsExp()}</p>
                    </div>
                  </div>
                </div>
              </div>
              
              
<!--    Second card with my bio            -->
              
              
              <div class="card mt-3" id="textareaone">
              Short Biography:
              <form:input path="biography" value="${staff.getBiography()}" rows="20" />
              </div>
              
              <input type="submit" name="done" value="Finalize Changes" />
            </div>
            
<!--      First and Second card end right here.        -->
            
            <div class="col-md-8">
              
              
              
              
              
              
              
<!--      Third card with the information starts right here          -->
              
              
              <div class="card mb-3">
                <div class="card-body">


<!--                   First Row       						 -->
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Full Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                       <form:input path="firstName" value="${staff.getFirstName()}" /> <form:input path="lastName" value="${staff.getLastName()}" />
                    </div>
                  </div>
                  <hr>
<!--                   Second Row       						 -->
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="userName" value="${staff.getEmailId()}" />
                    </div>
                  </div>
                  <hr>
<!--                   Third Row       				 -->                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Password</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="password" value="${staff.getPassword()}" />
                    </div>
                  </div>
                  <hr>
                  
 <!--                   Fourth Row       				 -->                 
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Position</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="position" value="${staff.getPosition()}" />
                    </div>
                  </div>
                  <hr>
                  
                  
  <!--                   Fifth Row       				 -->                 
                  
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Years Exp</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="yearsExp" value="${staff.getYearsExp()}" />
                    </div>
                  </div>
                  <hr>
                  
                  
   <!--                   Sixth Row       				 -->                  
                  
                  
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Phone</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="phone_number" value="${staff.getPhone_number()}" />
                    </div>
                  </div>
<hr>
   <!--                   Seventh Row       				 -->                  
                  
                  
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Pager Number</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="pager_number" value="${staff.getPager_number()}" />
                    </div>
                  </div>                  
                  <hr>
                  
   <!--                   Eight Row       				 -->                  
                  
                  
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Address</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="address" value="${staff.getAddress()}" />
                    </div>
                  </div>                  
                  <hr>
                  
   <!--                   Ninth Row       				 -->                  
                  
                  
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Comments</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <form:input path="comments" value="${staff.getComments()}" />
                    </div>
                  </div>                  
                  <hr>                                     
                  
                </div>
              </div>
<!--               <div class="row gutters-sm"> -->
<!--                 <div class="col-sm-6 mb-3"> -->
<!--                   <div class="card h-100"> -->
<!--                     <div class="card-body"> -->
<!--                       <h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">assignment</i>Project Status</h6> -->
<!--                       <small>Web Design</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Website Markup</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>One Page</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Mobile Template</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Backend API</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                     </div> -->
<!--                   </div> -->
<!--                 </div> -->
<!--                 <div class="col-sm-6 mb-3"> -->
<!--                   <div class="card h-100"> -->
<!--                     <div class="card-body"> -->
<!--                       <h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">assignment</i>Project Status</h6> -->
<!--                       <small>Web Design</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Website Markup</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>One Page</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Mobile Template</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                       <small>Backend API</small> -->
<!--                       <div class="progress mb-3" style="height: 5px"> -->
<!--                         <div class="progress-bar bg-primary" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div> -->
<!--                       </div> -->
<!--                     </div> -->
<!--                   </div> -->
<!--                 </div> -->
<!--               </div> -->
            </div>
          </div>
        </div>
    </div>
    </form:form>

</body>
</html>