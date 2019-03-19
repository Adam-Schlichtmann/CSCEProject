package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Blob;

public class ShoppingCart {
	private List<ShoppingCartItem> items;
	private int TotalPrice;
	
	public ShoppingCart() {
		super();
		items = new ArrayList<ShoppingCartItem>();
	}
	
	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}
	
	public void addToCart(ShoppingCartItem item) {
		this.items.add(item);
	}
	
	public void calculateNewTotalPrice() {
		int temp;
		this.setTotalPrice(0);
		for(int i=0;i<items.size();i++) {
			temp = items.get(i).getAmountOfTickets() * items.get(i).getPricePerTicket();
			this.TotalPrice += temp;
		}
	}
	
	
}
