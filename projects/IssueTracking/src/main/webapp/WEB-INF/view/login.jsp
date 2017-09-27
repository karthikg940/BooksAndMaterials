<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Issue Tracking</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<link
	href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'
	rel="stylesheet">
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
<script
	src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
<link href='<spring:url value="/resources/css/page.css"></spring:url>'
	rel="stylesheet">
<script type="text/javascript"
	src="<spring:url value="/resources/js/validate.js"></spring:url>"></script>
<script>
	window.history.forward(1);
	function noBack() {
		window.history.forward(1);
	}
</script>
<style>
</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();">
	<div class="container">

		<nav class="navbar navbar-default">
			<h1 style="text-align: center;">
				<a class="btn btn-primary btn-lg" href="#" role="button">ISSUE
					TRACKING SYSTEM </a>
			</h1>
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a
							href='<spring:url value="/user/loginhome"></spring:url>'> <span
								class="glyphicon glyphicon-home"></span>Home
						</a></li>
						<li><a href='<spring:url value="/user/about"></spring:url>'><span
								class="glyphicon glyphicon-user"></span> About</a></li>
						<li><a href='<spring:url value="/user/contact"></spring:url>'><span
								class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
						<li class="active"><a href="#"> <span
								class="glyphicon glyphicon-log-in"></span> Login
						</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
	</div>

	<div class="container">
		<div class="jumbotron">

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">

					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${error}
						</div>
					</c:if>
				</div>
				<div class="col-sm-2"></div>

			</div>




			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-login">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-12">
										<a href="#" class="active" id="login-form-link">Login</a>
									</div>
								</div>
								<hr>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<form id="login-form" method="post" name="myform"
											onsubmit="return loginValidate()"
											action="<spring:url value="/user/loginCheck"/>">

											<div class="form-group">
												<h4 class="fieldname">
													<span class="star-must">*</span>User Name:
												</h4>
												<input type="text" name="userName" id="userName"
													tabindex="1" class="form-control" placeholder="Username"
													value=""> <span id="spanuname" style="color: red;"></span>
											</div>

											<div class="form-group">
												<h4 class="fieldname">
													<span class="star-must">*</span>Password:
												</h4>
												<input type="password" name="password" id="password"
													tabindex="2" class="form-control" placeholder="Password">
												<span id="spanpwd" style="color: red;"></span>
											</div>

											<!-- <div class="form-group text-center">
	<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
	<label for="remember"> Remember Me</label>
	</div> -->

											<div class="form-group">
												<div class="row">
													<div class="col-sm-6 col-sm-offset-3">
														<input type="submit" name="login-submit" id="login-submit"
															tabindex="4" class="form-control btn btn-login"
															value="Log In">
													</div>
												</div>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-lg-12">
														<div class="text-center">
															<a href='<spring:url value="/user/reg"></spring:url>'
																tabindex="5" class="forgot-password">New user Sign
																Up Here?</a>
														</div>
													</div>
													<%-- <div class="col-lg-5">
	<div class="text-center">
	<a href='<spring:url value="/user/inprogress"></spring:url>' tabindex="5" class="forgot-password">Forgot Password?</a>
	</div>
	</div> --%>
												</div>
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>

	<div class="container">
		<nav class="navbar navbar-default" id="footer">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 text-center">
						<p>Copyright &copy; Team-9 Brain in Jars</p>
					</div>
				</div>
			</div>
	</div>
	<script>

$("#userName").change(function(){
	validateAlphaNumeric('userName');
});
$("#userName").keyup(function(){
	validateAlphaNumeric('userName');
});

$("#userName").blur(function(){
	validateAlphaNumeric('userName');
});
$("#password").change(function(){
	 validatePassword('password','spanpwd');
});
$("#password").keyup(function(){
	 validatePassword('password','spanpwd');
});
$("#password").blur(function(){
	 validatePassword('password','spanpwd');
});

</script>
</body>
</html>


