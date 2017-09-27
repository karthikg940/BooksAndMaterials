
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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href='<spring:url value="/resources/css/page.css"></spring:url>'
	rel="stylesheet">
<script type="text/javascript"
	src="<spring:url value="/resources/js/validations.js"></spring:url>"></script>
<script>
</script>
<style>
</style>
</head>
<body>
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
						<c:if test="${not empty user}">
							<li><a href='<spring:url value="/user/home"></spring:url>'><span
									class="glyphicon glyphicon-home"></span> Home</a></li>
						</c:if>
						<c:if test="${empty user}">
							<li><a
								href='<spring:url value="/user/loginhome"></spring:url>'><span
									class="glyphicon glyphicon-home"></span> Home</a></li>
						</c:if>
						<li class="active"><a
							href='<spring:url value="#"></spring:url>'><span
								class="glyphicon glyphicon-user"></span> About</a></li>
						<li><a href='<spring:url value="/user/contact"></spring:url>'><span
								class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
						<c:if test="${not empty user}">
							<li><a href='<spring:url value="/user/logout"></spring:url>'><span
									class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
						</c:if>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
	</div>

	<div class="container">
		<div class="jumbotron">

			<h3></h3>

		</div>
	</div>

	<div class="container">
		<nav class="navbar navbar-default" id="footer">
			<div class="container-fluid">
				<center>
					<p>>Virtusa</p>
				</center>
		</nav>
	</div>
</body>
</html>