package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CPTValues;
import model.CPTValuesDB;
import model.ShoppingCart;
import model.ShoppingCartItem;

/**
 * Servlet implementation class addToShoppingCart
 */
@WebServlet("/addToShoppingCart")
public class addToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quantity = request.getParameter("quantity");
		String ticketType = request.getParameter("ticketType");
		String cID = request.getParameter("CID");
		System.out.println(quantity);
		System.out.println(ticketType);
		System.out.println(cID);
		
		HttpSession session = request.getSession();
		CPTValuesDB cptValuesDB = new CPTValuesDB();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		String result = "";
		
		if (previousCartItems == null) {
			ShoppingCart cart = new ShoppingCart();
			ShoppingCartItem cartItemHolder = new ShoppingCartItem();
			CPTValues cptHolder = new CPTValues();
			cptHolder = cptValuesDB.getCPTData(Integer.parseInt(cID));
			
			cartItemHolder.setCpt(cptHolder);
			cartItemHolder.setAmountOfTickets(Integer.parseInt(quantity));
			cartItemHolder.setPricePerTicket(cptHolder.getT().getTicketPrice());
			cartItemHolder.setTotalPrice(cartItemHolder.getAmountOfTickets()*cartItemHolder.getPricePerTicket());
			cart.addToCart(cartItemHolder);
			cart.calculateNewTotalPrice();
			System.out.println(cartItemHolder.getCpt().getC().getThumbnail());
			result = "Sucesfullly Added to cart";
			response.getWriter().write(result);;
			session.setAttribute("cart", cart);
		}else {
			ShoppingCartItem cartItemHolder = new ShoppingCartItem();
			CPTValues cptHolder = new CPTValues();
			cptHolder = cptValuesDB.getCPTData(Integer.parseInt(cID));
			
			cartItemHolder.setCpt(cptHolder);
			cartItemHolder.setAmountOfTickets(Integer.parseInt(quantity));
			cartItemHolder.setPricePerTicket(cptHolder.getT().getTicketPrice());
			cartItemHolder.setTotalPrice(cartItemHolder.getAmountOfTickets()*cartItemHolder.getPricePerTicket());
			
			previousCartItems.addToCart(cartItemHolder);
			previousCartItems.calculateNewTotalPrice();
			result = "Sucesfullly Added to cart";
			response.getWriter().write(result);;
			session.setAttribute("cart", previousCartItems);
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
