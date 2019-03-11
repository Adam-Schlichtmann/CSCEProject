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
				<c:forEach items="${concerts}" var="concert">
			        <tr>
			        	<td style="text-align:center"><form action=ConcertSearchResult><button name="detailsButton" type=submit value="${$cpt.c.id}">View Concert Details</button></form></td>
		            	<td><c:out value="${cpt.c.getDescription()}" />${cpt.c.getDescription()}</td>
			            <td><c:out value="${cpt.p.StartTime}"/>${cpt.p.StartTime}</td>
			            <td><c:out value="${cpt.t.price}"/>${cpt.t.price}</td>
			            <td><c:out value="${cpt.p.remainingSeats}"/>${concert.performance.remainingSeats}</td>
			            <td><c:out value="${cpt.c.Thumbnail}"/>NO IMAGE ${concert.image}</td>
			            <td style="text-align:center"><form action=UpdateShoppingCart><button name="deleteConcert" type=submit value=1>Remove</button></form></td>
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
					<form style="text-align:center" name="paymentForm"   >
						First Name: <input type=text name=userName style="margin:10px" placeholder="John"><br>
						Last Name: <input type=text name=userName style="margin:10px" placeholder="Doe"><br>
						<table>
							<tr>Card Type : </tr>
							<tr>
									<select name='card' id='card'>
									    <option value=''>Card</option>
									    <option value='Visa'>Visa</option>
									    <option value='Mastercard'>MasterCard</option>
									    <option value='Discover'>Discover</option>
									</select>
							</tr>
							<br>
							<br>
							<tr>
								<form>
									Card Number: <input type=text name="cardNumber" value="CardNumber">
								</form>
							</tr>
							<br>
							<br>
							<tr>
								<form>
									Security code: <input type=text name="sec" value="security code">
								</form>
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
									    <option value='10'>2010</option>
									    <option value='11'>2011</option>
									    <option value='12'>2012</option>
									</select>
							</tr>
						</table>
						Billing Address: <input type=text name=userName style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Shipping Address: <input type=text name=userName style="margin:10px" placeholder='1 A St, Lincoln, NE-68508'><br>
						Password:  <input type=password name=password style="margin:10px" placeholder='6-Characters'><br>
					</form>
					<div style="text-align:center; margin:10px;">
						<form action="ViewAndCheckoutShoppingCart.jsp">
							<input type=submit value="Cancel">
						</form>
						<form action="CustomerTransactionConfirmation.jsp">
							<input  type=submit value="Confirm Payment" >	
						</form>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>