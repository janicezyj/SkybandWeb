/*  
This file: LoginForm.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean handles the interaction with 
the login form.
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String email;
	private String password;
	
	public String getEmail()  { return email; }
	public String getPassword()  { return password; }
	
	public void setEmail(String s) { email = s;  }
	public void setPassword(String s) {	password = s.trim();                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (email == null || email.length() == 0)
			errors.add("Email is required");		
		else if (!email.matches("[A-Za-z0-9_.]+@[A-Za-z0-9_.]+\\.[A-Za-z]+")) 
			errors.add("Invalid Format for E-mail Address");
		else if (email.matches(".*[<>\"].*")) 
        	errors.add("Email may not contain angle brackets or quotes");
		
		if (password == null || password.length() == 0) 
			errors.add("Password is required");
		else if (password.matches(".*[<>\"].*")) 
        	errors.add("Password may not contain angle brackets or quotes");
	        
		return errors;
	}
}