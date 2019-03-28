package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import model.ReviewDB;
import model.UsersDB;

/**
 * Servlet implementation class addReviewServlet
 */
@WebServlet("/addReviewServlet")
public class addReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HERERE");
		String review = request.getParameter("rev");
		String rating = request.getParameter("rat");
		String cID = request.getParameter("CID");
		String uID = request.getParameter("UID");
		System.out.println(review);
		System.out.println(rating);
		System.out.println(cID);
		System.out.println(uID);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Review r = new Review();
		r.setConcertID(Integer.parseInt(cID));
		r.setRating(Integer.parseInt(rating));
		r.setReview(review);
		r.setUserID(Integer.parseInt(uID));
		r.setUser(UsersDB.getUserByID(Integer.parseInt(uID)));
		r.setReviewDate(timeStamp);
		String result = ReviewDB.addReview(r);
		PrintWriter out = response.getWriter(); 
		if(result.equals("p")) {
			out.println(ReviewDB.getReview(Integer.parseInt(cID)));
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
