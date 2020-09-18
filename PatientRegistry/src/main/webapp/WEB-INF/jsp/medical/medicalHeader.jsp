<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="../css/navcolor1.css"> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
    .bs-example{
        margin: 20px;
    }
</style>
</head>
<body>
<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Medical Home</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="/medical" class="nav-item nav-link active">Home</a>
                <a href="/medical/patientAdd" class="nav-item nav-link">Add</a>
                <a href="/medical/patientView" class="nav-item nav-link">View</a>
                <a href="/medical/patientUpdate" class="nav-item nav-link">Update</a>
                <a href="/medical/deletePatient" class="nav-item nav-link">Remove</a>
                <a href="/medical/medicalProfileView" class="nav-item nav-link">View Profile</a>
                <a href="/medical/medicalProfile" class="nav-item nav-link">Update Profile</a>
                <a href="/" class="nav-item nav-link">Log out</a>
            </div>
        </div>
    </nav>
</div>
</body>
</html>