<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
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
		<h1 style="text-align:center">Results</h1>
		<table style="width:100%">
		  	<tr>
			  	<th>Details</th>
			    <th>Venue</th>
			    <th>Time</th> 
			    <th>Remaining Seats</th>
			    <th>Ticket Cost</th>
			    <th>Image</th>
			    <th></th>
		  	</tr>
		    <c:forEach items="${cpt}" var="concert">
		        <tr>
		        	<td style="text-align:center"><form action=ConcertSearchResult >
		        	<input type="hidden" name="venueID" value="${concert.getP().getVenueID()}">
		        	<button name="detailsButton" type=submit value="${concert.getP().getId()}">View Concert Details</button></form></td>
		            <td><c:out value="${concert.getC().getConcertName()}"></c:out> </td>
		            <td><c:out value="${concert.getP().getStartTime()}"></c:out></td>
		            <td><c:out value="${concert.getP().getRemainingSeats()}"></c:out></td>
		            <td>$ <c:out value="${concert.getT().getTicketPrice()}"></c:out></td>
		            <td>NO IMAGE</td>
		        </tr>
		    </c:forEach>

		</table>
	</body>
</html>