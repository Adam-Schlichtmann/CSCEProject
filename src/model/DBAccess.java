package model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import util.hashingUtil;

import model.Users;

import com.mysql.jdbc.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class DBAccess {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	static Logger log = Logger.getLogger(DBAccess.class.getName());
	String path = "/WebContent/WEB-INF/lib/log4j.properties";
	
	
	
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/aschlichtm"; 
	//final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_LOGIN";
	
	

	//  Database credentials
	static final String USER = "aschlichtm"; // Replace with your CSE_LOGIN
	static final String PASS = "LM6-dy";   // Replace with your CSE MySQL_PASSWORD
	
	
// <---------------REVIEWS------------------>
	public String addReview(Review r) {
		PropertyConfigurator.configure(path);
		String result = "p";
		try {
		  stmt = conn.createStatement();
		  String sql;
		  int concertID = r.getConcertID();
		  int userID = r.getUserID();
		  String reviewDate = r.getReviewDate();
		  int rating = r.getRating();
		  String review = r.getReview();
		  
		  

		  sql = "INSERT INTO customerreviews (concertID, userID, ReviewDate, Rating, Review)" +
		          "VALUES (?, ?, ?, ?, ?)";
		  
		  ps = conn.prepareStatement(sql);
		  ps.setInt(1, concertID);
		  ps.setInt(2, userID);
		  ps.setString(3, reviewDate);
		  ps.setInt(4, rating);
		  ps.setString(5, review);
		  ps.executeUpdate();
		  
		  // stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				//log.error("SQL Error: ", e);
				e.printStackTrace();
				result = "fail";
				
		}
		return result;
	}
	
	public List<Review> getReview(int concertID) {
		List<Review> r  = new ArrayList<Review>();
		String SQL = "SELECT * from customerreviews WHERE concertID='"+concertID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()) {
				Review rh = new Review();
				rh.setConcertID(Integer.parseInt(rs.getString("concertID")));
				rh.setRating(Integer.parseInt(rs.getString("Rating")));
				rh.setUserID(Integer.parseInt(rs.getString("userID")));
				rh.setReviewDate(rs.getString("ReviewDate"));
				rh.setReview(rs.getString("review"));
				rh.setUser(this.getUserByID(rh.getUserID()));
			    r.add(rh);
			}
			stat.close();
		        
		} catch (SQLException e) {
			//log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return r;
	}
	
	
	// <---------------Performances------------------>
	public List<Performance> getPerformancebyDateandVenue(String d, int vID) {
		List<Performance> p  = new ArrayList<Performance>();
		String SQL = "SELECT * from performance WHERE StartTime>'"+d+"' and venueID='" + vID +"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Performance PerformanceHolder = new Performance();
				PerformanceHolder.setStartTime(rs.getDate("StartTime"));
				PerformanceHolder.setEndTime(rs.getDate("EndTime"));
				PerformanceHolder.setConcertID(rs.getInt("concertID"));
				PerformanceHolder.setVenueID(rs.getInt("venueID"));
				PerformanceHolder.setId(rs.getInt("Id"));
				PerformanceHolder.setRemainingSeats(rs.getInt("remainingSeats"));
				p.add(PerformanceHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return p;
		
	}
	
	public Performance getPerformancebyID(int pID) {
		Performance p  = new Performance();
		String SQL = "SELECT * from performance WHERE Id='"+pID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				p.setStartTime(rs.getDate("StartTime"));
				p.setEndTime(rs.getDate("EndTime"));
				p.setConcertID(rs.getInt("concertID"));
				p.setVenueID(rs.getInt("venueID"));
				p.setId(rs.getInt("Id"));
				p.setRemainingSeats(rs.getInt("remainingSeats"));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: : ", e);
			e.printStackTrace();
		}
		return p;
		
	}
	
	public void updateRemainingTickets(int pID, int tickets){
		String SQL = "SELECT remainingSeats from performance WHERE Id='"+pID+"'";
	    Statement stat;
	    int remaining;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			rs.next();
			remaining = rs.getInt("remainingSeats");
			remaining = remaining - tickets;
			SQL = "UPDATE performance SET remainingSeats='"+ remaining+"' WHERE Id='"+pID+"'";
			stat.executeUpdate(SQL);
		    stat.close();   
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	// <---------------Concerts------------------>
	public Concerts getConcertBypID(int pID) {
		Concerts c  = new Concerts();
		String SQL = "SELECT * from performance WHERE Id='"+pID+"'";
		int cID = -1;
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				cID = rs.getInt("concertID");
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		
		SQL = "SELECT * from concert WHERE Id ='" + cID + "'";
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				c.setId(rs.getInt("Id"));
				c.setConcertName(rs.getString("ConcertName"));
				c.setDescription(rs.getString("Description"));
				c.setRating(rs.getString("Rating"));
				c.setThumbnail(rs.getString("Thumbnail"));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return c;
		
	}
	
	// <---------------Venues------------------>
	public List<Venue> getVenue(String VenueName, Date date) {
		List<Venue> v  = new ArrayList<Venue>();
		String SQL = "SELECT * from venue WHERE Name='"+VenueName+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Venue VenueHolder = new Venue();
				VenueHolder.setName(rs.getString("Name"));
				VenueHolder.setAddress(rs.getString("Address"));
				VenueHolder.setCity(rs.getString("City"));
				VenueHolder.setState(rs.getString("State"));
				VenueHolder.setPostalCode(rs.getString("PostalCode"));
				v.add(VenueHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return v;
		
	}
	
	public Venue getVenueByID(int id) {
		Venue VenueHolder = new Venue();
		String SQL = "SELECT * from venue WHERE Id='"+id+"'";
	    Statement stat;
	    try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				VenueHolder.setName(rs.getString("Name"));
				VenueHolder.setAddress(rs.getString("Address"));
				VenueHolder.setCity(rs.getString("City"));
				VenueHolder.setState(rs.getString("State"));
				VenueHolder.setPostalCode(rs.getString("PostalCode"));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return VenueHolder;
		
	}
	
	public List<Venue> getAllVenues() {
		List<Venue> v  = new ArrayList<Venue>();
		String SQL = "SELECT * from venue";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Venue VenueHolder = new Venue();
				VenueHolder.setName(rs.getString("Name"));
				VenueHolder.setAddress(rs.getString("Address"));
				VenueHolder.setCity(rs.getString("City"));
				VenueHolder.setState(rs.getString("State"));
				VenueHolder.setPostalCode(rs.getString("PostalCode"));
				VenueHolder.setId(rs.getInt("Id"));
				v.add(VenueHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return v;
		
	}
	
	
//	// <---------------ShoppingCart------------------>
//	public List<ShoppingCart> getShoppingCartbyOID(int oID, int TID) {
//		List<ShoppingCart>  o = new ArrayList<ShoppingCart>();
//		String SQL = "SELECT * from orderitmes WHERE OrderId='"+oID+"'";
//	    Statement stat;
//		try {
//			stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery(SQL);
//			while (rs.next()){
//				ShoppingCart SCHolder = new ShoppingCart();
//				SCHolder.setTicketQuantity(rs.getInt("Quantity"));
//				SCHolder.setPerformanceID(rs.getInt("PerformanceID"));
//				o.add(SCHolder);
//		    }
//			for(int i=0; i< o.size(); i++) {
//				SQL = "Select * from performance WHERE Id='" + o.get(i).getPerformanceID() + "'";
//				rs = stat.executeQuery(SQL);
//				while (rs.next()){
//					o.get(i).setShowtime(rs.getDate("StartTime"));
//					o.get(i).setConcertID(rs.getInt("concertID"));
//				}
//			}
//			
//			for(int i=0; i< o.size(); i++) {
//				SQL = "Select * from concert WHERE Id='" + o.get(i).getConcertID() + "'";
//				rs = stat.executeQuery(SQL);
//				while (rs.next()){
//					o.get(i).setPerformer(rs.getString("ConcertName"));
//					o.get(i).setThumbnail(rs.getBlob("Thumbnail")); 
//				}
//			}
//			
//			for(int i=0; i< o.size(); i++) {
//				SQL = "Select * from TicketVenuePrice WHERE performanceID='" + 
//							o.get(i).getPerformanceID() + "' AND ticketTypeID='" + TID +"'";
//				rs = stat.executeQuery(SQL);
//				while (rs.next()){
//					o.get(i).setTicketPrice(rs.getInt("TicketPrice"));
//					o.get(i).setTicketTypeID(TID);
//				}
//			}
//			
//			
//		    stat.close();
//		        
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return o;
//		
//	}
//	
	// <---------------Orders------------------>
	public List<Orders> getOrdersByCustomerID(int cID) {
		List<Orders>  o = new ArrayList<Orders>();
		String SQL = "SELECT * from orders WHERE CustomerId='"+cID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Orders OrderHolder = new Orders();
				OrderHolder.setId(rs.getInt("Id"));
				OrderHolder.setTotalCost(rs.getInt("TotalCost"));
				OrderHolder.setOrderDate(rs.getDate("OrderDate"));
				OrderHolder.setBillingAddress(rs.getString("BillingAddress"));
				OrderHolder.setCreditCardNumber(rs.getLong("CreditCardNumber"));
				o.add(OrderHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return o;
		
	}
	
	public List<Orders> getAllOrders() {
		List<Orders>  o = new ArrayList<Orders>();
		String SQL = "SELECT * from orders ";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Orders OrderHolder = new Orders();
				OrderHolder.setId(rs.getInt("Id"));
				OrderHolder.setTotalCost(rs.getInt("TotalCost"));
				OrderHolder.setOrderDate(rs.getDate("OrderDate"));
				OrderHolder.setBillingAddress(rs.getString("BillingAddress"));
				OrderHolder.setCreditCardNumber(rs.getLong("CreditCardNumber"));
				o.add(OrderHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return o;
		
	}
	
	public Orders getOrdersByOrdersID(int oID) {
		List<Orders>  o = new ArrayList<Orders>();
		String SQL = "SELECT * from orders WHERE Id='"+oID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				Orders OrderHolder = new Orders();
				OrderHolder.setId(rs.getInt("Id"));
				OrderHolder.setTotalCost(rs.getInt("TotalCost"));
				OrderHolder.setOrderDate(rs.getDate("OrderDate"));
				OrderHolder.setBillingAddress(rs.getString("BillingAddress"));
				OrderHolder.setShippingAddress(rs.getString("ShippingAddress"));
				OrderHolder.setCreditCardNumber(rs.getLong("CreditCardNumber"));
				o.add(OrderHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return o.get(0);
		
	}
	
	public void delOrder(int oID) {
		String SQL = "DELETE from orders WHERE Id='"+oID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	public void createOrder(Orders o) {
		int cID = o.getCustomerId();
		int TC = o.getTotalCost();
		Date day = o.getOrderDate();
		String billAdd = o.getBillingAddress();
		String shippAdd = o.getShippingAddress();
		long CCN = o.getCreditCardNumber();
		try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO orders (CustomerId, TotalCost, OrderDate, BillingAddress, ShippingAddress, CreditCardNumber)" +
			          "VALUES (?, ?, ?, ?, ?, ?)";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, cID);
			  ps.setInt(2, TC);
			  ps.setDate(3, day);
			  ps.setString(4, billAdd);
			  ps.setString(5, shippAdd);
			  ps.setLong(6, CCN);
			  ps.executeUpdate();
//			  stmt.executeUpdate(sql);
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	// <---------------OrderItems------------------>
	public List<OrderItems> getOrderItemsbyOrderID(int cID) {
		List<OrderItems>  o = new ArrayList<OrderItems>();
		CPTValuesDB cptDB = new CPTValuesDB();
		String SQL = "SELECT * from orderitems WHERE OrderId='"+cID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				OrderItems OrderItemHolder = new OrderItems();
				OrderItemHolder.setId(rs.getInt("Id"));
				OrderItemHolder.setOrderId(rs.getInt("OrderId"));
				OrderItemHolder.setPerformanceId(rs.getInt("PerformanceId"));
				OrderItemHolder.setQuantity(rs.getInt("Quantity"));
				OrderItemHolder.setCpt(cptDB.getCPTData(OrderItemHolder.getPerformanceId()));
				o.add(OrderItemHolder);
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return o;
		
	}
	
	public OrderItems getOrderItembyOrderItemID(int oID) {
		CPTValuesDB cptDB = new CPTValuesDB();
		OrderItems OrderItemHolder = new OrderItems();
		String SQL = "SELECT * from orderitems WHERE Id='"+oID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				OrderItemHolder.setId(rs.getInt("Id"));
				OrderItemHolder.setOrderId(rs.getInt("OrderId"));
				OrderItemHolder.setPerformanceId(rs.getInt("PerformanceId"));
				OrderItemHolder.setQuantity(rs.getInt("Quantity"));
				OrderItemHolder.setCpt(cptDB.getCPTData(OrderItemHolder.getPerformanceId()));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return OrderItemHolder;
		
	}
	
	public void delOrderItem(int oID) {
		String SQL = "DELETE from orderitems WHERE Id='"+oID+"'";
	    Statement stat;
		try {
			stat = conn.createStatement();
			int rs = stat.executeUpdate(SQL);
		    stat.close();
		        
		} catch (SQLException e) {
 			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	public void addOrderItem(OrderItems o) {
		int oID = o.getOrderId();
		int pID = o.getPerformanceId();
		int quantity = o.getQuantity();
		try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO orderitems (OrderId, PerformanceID, Quantity)" +
			          "VALUES (?, ?, ?)";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, oID);
			  ps.setInt(2, pID);
			  ps.setInt(3, quantity);
			  ps.executeUpdate();
			  
			// stmt.executeUpdate(sql);
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	
	
	// <---------------TicketTypes------------------>
		public TicketTypes getTicketTypesbyID(int tID) {
			TicketTypes TicketHolder = new TicketTypes();
			String SQL = "SELECT * from tickettypes WHERE idTicket='"+tID+"'";
		    Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				while (rs.next()){
					TicketHolder.setIdTicket(rs.getInt("idTicket"));
					TicketHolder.setSeatName(rs.getString("SeatName"));
					TicketHolder.setTicket(rs.getString("Ticket"));
				}
			    stat.close();
			} catch (SQLException e) {
				log.error("SQL Error: ", e);
				e.printStackTrace();
			}
			return TicketHolder;
		}
		
	// <---------------TicketVenuePrices------------------>
		public List<TicketVenuePrices> getTicketVenuePricesbyVenueID(int vID) {
			List<TicketVenuePrices>  t = new ArrayList<TicketVenuePrices>();
			String SQL = "SELECT * from TicketVenuePrices WHERE idTicketVenuePrices='"+vID+"'";
		    Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				while (rs.next()){
					TicketVenuePrices TicketVPriceHolder = new TicketVenuePrices();
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("idTicketVenuePrices"));
					TicketVPriceHolder.setVenueID(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketPrice(rs.getInt("TicketPrice"));
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketTypeID(rs.getInt("ticketTypeID"));
					TicketVPriceHolder.setPerformanceID(rs.getInt("performanceID"));
					t.add(TicketVPriceHolder);
				}
			    stat.close();
			} catch (SQLException e) {
				log.error("SQL Error: ", e);
				e.printStackTrace();
			}
			return t;
		}
		
		
		public List<TicketVenuePrices> getTicketVenuePricesbyVenuePID(int PID, int vID) {
			String SQL = "SELECT * from TicketVenuePrices WHERE performanceID='"+PID+"' AND venueID='"+vID+"'";
		    Statement stat;
		    List<TicketVenuePrices> t = new ArrayList<TicketVenuePrices>();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				while (rs.next()){
					TicketVenuePrices TicketVPriceHolder = new TicketVenuePrices();
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("idTicketVenuePrices"));
					TicketVPriceHolder.setVenueID(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketPrice(rs.getInt("TicketPrice"));
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketTypeID(rs.getInt("ticketTypeID"));
					TicketVPriceHolder.setPerformanceID(rs.getInt("performanceID"));
					t.add(TicketVPriceHolder);
				}
			    stat.close();
			} catch (SQLException e) {
				log.error("SQL Error: ", e);
				e.printStackTrace();
			}
			return t;
		}
		
		public TicketVenuePrices getTicketVenuePricesbyVenuePIDSingle(int PID) {
			String SQL = "SELECT * from TicketVenuePrices WHERE performanceID='"+PID+"'";
		    Statement stat;
		    TicketVenuePrices TicketVPriceHolder = new TicketVenuePrices();
			try {
				stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				while (rs.next()){
					
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("idTicketVenuePrices"));
					TicketVPriceHolder.setVenueID(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketPrice(rs.getInt("TicketPrice"));
					TicketVPriceHolder.setIdTicketVenuePrices(rs.getInt("venueID"));
					TicketVPriceHolder.setTicketTypeID(rs.getInt("ticketTypeID"));
					TicketVPriceHolder.setPerformanceID(rs.getInt("performanceID"));
				}
			    stat.close();
			} catch (SQLException e) {
				log.error("SQL Error: ", e);
				e.printStackTrace();
			}
			return TicketVPriceHolder;
		}
		
	
	// <---------------Users------------------>
	public void addSingleUser(Users aUser) {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  String firstName = aUser.getFirstName();
		  String lastName = aUser.getLastName();
		  String userName = aUser.getUserName();
		  String password = aUser.getPassword();
		  String hashedpword = "";
		try {
			hashedpword = hashingUtil.hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			log.error("No Such Algorithm: ", e);
			e.printStackTrace();
		}
		  

		  sql = "INSERT INTO users (FirstName, LastName, Username, Password)" +
		          "VALUES (?, ?, ?, ?)";
		  ps = conn.prepareStatement(sql);
		  ps.setString(1, firstName);
		  ps.setString(2, lastName);
		  ps.setString(3, userName);
		  ps.setString(4, hashedpword);
		  ps.executeUpdate();
		  
		  // stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
			  log.error("SQL Error: ", e);
			  e.printStackTrace();
		}
		
	}
	
	public boolean findUserByUsername(String aUserName) {
		boolean userExists = false;
		String SQL = "SELECT * from users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(aUserName.equals( rs.getString("Username") )) {
					userExists = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		
		return userExists;
	}
	
	public boolean findUserByPassword(String password) {
		boolean passwordMatches = false;
		String SQL = "SELECT * from users";
	    Statement stat;
	    String hashedPword = "";
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				try {
					hashedPword = hashingUtil.hashPassword(password);
					if(hashedPword.equals(rs.getString("Password"))) {
						passwordMatches = true;
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					log.error("No Such Algorithm: ", e);
					e.printStackTrace();
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		
		return passwordMatches;
	}
	
	public int getCustomerID(String username) {
		String SQL = "SELECT * from users where Username='"+username+"'";
	    Statement stat;
	    int cId = -1;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				if(username.equals( rs.getString("Username") )) {
					cId = rs.getInt("Id");
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return cId;
	}
	
	public Users getUserByID(int userID) {
		String SQL = "SELECT * from users where Id='"+userID+"'";
	    Statement stat;
	    Users user = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setAddress(rs.getString("Address"));
				user.setBirthday(rs.getString("Birthday"));
				user.setCity(rs.getString("City"));
				user.setPassword(rs.getString("Password"));
				user.setPhoneNumber(rs.getString("PhoneNumber"));
				user.setUserName(rs.getString("Username"));
			    user.setState(rs.getString("State"));
			    user.setPostalCode(rs.getString("PostalCode"));
			    user.setId(Integer.parseInt(rs.getString("iD")));
			}
			stat.close();
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		return user;
	}
	
	public String getUsersName(String username) {
		String SQL = "SELECT * from users where Username='"+username+"'";
	    Statement stat;
	    String fname = "";
	    String lname = "";
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				if(username.equals( rs.getString("Username") )) {
					fname = rs.getString("FirstName");
					lname = rs.getString("LastName");
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		String fullname = fname + " " + lname;
		return fullname;
	}
	
	public Users returnUserByUsername(String aUserName) {
		String SQL = "SELECT * from users";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString(4) )) {
					aUser.setFirstName(rs.getString(2));
					aUser.setLastName(rs.getString(3));
					aUser.setUserName(rs.getString(4));
					try {
						aUser.setPassword(hashingUtil.hashPassword( rs.getString(5)));
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						log.error("No Such Algorithm: ", e);
						e.printStackTrace();
					}
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
		
		return aUser;
	}

	
	public void displayAllUsers() {
		String SQL = "SELECT * from users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
		        System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3)
		        		+ " " + rs.getString(4) + " " + rs.getString(5));
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}

	// <---------------Connection------------------>
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			log.error("SQL Error: ", e);
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			log.error("SQL Error: ", e);
		}
	}


}
