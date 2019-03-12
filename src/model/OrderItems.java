package model;

public class OrderItems {
	private int Id;
	private int OrderId;
	private int PerformanceId;
	private int Quantity;
	private int totalPrice;
	private boolean processed;
	private CPTValues cpt;
	
	public OrderItems() {
		super();
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getPerformanceId() {
		return PerformanceId;
	}
	public void setPerformanceId(int performanceId) {
		PerformanceId = performanceId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public CPTValues getCpt() {
		return cpt;
	}

	public void setCpt(CPTValues cpt) {
		this.cpt = cpt;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
}
