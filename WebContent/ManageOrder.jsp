<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Management</title>
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
		<h1 style="text-align:center">Order #113456</h1>
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
			  		<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="View"></form></td>
				    <td style="text-align:center">Mac Miller</td>
				    <td style="text-align:center">4</td>
				    <td style="text-align:center">The Bourbon Theater</td>
				    <td style="text-align:center">7:00pm</td>
				    <td style="text-align:center">$240.00 ($60 x 4)</td>
   				    <td style="text-align:center">Shipped</td>
   				    <td style="text-align:center"><form action="CancelOrder.jsp"><input type=submit disabled=true value="Cancel" style="background-color:gray"></form></td>	    	
			    </tr>
			    <tr>
			  		<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="View"></form></td>
			  		<td style="text-align:center">6LACK</td>
			  		<td style="text-align:center">6</td>
				    <td style="text-align:center">The Bourbon Theater</td>
				    <td style="text-align:center">7:00pm</td>
				    <td style="text-align:center">$120.00 ($20 x 6)</td>
				    <td style="text-align:center">Processing</td>
				    <td style="text-align:center"><form action="CancelOrder.jsp"><input type=submit value="Cancel" style="background-color:#E73712"></form></td>	    	
			    </tr>
			  	<tr>
				  	<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="View"></form></td>
				  	<td style="text-align:center">Drake</td>
				  	<td style="text-align:center">2</td>
				  	<td style="text-align:center">Pinnacle Bank Arena</td>
				    <td style="text-align:center">9:00pm</td>
				    <td style="text-align:center">$650.00 ($325 x 2)</td>
				    <td style="text-align:center">Processing</td>
				    <td style="text-align:center"><form action="CancelOrder.jsp"><input type=submit value="Cancel" style="background-color:#E73712"></form></td>
			    </tr>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Total </td>
				    <td style="text-align:center">$1010</td>	
			    </tr>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Date Order </td>
				    <td style="text-align:center">1/30/2019</td>	
			    </tr>
		  	</table>
	</body>
</html>