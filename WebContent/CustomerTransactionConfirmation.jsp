<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Confirmation</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <a href="ViewOrders">Orders</a>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="UpdateShoppingCart">Shopping Cart</a>
		</div>
		<h1 style="text-align:center">Confirmation</h1>
		<table style="width:100%">
		  	<tr>
			  	<th></th>
			    <th>Band/Artist</th>
			    <th>Quantity</th> 
			    <th>Venue</th>
			    <th>Time</th>
			    <th>Price</th>
		  	</tr>
		  	<tr>
		  		<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="Details"></form></td>
			    <td style="text-align:center">Mac Miller</td>
			    <td style="text-align:center">14</td>
			    <td style="text-align:center">The Bourbon Theater</td>
			    <td style="text-align:center">7:00pm</td>
			    <td style="text-align:center">$240.00</td>	    	
		    </tr>
		    <tr>
		  		<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="Details"></form></td>
		  		<td style="text-align:center">6LACK</td>
		  		<td style="text-align:center">60</td>
			    <td style="text-align:center">The Bourbon Theater</td>
			    <td style="text-align:center">7:00pm</td>
			    <td style="text-align:center">$120.00</td>		    	
		    </tr>
		  	<tr>
			  	<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"><input type=submit value="Details"></form></td>
			  	<td style="text-align:center">Drake</td>
			  	<td style="text-align:center">4</td>
			  	<td style="text-align:center">Pinnacle Bank Arena</td>
			    <td style="text-align:center">9:00pm</td>
			    <td style="text-align:center">$650.00</td>	    
		    </tr>
		    <tr>
		    	<td style="text-align:center"><form action="ConcertDetailsSelection.jsp"></td>
			  	<td style="text-align:center"></td>
			  	<td style="text-align:center"></td>
			  	<td style="text-align:center"></td>
			  	<td style="text-align:center">Total </td>
			    <td style="text-align:center">$1010</td>	
		    </tr>
	  	</table>
	  	<table style="width:50%">
			<tr>
				<td>
					<form style="text-align:center" name="paymentForm"   >
						<h4>First Name: John</h4>
						<h4>Last Name: Doe</h4>
						<h4>Billing Address:1 A St, Lincoln, NE-68508</h4>
						<h4>Shipping Address:1 A St, Lincoln, NE-68508</h4>
					</form>			
				</td>
			</tr>
		</table>
		<div style="text-align:center; margin:10px;">
			<h1>Your order has been placed!</h1>
		</div>
	</body>
</html>