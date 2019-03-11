package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import model.OrdersDB;

/**
 * Servlet implementation class ManageOrder
 */
@WebServlet("/ManageOrder")
public class ManageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String orderID = request.getParameter("orderID");
		OrderItemsDB orderItemsDB = new OrderItemsDB();
		List<OrderItems> orderItems = OrderItemsDB.getOrderItemsbyOrderID(Integer.parseInt(orderID));
		CPTValuesDB cptValuesDB = new CPTValuesDB();
		List<CPTValues> cpt = new ArrayList<CPTValues>();
		for(int i=0;i<orderItems.size(); i++) {
			cpt.add(cptValuesDB.getCPTData(orderItems.get(i).getPerformanceId()));
		}
		request.setAttribute("cpt", cpt);
//		request.setAttribute("order", orderItemsDB.ge);
		request.setAttribute("orderItems", orderItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageOrder.jsp");
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
