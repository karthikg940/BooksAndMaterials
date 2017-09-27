<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="xmlModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">
    <!-- Modal content-->
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
</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>