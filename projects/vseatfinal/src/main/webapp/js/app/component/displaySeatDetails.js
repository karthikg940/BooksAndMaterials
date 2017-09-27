/*display seats based only on block */
function displaySeatByBlock() 
{
	    var eachrow="";
		var $block = $("#block").val();
		$.ajax({
					contentType : 'application/json',
					method : "GET",
					url : "/api/seat/blockno/" +$block+"/seats",
					success : function(response) 
					{
						createTable(response);
					}
		    });   
}

/*display seats based on block and floor */
function displaySeatByBlockAndFloor() 
{
	    var eachrow="";
	    var $block = $("#block").val();
		var $floor = $("#floor").val();
		$.ajax({
					contentType : 'application/json',
					method : "GET",
					url : "/api/seat/block/" +$block+"/floor/"+$floor,
					success : function(response) 
					{
						createTable(response);
				    }
		    });   
}

/*display seats in given RANGE */
function displaySeatInGivenRange() 
{
	    var eachrow="";
		var $startSeatfl = $("#startseat").val();
		var $endSeatfl = $("#endseat").val();
		$.ajax({
					contentType : 'application/json',
					method : "GET",
					url : "/api/seat/start/"+$startSeatfl+"/end/"+$endSeatfl,
					success : function(response) 
					{ 
						if(response.length>0){
							createTable(response); 
						}
						else
						{
							 $("#displayseat").hide();
							 alert("Please Enter Valid SeatName" + "\n"+"Ex: DM7xxx or DM5xxx or DM1xxx");
						}
				    }
		
		      });   
}


/*display seats based on BLOCK and RANGE */
function displaySeatByBlockAndRange() 
{
	    var eachrow="";
	    var $startSeat = $("#startseat").val();
		var $endSeat = $("#endseat").val();
		var $block = $("#block").val();
		$.ajax({
					contentType : 'application/json',
					method : "GET",
					url : "/api/seat/block/"+$block+"/range/start/"+$startSeat+"/end/"+$endSeat,
					success : function(response) 
					{
						if(response.length>0)
						{
							createTable(response); 
					    }
					     else
			            {
							 $("#displayseat").hide();
							 alert("Please Enter Valid SeatName" + "\n"+"Ex: DM7xxx or DM5xxx or DM1xxx");
					    }
				    }
		    });   
}

/*display seats in given RANGE based on BLOCK and FLOOR */
function displaySeatInGivenBFR() 
{
	    var eachrow="";
		var $startSeat = $("#startseat").val();
		var $endSeat = $("#endseat").val();
		var $block = $("#block").val();
		var $floor= $("#floor").val();
		$.ajax({
					contentType : 'application/json',
					method : "GET",
					url : "/api/seat/block/"+$block+"/floor/"+$floor+"/range/start/"+$startSeat+"/end/"+$endSeat,
					success : function(response) 
					{
						if(response.length>0)
						{
							createTable(response); 
					    }
					     else
			            {
							 $("#displayseat").hide();
							 alert("Please Enter Valid SeatName" + "\n"+"Ex: DM7xxx or DM5xxx or DM1xxx");
					    }
				    }
		    });   
}
