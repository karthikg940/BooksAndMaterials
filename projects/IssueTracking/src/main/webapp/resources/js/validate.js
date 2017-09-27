
var str="";
var res="";
var fullNameStatus=1;
var emailStatus=1;
var passwordStatus=1;
var userNameStatus=1;
var phoneNumberStatus=1;
var countryStatus=1;
var confirmPasswordStatus=1;
var projectStatus=1;
var descriptionStatus=1;
var categoryStatus=1;
var ticketIdStatus=1;

function validateFullName(id){
	//var reg1=new RegExp(/^[a-zA-Z]+$/)
	var reg1=new RegExp(/^[^-\s\d.][a-zA-Z\d\-_\s.]{0,49}$/)
	var numVal=document.getElementById(id).value;
	console.log(id)
	if(reg1.test(document.getElementById(id).value)){
			fullNameStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spanfname").innerHTML="";	

	
	}else{
			fullNameStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spanfname").innerHTML="Enter Only Alphabets and Numbers..must be less than 50 characters";
		 }
}

function validateAlphaNumeric(id){
	var reg1=new RegExp(/^[^\d][a-z\d]{4,18}$/i);
	var numVal=document.getElementById(id).value;
	console.log(id)
	//alert("outside value"+id+"value"+document.getElementById(id).value+"booloean"+reg1.test(document.getElementById(id).value));
	if(reg1.test(document.getElementById(id).value)){
		if(id=="userName"){
			userNameStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spanuname").innerHTML="";	
		}

	
	}else{
		str+="Enter correct characters only for"+id+"\n";
		 if(id=="userName"){
			 userNameStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spanuname").innerHTML="Enter Only Alphabets and Numbers...must be less than 18 characters";
		 }	
	}
}

function validatePassword(id,spanid){
	//alert("entered password");
	var reg1=new RegExp(/^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{6,18}$/)
	var numVal=document.getElementById(id).value;
	console.log(numVal)
	if(reg1.test(document.getElementById(id).value)==false){
		
			passwordStatus=1;
			document.getElementById(id).style.borderColor="#FF0000";
			document.getElementById(spanid).innerHTML="Password Must Contain Atleast 1 Capital,1 Small,1 Number,1 Special Character..must be 6-8 characters";
		
	}else{
		
			passwordStatus=0;
			document.getElementById(id).style.borderColor="#ccc";
			document.getElementById(spanid).innerHTML="";
		
	}
}

function validateConfirmPassword(pid,cpid){
	var reg1=new RegExp(/^[978]{1}[0-9]{9}$/)
	var password=document.getElementById(pid).value;
	var cpassword=document.getElementById(cpid).value;
	console.log(cpid)
	if(cpassword==password){
			confirmPasswordStatus=0;
			 document.getElementById(cpid).style.borderColor="#ccc";
			 document.getElementById("spancpwd").innerHTML="";	

	
	}else{
			confirmPasswordStatus=1;
			 document.getElementById(cpid).style.borderColor="#FF0000";
			 document.getElementById("spancpwd").innerHTML="Password and Confirm Password Must Match";
		 }
}

function validateEmail(id){
	var reg1=new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)
	var numVal=document.getElementById(id).value;
	console.log(id)
	if(reg1.test(document.getElementById(id).value)){
			emailStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spanemail").innerHTML="";	

	
	}else{
			 emailStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spanemail").innerHTML="Enter Correct Email Format";
		 }
}

function validatePhoneNumber(id){
	var reg1=new RegExp(/^[978]{1}[0-9]{9}$/)
	var numVal=document.getElementById(id).value;
	console.log(id)
	if(reg1.test(document.getElementById(id).value)){
			phoneNumberStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spanphone").innerHTML="";	

	
	}else{
			phoneNumberStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spanphone").innerHTML="Enter Valid Phone Number";
		 }
}

function validateProject(id)
{
var e = document.getElementById(id);
var value = e.selectedIndex;
console.log(value);
console.log(e.options[0]);
if(value!=0)
	{
		projectStatus=0;
		document.getElementById(id).style.borderColor="#ccc";
		document.getElementById("spanproject").innerHTML="";
	}
else
{	 projectStatus=1;
	 document.getElementById(id).style.borderColor="#FF0000";
	 document.getElementById("spanproject").innerHTML="Select Project";
}
}


function validateDescription(id){
	var reg1=new RegExp(/^[^-\s][a-zA-Z\d\-_\s\(\)!@#$%.^&*+\[\]":;\/\\\{\}]{0,200}$/)
	var numVal=document.getElementById(id).value;
	console.log(id)
	if(reg1.test(document.getElementById(id).value)){
			descriptionStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spandescription").innerHTML="";	

	
	}else{
			 descriptionStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spandescription").innerHTML="Give The Description";
		 }
}

function validateCategory(id)
{
var e = document.getElementById(id);
var value = e.selectedIndex;
console.log(value);
console.log(e.options[0]);
if(value!=0)
	{
		categoryStatus=0;
		document.getElementById(id).style.borderColor="#ccc";
		document.getElementById("spancategory").innerHTML="";
	}
else
{	 categoryStatus=1;
	 document.getElementById(id).style.borderColor="#FF0000";
	 document.getElementById("spancategory").innerHTML="Select Category";
}
}

function validateTicketId(id){
	var reg1=new RegExp(/^[0-9]{1,9}$/)
	var numVal=document.getElementById(id).value;
	console.log(id)
	if(reg1.test(document.getElementById(id).value)){
		ticketIdStatus=0;
			 document.getElementById(id).style.borderColor="#ccc";
			 document.getElementById("spanticketId").innerHTML="";	

	
	}else{
		ticketIdStatus=1;
			 document.getElementById(id).style.borderColor="#FF0000";
			 document.getElementById("spanticketId").innerHTML="Ticket Id must have only digits";
		 }
}

function getResult(){
	var res=str;
    str="";
	return res;
}

function loginValidate(){
	
	if(userNameStatus==0 && passwordStatus==0){
		return true;
	}
	if(passwordStatus==1){
		document.getElementById("password").style.borderColor="#FF0000";
		document.getElementById("spanpwd").innerHTML="Password Cannot Be Empty";
	}
	if(userNameStatus==1)
	{
		document.getElementById("userName").style.borderColor="#FF0000";
		document.getElementById("spanuname").innerHTML="UserName Cannot Be Empty";
	}
	return false;
}
function registerValidate(){
	
	if(fullNameStatus==0 && userNameStatus==0 && passwordStatus==0 && confirmPasswordStatus==0 && emailStatus==0 && phoneNumberStaus==0){
		return true;
	}
	if(fullNameStatus=1)
	{
		 document.getElementById("fullName").style.borderColor="#FF0000";
		 document.getElementById("spanfname").innerHTML="Full Name Cannot Be Empty";
	}
	if(userNameStatus==1)
	{
		document.getElementById("userName").style.borderColor="#FF0000";
		document.getElementById("spanuname").innerHTML="UserName Cannot Be Empty";
	}
	if(emailStatus==1)
	{
		 document.getElementById("email").style.borderColor="#FF0000";
		 document.getElementById("spanemail").innerHTML="Email Cannot Be Empty";
	}
	if(passwordStatus==1){
		document.getElementById("password").style.borderColor="#FF0000";
		document.getElementById("spanpwd").innerHTML="Password Cannot Be Empty";
	}
	if(confirmPasswordStatus==1){
		document.getElementById("confirmPassword").style.borderColor="#FF0000";
		document.getElementById("spancpwd").innerHTML="Confirm Cannot Be Empty";
	}
	if(phoneNumberStatus==1)
	{
		document.getElementById("phoneNumber").style.borderColor="#FF0000";
		 document.getElementById("spanphone").innerHTML="Phone Number Cannot Be Empty";
	}
	return false;
}
function ticketValidate()
{
	if(projectStatus==0 && descriptionStatus==0 && categoryStatus==0)
	{
		return true;
	}
	if(projectStatus==1)
	{
		 document.getElementById("project").style.borderColor="#FF0000";
		 document.getElementById("spanproject").innerHTML="Select Project";
	}
	if(descriptionStatus==1)
	{
		 document.getElementById("description").style.borderColor="#FF0000";
		 document.getElementById("spandescription").innerHTML="Give The Description";
	}
	if(categoryStatus==1)
	{
		 document.getElementById("category").style.borderColor="#FF0000";
		 document.getElementById("spancategory").innerHTML="Select Category";
	}
	return false;
}
function searchTicketById()
{
	if(ticketIdStatus==0)
	{
		return true;
	}
	if(ticketIdStatus==1)
	{
		 document.getElementById("ticketId").style.borderColor="#FF0000";
		 document.getElementById("spanticketId").innerHTML="Ticket Id Cannot Be Empty";
	}
	return false;
}
function searchTicketByCategory()
{
	if(categoryStatus==0)
	{
		return true;
	}
	if(categoryStatus==1)
	{
		 document.getElementById("category").style.borderColor="#FF0000";
		 document.getElementById("spancategory").innerHTML="Select Category";
	}
	return false;
}