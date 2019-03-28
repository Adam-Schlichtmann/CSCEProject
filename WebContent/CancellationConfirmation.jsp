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
			<h4>Band/Artist: ${orderItem.getCpt().getC().getConcertName()}</h4>
			<h4>Quantity : ${orderItem.getQuantity()}</h4>
			<h4>Venue : ${orderItem.getCpt().getV().getName()}</h4>
			<h4>Time : ${orderItem.cpt.p.getStartTime()}</h4>
			<h4>NEW Paid Total : ${order.getTotalCost()}</h4>
			<h4>Refund Amount : $ ${refundAmount}</h4>
			<h4 style="color:Green">Status: Order Cancelled, Processing Refund</h4>
		</form>
	</body>
</html>