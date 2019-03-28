<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel Confirmation</title>
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
		<h1 style="text-align:center">Cancellation Confirmation</h1>
		<img src="${orderItem.getCpt().getC().getThumbnail()}"  style="display:block; margin:auto auto; width:200px; height:200px"></img>
		<form style="text-align:center" name="paymentForm"   >
			<h4>Band/Artist: <c:out value="${orderItem.getCpt().getC().getConcertName()}"></c:out></h4>
			<h4>Quantity : <c:out value="${orderItem.getQuantity()}"></c:out></h4>
			<h4>Venue : <c:out value="${orderItem.getCpt().getV().getName()}"></c:out></h4>
			<h4>Time : <c:out value="${orderItem.cpt.p.getStartTime()}"></c:out></h4>
			<h4>Paid Total : <c:out value="${order.getTotalCost()}"></c:out></h4>
			<h4>Refund Amount : $ <c:out value="${orderItem.getTotalPrice()}"></c:out></h4>
			<h4 style="color:Green">Status: Order Cancelled, Processing Refund</h4>
		</form>
	</body>
</html>