package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;

/**
 * Servlet implementation class loadShoppingCart
 */
@WebServlet("/loadShoppingCart")
public class loadShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		session.setAttribute("cart", previousCartItems);
		session.setAttribute("cartItems", previousCartItems.getItems());
		String html;
		if(previousCartItems.getItems().size() == 0) {
			html = "No items in Cart";
		} else {
			
		
			html = "<tr>" + 
					"<td style=\"text-align:center\">Event Name</td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\">Time & Date</td>" + 
					"<td style=\"text-align:center\">Quantity</td>" + 
					"<td style=\"text-align:center\">X</td>" + 
					"<td style=\"text-align:center\">Price/Ticket</td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\">SubTotal</td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"</tr>";
			for(int i = 0; i < previousCartItems.getItems().size(); i++) {
				html = html + " <tr>" + 
						"<td style=\"text-align:center\">" + previousCartItems.getItems().get(i).getCpt().getC().getConcertName()+"</td>" + 
						"<td style=\"text-align:center\"><img src=\"" + previousCartItems.getItems().get(i).getCpt().getC().getThumbnail() + "\" alt=\"\" border=3 height=150 width=150></img></td>			            	" + 
						"<td style=\"text-align:center\">" + previousCartItems.getItems().get(i).getCpt().getP().getStartTime() + "</td>" + 
						"<td style=\"text-align:center\">" + previousCartItems.getItems().get(i).getAmountOfTickets()+ "</td>				            " + 
						"<td style=\"text-align:center\">X</td>" + 
						"<td style=\"text-align:center\">" + previousCartItems.getItems().get(i).getPricePerTicket() + "</td>" + 
						"<td style=\"text-align:center\">=</td>" + 
						"<td style=\"text-align:center\">" + previousCartItems.getItems().get(i).getTotalPrice() + "</td>" + 
						"<td style=\"text-align:center\"><button onclick=\"removeFromCart();\"id=\"deleteConcert\" type=submit value=\"" + previousCartItems.getItems().get(i).getCpt().getP().getId() + "\">Remove</button></td>" + 
						"</tr>";
			}
			html = html + "<tr>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"<td style=\"text-align:center\">Total Cost:</td>" + 
					"<td style=\"text-align:center\">=</td>" + 
					"<td style=\"text-align:center\">" + previousCartItems.getTotalPrice() + "</td>" + 
					"<td style=\"text-align:center\"></td>" + 
					"</tr>";
		}
		out.write(html);
		
		System.out.println("cart items is now a session object");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
