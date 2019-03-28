//package model;
//
//import java.util.List;
//
//public class CreditCardsDB {
//	public static List<CreditCards> getCreditCards(int cID) {
//		DBAccess db = new DBAccess();
//		db.connectMeIn();
//		List<CreditCards> c = db.getCreditCards(cID);
//		db.closeConnection();
//		return c;
//	}
//	
//	public static CreditCards getCreditCardsByCreditCardNumber(long ccNum) {
//		DBAccess db = new DBAccess();
//		db.connectMeIn();
//		CreditCards c = db.getCreditCardByCreditCardNumber(ccNum);
//		db.closeConnection();
//		return c;
//	}
//	
//	public static void updatebalance(int cID, double cost) {
//		DBAccess db = new DBAccess();
//		db.connectMeIn();
//		db.updateBalance(cID, cost);
//		db.closeConnection();
//	}
//	
//}
