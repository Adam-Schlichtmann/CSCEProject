package model;

import java.util.List;

public class TicketTypesDB {
	public static TicketTypes getTicketTypesbyID(int tID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		TicketTypes t = db.getTicketTypesbyID(tID);
		db.closeConnection();
		return t;
	}
}
