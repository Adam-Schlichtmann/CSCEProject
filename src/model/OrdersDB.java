package model;

import java.util.List;

public class OrdersDB {
	public static List<Orders> getOrdersByCustomerID(int cID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<Orders> o = db.getOrdersByCustomerID(cID);
		db.closeConnection();
		return o;
	}
	
	public static List<Orders> getAllOrders(){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<Orders> o = db.getAllOrders();
		db.closeConnection();
		return o;
	}
	
	public static Orders getOrdersByOrderID(int oID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		Orders o = db.getOrdersByOrdersID(oID);
		db.closeConnection();
		return o;
	}
	
	public static void delOrder(int oID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		db.delOrder(oID);
		db.closeConnection();
	}
	
	public static void createOrder(Orders o){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		db.createOrder(o);
		db.closeConnection();
	}
	
	public static void updateBalance(int oID, int balance){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		db.updateBalance(oID, balance);
		db.closeConnection();
	}
	
	
}
