package model;


public class ConcertsDB {
	public Concerts getConcertBypID(int pID) {
		DBAccess db = new DBAccess();
		db.connectMeIn();
		Concerts result = db.getConcertBypID(pID);
		db.closeConnection();
		return result;
	}
	
}
