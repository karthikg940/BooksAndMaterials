<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Issue Tracking</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<link
	href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/page.css"></spring:url>'
	rel="stylesheet">
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
<script>
	
</script>
<script>
	window.history.forward(1);
	function noBack() {
		window.history.forward(1);
	}
</script>
<style>
/* .glyphicon.glyphicon-user {
    font-size: 20px;
}
 */
.v4-tease {
	display: block;
	padding: 15px 20px;
	font-weight: bold;
	font-size: 30px;
	color: #fff;
	text-align: center;
	background-color: #0275d8;
}

h3 {
	color: #337AB7;
	text-shadow: 0.5px 0px 0.5px gray;
}

p {
	color: #555;
	text-shadow: 0.1px 0px 0.1px gray;
}
</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();">
	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<h1 style="text-align: center;">
				<a class="btn btn-primary btn-lg" href="#" role="button">ISSUE
					TRACKING SYSTEM </a>
			</h1>
			<!-- <a href="" class="v4-tease">ISSUE TRACKING</a> -->
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
						<c:if test="${not empty user.role.functions}">
							<c:forEach items="${user.role.functions}" var="functions">
								<li><a
									href='<spring:url value="/${user.role.roleName}/${functions.functionName}"></spring:url>'>${functions.functionName}</a></li>
							</c:forEach>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a
							href='<spring:url value="/user/home"></spring:url>'><span
								class="glyphicon glyphicon-home"></span> Home</a></li>
						<li><a href='<spring:url value="/user/about"></spring:url>'><span
								class="glyphicon glyphicon-user"></span> About</a></li>
						<li><a href='<spring:url value="/user/contact"></spring:url>'><span
								class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
						<li><a href='<spring:url value="/user/logout"></spring:url>'><span
								class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
	</div>

	<div class="container">
		<div class="jumbotron">

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8"></div>
				<div class="col-sm-2">
					<span class="glyphicon glyphicon-user"></span><strong> Hi,</strong>${user.fullName}
				</div>
			</div>

			<div class="row">

				<div class="col-sm-1"></div>

				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-3">
							<img
								src="<spring:url value="/resources/img/logo1.png"></spring:url>"
								alt="Smiley face" width="100" height="100">
						</div>
						<div class="col-sm-9">
							<h3>What is a Ticket?</h3>
						</div>
						<div class="row"></div>
						<div class="row">
							<p>A ticket element, within an issue tracking system, is a
								running report on a particular problem, its status, and other
								relevant data</p>
						</div>
					</div>
				</div>


				<div class="col-sm-1"></div>

				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-3">
							<img
								src="<spring:url value="/resources/img/logo4.png"></spring:url>"
								alt="Smiley face" width="100" height="100">
						</div>
						<div class="col-sm-9">
							<h3>How to Raise a Ticket?</h3>
						</div>
						<div class="row"></div>
						<div class="row">
							<p>To raise a ticket you need to have an account. Login to
								the site and click on Submit a Ticket. Select your category and
								enter your summary and description. When you've completed
								entering your information, click Submit.</p>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">

				<div class="col-sm-1"></div>

				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-3">
							<img
								src="<spring:url value="/resources/img/logo2.png"></spring:url>"
								alt="Smiley face" width="100" height="100">
						</div>
						<div class="col-sm-9">
							<h3>What are Ticket Priorities?</h3>
						</div>
						<div class="row"></div>
						<div class="row">
							<p>Include as much information as possible in your ticket so
								that our Support team can give you the best help. Depending on
								the information given by you, the tickets are set with the
								priority levels high, medium or low.</p>
						</div>
					</div>
				</div>


				<div class="col-sm-1"></div>

				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-3">
							<img
								src="<spring:url value="/resources/img/logo3.png"></spring:url>"
								alt="Smiley face" width="100" height="100">
						</div>
						<div class="col-sm-9">
							<h3>About Ticket Status?</h3>
						</div>
						<div class="row"></div>
						<div class="row">
							<p>There are three different status tags that are provided by
								our Support team while solving your tickets, which
								are Open,Pending and Completed</p>
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
		</nav>
	</div>
</body>
</html>