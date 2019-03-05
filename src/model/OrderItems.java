package model;

public class OrderItems {
	private int Id;
	private int OrderId;
	private int PerformanceId;
	private int Quantity;
	
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
}
