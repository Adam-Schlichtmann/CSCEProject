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
import javax.servlet.http.HttpSession;

import model.CPTValuesDB;
import model.DBAccess;
import model.ShoppingCart;
import model.ShoppingCartItem;
import model.VenueDB;

/**
 * Servlet implementation class ViewAndCheckoutShoppingCart
 */
@WebServlet("/ViewAndCheckoutShoppingCart")
public class ViewAndCheckoutShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndCheckoutShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmOrder.jsp");		
		ShoppingCart previousCart = (ShoppingCart)session.getAttribute("cart");
		request.setAttribute("cartItems", previousCart.getItems());
		session.setAttribute("cart", previousCart);
		session.setAttribute("cartItems", previousCart.getItems());
		System.out.println("here");
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
