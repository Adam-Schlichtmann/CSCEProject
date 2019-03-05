package model;

public class Concerts {
	private int id;
	private String ConcertName;
	private String Description;
	private String rating;
	private String Thumbnail;
	
	public Concerts() {
		super();
	}
	
	public String getThumbnail() {
		return Thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConcertName() {
		return ConcertName;
	}
	public void setConcertName(String concertName) {
		ConcertName = concertName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
