package model;

import java.sql.Date;

public class Orders {
	private int Id;
	private int CustomerId;
	private int TotalCost;
	private Date OrderDate;
	private String ShippingAddress;
	private String BillingAddress;
	private long CreditCardNumber;
	
	public Orders() {
		super();
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public String getBillingAddress() {
		return BillingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}
	public long getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}

	public String getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}
}
