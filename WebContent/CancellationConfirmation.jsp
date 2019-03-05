<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel Confirmation</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <a href="ViewOrders.jsp">Orders</a>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="VewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</div>
		<h1 style="text-align:center">Cancellation Confirmation</h1>
		<img src="Pics/Drake.jpg" alt="Drake" style="display:block; margin:auto auto; width:200px; height:200px"></img>
		<form style="text-align:center" name="paymentForm"   >
			<h4>Band/Artist: Drake</h4>
			<h4>Quantity : 2</h4>
			<h4>Venue : Pinnacle Bank Arena</h4>
			<h4>Time : 9:00pm</h4>
			<h4>Paid Total : $650</h4>
			<h4>Deposit : $100</h4>
			<h4>Refund Amount : $550</h4>
			<h4 style="color:yellow">Status: Cancelled, Processing Refund</h4>
		</form>
	</body>
</html>