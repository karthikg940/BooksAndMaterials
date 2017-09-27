<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<script>
window.history.forward(1);
function noBack(){
	window.history.forward(1);
}
</script>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Issue Tracking</title>
<%-- <link href='<spring:url value="/resources/css/page.css"></spring:url>' rel="stylesheet">
  <script type="text/javascript" src="<spring:url value="/resources/js/validate.js"></spring:url>"></script> --%>
<link
	href='<spring:url value="/resources/css/bootstrap.css"></spring:url>'
	rel="stylesheet">

<!-- Custom CSS -->
<!-- <link href="css/business-casual.css" rel="stylesheet"> -->
<link
	href='<spring:url value="/resources/css/business-casual.css"></spring:url>'
	rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">


</head>

<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();">

	<div class="brand">Issue Tracking</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="index.html">Issue Tracking</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Home</a></li>
					<li><a href='<spring:url value="/user/about"></spring:url>'>About</a>
					</li>
					<li><a href='<spring:url value="/user/contact"></spring:url>'>Contact</a>
					</li>
					<li><a href="<spring:url value="/user/login"></spring:url>">Login</a>
					</li>
					<li><a href="<spring:url value="/user/reg"></spring:url>">Sign
							Up</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<%-- <spring:url value="/resources/img/bootstrap.min.js"></spring:url> --%>
								<img class="img-responsive img-full"
									src='<spring:url value="/resources/img/slide-1.png"></spring:url>'
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="<spring:url value="/resources/img/slide-2.png"></spring:url>"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="<spring:url value="/resources/img/slide-3.jpg"></spring:url>"
									alt="">
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Welcome to</small>
					</h2>
					<h1 class="brand-name">Issue Tracking</h1>
					<hr class="tagline-divider">
				</div>
				<h2 4c741l410 "intro-text text-center>
					About <strong>Issue Tracking</strong>
				</h2>
				<p>A issue tracking system is a software application that keeps
					track of reported software bugs in software development project</p>
			</div>
		</div>

		<div class="row">
			<div class="">
				<div class="col-lg-12"></div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<p>Copyright &copy; Team-9 Brain in Jars</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery 
    <script src="js/jquery.js"></script>-->

	<!-- Bootstrap Core JavaScript 
    <script src="js/bootstrap.min.js"></script>-->

	<!-- Script to Activate the Carousel -->
	<script src='<spring:url value="/resources/js/jquery.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
	<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
