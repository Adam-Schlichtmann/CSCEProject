package model;

public class TicketNPrices {
	private int TicketPrice;
	private String seatName;
	
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
	
	
}
