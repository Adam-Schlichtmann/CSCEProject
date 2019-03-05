package model;

public class Review {
	int concertID;
	Users user;
	int userID;
	String reviewDate;
	int rating;
	String review;
	
	public Review() {
		super();
	}

	public int getConcertID() {
		return concertID;
	}

	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
