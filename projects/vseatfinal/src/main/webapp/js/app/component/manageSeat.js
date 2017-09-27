
/*invoking add seat popup*/
function addSeat()
{
       $("#addseatPopup").click(function() 
			{
    	   
                  	 $('#addNewSeat').modal({show: 'false'});
	
			});
 }


/*adding new seat*/
function newSeat() 
{
	$("#addSeat").click(function() 
	{
		var seat=$("#newSeat").val();
		var block=$("#blockId").val();
		var floor=$("#floorNo").val();
		if(seat.length!=0|| block.length!=0||floor.length!=0)
			{
			
		$.ajax({
			         data : JSON.stringify({ "seatName": seat,"blockNo" : block ,
			        	                     "floorNo" : floor,"status"  : $("#newstatus").val()}),            
			         method : "POST",
					 url : "/api/seat",
					 contentType : 'application/json',
					 success : function(data,xhr,status)
					 {
					      alert("Seat Added Successfully");
					 }
			  }); 
			}
		else {
			alert("Please fill all fields");
		}
	  });
}



/*deleting existing seat*/
function deletePop()
{
       $("#delete").click(function() 
			{
                  	 $('#deleteSeat').modal({show: 'false'});
	
			});
 }



/* delete seat */
function deleteSeat() {
	
	$("#deleteseat").click(function() {
		
		$.ajax({
			contentType : 'application/json',
			method : 'GET',
			url : "/api/seat/status/" + $("#delseatname").val(),
			
			success : function(response) {
				var status = response[0];
				console.log(response[0]);
				if (status == "Available" || status == "Available") {
					$.ajax({

						method : "DELETE",
						url : "/api/seat/" + $('#delseatname').val(),
						contentType : 'application/json',
						success : function(response) {
							alert("Seat Deleted Successfully");
						}
					});
				}

				else if (status == "Reserved" || status == "Reserved") {
					alert("Seat is already Reserved can't delete now... ")
				}

				else {
					alert("Seat not available..");
				}
			}
		});
			
	});

}
