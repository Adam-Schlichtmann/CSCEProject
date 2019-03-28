<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"/> 
<meta charset="ISO-8859-1">
<title>Confirm Order</title>
	<script>
			function getdata() {
				var firstName = $("#firstName").val();
				var lastName  = $("#lastName").val();
				var cardType  = $("#cardType").val();
				var billingAddress  = $("#billingAddress").val();
				var shippingAddress  = $("#shippingAddress").val();
				var cardNumberTemp  = $("#cardNumber").val();
				cardNumberTemp = Number(cardNumberTemp);
			
			   	// make call to Bank
				 $.post("../WebApp/BankTransaction", {firstName:firstName, lastName:lastName, cardType:cardType, billingAddress:billingAddress, shippingAddress:shippingAddress, cardNumberTemp:cardNumberTemp}, function(data,status) {
					    
			    		
			    	 // Following data values are received from the "FormjQueryResponse" app
			    		if(data == 0) {	    			
			    			alert("FROM BANKING APP: Your credit card does not have enough balance");
			    		}
			    	 
			    		if(data == -1) {	    			
			    			alert("FROM BANKING APP: Invalid Credit Card");
			    		}
			    		
			    		if(data == 1) {	
			    			var bankStatus = true;
			    			 $.get("PlaceOrder", {firstName:firstName, lastName:lastName, cardType:cardType, billingAddress:billingAddress, shippingAddress:shippingAddress, cardNumberTemp:cardNumberTemp}, function(data,status) {
			 		    	 
			 				}
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
		  <form action="ViewOrders"><input type=submit value="Orders"></form>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</div>>
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
				    <td style="text-align:center">$1010</td>	
			    </tr>
		  	</table>
			<table align="center">
			<tr>
				<td>
					<form style="text-align:center" name="paymentForm"  action="CustomerTransactionConfirmation" >
						First Name: <input type=text name=firstName style="margin:10px" placeholder="John"><br>
						Last Name: <input type=text name=lastName style="margin:10px" placeholder="Doe"><br>
						<table>
							<tr>Card Type : </tr>
							<tr>
								<select name='cardType' id='card'>
								    <option value=''>Card</option>
								    <option value='Visa'>Visa</option>
								    <option value='MasterCard'>MasterCard</option>
								    <option value='Discover'>Discover</option>
								</select>
							</tr>
							<br>
							<br>
							<tr>
								Card Number: <input type=text name="cardNumber" >
							</tr>
							<br>
							<br>
							<tr>
								Security code: <input type=text name="sec" >
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
						Billing Address: <input type=text name=billingAddress style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Shipping Address: <input type=text name=shippingAddress style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Password:  <input type=password name=password style="margin:10px" placeholder='6-Characters'><br>
					
					<div style="text-align:center; margin:10px;">
						
						<input type=submit value="Cancel">
					
						<input  type=submit value="Confirm Payment" onClick="getdata()" >	
						
					</div>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>