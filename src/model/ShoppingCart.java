package model;

import java.sql.Date;

import com.mysql.jdbc.Blob;

public class ShoppingCart {
	private int ConcertID;
	private int TicketQuantity;
	private String Performer;
	private java.sql.Blob Thumbnail;
	private Date Showtime;
	private int TicketPrice;
	private int PerformanceID;
	private int TicketTypeID;
	
	public ShoppingCart() {
		super();
	}

	public int getTicketTypeID() {
		return TicketTypeID;
	}

	public void setTicketTypeID(int ticketTypeID) {
		TicketTypeID = ticketTypeID;
	}

	public int getPerformanceID() {
		return PerformanceID;
	}

	public void setPerformanceID(int performanceID) {
		PerformanceID = performanceID;
	}

	public int getConcertID() {
		return ConcertID;
	}

	public void setConcertID(int concertID) {
		ConcertID = concertID;
	}

	public int getTicketQuantity() {
		return TicketQuantity;
	}

	public void setTicketQuantity(int ticketQuantity) {
		TicketQuantity = ticketQuantity;
	}

	public String getPerformer() {
		return Performer;
	}

	public void setPerformer(String performer) {
		Performer = performer;
	}

	public java.sql.Blob getThumbnail() {
		return Thumbnail;
	}

	public void setThumbnail(java.sql.Blob blob) {
		Thumbnail = blob;
	}

	public Date getShowtime() {
		return Showtime;
	}

	public void setShowtime(Date showtime) {
		Showtime = showtime;
	}

	public int getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}
	
	
	
}
