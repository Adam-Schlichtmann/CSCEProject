package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerReviewServlet
 */
@WebServlet("/CustomerReviewServlet")
public class CustomerReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String review = request.getParameter("review");
		String stars = request.getParameter("stars");
		int rating = Integer.parseInt(stars);
		System.out.println(review);
		System.out.println(stars);
//		Review r = new Review();
//		//HttpSession session = request.getSession();
//		
//		//int cID = (int) session.getAttribute("id");
//		//System.out.println(cID);
//		r.setReview(review);
//		r.setRating(rating);
//		String result = ReviewDB.addReview(r);
//		boolean status = false;
//		request.setAttribute("status", status);
//		
//		// TODO STUB send the result to the next page
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerReviewConfirmation.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("CustomerReviewConfirmation.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
