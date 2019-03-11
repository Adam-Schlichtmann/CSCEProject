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
		  <form action="ViewOrders"><input type=submit value="Orders"></form>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
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
    		    <c:forEach items="${items}" var="items">
			        <tr>
			        	<td style="text-align:center"><form action=ConcertSearchResult >
			        	<input type="hidden" name="venueID" value="${concert.getP().getVenueID()}">
			        	<button name="detailsButton" type=submit value="${concert.getP().getId()}">View Concert Details</button></form></td>
			            <td>${item.getC().getConcertName()} </td>
			            <td>${item.getP()}</td>
			            <td>${item.getV().getAddress()}</td>
			            <td>${item.getP().getStarTime()}</td>
			            <td>${item.getT().getTicketPrice()}</td>
			        </tr>
		   		</c:forEach>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Total </td>
				    <td style="text-align:center">${orders.getTotalCost() }</td>	
			    </tr>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Date Order </td>
				    <td style="text-align:center">${orders.getOrderDate()</td>	
			    </tr>
		  	</table>
	</body>
</html>