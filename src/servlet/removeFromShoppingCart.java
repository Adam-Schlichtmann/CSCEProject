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
 * Servlet implementation class removeFromShoppingCart
 */
@WebServlet("/removeFromShoppingCart")
public class removeFromShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeFromShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart previousCartItems = (ShoppingCart)session.getAttribute("cart");
		int deleteConcertID = Integer.parseInt(request.getParameter("deleteConcert"));
		PrintWriter out = response.getWriter();
		if(previousCartItems != null) {
			for(int i = 0 ; i< previousCartItems.getItems().size();i++) {
				if(previousCartItems.getItems().get(i).getCpt().getP().getId() == deleteConcertID) {
					previousCartItems.getItems().remove(i);
				}
			}
			previousCartItems.calculateNewTotalPrice();
			String html = "<tr>" + 
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
			out.write(html);
			session.setAttribute("cart", previousCartItems);
			
		}else {
			System.out.println("Empty Cart, cant delete");
		}
		
		if(previousCartItems == null) {
			session.setAttribute("cart", null);
			
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
