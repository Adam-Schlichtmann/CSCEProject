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
import javax.websocket.Session;

import model.CPTValues;
import model.CPTValuesDB;
import model.Concerts;
import model.ShoppingCart;
import model.ShoppingCartDB;
import model.ShoppingCartItem;

/**
 * Servlet implementation class UpdateShoppingCart
 */
@WebServlet("/UpdateShoppingCart")
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		
		if(!(request.getParameter("selectedConcert") == null)) {
			System.out.println("line45");
			addToCart(request);
			previousCartItems = (ShoppingCart)session.getAttribute("cart");

		}else if (!(request.getParameter("deleteConcert") == null)) {
			System.out.println("line49");
			deleteFromCart(request);
			previousCartItems = (ShoppingCart)session.getAttribute("cart");
		}
		System.out.println("line52");
		
		if(previousCartItems != null) {
			System.out.println("line58");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAndCheckoutShoppingCart.jsp");
			if(previousCartItems.getItems() !=null) {
				loadConcerts(request); //load concerts variable to be used on front end
				
			}
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAndCheckoutShoppingCart.jsp");
			String errorMessage = "Cart is Empty!";
			request.setAttribute("errorMessage", errorMessage);
			dispatcher.forward(request, response);
			System.out.println("line65");

		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void loadConcerts(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ShoppingCart previousCart = (ShoppingCart)session.getAttribute("cart");
		request.setAttribute("cart", previousCart);
		request.setAttribute("cartItems", previousCart.getItems());
	}

	private void deleteFromCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		int deleteConcertID = Integer.parseInt(request.getParameter("deleteConcert"));
		
		if(previousCartItems != null) {
			for(int i = 0 ; i< previousCartItems.getItems().size();i++) {
				if(previousCartItems.getItems().get(i).getCpt().getP().getId() == deleteConcertID) {
					previousCartItems.getItems().remove(i);
				}
			}
			previousCartItems.calculateNewTotalPrice();
			session.setAttribute("cart", previousCartItems);
			
		}else {
			System.out.println("Empty Cart, cant delete");
		}
		
		if(previousCartItems == null) {
			session.setAttribute("cart", null);
			
		}
		
	}
	
	private void addToCart(HttpServletRequest request)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String selectedConcert = request.getParameter("selectedConcert");
		int numOfTickets = Integer.parseInt(request.getParameter("ticketQuantity"));
		String TicketVenuePricesID = request.getParameter("ticketType");

		CPTValuesDB cptValuesDB = new CPTValuesDB();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		
		if (previousCartItems == null) {
			ShoppingCart cart = new ShoppingCart();
			ShoppingCartItem cartItemHolder = new ShoppingCartItem();
			CPTValues cptHolder = new CPTValues();
			cptHolder = cptValuesDB.getCPTData(Integer.parseInt(selectedConcert));
			
			cartItemHolder.setCpt(cptHolder);
			cartItemHolder.setAmountOfTickets(numOfTickets);
			cartItemHolder.setPricePerTicket(cptHolder.getT().getTicketPrice());
			cartItemHolder.setTotalPrice(cartItemHolder.getAmountOfTickets()*cartItemHolder.getPricePerTicket());
			cart.addToCart(cartItemHolder);
			cart.calculateNewTotalPrice();
			session.setAttribute("cart", cart);
		}else {
			ShoppingCartItem cartItemHolder = new ShoppingCartItem();
			CPTValues cptHolder = new CPTValues();
			cptHolder = cptValuesDB.getCPTData(Integer.parseInt(selectedConcert));
			
			cartItemHolder.setCpt(cptHolder);
			cartItemHolder.setAmountOfTickets(numOfTickets);
			cartItemHolder.setPricePerTicket(cptHolder.getT().getTicketPrice());
			cartItemHolder.setTotalPrice(cartItemHolder.getAmountOfTickets()*cartItemHolder.getPricePerTicket());
			
			previousCartItems.addToCart(cartItemHolder);
			previousCartItems.calculateNewTotalPrice();
			session.setAttribute("cart", previousCartItems);
		}
	}

}
