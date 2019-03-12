package model;

import java.util.List;

public class OrderItemsDB {
	public static List<OrderItems> getOrderItemsbyOrderID(int oID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<OrderItems> o = db.getOrderItemsbyOrderID(oID);
		db.closeConnection();
		return o;
	}
	
	public static OrderItems getOrderItembyOrderItemID(int oID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		OrderItems o = db.getOrderItembyOrderItemID(oID);
		db.closeConnection();
		return o;
	}
	
	public static void delOrderItem(int oID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		db.delOrderItem(oID);
		db.closeConnection();
	}
}
