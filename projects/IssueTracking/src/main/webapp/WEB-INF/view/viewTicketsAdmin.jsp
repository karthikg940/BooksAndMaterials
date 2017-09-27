 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Issue Tracking</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <%--  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href='<spring:url value="/resources/css/page.css"></spring:url>' rel="stylesheet"> --%>
  <script type="text/javascript" src="<spring:url value="/resources/js/jquery.min.js"></spring:url>"></script>
  <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
<!--   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
   <link href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>' rel="stylesheet">
     <link href='<spring:url value="/resources/css/page.css"></spring:url>' rel="stylesheet">
  <script type="text/javascript" src="<spring:url value="/resources/js/validate.js"></spring:url>"></script>
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
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
           		 <c:if test="${not empty user.role.functions}">
					<c:forEach items="${user.role.functions}" var="functions">
						<li><a href='<spring:url value="/${user.role.roleName}/${functions.functionName}"></spring:url>'>${functions.functionName}</a></li>
					</c:forEach>
				</c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="<spring:url value="/user/home"></spring:url>"><span class="glyphicon glyphicon glyphicon-home"></span> Home</a></li>
              <li><a href="<spring:url value="/user/about"></spring:url>"><span class="glyphicon glyphicon glyphicon-user"></span> About</a></li>
              <li><a href="<spring:url value="/user/contact"></spring:url>"><span class="glyphicon glyphicon glyphicon-phone-alt"></span> Contact</a></li>
              <li><a href='<spring:url value="/user/logout"></spring:url>'><span class="glyphicon glyphicon glyphicon-log-out"></span> Log Out</a></li>
            </ul>
          </div><!--/.nav-collapse -->
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

					<c:if test="${not empty searchId}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${searchId}
						</div>
					</c:if>

					<c:if test="${not empty searchCategory}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${searchCategory}
						</div>
					</c:if>

					<c:if test="${(not empty searchAll)}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${searchAll}
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
	<a href="#" class="active" id="login-form-link">Search Ticket By Id</a>
	</div>
	</div>
	<hr>
	</div>
	<div class="panel-body">
	<div class="row">
	<div class="col-lg-12">
	<spring:url value="/admin/viewTicketsById" var="path"></spring:url>
	<form id="login-form"  name="myform" method="POST" action="${path}" onsubmit="return searchTicketById()">

	<div class="form-group">
	<input type="text" name="ticketId" id="ticketId" tabindex="1" class="form-control" placeholder="Ticket Id" value="">
	<span id="spanticketId" style="color:red;"></span>
	</div>
	
	<div class="form-group">
	<div class="row">
	<div class="col-sm-5 col-sm-offset-3">
	<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Search Now">
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
	
	<div class="container">
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
	<div class="panel panel-login">
	<div class="panel-heading">
	<div class="row">
	<div class="col-xs-12">
	<a href="#" class="active" id="login-form-link">Search Ticket By Category</a>
	</div>
	</div>
	<hr>
	</div>
	<div class="panel-body">
	<div class="row">
	<div class="col-lg-12">
 	<spring:url value="/admin/viewTicketsByCategory" var="path2"></spring:url>
	<form:form id="login-form"  name="myform" method="POST" action="${path2}" modelAttribute="ticket" onsubmit="return searchTicketByCategory()">

	<div class="form-group">
	<form:select path="category" class="form-control" multiple="false">			  
		<form:option value="" label="--- Select ---" />
		<form:options items="${map}" />
		</form:select>
		<span id="spancategory" style="color:red;"></span>
	</div>
	
	<div class="form-group">
	<div class="row">
	<div class="col-sm-5 col-sm-offset-3">
	<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Search Now">
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
	
	<div>
	<spring:url value="/admin/viewAllTickets" var="path3"></spring:url>
	<form:form id="login-form" name="myform" method="POST" action="${path3}" modelAttribute="ticket">
	<div class="form-group">
	<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
	<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="View All Tickets">
	</div>
	</div>
	</div>
	</form:form>
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

$("#ticketId").change(function(){
	validateTicketId('ticketId');
});
$("#ticketId").keyup(function(){
	validateTicketId('ticketId');
});
$("#ticketId").blur(function(){
	validateTicketId('ticketId');
});
$("#category").change(function(){
	validateCategory('category');
});
$("#category").keyup(function(){
	validateCategory('category');
});

$("#category").blur(function(){
	validateCategory('category');
});
</script>

</body>
</html>