
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
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
<link
	href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/page.css"></spring:url>'
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
<%--  <script type="text/javascript" src="<spring:url value="/resources/js/validations.js"></spring:url>"></script> --%>
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
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
								class="glyphicon glyphicon glyphicon-home"></span> Home</a></li>
						<li><a href="<spring:url value="/user/about"></spring:url>"><span
								class="glyphicon glyphicon glyphicon-user"></span> About</a></li>
						<li><a href="<spring:url value="/user/contact"></spring:url>"><span
								class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
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

					<c:if test="${not empty message}">
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success! </strong> ${message}...<a
								href='<spring:url value="/developer/View Tickets"></spring:url>'>Click
								Here To View Tickets</a>
						</div>
					</c:if>

				</div>
				<div class="col-sm-2"></div>

			</div>

			<c:if test="${not empty ticketDeveloperSet}">
				<table id="example" class="table table-hover table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Ticket Id</th>
							<th>Project Id</th>
							<th>Description</th>
							<th>Category</th>
							<th>Raise Date</th>
							<th>Priority</th>
							<th>Status</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Ticket Id</th>
							<th>Project Id</th>
							<th>Description</th>
							<th>Category</th>
							<th>Raise Date</th>
							<th>Priority</th>
							<th>Status</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${ticketDeveloperSet}" var="ticket">
							<spring:url value="/developer/setstatus/${ticket.ticketId}"
								var="path2"></spring:url>
							<tr>
								<td>${ticket.ticketId}</td>
								<td>${ticket.project.projectId}</td>
								<td>${ticket.description}</td>
								<td><c:forEach items="${ticket.category}" var="category">${category.categoryName}</c:forEach></td>
								<td>${ticket.riseDate}</td>
								<td>${ticket.priority.priorityName}</td>
								<td>
									<form method="POST" action="${path2}"
										enctype="multipart/form-data">
										<div class="input-group">
										<input type="file" name="fileUpload" id="fileUpload"
											tabindex="1" class="form-control" placeholder="Upload File"
											value=""> 
											<span class="input-group-btn">
											<input type="submit" name="login-submit"
											id="login-submit" tabindex="1" class="btn btn-primary"
											value="Resolved" onclick="${path2}">
											</span>
										</div>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
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
</body>
</html>