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
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
<script
	src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
<link
	href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/page.css"></spring:url>'
	rel="stylesheet">
<script type="text/javascript"
	src="<spring:url value="/resources/js/validate.js"></spring:url>"></script>
<script>
	
</script>
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

		<!-- Static navbar -->
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
						<c:if test="${not empty user.role.functions}">
							<c:forEach items="${user.role.functions}" var="functions">
								<li><a
									href='<spring:url value="/${user.role.roleName}/${functions.functionName}"></spring:url>'>${functions.functionName}</a></li>
							</c:forEach>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a
							href="<spring:url value="/user/home"></spring:url>"><span
								class="glyphicon glyphicon glyphicon-user"></span> Home</a></li>
						<li><a href="<spring:url value="/user/about"></spring:url>"><span
								class="glyphicon glyphicon glyphicon-user"></span> About</a></li>
						<li><a href="<spring:url value="/user/contact"></spring:url>">Contact</a></li>
						<li><a href='<spring:url value="/user/logout"></spring:url>'><span
								class="glyphicon glyphicon glyphicon-log-out"></span> Log Out</a></li>
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
										<a href="#" class="active" id="login-form-link">Raise
											Ticket</a>
									</div>
								</div>
								<hr>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<spring:url value="/user/ticketdetails" var="path"></spring:url>
										<form:form id="login-form" onsubmit="return ticketValidate()"
											name="myform" method="POST" action="${path}"
											modelAttribute="ticket">

											<div class="form-group">
												<h4 class="fieldname">
													<span class="star-must">*</span>Project Name:
												</h4>
												<!-- 	<input type="text" name="projectId" id="projectId" tabindex="1" class="form-control" placeholder="Project Id" value=""> -->
												<form:select path="project" id="project"
													class="form-control" multiple="false">
													<form:option value="none" label="--- Select ---" />
													<form:options items="${projectMap}" />
												</form:select>
												<span id="spanproject" style="color: red;"></span>
											</div>

											<div class="form-group">
												<h4 class="fieldname">
													<span class="star-must">*</span>Description:
												</h4>
												<textarea name="description" id="description" rows="3"
													tabindex="2" class="form-control" placeholder="Description"></textarea>
												<span id="spandescription" style="color: red;"></span>
											</div>

											<div class="form-group">
												<h4 class="fieldname">
													<span class="star-must">*</span>Category:
												</h4>
												<form:select path="category" id="category"
													class="form-control" multiple="false">
													<form:option value="none" label="--- Select ---" />
													<form:options items="${categoryMap}" />
												</form:select>
												<span id="spancategory" style="color: red;"></span>
											</div>

											<div class="form-group">
												<div class="row">
													<div class="col-sm-6 col-sm-offset-3">
														<input type="submit" name="login-submit" id="login-submit"
															tabindex="4" class="form-control btn btn-login"
															value="Raise Now">
													</div>
												</div>
											</div>
										</form:form>

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
		</nav>
	</div>

	<script type="text/javascript">
		$("#project").change(function() {
			validateProject('project');
		});
		$("#project").keyup(function() {
			validateProject('project');
		});

		$("#project").blur(function() {
			validateProject('project');
		});
		$("#description").change(function() {
			validateDescription('description');
		});
		$("#description").keyup(function() {
			validateDescription('description');
		});

		$("#description").blur(function() {
			validateDescription('description');
		});
		$("#category").change(function() {
			validateCategory('category');
		});
		$("#category").keyup(function() {
			validateCategory('category');
		});

		$("#category").blur(function() {
			validateCategory('category');
		});
	</script>

</body>
</html>