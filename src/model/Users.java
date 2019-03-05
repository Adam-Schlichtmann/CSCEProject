package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;



public class Users {
	
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String PostalCode;
	private String EmailAddress;
	private String PhoneNumber;
	private String Birthday;
	private String Username;
	private String Password;
	
	
	
	public Users() {
		super();
	}
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getUserName() {
		return Username;
	}

	public void setUserName(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public void registerUser(Users aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean validateUser(Users u, String path) {
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			
			fis = new FileInputStream(path);
			
			p.load(fis);
				
			// Check whether the user name exists or not
			if(!p.containsKey(u.getUserName())) {	
				return false;
			} else {
				String pword = p.getProperty(u.getUserName());  
				if(!pword.equals(u.getPassword())) {
					return false;
				} else {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	// removeUser
	
	
}
