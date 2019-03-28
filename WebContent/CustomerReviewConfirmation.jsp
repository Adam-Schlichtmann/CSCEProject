<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <a href="ViewOrders">Orders</a>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp"">Shopping Cart</a>
		</div>
		<div align=center>
			<% if(request.getParameter("status").equals("true")){
				out.print(" Your Review was Successfully Submitted");		
			}else {%>	
			<%
				out.print(request.getParameter("status"));
			}
			%>
			
			<h1>Your Review was Successfully Submitted MAKE SURE ERRORS ARE SHOWN</h1>
			<form action="CustomerHomePage.jsp">
				<input type=submit value="Return to Home Page">
			</form>
		</div>
	</body>
</html>