<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Lilly External Data Aggregation - POC</title>

    <meta name="description" content="">
    <meta name="author" content="">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>
  
  <%
/*   String NO_OF_FILES=request.getParameter("NO_OF_FILES");
  String NO_OF_INPUT=request.getParameter("NO_OF_FILES");
  String NO_OF_ERRORS=request.getParameter("NO_OF_FILES"); */
  
  Connection con = null;
  try {  
      Class.forName("oracle.jdbc.odbc.JdbcOdbcDriver");  
  }  
  catch(Exception ex){
	  System.out.println("Error: unable to load driver class! " + ex);  
      System.exit(1);  
  }
  
  con = DriverManager.getConnection("jdbc:oracle:thin:@10.5.112.106:1521:XE","LLY_EDA","LLY_EDA");
  
  Statement stmt=con.createStatement();  
  ResultSet rs=stmt.executeQuery("select * from EDA_POC_CLINICAL_STUDY_MASTER");
  while(rs.next())  {
	  System.out.println("No of TPO " + rs.getString(12));
  }
  
  %>

    <!-- <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
					</button> <a class="navbar-brand" href="#"><img src="images/lilly-logo.png"></a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#">Link</a>
						</li>
						<li>
							<a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Separated link</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control">
						</div> 
						<button type="submit" class="btn btn-default">
							Submit
						</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">User Name:Shan</a>
						</li>
						<li >
							<a href="#">Logout</a>
						</li>
					</ul>
				</div>
				
			</nav>
			
			<div class="page-header">
				<h1>
					<small>Page title goes here...</small>
				</h1>
			</div>
			<p>
			 <div class="table-responsive">
				<table class="table table-hover">
					<thead>
					  <tr>
						<th>Date TimeStamp</th>
						<th class="text-center">No. of input XMLs</th>
						<th class="text-center">No. of input Aggregated</th>
						<th class="text-center">No. of Errors/ Info</th>
						<th class="text-center">Aggregated File</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>08/09/2016 11.00</td>
						<td class="text-center"><%= rs.getString(1) %></td>
						<td class="text-center"><%= rs.getString(1) %></td>
						<td class="text-center"><a href="#"><%= rs.getString(1) %></a></td>
						<td class="text-center">
							<a href="#" >
								<img src="images/xml-icon.png" class="w_30">
							</a>
						</td>
					  </tr>
					  <tr>
						<td>08/09/2016 13.00</td>
						<td class="text-center">TPO 2 (1)</td>
						<td class="text-center">1</td>
						<td class="text-center"><a href="#">0</a></td>
						<td class="text-center"><a href="#"><img src="images/xml-icon.png" class="w_30"></a></td>
					  </tr>
					  <tr>
						<td>08/10/2016 14:00</td>
						<td class="text-center">TPO 3 (5)</td>
						<td class="text-center">3</td>
						<td class="text-center"><a href="#" data-toggle="modal" data-target="#xmlModal">2</a></td>
						<td class="text-center"><a href="#"><img src="images/xml-icon.png" class="w_30"></a></td>
					  </tr>
					  <tr>
						<td>08/11/2016 13.00</td>
						<td class="text-center">TPO 4 (1)</td>
						<td class="text-center">1</td>
						<td class="text-center"><a href="#">0</a></td>
						<td class="text-center"><a href="#"><img src="images/xml-icon.png" class="w_30"></a></td>
					  </tr>
					  <tr>
						<td>08/12/2016 14:00</td>
						<td class="text-center">TPO 5 (2)</td>
						<td class="text-center">3</td>
						<td class="text-center"><a href="#">2</a></td>
						<td class="text-center"><a href="#"><img src="images/xml-icon.png" class="w_30"></a></td>
					  </tr>
					</tbody>
				</table>
				</div>
				<div class="text-center">
					<ul class = "pagination">
					   <li><a href = "#">Previous</a></li>
					   <li class = "active"><a href = "#">1</a></li>
					   <li><a href = "#">2</a></li>
					   <li><a href = "#">3</a></li>
					   <li><a href = "#">4</a></li>
					   <li><a href = "#">5</a></li>
					   <li><a href = "#">Next</a></li>
					</ul>
				</div>
			</p>
		</div>
	</div>
</div>
Modal
<div id="xmlModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">
    Modal content
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Error Details</h4>
      </div>
      <div class="modal-body">
        <p>
		<div class="table-responsive">
				<table class="table table-hover">
					<thead>
					  <tr>
						<th>Date TimeStamp</th>
						<th class="text-center">TPO Name</th>
						<th class="text-center">Error Description</th>
						<th class="text-center">Input File</th>						
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>08/10/2016 14:00</td>
						<td class="text-center">TPO 3</td>
						<td class="text-center">Invalid Height Measurement</td>
						<td class="text-center">
							<a href="#" data-toggle="modal" data-target="#viewxmlModal">
								<img src="images/xml-icon.png" class="w_30">
							</a>
						</td>
					  </tr>
					  <tr>
						<td>08/10/2016 17:00</td>
						<td class="text-center">TPO 3</td>
						<td class="text-center">Invalid BP value</td>
						<td class="text-center">
							<a href="#" >
								<img src="images/xml-icon.png" class="w_30">
							</a>
						</td>
					  </tr>

					  
					</tbody>
				</table>
				</div>
		</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>