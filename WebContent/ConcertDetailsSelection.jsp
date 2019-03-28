<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>
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
		<script>
		  	function addToCart() {
				var q = document.getElementById("ticketQuantity").value;
			 	var t = document.getElementById("ticketType").value;
			 	var cID = document.getElementById("cID").value;
			 	
			 	console.log(review);
			 	$.post("addToShoppingCart", {quantity:q, ticketType:t, CID:cID}, function(data,status) {
			 		console.log(data);
			    	if(data == null) {	    			
			   			alert("Item not added to cart");
			   		} else {
			   			var res = document.getElementById("cartUpdate");
			   			res.innerHTML = "";
			   			res.innerHTML = data;
			   			
			   		}
			    	
			 	});
			}
		</script>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <a href="ViewOrders">Orders</a>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp"">Shopping Cart</a>
		</div>
		<table style="width:100%">
			<tr>
				<td>
					<form action="VenueAndConcertSearchQuery">
						<input type=submit value="Back">
					</form>
				</td>
				<td>
					<span style="color:lime" id="cartUpdate"></span>
				</td>

				<td align="right">
					<select id="ticketQuantity">
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
				  	<select id="ticketType">
				  	<c:forEach items="${seats}" var="tickets">
				  		<option value="${tickets.getTicketVenuePricesID()}">${tickets.getSeatName()}</option>
				  	</c:forEach>
				  		
					</select>
					<button onclick="addToCart();" id="selectedConcert" type=submit value="${cpt.getP().getId()}">Add to Cart</button>
				</td>
			</tr>
		</table>
		
		<h1 style="text-align:center">Details</h1>
		<h2 style="text-align:center" name="concertName">${cpt.c.getConcertName()}</h2>
		<div class="center">
			<p><c:out value="${cpt.getC().getDescription()}"></c:out></p>
			<br>
            <img src="${cpt.getC().getThumbnail()}" align="middle" height="60%" >
            <br>
            <p><c:out value="${cpt.getV().getName()}"></c:out></p>
            <br>
            <p>Date/Time : <c:out value="${cpt.getP().getStartTime()}"></c:out></p>
            <br>
            <p>Tickets : $ <c:out value="${cpt.getT().getTicketPrice()}"></c:out></p>
            <br>
            <p>Remaining Seats : <c:out value="${cpt.getP().getRemainingSeats()}"></c:out></p>
            <br>
		</div>
		
		
		<h3 align="center">Concert Reviews</h3>
		
		<div align="center">
			<textarea col="250" rows="4" type=text placeholder="Enter your Review" id="review"></textarea><br>
			Star Rating: <br>
			<select id="stars">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<br>
			<br>
			<button onclick="getData();" type=submit value="Submit">Submit Review</button>
		</div>
		
		<span class="heading">User Concert Rating</span>
		<h3><c:out value="${cpt.getC().getRating()}"></c:out> / 5</h3>
		
		<br>
		<br>
		
		<table style="width:100%" id="reviewTable">
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Rating</th>
				<th>Review</th>
			</tr>
			<c:forEach items="${review}" var="r"> 
				<tr>
		            <td><c:out value="${r.getUser().getFirstName()}"></c:out></td>
		            <td><c:out value="${r.getReviewDate()}"></c:out></td>
		            <td><c:out value="${r.getRating()}"></c:out></td>
		            <td><c:out value="${r.getReview()}"></c:out></td>
		        </tr>
			</c:forEach>
		</table>
		<script>
		  	function getData() {
				var review = document.getElementById("review").value;
			 	var rating = document.getElementById("stars").value;
			 	var cID = document.getElementById("cID").value;
			 	var uID = document.getElementById("uID").value;
			 	
			 	console.log(review);
			 	$.post("addReviewServlet", {rev:review, rat:rating, CID:cID, UID:uID}, function(data,status) {
			 		console.log(data);
			    	if(data == null) {	    			
			   			alert("Review Submission Unsucessful");
			   		} else {
			   			var Table = document.getElementById("reviewTable");
			   			Table.innerHTML = "";
			   			Table.innerHTML = data;
			   			
			   		}
			    	
			 	});
			}
		</script>
		
		<input type="hidden" id="cID" value="${cpt.getC().getId()}" />
		<input type="hidden" id="uID" value="${id}" />
		
		
	</body>
</html>