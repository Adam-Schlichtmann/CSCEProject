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
		  <form action="ViewOrders"><input type=submit value="Orders"></form>
		  <a href="Login.jsp" style="float:right">Log Out</a>
		  <a href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</div>
		<h1 style="text-align:center">Shopping Cart</h1>
		<br>
		<br>
		<c:choose >
			<c:when test="${errorMessage != null }">
				<h3 style="text-align:center">${errorMessage }</h3>
			</c:when>
			<c:otherwise>
				<table style="width:100%">
			
					<tr>
						<td style="text-align:center">Chance the Rapper</td>
						<td style="text-align:center"><img src="Pics/Chance.jpg" alt="" border=3 height=150 width=150></img></td>
						<td style="text-align:center">9:00pm February 24, 2019</td>
						<td style="text-align:center">5</td>
						<td style="text-align:center">X</td>
						<td style="text-align:center">$100.00</td>
						<td style="text-align:center">=</td>
						<td style="text-align:center">$500.00</td>
						<td style="text-align:center">
							<form>
								<input type=submit value="Delete">
							</form>
						</td>
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
						<td style="text-align:center"></td>
						<td style="text-align:center">Total Cost:</td>
						<td style="text-align:center">=</td>
						<td style="text-align:center">$780.00</td>
						<td style="text-align:center"></td>
					</tr>
				</table>
					<br>
					<br>
				<form style = "text-align:center" action="CustomerTransaction.jsp">
				<input type=submit value="Checkout">
		</form>
			</c:otherwise>
		
		</c:choose>

	</body>
</html>