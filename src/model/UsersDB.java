package model;

import model.DBAccess;
import model.Users;

public class UsersDB {
	public static void registerUser(Users aUser) {
       	DBAccess db = new DBAccess();
       	db.connectMeIn();
       	db.addSingleUser(aUser);
       	db.closeConnection();
    }
    
    public static boolean validateUserByUsername(String aUserName) {
    	boolean userExists = false;
       	DBAccess db = new DBAccess();
       	db.connectMeIn();
       	userExists = db.findUserByUsername(aUserName);
       	db.closeConnection();
       	
       	return userExists;
    }
    
    public static boolean validateUserByPassword(String password) {
	    boolean passwordMatches = false;
	    if(password == null) {
	    	return false;
	    }
   	    DBAccess db = new DBAccess();
   	    db.connectMeIn();
   	    passwordMatches = db.findUserByPassword(password);
   	    db.closeConnection();
   	
   	    return passwordMatches;
    }
    
    
    public Users getUser(String aUserName) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	Users aUser = db.returnUserByUsername(aUserName);
	   	db.closeConnection();
	   	
	   	return aUser;
    }
    
    public static Users getUserByID(int userID) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	Users aUser = db.getUserByID(userID);
	   	db.closeConnection();
	   	
	   	return aUser;
    }
    
    public static int getUserID(String username) {
    	int cId = -1;
    	DBAccess db = new DBAccess();
    	db.connectMeIn();
    	cId = db.getCustomerID(username);
    	db.closeConnection();
    	return cId;
    }
    
    public static String getUsersFullName(String username) {
    	String fullname = "";
    	DBAccess db = new DBAccess();
    	db.connectMeIn();
    	fullname = db.getUsersName(username);
    	db.closeConnection();
    	return fullname;
    }
}
