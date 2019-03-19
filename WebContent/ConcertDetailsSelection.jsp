<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Font Awesome Icon Library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.checked {
	  color: orange;
	}
}
</style>
<meta charset="UTF-8">
<title>Concert Details</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
	<style>
		input[type=submit] {
		    width: 20em;  height: 2em;
		    background-color: cornsilk;
		}
		button[type=submit] {
		    width: 20em;  height: 2em;
		    background-color: cornsilk;
		}
		* {
		 	font-family: Arial;
		} 
		body {
		 	background-color: lightblue;
		}
	</style>
	<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <form action="ViewOrders"><input type=submit value="Orders"></form>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</div>
		<table style="width:100%">
			<tr>
				<td>
					<form action="ConcertSearchResults.jsp">
						<input type=submit value="Back">
					</form>
				</td>

				<td align="right">
					<form action="UpdateShoppingCart">
						<select name="ticketQuantity">
						    <option value=1>1</option>
						    <option value=2>2</option>
						    <option value=3>3</option>
						    <option value=4>4</option>
						    <option value=5>5</option>
						    <option value=6>6</option>
						    <option value=7>7</option>
						    <option value=8>8</option>
						    <option value=9>9</option>
					  	</select>
					  	<select name="ticketType">
					  	<c:forEach items="${seats}" var="tickets">
					  		<option value="${tickets.getTicketVenuePricesID()}">${tickets.getSeatName()}</option>
					  	</c:forEach>
					  		
						</select>
						<form action=ViewAndCheckoutShoppingCart name="search">
							<button name="selectedConcert" type=submit value="${cpt.getP().getId()}">Add to Cart</button>
						</form>
					</form>
				</td>
			</tr>
		</table>
		
		<h1 style="text-align:center">Details</h1>
		<h2 style="text-align:center" name="concertName">${cpt.c.getConcertName()}</h2>
		<div class="center">
			<p>${cpt.getC().getDescription()}</p>
			<br>
            <img src="${cpt.getC().getThumbnail()}" align="middle" height="60%" >
            <br>
            <p>${cpt.getV().getName()}</p>
            <br>
            <p>Date/Time : ${cpt.getP().getStartTime()}</p>
            <br>
            <p>Tickets : $ ${cpt.getT().getTicketPrice()}</p>
            <br>
            <p>Remaining Seats : ${cpt.getP().getRemainingSeats()}</p>
            <br>
		</div>
		
		
		<h3>Reviews for Pinnacle Bank Arena</h3>
		<form action="CustomerReview.jsp">
		<input type=submit value="Submit">
		</form>
		<span class="heading">User Rating</span>
		<h3>${concert.rating} / 5</h3>
		
		<br>
		<br>
		
		<table style="width:100%">
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Rating</th>
				<th>Review</th>
			</tr>
			<tr>
	            <td>${review.getUser().getFirstName()}</td>
	            <td>${review.getReviewDate()}</td>
	            <td>${review.getRating()}</td>
	            <td>${review.getReview()}</td>
	        </tr>

		</table>
	
	</body>
</html>