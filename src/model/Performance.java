package model;

import java.sql.Date;

public class Performance {
	private int Id;
	private Date StartTime;
	private Date EndTime;
	private int concertID;
	private int venueID;
	private int remainingSeats;
	
	public Performance() {
		super();
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public int getConcertID() {
		return concertID;
	}

	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}

	public int getVenueID() {
		return venueID;
	}

	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}
	
	
}
