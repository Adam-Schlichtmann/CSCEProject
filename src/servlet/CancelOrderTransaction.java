package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderItems;
import model.OrderItemsDB;
import model.Orders;
import model.OrdersDB;

/**
 * Servlet implementation class CancelOrderTransaction
 */
@WebServlet("/CancelOrderTransaction")
public class CancelOrderTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderItemID = request.getParameter("orderID");
		OrderItemsDB orderItemsDB = new OrderItemsDB();
		OrderItems orderItem = orderItemsDB.getOrderItembyOrderItemID(Integer.parseInt(orderItemID));
		Orders order = new Orders();
		OrdersDB ordersDB = new OrdersDB();
		
		
		order = ordersDB.getOrdersByOrderID(orderItem.getOrderId());
		int refundAmount = orderItem.getCpt().getT().getTicketPrice() * orderItem.getQuantity();
		int totalPrice =  order.getTotalCost() - refundAmount;
		order.setTotalCost(totalPrice);
		
		orderItemsDB.delOrderItem(Integer.parseInt(orderItemID)); //delete order item from database
		//ordersDB.setTotalPrice(int orderID, int newTotalPrice); //need to update total price in database for order
		
		
		request.setAttribute("order", order);
		request.setAttribute("orderItem", orderItem);
		request.setAttribute("refundAmount", refundAmount );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancellationConfirmation.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
