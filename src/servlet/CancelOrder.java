package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CPTValues;
import model.CPTValuesDB;
import model.OrderItems;
import model.OrderItemsDB;
import model.Orders;
import model.OrdersDB;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int orderItemID = Integer.parseInt(request.getParameter("orderItemID"));
		OrderItemsDB orderItemsDB = new OrderItemsDB();
		OrderItems orderItem = orderItemsDB.getOrderItembyOrderItemID(orderItemID);
		List<Orders> order = OrdersDB.getOrdersByOrderID(cancelOrderID);
		for(int i=0; i < newOrder.size(); i++) {
			if(newOrder.get(i).getId() == cancelOrderID) {
				newOrder.remove(i);
			}
		}
		int totalPrice = orderItem.getCpt().getT().getTicketPrice() * orderItem.getQuantity();
		orderItem.setTotalPrice(totalPrice);

		cancelValidation(orderItem);
		
		request.setAttribute("orderItem", orderItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancelOrder.jsp");
		dispatcher.forward(request, response);
	}

	private void cancelValidation(OrderItems orderItem) {
		OrdersDB ordersDB = new OrdersDB();
		Orders orders = OrdersDB.getOrdersByOrderID(orderItem.getOrderId());
		Date currentDate = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(orders.getOrderDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		
		if(currentDate.after(date)) {
			orderItem.setProcessed(false);
		}else {
			orderItem.setProcessed(true);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
