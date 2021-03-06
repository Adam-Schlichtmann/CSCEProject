<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
						<form action="ViewAndCheckoutShoppingCart.jsp">
							<input type=submit value="Cancel">
						</form>
						<input  type=submit value="Confirm Payment" >	
						
					</div>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>