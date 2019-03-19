package model;

public class TicketNPrices {
	private int TicketPrice;
	private int TicketTypeID;
	private String seatName;
	private int TicketVenuePricesID;
	private int pID;
	
	public int getTicketTypeID() {
		return TicketTypeID;
	}

	public void setTicketTypeID(int ticketTypeID) {
		TicketTypeID = ticketTypeID;
	}
	
	public TicketNPrices() {
		super();
	}
	
	public int getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(int ticketPtice) {
		TicketPrice = ticketPtice;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public int getTicketVenuePricesID() {
		return TicketVenuePricesID;
	}

	public void setTicketVenuePricesID(int ticketVenuePricesID) {
		TicketVenuePricesID = ticketVenuePricesID;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}
	
	
}
