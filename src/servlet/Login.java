package servlet;

import java.io.FileInputStream;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.DBAccess;
import model.Users;
import model.UsersDB;
import model.Venue;
import model.VenueDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DBAccess.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/lib/log4j.properties");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerHomePage.jsp");
		Users u = new Users();
		u.setUserName(userName);
		u.setPassword(password);
		VenueDB venue = new VenueDB();
		int customerId = -1;
		if(UsersDB.validateUserByUsername(userName)) {
			if(UsersDB.validateUserByPassword(password)) {	
				customerId = UsersDB.getUserID(userName);
				HttpSession session = request.getSession();
				session.setAttribute("id", customerId);
				List<Venue> venueList = VenueDB.getAllVenues();
				session.setAttribute("venueList", venueList);
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("Register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
