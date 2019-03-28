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

import model.CPTValues;
import model.CPTValuesDB;
import model.Review;
import model.ReviewDB;
import model.TicketNPrices;
import model.TicketTypes;
import model.TicketTypesDB;
import model.TicketVenuePrices;
import model.TicketVenuePricesDB;

/**
 * Servlet implementation class ConcertSearchResult
 */
@WebServlet("/ConcertSearchResult")
public class ConcertSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertSearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CPTValuesDB cptDB = new CPTValuesDB();
        CPTValues cpt = new CPTValues();
        List<CPTValues> temp = new ArrayList<CPTValues>();
        ReviewDB reviewDB = new ReviewDB(); 
        List<Review> review = new ArrayList<Review>();
        String venue = request.getParameter("venue");
        String date = request.getParameter("date");
        request.setAttribute("venue", venue);
        request.setAttribute("date", date);
        
        
		int performanceID = Integer.parseInt(request.getParameter("detailsButton"));
		
		cpt =cptDB.getCPTData(performanceID);
		
		review = ReviewDB.getReview(cpt.getC().getId());
		List<TicketVenuePrices> tickets = new ArrayList<TicketVenuePrices>();
		System.out.println(cpt.getP().getVenueID());
		tickets = TicketVenuePricesDB.getTicketTypesbyPID(performanceID, cpt.getP().getVenueID());
		
		request.setAttribute("cpt", cpt);
		request.setAttribute("review", review);
		
		List<TicketTypes> t = new ArrayList<TicketTypes>();
		for(int i = 0; i < tickets.size(); i++) {
			t.add(TicketTypesDB.getTicketTypesbyID(tickets.get(i).getTicketTypeID()));
		}
		
		List<TicketNPrices> tp = new ArrayList<TicketNPrices>();
		for(int j = 0; j < tickets.size(); j++) {
			TicketNPrices TicketNPricesHolder = new TicketNPrices();
			TicketNPricesHolder.setSeatName(t.get(j).getSeatName());
			TicketNPricesHolder.setTicketPrice(tickets.get(j).getTicketPrice());
			TicketNPricesHolder.setTicketTypeID(tickets.get(j).getTicketTypeID());
			TicketNPricesHolder.setTicketVenuePricesID(tickets.get(j).getIdTicketVenuePrices());
			tp.add(TicketNPricesHolder);
		}
		request.setAttribute("seats", tp);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ConcertDetailsSelection.jsp");
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
