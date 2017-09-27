<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
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

					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${error}
						</div>
					</c:if>
				</div>
				<div class="col-sm-2"></div>

			</div>

			<c:if test="${not empty ticketAdminList}">
				<spring:url value="/admin/setdeveloper" var="path2"></spring:url>
				<form:form method="POST" action="${path2}">
					<table id="example" class="table table-hover table-bordered"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Ticket Id</th>
								<th>Project Id</th>
								<th>Description</th>
								<th>Category</th>
								<th>Raise Date</th>
								<th>Status</th>
								<th>Priority</th>
								<th>Assign Developer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ticketAdminList}" var="ticket">
								<tr>
									<td>${ticket.ticketId}</td>
									<td>${ticket.project.projectId}</td>
									<td>${ticket.description}</td>
									<td><c:forEach items="${ticket.category}" var="category">${category.categoryName}</c:forEach></td>
									<td>${ticket.riseDate}</td>
									<td>${ticket.status.statusName}</td>
									<td>${ticket.priority.priorityName}</td>
									<td><label><input type="checkbox"
											value="${ticket.ticketId}" name="${ticket.ticketId}"></label></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<input type="submit" name="login-submit" id="login-submit"
								tabindex="4" class="form-control btn btn-login" value="Submit">
						</div>
						<div class="col-sm-4"></div>
					</div>
				</form:form>
			</c:if>
		</div>
	</div>

	<div class="container">
		<nav class="navbar navbar-default" id="footer">
			<div class="container-fluid">
				<center>
					<p class="text-muted">Place sticky footer content here.</p>
					<center>
			</div>
	</div>
</body>
</html>
</body>
</html>