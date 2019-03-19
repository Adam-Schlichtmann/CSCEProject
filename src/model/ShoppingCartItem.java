package model;

public class ShoppingCartItem {
	private CPTValues cpt;
	private int amountOfTickets;
	private int pricePerTicket;
	private int totalPrice;
	
	public ShoppingCartItem() {
		super();
	}

	public CPTValues getCpt() {
		return cpt;
	}

	public void setCpt(CPTValues cpt) {
		this.cpt = cpt;
	}

	public int getAmountOfTickets() {
		return amountOfTickets;
	}

	public void setAmountOfTickets(int amountOfTickets) {
		this.amountOfTickets = amountOfTickets;
	}

	public int getPricePerTicket() {
		return pricePerTicket;
	}

	public void setPricePerTicket(int pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
