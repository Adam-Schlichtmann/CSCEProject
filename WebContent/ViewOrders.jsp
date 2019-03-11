<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<script>
	function makeTable(){
		var orders = session.getAttribute("orders");
		var r = 0;
		var table = document.getElementById('orderTable');
		foreach (order in orders) {
		    var x = document.getElementById('orderTable').insertRow(r);
		    for (var c = 0; c < 4; c += 1) {
		      var y = x.insertCell(c);
		    }
		    table.rows[r].cells[0].innerHTML = 0;
		    table.rows[r].cells[1].innerHTML = order[r].Id;
		    table.rows[r].cells[2].innerHTML = order[r].TotalCost;
		    table.rows[r].cells[3].innerHTML = order[r].OrderDate;
		    r+=1;
		}
		
	}
</script>
<!-- <form action="ManageOrder.jsp"><input type=submit value="View"></form> -->
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
		<h1 style="text-align:center">Orders</h1>
		<table style="width:100%" id="orderTable">    
			<tr>
			  	<th></th>
			    <th>Order Number</th>
			    <th>Order Total</th> 
			    <th>Order Date</th>
		  	</tr>
		    <c:forEach items="${orders}" var="order">
		        <tr>
		        	<td style="text-align:center"><form action=ManageOrder >
		        	<input type="hidden" name="order" value="${order.getId()}">
		        	<button name="orderID" type=submit value="${order.getId()}">View Order Details</button></form></td>
		            <td>${order.getId()} </td>
		            <td>${order.getTotalCost()}</td>
		            <td>${order.getOrderDate()}</td>
		        </tr>
		    </c:forEach>
	  	</table>
	</body>
</html>