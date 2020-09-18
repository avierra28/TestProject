<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.paddingTB60 {
	padding: 60px 0px 60px 0px;
}

.gray-bg {
	background: #F1F1F1 !important;
}

.about-title {
	
}

.about-title h1 {
	color: #535353;
	font-size: 45px;
	font-weight: 600;
}

.about-title span {
	color: #AF0808;
	font-size: 45px;
	font-weight: 700;
}

.about-title h3 {
	color: #535353;
	font-size: 23px;
	margin-bottom: 24px;
}

.about-title p {
	color: #7a7a7a;
	line-height: 1.8;
	margin: 0 0 15px;
}

.about-paddingB {
	padding-bottom: 12px;
}

.about-img {
	padding-left: 57px;
}

/* Social Icons */
.about-icons {
	margin: 48px 0px 48px 0px;
}

.about-icons i {
	margin-right: 10px;
	padding: 0px;
	font-size: 35px;
	color: #323232;
	box-shadow: 0 0 3px rgba(0, 0, 0, .2);
}

.about-icons li {
	margin: 0px;
	padding: 0;
	display: inline-block;
}

#social-fb:hover {
	color: #3B5998;
	transition: all .001s;
}

#social-tw:hover {
	color: #4099FF;
	transition: all .001s;
}

#social-gp:hover {
	color: #d34836;
	transition: all .001s;
}

#social-em:hover {
	color: #f39c12;
	transition: all .001s;
}
</style>
<body style="background-color: #e6dbc9">
<jsp:include page='mainheader.jsp' />
	<div class="about-section paddingTB60 gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-7 col-sm-6">
					<div class="about-title clearfix">
						<h1>
							About <span>Patient Registry</span>
						</h1>
						<h3>The database for medical staffing</h3>
						<p class="about-paddingB">The software that stores and manages patients
						admitted by a team of medical professionals in a timely and efficient
						manner.</p>
						<p>The medical personel must create an account before having access to the
						database of patients and will be able to do the basic CRUD operations in each
						patient.</p>
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>