function loginValidations()
{
	var nameExp = /^[a-zA-Z]+[0-9]*$/;
	var userName=document.myform.userName.value;
	var password=document.myform.password.value;
	var passwordExp=/^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{6,20}$/; 
	
	var msg="";
	 if(userName.length==0)
		{
		 msg=msg+"User Name cannot  be null\n";
		 
		}
	 	
	 else if(nameExp.test(userName)==false)
	 {
		 msg=msg+"user name must be alphabets or alphnumerics\n";
	 }
	 
	 if(password.length==0)
		 {
		 msg=msg+"password  cannot  be null\n";
	 
		 }
	 
	 else if(password.length<7)
		{
			msg = msg + "password length must be greater than 6\n";
		}
	 else if(passwordExp.test(password)==false)
	 {
		 msg=msg+"password must contain one lower case,one number,one upper case and special character!\n";
	 }
	
	 if(msg!="")
	{
		 alert(msg);
		 return false;
	}
 
return true;
}
function registerValidations() {
	var nameExp = /^[a-zA-Z]+[0-9]*$/;
	var fullNameExp = /^[a-zA-Z]+[0-9]*$/;
	var passwordExp = /^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{6,20}$/;
	var emailExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var phoneExp = /^[978][0-9]+$/;

	var fullName = document.myform.fullName.value;
	var userName = document.myform.userName.value;
	var password = document.myform.password.value;
	var confirmPassword = document.myform.confirmPassword.value;
	var email = document.myform.email.value;
	var phone = document.myform.phoneNumber.value;
	var msg = "";

	if (fullName.length == 0) {
		msg = msg + "Full Name cannot  be null\n";

	}

	else if (fullNameExp.test(fullName) == false) {
		msg = msg + "Full name must be alphabets or alphnumerics\n";
	}
	else if(fullName.length>51)
	{
		msg = msg + "Full name length must be less than 50 characters\n";
	}
	if (userName.length == 0) {
		msg = msg + "User Name cannot  be null\n";

	}

	else if (nameExp.test(userName) == false) {
		msg = msg + "user name must be alphabets or alphnumerics\n";
	}
	else if (userName.length>21) {
		msg = msg + "User Name length must be less than 20 characters \n";

	}
	if (password.length == 0) {
		msg = msg + "Password  cannot  be null\n";

	}
	else if (passwordExp.test(password) == false) {
		msg = msg+ "Password must contain one lower case,one number,one upper case and special character!\n";
	} 
	else if (password.length < 7 && password.length>21) {
		msg = msg + "Password length must be greater than 6 and less than 20\n";
	}
	
	else if (password != confirmPassword) {
		msg = msg + "Password and Confirm Password must match!\n";
	}
	if (email.length == 0) {
		msg = msg + "Email not be null\n";
	} 
	else if (emailExp.test(email) == false) {
		msg = msg + "Please Enter Valid Email Id\n";
	}
	else if(email.length>101)
	{
		msg = msg + "Email length must be less than 100\n";
	}
	if (phone.length == 0) {
		msg = msg + "Phone Number not be null\n";
	} 
	else if (phoneExp.test(phone) == false) {
		msg = msg + "Please Enter valid Phone Number\n";
	}
	else if (phone.length != 10) {
		msg = msg + "Phone Number must have 10 digits\n";
	}
	if (msg != "") {
		alert(msg);
		return false;
	}

	return true;

}
function riseTicketValidations() {

//	var projectIdExp = /^[0-9]+$/;
	
//	var projectId = document.myform.projectId.value;
	
	var project=document.getElementById("project").value;
	var description = document.myform.description.value;
	var category=document.myform.category.value;
	var msg = "";
	if(project=="none")
	{
		msg = msg + "Please Select Project\n";
	}
	if (description.length == 0) {
		msg = msg + "Description cannot  be empty\n";
	}
	else if(description.length>=300) 
	{
		msg = msg + "Description should be less than 300 characters\n";
	}
	if(category=="none")
		{
		
		msg = msg + "Please Select Category\n";
		}
	if (msg != "") {
		alert(msg);
		return false;
	}
	return true;

}
function searchTicketById(){
	
	var ticketExp = /^[0-9]+$/;
	var ticketId = document.getElementById("ticketId").value;
	var msg = "";
	if (ticketId.length == 0) {
		msg = msg + "Ticket Id should not be empty\n";
	} 
	else if (ticketExp.test(ticketId) == false) {
		msg = msg + "Ticket Id must be numbers\n";
	}
	else if (ticketId.length>10) {
		msg = msg + "Digits in ticket id must be less than 10\n";
	}
	if (msg!="") {
		alert(msg);
		return false;
	}
	return true;
}
function searchTicketByCategory(){
	var category=document.getElementById("category").value;
	var msg = "";
	if(category=="none"){
		msg = msg + "Please Select Category\n";
	}
	if (msg != "") {
		alert(msg);
		return false;
	}
	return true;
}
/*function validate() {
	//alert("in function");
	var msg = "";
	var email = document.myform.email.value;
	var exp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var nameExp = /^[a-zA-Z]*$/;
	var phoneExp =  /^[978][0-9]+$/;
	var id = /^[0-9]*$/;
	var redirect = false;
	var firstName=document.myform.firstName.value;
	//var lastName=document.myform.lastName.value;
	//var age=document.myform.age.value;
	//var password=document.myform.password.value;
	var phone=document.myform.phone.value;
	var address=document.myform.address.value;
	var studentId=document.myform.studentId.value;
	var count=0;
	if(studentId==null || studentId.length==0)
	{
		msg=msg+"Student Id should not be null\n";
		count=count+1;
	}
	else if(studentId<=0)
	{
		msg=msg+"Student Id must be a Positive Number and greaterthan zero\n";
		count++;
	}
	else if(id.test(studentId)==false && count==0)
	{
		msg=msg+"Student Id must be Numbers\n";
	}
	if(firstName.length==0 )
	{
		msg = msg + "First Name not be null\n";
	}
	else if(nameExp.test(firstName)==false)
	{
		msg = msg + "First Name must be Alphabets\n";
	}
	if(lastName.length==0 )
	{
		msg = msg + "Last Name not be null\n";
	}
	else if(nameExp.test(lastName)==false)
	{
		msg = msg + "Last Name must be Alphabets\n";
	}
	if(age.length==0 )
	{
		msg = msg + "Age not be null\n";
	}
	else if(age<=0 || age >100)
		{
		msg=msg+"Age must greater than zero and lessthan 101\n";
		}
	else if(parseInt(age)=="NaN")
	{
		msg = msg + "Age must be Numbers\n";
	}
	if(email.length==0 )
	{
		msg = msg + "Email not be null\n";
	}
	else if(exp.test(email)==false)
	{
		msg = msg + "Please Enter Valid Email Id\n";
	}
	if(password.length==0 )
	{
		msg = msg + "Password  not be null\n";
	}
	else if(password.length<7)
	{
		msg = msg + "password length must be greater than 6\n";
	}
	if(phone.length==0 )
	{
		msg = msg + "Phone Number not be null\n";
	}
	else if(phone.length!=10)
	{
	msg=msg+"Phone Number must have 10 digits\n";
	}
	else if(phoneExp.test(phone)==false)
	{
		msg = msg + "Please Enter valid Phone Number\n";
	}if(address.length==0 )
	{
		msg = msg + "Address not be null\n";
	}
	function checkTheBox() {
		var flag = 0;
		for (var i = 0; i< 5; i++) {
		if(document.myform["checkbox[]"][i].checked){
		flag ++;
		}
		}
		if (flag == 0) {
		msg=msg+"You must check one and only one checkbox!";
		return false;
		}

	if (firstName == "" || nameexp.test(firstName) == false) {
		msg = msg + "Please Enter " + "Valid First Name\n";
		document.myform.fname.focus();
	}

	if (document.myform.lastName.value == ""
			|| nameexp.test(document.myform.lname.value) == false) {
		msg = msg + "Please Enter Valid" + "Last Name\n";
		document.myform.lname.focus();
	}

	if (document.myform.age.value == "" || isNaN(document.myform.age.value)
			|| document.myform.age.value.length < 0
			|| document.myform.age.value.length > 100) {
		msg = msg + "Please Enter Valid" + "Age\n";
		document.myform.age.focus();
	}

	if (email == "" || exp.test(email) == false) {
		msg = msg + "Please Enter Valid" + "Email\n";
		document.myform.email.focus();
	}

	if (document.myform.password.value == ""
			|| document.myform.password.value < 6) {
		msg = msg + "Please Enter Valid" + "Password\n";
		document.myform.password.focus();
	}

	if (document.myform.phone.value == "" || isNaN(document.myform.phone.value)
			|| document.myform.phone.value.length != 10 ||phexp.test(document.myform.phone.value) == false) {
		msg = msg + "Please Enter Valid " + "Phone Number\n";
		document.myform.phone.focus();
	}

	if (document.myform.address.value == "") {
		msg = msg + " " + " Please enter Valid Address\n";
		document.myform.address.focus();
	}
	var checked=false;
	var elements = document.getElementsByName("checkbox");
	for(var i=0; i < elements.length; i++){
		if(elements[i].checked) {
			checked = true;
		}
	}
	if (!checked) {
		msg=msg+'Please select at least one checkbox\n';
	}
	if (msg != ("")) {
		alert(msg);
		return false;
	} else {
		redirect = true;
		return true;
	}
}*/