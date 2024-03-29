/*
This file: UserBean.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean represents an entry in the 
user database - hsuehhac_user
Last Modified: 2/26/2011
Compiler: JavaSE 1.6
*/

package databeans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class UserBean implements Comparable<UserBean> {
	private int    id		 = -1;
    private String firstName = null;
    private String lastName  = null;
    private String email 	 = null;	//primary key
    
    private String  hashedPassword = "*";
	private int     salt           = 0;

	public UserBean(String email) {
		this.email = email;
	}
	
	public boolean checkPassword(String password) {
		return hashedPassword.equals(hash(password));
	}
	
	public int compareTo(UserBean other) {
		// Order first by lastName and then by firstName, finally by email
		// The result is zero if the strings are equal
		int c = lastName.compareTo(other.lastName);
		if (c != 0) return c;
		c = firstName.compareTo(other.firstName);
		if (c != 0) return c;
		return email.compareTo(other.email);
	}

	public boolean equals(Object obj) {
		if (obj instanceof UserBean) {
			UserBean other = (UserBean) obj;
			return email.equals(other.email);
		}
		return false;
	}
	
    public int    getId()            	{ return id;   }
    public String getHashedPassword() 	{ return hashedPassword; }
    public String getFirstName()        { return firstName;}
    public String getLastName()        	{ return lastName; }
    public String getEmail()        	{ return email;    }	
	public int    getSalt()           	{ return salt;     }
	public int    hashCode()          	{ return email.hashCode(); }
	
    public void setId(int id)	 			{ this.id = id;   }
	public void setHashedPassword(String x) { hashedPassword = x; }
	public void setPassword(String s)       { salt = newSalt(); hashedPassword = hash(s); }
    public void setFirstName(String s)  	{ firstName = s; }
    public void setLastName(String s)  		{ lastName = s;  }
    public void setEmail(String s)  		{ email = s;     }
	public void setSalt(int x)              { salt = x;           }
	
	public String toString() {
		return "Email("+getEmail()+")";
	}
	
	private String hash(String clearPassword) {
		if (salt == 0) return null;

		MessageDigest md = null;
		try {
		  md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
		  throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}

		String saltString = String.valueOf(salt);
		
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		byte[] digestBytes = md.digest();

		// Format the digest as a String
		StringBuffer digestSB = new StringBuffer();
		for (int i=0; i<digestBytes.length; i++) {
		  int lowNibble = digestBytes[i] & 0x0f;
		  int highNibble = (digestBytes[i]>>4) & 0x0f;
		  digestSB.append(Integer.toHexString(highNibble));
		  digestSB.append(Integer.toHexString(lowNibble));
		}
		String digestStr = digestSB.toString();

		return digestStr;
	}

	private int newSalt() {
		Random random = new Random();
		return random.nextInt(8192)+1;  // salt cannot be zero
	}
}
