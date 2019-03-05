package model;

import java.sql.Date;
import java.util.List;

public class PerformanceDB {
	public static List<Performance> getPerformancebyDate(String d, int vID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		List<Performance> c = db.getPerformancebyDateandVenue(d, vID);
		db.closeConnection();
		return c;
	}
	
	public static Performance getPerformancebyID(int pID){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		Performance p = db.getPerformancebyID(pID);
		db.closeConnection();
		return p;
	}
}
