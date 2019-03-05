package model;

import java.sql.Date;
import java.util.List;

public class VenueDB {
	public static List<Venue> getVenue(String name, Date date){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<Venue> c = db.getVenue(name, date);
		db.closeConnection();
		return c;
	}
	public static List<Venue> getAllVenues(){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<Venue> c = db.getAllVenues();
		db.closeConnection();
		return c;
	}
}
