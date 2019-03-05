<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
	<script>
			function validateForm() {
				console.log("hello0");
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    if (x == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    console.log("hello1");
			    if (y == "") {
			        alert("Password must be filled out");
			        return false;
			    }
			    console.log("hello2");
			}
	</script>
</head>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
			<h1></h1>
		</div>
		<h2 style="text-align:center"> Login </h2>
			
		<form style="text-align:center" name="userForm" action=Login onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName><br>
			<br>
			Password:  <input type=password name=password><br>
			<br>
			<input type=submit value=Login> <br>  		
		</form>
		
		<br>
		<br>
		
		<form style="text-align:center" action="Register.jsp">
			<input type=submit value="Register An Account">
		</form>
	
	</body>
</html>