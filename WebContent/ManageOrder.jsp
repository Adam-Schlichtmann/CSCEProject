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
		<h1 style="text-align:center">Order #${orders.getId() }</h1>
		<table style="width:100%" align="center">
			  	<tr>
				    <th>Band/Artist</th>
				    <th>Quantity</th> 
				    <th>Venue</th>
				    <th>Time</th>
				    <th>Price</th>
				    <th></th>
			  	</tr>
    		    <c:forEach items="${orderItems}" var="item">
			        <tr>
			            <td>${item.getCpt().getC().getConcertName()} </td>
			            <td>${item.getQuantity()}</td>
			            <td>${item.getCpt().getV().getName()}</td>
			            <td>${item.getCpt().getP().getStartTime()}</td>
			            <td>${item.getCpt().getT().getTicketPrice()}</td>
			            <td style="text-align:center"><form action=CancelOrder >
			        	<input type="hidden" name="venueID" value="${item.getCpt().getP().getVenueID()}">
			        	<button name="orderItemID" type=submit value="${item.getId()}">Cancel Order</button></form></td>
			        </tr>
		   		</c:forEach>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Total </td>
				    <td style="text-align:center">$ ${orders.getTotalCost() }</td>	
				  	<td style="text-align:center"></td>
			    </tr>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Date Order </td>
				    <td style="text-align:center">${orders.getOrderDate()}</td>
				  	<td style="text-align:center"></td>
			    </tr>
		  	</table>
	</body>
</html>