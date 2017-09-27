<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Issue Tracking</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
  <link href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>' rel="stylesheet">
  <link href='<spring:url value="/resources/css/page.css"></spring:url>' rel="stylesheet">
  <script type="text/javascript" src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
  <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
  <script type="text/javascript" src="<spring:url value="/resources/js/validate.js"></spring:url>"></script>
  <spring:url value="/user/checkuser/" var="checkuser"></spring:url>
<script>
</script>
<script >
window.history.forward(1);
function noBack(){
	window.history.forward(1);
}
</script>
<style>
</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();">
<div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
  	<h1 style="text-align:center;"><a class="btn btn-primary btn-lg" href="#" role="button">ISSUE TRACKING SYSTEM </a></h1>
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          <!--   <a class="navbar-brand" href="#">Project name</a> -->
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <!-- <li class="active"><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li> -->
            </ul>
            <ul class="nav navbar-nav navbar-right">
           	 <li><a href='<spring:url value="/user/loginhome"></spring:url>'> <span class="glyphicon glyphicon-home"></span>Home</a></li>
              <li><a href='<spring:url value="/user/inprogress"></spring:url>'><span class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
              <li><a href='<spring:url value="/user/about"></spring:url>'><span class="glyphicon glyphicon glyphicon-user"></span> About</a></li>
                <li class="active"><a href="#"><span class="glyphicon glyphicon glyphicon-user"></span>Register</a></li>
            </ul>
          </div><!--/.nav-collapse -->
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

					<c:if test="${not empty success}">
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success! </strong> ${success}
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
	<a href="#" class="active" id="login-form-link">Registration</a>
	</div>
	</div>
	<hr>
	</div>
	<div class="panel-body">
	<div class="row">
	<div class="col-lg-12">
	<spring:url value="/user/registration" var="register"/>
	<form id="login-form" onsubmit="return registerValidate()" name="myform" method="POST" action="${register}" modelAttribute="user">
	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>Full Name:</h4>
	<input type="text" name="fullName" id="fullName" tabindex="1" class="form-control" placeholder="Fullname" value="${user.fullName}">
	<span id="spanfname" style="color:red;"></span>
	</div>

	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>User Name:</h4>
	<input type="text" name="userName" id="userName" tabindex="1" class="form-control" placeholder="Username" value="${user.userName}">
	<span id="spanuname" style="color:red;"></span><span id="spandbuser" style=""></span>
	</div>

	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>Email:</h4>
	<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="${user.email}">
	<span id="spanemail" style="color:red;"></span>
	</div>

	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>Password:</h4>
	<input type="password" name="password" id="password" tabindex="1" class="form-control" placeholder="Password" value="${user.password}">
	<span id="spanpwd" style="color:red;"></span>
	</div>

	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>Confirm Password:</h4>
	<input type="password" name="confirmPassword" id="confirmPassword" tabindex="1" class="form-control" placeholder="Confirm Password">
	<span id="spancpwd" style="color:red;"></span>
	</div>

	<div class="form-group">
	<h4 class="fieldname"><span class="star-must">*</span>Phone Number:</h4>
	<input type="text" name="phoneNumber" id="phoneNumber" tabindex="1" class="form-control" placeholder="Phone Number" value="${user.phoneNumber}">
	<span id="spanphone" style="color:red;"></span>
	</div>

	<div class="form-group">
	<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
	<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
	</div>
	</div>
	</div>

	<div class="form-group">
	<div class="row">
	<div class="col-lg-12">
	<div class="text-center">
	<a href="<spring:url value="/user/login"></spring:url>" tabindex="5" class="forgot-password">Already have account Sign In Here?</a>
	</div>
	</div>
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
$("#fullName").change(function(){
	validateFullName('fullName');
});
$("#fullName").keyup(function(){
	validateFullName('fullName');
});

$("#fullName").blur(function(){
	validateFullName('fullName');
});
$("#userName").change(function(){
	validateAlphaNumeric('userName');
	//checkUser("${checkuser}", 'userName');
});
$("#userName").keyup(function(){
	validateAlphaNumeric('userName');
	//checkUser("${checkuser}", 'userName');
});

$("#userName").blur(function(){
	validateAlphaNumeric('userName');
	//checkUser("${checkuser}", 'userName');
});
$("#email").keypress(function(){
	 validateEmail('email');
	 //checkEmail('email');
});
$("#email").keyup(function(){
	 validateEmail('email');
	// checkEmail('email');
});

$("#email").blur(function(){
	 validateEmail('email');
	 //checkEmail('email');
});
$("#password").change(function(){
	 validatePassword('password','spanpwd');
	 if($("#confirmPassword").val().length!=0){
		 validateConfirmPassword('password','confirmPassword');
	 }
});
$("#password").keyup(function(){
	 validatePassword('password','spanpwd');
	 if($("#confirmPassword").val().length!=0){
		 validateConfirmPassword('password','confirmPassword');
	 }
});
$("#password").blur(function(){
	 validateConfirmPassword('password','spanpwd');
	 if($("#confirmPassword").val().length!=0){
		 validateConfirmPassword('password','confirmPassword');
	 }
});
$("#confirmPassword").change(function(){
	 validateConfirmPassword('password','confirmPassword');
});
$("#confirmPassword").keyup(function(){
	 validateConfirmPassword('password','confirmPassword');
});
$("#confirmPassword").blur(function(){
	 validateConfirmPassword('password','confirmPassword');
});
$("#phoneNumber").keypress(function(){
	 validatePhoneNumber('phoneNumber');
	 //checkEmail('email');
});
$("#phoneNumber").keyup(function(){
	 validatePhoneNumber('phoneNumber');
	 //checkEmail('email');
});

$("#phoneNumber").blur(function(){
	 validatePhoneNumber('phoneNumber+');
	 //checkEmail('email');
});
/* function checkUser(url1, idval) {
	var userName = "";
	userName = document.getElementById(idval).value;
	console.log(userName);
	$
			.ajax({
				type : "POST",
				contentType : "application/json",
				url : url1 + userName,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if (data != "") {
						console.log("successly retrieved");
						document.getElementById("spandbuser").innerHTML = "UserName is unavaible, choose other";
					} else {
						console.log("successly not retrieved");
						document.getElementById("spandbuser").innerHTML = "UserName is available..proceed";
					}

				}
			});
} */
</script>

</body>
</html>
