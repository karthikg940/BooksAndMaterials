
function validateUserEntry() 
{
	$('#search').on('click',function() 
	{
				var startseat = $('#startseat').val();
				var endseat = $('#endseat').val();
				var block = $('#block').val();
				var floor = $('#floor').val();
				
				if (block.length == 0 && floor.length == 0 && startseat.length == 0 && endseat.length == 0) 
				{
				    $("#displayseat").hide();
					alert("Search FAILED ...! Please Enter Some Values")
				} 
				else if (block.length >= 1 && floor.length == 0 && startseat.length == 0 && endseat.length == 0) 
				{
					/*display seats based only on block */
					displaySeatByBlock();
				} 
				else if (block.length >= 1 && floor.length >= 1 && startseat.length == 0 && endseat.length == 0) 
				{
					/*display seats based on block and floor */
					displaySeatByBlockAndFloor();
				}
				else if (block.length == 0 && floor.length == 0 && startseat.length >= 1 && endseat.length >= 1) 
				{
					/*display seats in given RANGE */
					displaySeatInGivenRange();
				}
				else if (block.length >= 1 && floor.length == 0 && startseat.length >= 1 && endseat.length >= 1 ) 
				{
					/*display seats based on BLOCK and RANGE */
					displaySeatByBlockAndRange();
				}
				else if (block.length >= 1 && floor.length >= 1 && startseat.length >= 1 && endseat.length >= 1)
				{
					/*display seats in given RANGE based on BLOCK and FLOOR */
					displaySeatInGivenBFR(); 
				}
				else if (  block.length == 0 && floor.length == 0 && startseat.length >= 1 && endseat.length == 0 || block.length == 0 && floor.length == 0 && startseat.length == 0 && endseat.length >= 1|| block.length >= 1 && floor.length == 0 && startseat.length >= 1 && endseat.length == 0 
						 || block.length >= 1 && floor.length == 0 && startseat.length == 0 && endseat.length >= 1 || block.length == 0 && floor.length >= 1 && startseat.length >= 1 && endseat.length == 0|| block.length == 0 && floor.length >= 1 && startseat.length == 0 && endseat.length >= 1
						 || block.length >= 1 && floor.length >= 1 && startseat.length >= 1 && endseat.length == 0 || block.length >= 1 && floor.length >= 1 && startseat.length == 0 && endseat.length >= 1|| block.length >= 1 && floor.length >= 1 && startseat.length >= 1 && endseat.length == 0 
						 || block.length >= 1 && floor.length >= 1 && startseat.length == 0 && endseat.length >= 1) 
				{
					$("#displayseat").hide();
					alert("Missing StartSeat/EndSeat...!")
				}
				else{
					$("#displayseat").hide();
					alert("OOPS...Something Went Wrong..!!")	
				}
			});
			
	$('#allocateSeat').on('click',function() 
			{
				var regEmpId = $('#regEmpId').val();
				var regStartDate = $('#regStartDate').val();
				var regEndDate = $('#regEndDate').val();
				
				if (regEmpId.length == 0 || regStartDate.length == 0 || regEndDate.length == 0) 
				{
					alert("PLEASE SET ALL FIELDS ...!!! ");
				} 
			});

	
}


