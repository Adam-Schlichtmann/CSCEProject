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
			  	<td style="text-align:center">${orderItem.cpt.c.getConcertName()}</td>
			  	<td style="text-align:center">${orderItem.getQuantity()}</td>
			  	<td style="text-align:center">${orderItem.cpt.v.getName()}</td>
			    <td style="text-align:center">${orderItem.cpt.p.getStartTime()}</td>
			    <td style="text-align:center">$ ${orderItem.getTotalPrice()}</td>
			    <td style="text-align:center">${ orderItem.processed ? 'Processed' : 'Processing'}</td>
		    </tr>

	  	</table>
	  	<div style="text-align:center; margin:10px;">
			<form action="ManageOrder">
				<button name="orderID" type=submit value="${orderItem.getOrderId()}" ${ orderItem.processed ? 'disabled="disabled"' : ''} >Discard Cancellation</button>
			</form>
			<br>
			<form action="CancelOrderTransaction">
				<button name="orderID" type=submit  value="${orderItem.getId()}" ${ orderItem.processed ? 'disabled="disabled"' : ''} >Confirm Cancellation</button>
			</form>
		</div>
	</body>
</html>