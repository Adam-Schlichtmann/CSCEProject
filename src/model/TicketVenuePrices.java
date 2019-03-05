package model;

public class TicketVenuePrices {
	private int idTicketVenuePrices;
	private int TicketPrice;
	private int venueID;
	private int ticketTypeID;
	private int performanceID;
	
	public TicketVenuePrices() {
		super();
	}
	
	public int getIdTicketVenuePrices() {
		return idTicketVenuePrices;
	}
	public void setIdTicketVenuePrices(int idTicketVenuePrices) {
		this.idTicketVenuePrices = idTicketVenuePrices;
	}
	public int getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}
	public int getVenueID() {
		return venueID;
	}
	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}
	public int getTicketTypeID() {
		return ticketTypeID;
	}
	public void setTicketTypeID(int ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}
	public int getPerformanceID() {
		return performanceID;
	}
	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}
	
}
