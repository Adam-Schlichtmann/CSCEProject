package model;

import java.util.List;

public class CreditCardsDB {
	public static List<CreditCards> getCreditCards(int cID) {
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<CreditCards> c = db.getCreditCards(cID);
		db.closeConnection();
		return c;
	}
	
}
