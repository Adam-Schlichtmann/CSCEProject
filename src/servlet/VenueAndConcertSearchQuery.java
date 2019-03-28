package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CPTValues;
import model.CPTValuesDB;
import model.Concerts;
import model.Performance;
import model.PerformanceDB;
import model.Venue;
import model.VenueDB;

/**
 * Servlet implementation class VenueAndConcertSearchQuery
 */
@WebServlet("/VenueAndConcertSearchQuery")
public class VenueAndConcertSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueAndConcertSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        CPTValuesDB cptDB = new CPTValuesDB();
        List<CPTValues> cpt = new ArrayList<CPTValues>();
		PerformanceDB perf = new PerformanceDB();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		HttpSession session = request.getSession();
		
		String venue = (String) session.getAttribute("venue");
		String date = (String) session.getAttribute("date");
		
		if(venue == null) {
			venue = request.getParameter("venue");
		} else if (venue != null && request.getParameter("venue") == null){
			venue = (String) session.getAttribute("venue");
		} else {
			venue = request.getParameter("venue");
		}
		
		if(date == null) {
			date = request.getParameter("datepicker");
		} else if (date != null && request.getParameter("datepicker") == null){
			date = (String) session.getAttribute("date");
		} else {
			date = request.getParameter("datepicker");
		}
		
		System.out.println("Date: " + date);
		System.out.println("Venye: " + venue);

        List<Performance> perfList = PerformanceDB.getPerformancebyDate(date, Integer.parseInt(venue));
        for(int i = 0 ; i<perfList.size(); i++) {
        	cpt.add(cptDB.getCPTData(perfList.get(i).getId()));
        }
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConcertSearchResults.jsp");
		request.setAttribute("cpt", cpt);
		
		session.setAttribute("venue", venue);
		session.setAttribute("date", date);
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
