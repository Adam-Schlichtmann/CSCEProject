<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel Order</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <form action="ViewOrders"><input type=submit value="Orders"></form>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</div>
		<h1 style="text-align:center">Order Cancellation</h1>
		<img src="Pics/Drake.jpg" alt="Drake" style="display:block; margin:auto auto; width:200px; height:200px"></img>
		<br>
		<table style="width:100%" align="center">
		  	<tr>
			  	<th></th>
			    <th>Band/Artist</th>
			    <th>Quantity</th> 
			    <th>Venue</th>
			    <th>Time</th>
			    <th>Price</th>
			    <th>Status</th>
			    <th></th>
		  	</tr>
		  	<tr>
		  		<td></td>
			  	<td style="text-align:center">Drake</td>
			  	<td style="text-align:center">2</td>
			  	<td style="text-align:center">Pinnacle Bank Arena</td>
			    <td style="text-align:center">9:00pm</td>
			    <td style="text-align:center">$650.00 ($325 x 2)</td>
			    <td style="text-align:center">Processing</td>
		    </tr>

	  	</table>
	  	<div style="text-align:center; margin:10px;">
			<form action="CustomerHomePage.jsp">
				<input type=submit value="Discard Cancellation">
			</form>
			<br>
			<form action="CancellationConfirmation.jsp">
				<input  type=submit value="Confirm Cancellation" >	
			</form>
		</div>
	</body>
</html>