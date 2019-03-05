package model;

import java.util.List;

public class TicketVenuePricesDB {
	public static List<TicketVenuePrices> getTicketTypesbyID(int tID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<TicketVenuePrices> t = db.getTicketVenuePricesbyVenueID(tID);
		db.closeConnection();
		return t;
	}
	
	public static List<TicketVenuePrices> getTicketTypesbyPID(int PID, int vID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<TicketVenuePrices> t = db.getTicketVenuePricesbyVenuePID(PID, vID);
		db.closeConnection();
		return t;
	}
}
