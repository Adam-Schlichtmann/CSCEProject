<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>
<meta charset="ISO-8859-1">
<title>Confirm Order</title>
	<script>
			function confirm_function() {
				var firstName = document.getElementById("firstName").value;
				var lastName  = document.getElementById("lastName").value;
				var password = document.getElementById("password").value;
				var cardType  = document.getElementById("cardType").value;
				var billingAddress  = document.getElementById("billingAddress").value;
				var shippingAddress  = document.getElementById("shippingAddress").value;
				var cardNumber  = document.getElementById("cardNumber").value;
				var cardSec = document.getElementById("cardSec").value;
			   	// make call to Bank
				 $.post("../Bank/BankTransaction", {firstName:firstName, lastName:lastName, cardSec:cardSec, cardType:cardType, billingAddress:billingAddress, shippingAddress:shippingAddress, cardNumber:cardNumber}, function(data,status) {
					    
			    		
			    	 // Following data values are received from the "FormjQueryResponse" app
			    		if(data == 0) {	    			
			    			
			    			$("#status").text("FROM BANKING APP: Your credit card does not have enough balance");
			    		}
			    	 
			    		if(data == -1) {	    			
			    			alert("FROM BANKING APP: Invalid Credit Card Information");
			    			
			    		}
			    		
			    		if(data == 1) {	
			    			var bankStatus = true;
			    			 $.get("PlaceOrder", {firstName:firstName, lastName:lastName, password:password, cardSec:cardSec, cardType:cardType, billingAddress:billingAddress, shippingAddress:shippingAddress, cardNumber:cardNumber}, function(data,status) {
			 		    	   var form_table = document.getElementById("form_table");
			 		    	   var success_message=document.getElementById("success_message");
			 		    	   form_table.style.display= "none";
			 		    	   $("#status").text("Transaction Approved and order is being processed!");
			 				});
						}
			    		
			    		//*** END of the block for receiving data from another APP***
			    			
			    });
		    	// Sending request to servlet of the same app

					
			     //*** START of the block for receiving data from another APP***
		    		 // Sending request to another app named "FormjQueryResponse"
				 // Before sending request, run the app "FormjQueryResponse" on server first
				 
			  }
		</script>
</head>
<body>
		<link rel="stylesheet" type="text/css" href="NavigationBarTheme.css">
		<div class="topnav">
		  <a class="active" href="CustomerHomePage.jsp">Home</a>
		  <a href="ViewOrders">Orders</a>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp"">Shopping Cart</a>
		</div>
		<h1 style="text-align:center">Transactions</h1>
			<table style="width:50%" align="center">
			  	<tr>
				  	<th></th>
				    <th>Band/Artist</th>
				    <th>Tickets Remaining</th> 
				    <th>Venue</th>
				    <th>Time</th>
				    <th>Price</th>
			  	</tr>
				<c:forEach items="${cartItems}" var="cartItem">
			        <tr>
			        	<td style="text-align:center"><form action=ConcertSearchResult><button name="detailsButton" type=submit value="${cartItem.getCpt().getP().getId()}">View Concert Details</button></form></td>
		            	<td><c:out value="${cartItem.getCpt().c.getConcertName()}" /></td>
			            <td><c:out value="${cartItem.getCpt().p.getRemainingSeats()}"/></td>
			            <td><c:out value="${cartItem.getCpt().v.getName()}"/></td>
			            <td><c:out value="${cartItem.getCpt().p.getStartTime()}"/></td>
			            <td><c:out value="$ ${cartItem.getTotalPrice()}"/></td>
			        </tr>
		    	</c:forEach>
			    <tr>
			    	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center"></td>
				  	<td style="text-align:center">Total </td>
				    <td style="text-align:center"><c:out value="$ ${cart.getTotalPrice()}"/></td>	
			    </tr>
		  	</table>
			<table align="center" id="form_table">
			<tr>
				<td>
						First Name: <input type=text id="firstName" name="firstName" style="margin:10px" placeholder="John"><br>
						Last Name: <input type=text id="lastName" name="firstName" style="margin:10px" placeholder="Doe"><br>
						<table>
							<tr>Card Type : </tr>
							<tr>
								<select name='cardType' id='cardType'>
								    <option value=''>Card</option>
								    <option value='Visa'>Visa</option>
								    <option value='MasterCard'>MasterCard</option>
								    <option value='Discover'>Discover</option>
								</select>
							</tr>
							<br>
							<br>
							<tr>
								Card Number: <input type=text id="cardNumber" name="cardNumber" >
							</tr>
							<br>
							<br>
							<tr>
								Security code: <input type=text id="cardSec"  name="cardSec">
							</tr>
							<br>
							<tr>Expiration Date : </tr>
							<tr>
									<select name='expireMM' id='expireMM' style="margin:10px">
									    <option value=''>Month</option>
									    <option value='01'>January</option>
									    <option value='02'>February</option>
									    <option value='03'>March</option>
									    <option value='04'>April</option>
									    <option value='05'>May</option>
									    <option value='06'>June</option>
									    <option value='07'>July</option>
									    <option value='08'>August</option>
									    <option value='09'>September</option>
									    <option value='10'>October</option>
									    <option value='11'>November</option>
									    <option value='12'>December</option>
									</select>
									<select name='expireYY' id='expireYY' style="margin:10px">
									    <option value=''>Year</option>
									    <option value='10'>2019</option>
									    <option value='11'>2020</option>
									    <option value='12'>2021</option>
									    <option value='12'>2022</option>
									    <option value='12'>2023</option>
									    <option value='12'>2024</option>
									    <option value='12'>2025</option>
									    
									</select>
							</tr>
						</table>
						Billing Address: <input type=text id="billingAddress" name="billingAddress" style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Shipping Address: <input type=text id="shippingAddress" name="shippingAddress" style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Password:  <input type=password id="password" name="password" style="margin:10px" placeholder='6-Characters'><br>
					
					<div style="text-align:center; margin:10px;">
						<input type=submit value="Cancel">		
									
						<input  type=submit value="Confirm Payment" onClick="confirm_function()" >	
						
					</div>
				</td>
			</tr>
		</table>
		<h2 id="status" align="center" > </h2>
	</body>
</html>