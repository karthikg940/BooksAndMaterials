var attempt = 5; // Variable to count number of attempts.
function validate()
{
		var username = document.getElementById("uname").value;
		var password = document.getElementById("pass").value;
		if(username=="" && password=="")
		{
			alert("Please fill the fields")
		}
		else if ( username == "admin" && password == "admin" ||username == "ADMIN" && password == "ADMIN" )
		{
			window.location = "index.html";
			return false;
	    }
	    else
	    {
			attempt --;// Decrementing by one.
			alert("Login Failed...!!!" + "\n"+" You have "+attempt+" attempt left");
	
			// Disabling fields after 3 attempts.
        	if( attempt == 0)
        	{
				document.getElementById("uname").disabled = true;
				document.getElementById("pass").disabled = true;
				document.getElementById("submit").disabled = true;
				return false;
	        }
	    }
		
}