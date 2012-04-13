/*  
This file: RegisterForm.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean handles the interaction with 
the registration form.
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirm ;
	
	public String getFirstName() { return firstName; }
	public String getLastName()  { return lastName;  }
	public String getEmail()  	 { return email;  	 }
	public String getPassword()  { return password;  }
	public String getConfirm()   { return confirm;   }
	
	public void setFirstName(String s) { firstName = trimAndConvert(s,"<>\"");;  }
	public void setLastName(String s)  { lastName  = trimAndConvert(s,"<>\"");;  }
	public void setEmail(String s)     { email     = trimAndConvert(s,"<>\"");;  }
	public void setPassword(String s)  { password  = s.trim();                  }
	public void setConfirm(String s)   { confirm   = s.trim();                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (firstName == null || firstName.length() == 0) {
			errors.add("First Name is required");
		}
		else if (firstName.matches(".*[<>\"].*")) 
        	errors.add("First name may not contain angle brackets or quotes");

		if (lastName == null || lastName.length() == 0) {
			errors.add("Last Name is required");
		}
		else if (lastName.matches(".*[<>\"].*")) 
        	errors.add("Last name may not contain angle brackets or quotes");

		if (email == null || email.length() == 0) {
			errors.add("Email is required");
		}
		else if (!email.matches("[A-Za-z0-9_.]+@[A-Za-z0-9_.]+\\.[A-Za-z]+")){ 
			errors.add("Invalid Format for E-mail Address");
		}
		else if (email.matches(".*[<>\"].*")) 
        	errors.add("Email may not contain angle brackets or quotes");

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		else if (password.matches(".*[<>\"].*")) 
        	errors.add("Password may not contain angle brackets or quotes");
		
		if (confirm == null || confirm.length() == 0) {
			errors.add("Confirm Password is required");
		}
		else if (confirm.matches(".*[<>\"].*")) 
        	errors.add("Confirmed password may not contain angle brackets or quotes");
				
		if (errors.size() > 0) {
			return errors;
		}
		
		if (!password.equals(confirm)) {
			errors.add("Passwords are not the same");
		}
		
		return errors;
	}
}
