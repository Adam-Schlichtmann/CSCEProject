<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
	
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		
		<div class="topnav">
		  <a href="Login.jsp" style="float:right">Log In</a>
		</div>
		<h1 style="text-align:center"> Registration </h1>
		<script> 
			function validateForm(){
				var x = document.forms["form"]["userName"].value;
				var y = document.forms["form"]["password"].value;
				var z = document.forms["form"]["passwordC"].value;
				var a = document.forms["form"]["fname"].value;
				var b = document.forms["form"]["lname"].value;
				if(x == ""){
					alert("Username must be filled out");
					return false;
				}
				if(y == ""){
					alert("Password must be filled out");
					return false;
				}
				if (z == ""){
					alert("Password Confirmation must be filled out")
					return false;
				}
				if (z != y){
					alert("Passwords did not match")
					return false;
				}
				if (a == ""){
					alert("Enter Firstname")
					return false;
				}
				if (b == ""){
					alert("Enter Lastname")
					return false;
				}
			}
		</script>
		<form style="text-align:center" name="form" onsubmit="return validateForm()" action=Register method="post">
		
			User Name: <input type=text name=userName placeholder="Username"><br>
			<br>
			Password: <input type=password name=password placeholder="Password"><br>
			<br>
			Confirm Password: <input type=password name=passwordC placeholder="Retype Password"><br>
			<br>
			FirstName: <input type=text name=fname placeholder="Firstname"><br>
			<br>
			LastName: <input type=text name=lname placeholder="Lastname"><br>
			<input type=submit value=Register> <br> 
		
		</form>
		
		<br>
		
		<form style="text-align:center" action="Login.jsp">
			<input type=submit value="Return to Login">
		</form>
		
	
	</body>
</html>