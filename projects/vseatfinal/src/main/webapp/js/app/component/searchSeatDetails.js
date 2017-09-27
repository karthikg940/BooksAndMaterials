/*show and hide table*/
function showTable()
{
    $("#displayseat").hide();
    $("#search").click(function()
    {
		$("#displayseat").show();
    });
    $("#homeicon").click(function()
    {
    	 location.reload();
    	 window.location.href = 'index.html';
         return false;
     });
    $('#submit').click(function() {
        window.location.href = 'index.html';
        return false;
    });
    $('#login').click(function() {
        window.location.href = 'index.html';
        return false;
    });
}

/*find floor based on block*/
function findFloorByBlock() {
	$("#block").change(function() 
	{
		$.ajax({
			       contentType : 'application/json',
			       method : "GET",
			       url : "/api/seat/blockno/" + $("#block").val()+"/floor",
			       success : function(response) 
			       {
			    	   $('#floor').empty();
			    	   $('#floor').append($('<option></option>'))
			    	   $.each(response, function(key, value) 
			    	   {
					       $('#floor').append($('<option></option>',{
			
					   }).text(value));
				});

			      }
		});

	});
}

/* Edit Button Action */
function seatAction(){
	var empId;
	var empname;
	var project;
	var email;
	
	   $("#displayseat,#edit").click(function ()
		{    
		   var table=$("#displayseat,#edit");
		   table.find('tr').click(function () 
		   {
			    var $tds = $(this).find('td');
		        var $seatNo = $tds.eq(1).text();
		        var $status = $tds.eq(4).text();
		         
		        if($status=="Reserved" || $status=="reserved")
		          {
		        	
		        	$.ajax({
								method : "GET",
								url : "/api/allocation/getDetails/seat/" + $seatNo,
								contentType : 'application/json',
						        success : function(response) 
						        {
						         	$.each(response, function(index, item) 
						         	{
						         	   empId = item[0];
									   empname = item[1];
									   project = item[2];
									   email = item[3];
							        });
						         	$("#displayPopSid").attr("value", $seatNo);
						         	$("#displayPopEid").attr("value", empId);
						         	$("#displayPopEname").attr("value", empname);	
						         	$("#displayPopProject").attr("value", project);
						         	$("#displayPopEmail").attr("value", email);
						            $('#detailsModal').modal({show: 'false'});
						         	console.log("showing detailsModal");
						        }

					      });
		        	 
		          }
		          else if ($status == "available" || $status == "Available") 
				  {
						$("#regSeatId").attr("value",$seatNo);
						
			            $('#registrationModal').modal({show: 'false'}); 
			            console.log("showing registrationModal");
				  }
		          else
		          {
		        	 alert("Something Went Wrong...!!!")
		          }
		   });
		   
		});
}	

/*allocate new Seat*/
function allocateNewSeat() 
{
	console.log("hai");
	var $startSeat=$("#startseat").val();
	var $endSeat=$("#endseat").val();
	var $block=$("#block").val();
	var $floor=$("#floor").val();
	$("#allocateSeat").click(function() 
	{
		$.ajax({
			         data : JSON.stringify({"empId" : $("#regEmpId").val(),"seatName": $("#regSeatId").val(),
			        	    "startDate" : $("#regStartDate").val(),"endDate" : $("#regEndDate").val() }),
			        	                   
					 method : "POST",
					 url : "/api/allocation/create",
					 contentType : 'application/json',
					 success : function(response)
					 {
					       alert("Allocated Successfully");	
					       updateStatusToReserved();  
					       clearModal("#registrationModal");
					  }
		              
			     });
	  });
}

/*update status after allocation */
function updateStatusToReserved() 
{     
	 $.ajax({
		        method : "POST",
				url : "/api/allocate/status/seat/" + $("#regSeatId").val(),
				success : function(response) 
				 {
				     console.log("status updated to 'Reserved' ");
				     changeStatusToReserved(newObject);
				 }         
		   });        
}

function changeStatusToReserved(obj)
{
	$(obj).closest('tr').find('td').eq(3).text("Reserved");
   }

/*deAllocate*/
function deAllocate() {
		$('#deallocate').on('click', function() {
			           if (confirm("Do You Want To Deallocate..?")) 
			           {
				          $.ajax({
										method : "POST",
										url : "/api/allocation/delete/seat/" + $("#displayPopSid").val(),
										contentType : 'application/json',
										success : function(response)
									{
											console.log("Deallocated");
											updateStatusToAvailable(); 
										}
				                 });
			             }
		         });
}

/*update status after DeAllocation*/
function updateStatusToAvailable() {
	 $.ajax({
		        method : "POST",
				url : "/api/deallocate/status/seat/" + $("#displayPopSid").val(),
				success : function(response) 
				 {
				     console.log("status updated to 'Available'");
				     changeStatusToAvailable(newObject);
				   
				 }         
		     });        
}

function changeStatusToAvailable(obj)
{
	$(obj).closest('tr').find('td').eq(3).text("Available");

}

/*clear pop up fields after allocation*/
function clearModal(modal){
    $("input:not(:first)", modal).each(function()
    {
	    var type = this.type;
	    var tag = this.tagName.toLowerCase();
    	if (type == 'text' || type == 'date')
    	{
    	   this.value = "";
    	}
    });
};

/*clear cached data in popup if press cancel*/
function clear(){
	
     $("#registrationModal").on("hidden.bs.modal", function() 
     {
		clearModal("#registrationModal")
	 });
}

/*dispaly Search Result Using dataTable */
function createTable(result)
{
    var seatResult = {"results":result};	
    obj = seatResult.results;
    $('#displaySeat').DataTable({
         "data"  : seatResult.results,
  		"bDestroy":true,
      "bProcessing": true,
          "columns":
        	  [
              { "title": "Seat_No" },
              { "title": "Block_no" },
              { "title": "Floor_no" },
              { "title": "Status" },
  			  {
            	 "title":"Actions",
                  data: null,
                  className: "center",
                  defaultContent:'<button type="submit" id="tableUpdatebutton" class="btn btn-primary" >Edit</button>'
              }
          ]
      });

    
	$('#displaySeat, #tableUpdatebutton').on('click', 'tr', function () 
	{
		window.table = $('#displaySeat').DataTable();
		window.newObject=$(this);
	    var rowId = table.row(this).data();
	   
	    
	    var changeStatus = $(newObject).closest('tr').find('td').eq(3).html();
	   
	     if(changeStatus =='Reserved'||changeStatus=='reserved')
	    {
	    	$.ajax({
				method : "GET",
				url : "/api/allocation/getDetails/seat/" + rowId[0],
				contentType : 'application/json',
		        success : function(response) 
		        {
		         	$.each(response, function(index, item) 
		         	{
		         	   empId = item[0];
					   empname = item[1];
					   project = item[2];
					   email = item[3];
			        });
		         	$("#displayPopSid").attr("value", rowId[0]);
		         	$("#displayPopEid").attr("value", empId);
		         	$("#displayPopEname").attr("value", empname);	
		         	$("#displayPopProject").attr("value", project);
		         	$("#displayPopEmail").attr("value", email);
		            $('#detailsModal').modal({show: 'false'});
		         
		         	console.log("showing detailsModal");
		        }

	      });
	    	  
	    }
	     else if(changeStatus=='Available'||changeStatus=='available')
	    {
	    	$("#regSeatId").attr("value",rowId[0]);
	    	$('#registrationModal').modal({show: 'false'}); 
        }
	});
}      

function dataTable()
{
	$('#displaySeat').on('click', 'tr', function() 
	{
		var table = $('#displaySeat').DataTable();
	});	 
}