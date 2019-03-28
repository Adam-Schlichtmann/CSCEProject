<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
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
		<script>
		(function(){	
		 	$.post("loadShoppingCart", {}, function(data,status) {
		 		console.log(data);
		    	if(data == null) {	    			
		   			alert("No Cart to Load");
		   		} else {
		   			var res = document.getElementById("cartTable");
		   			res.innerHTML = "";
		   			res.innerHTML = data;
		   			
		   		}
		    	
		 	});
		})();
		
		</script>
		
		
		<script>
		  	function removeFromCart() {
				var pID = document.getElementById("deleteConcert").value;
			 	$.post("removeFromShoppingCart", {deleteConcert:pID}, function(data,status) {
			 		console.log(data);
			    	if(data == null) {	    			
			   			alert("Item not added to cart");
			   		} else {
			   			var res = document.getElementById("cartTable");
			   			res.innerHTML = "";
			   			res.innerHTML = data;
			   			
			   		}
			    	
			 	});
			}
		</script>
		
		<h1 style="text-align:center">Shopping Cart</h1>
		<br>
		<br>
		<c:choose >
			<c:when test="${errorMessage != null }">
				<h3 style="text-align:center">${errorMessage }</h3>
			</c:when>
			<c:otherwise>
				<table id="cartTable" style="width:100%">
			
					<tr>
						<td style="text-align:center">Event Name</td>
						<td style="text-align:center"></td>
						<td style="text-align:center">Time & Date</td>
						<td style="text-align:center">Quantity</td>
						<td style="text-align:center">X</td>
						<td style="text-align:center">Price/Ticket</td>
						<td style="text-align:center"></td>
						<td style="text-align:center">SubTotal</td>
						<td style="text-align:center">
						</td>
					</tr>
					 <c:forEach items="${cartItems}" var="items">
				        <tr>
			            	<td style="text-align:center"><c:out value="${items.getCpt().c.getConcertName()}" /></td>
        					<td style="text-align:center"><img src="${items.getCpt().getC().getThumbnail() }" alt="" border=3 height=150 width=150></img></td>			            	
				            <td style="text-align:center"><c:out value="${items.getCpt().p.getStartTime()}"/></td>
				            <td style="text-align:center"><c:out value="${items.getAmountOfTickets()}"/></td>				            
				            <td style="text-align:center">X</td>
				            <td style="text-align:center"><c:out value="$ ${items.getPricePerTicket()}"/></td>
				            <td style="text-align:center">=</td>
				            <td style="text-align:center"><c:out value="$ ${items.getTotalPrice()}"/></td>
				            <td style="text-align:center"><button onclick="removeFromCart();"id="deleteConcert" type=submit value="${items.getCpt().getP().getId()}">Remove</button></td>
				        </tr>
				    </c:forEach>
					<tr>
						<td style="text-align:center"></td>
						<td style="text-align:center"></td>
						<td style="text-align:center"></td>
						<td style="text-align:center"></td>
						<td style="text-align:center"></td>
						<td style="text-align:center">Total Cost:</td>
						<td style="text-align:center">=</td>
						<td style="text-align:center"><c:out value="$ ${cart.getTotalPrice()}"/></td>
						<td style="text-align:center"></td>
					</tr>
				</table>
					<br>
					<br>
				<form style = "text-align:center" action="ConfirmOrder.jsp">
				<button name="checkoutButton" type=submit value="${cartItems}">Checkout</button>
				</form>
			</c:otherwise>
		
		</c:choose>

	</body>
</html>