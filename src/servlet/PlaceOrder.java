package servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Orders;
import model.OrdersDB;
import model.ShoppingCart;
import model.Users;
import model.UsersDB;
import model.Venue;
import model.VenueDB;
import util.hashingUtil;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		hashingUtil hash = new hashingUtil();
		long cardNumber =0;
		int cardSec =0;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardType = request.getParameter("cardType");
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		String cardNumberTemp = request.getParameter("cardNumber");
		System.out.println(cardNumberTemp);
		if(cardNumberTemp !=null) {
			cardNumber = Long.parseLong(cardNumberTemp);
			System.out.println("card Number is long at " + cardNumber);
		}
		String cardSecTemp = request.getParameter("sec");
		if(cardSecTemp !=null) {
			cardSec = Integer.parseInt(cardSecTemp);
		}	
		String password = request.getParameter("password");
		try {
			password = hash.hashPassword(password);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date uDate = new java.util.Date();
		java.sql.Date sDate = convertUtilToSql(uDate);
		
		try {
			if( verifyUser(session, password) ) {
					System.out.println("User verified & Bank approved");
					RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerTransactionConfirmation.jsp");
					Orders newOrder = new Orders();
					OrdersDB ordersDB = new OrdersDB();
					ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
					int customerId = (int) session.getAttribute("id");
					
					newOrder.setTotalCost(previousCartItems.getTotalPrice());
					newOrder.setCustomerId(customerId);
					newOrder.setOrderDate(sDate);
					newOrder.setCreditCardNumber(cardNumber);
					newOrder.setBillingAddress(billingAddress);
					newOrder.setShippingAddress(shippingAddress);
					
					ordersDB.createOrder(newOrder);
					session.setAttribute("cart", null);
					dispatcher.forward(request, response);
					System.out.println("Processed");
				
			}else {
				failed(request,response, "User Authentication Error");
			}
			
		} catch (Exception e) {
			System.out.println("Logic Issue");
			e.printStackTrace();
		}
		
		System.out.println("out of logic");
	}
	
	 private static boolean verifyUser(HttpSession session, String password) {
		UsersDB usersDB = new UsersDB();
		Users user = new Users();
		int customerId = (int) session.getAttribute("id");
		user = usersDB.getUserByID(customerId);
		
    	if(user.getPassword().equals(password)) {
    		System.out.println("User verified");
    		return true;
    	}
    	System.out.println("User Authentication Error");
    	System.out.println("ID : " + customerId);
		return false;
	    	
	}
	
	private static void failed(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {

		System.out.println(message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerTransaction.jsp");
		dispatcher.forward(request, response);
	}
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
   
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
