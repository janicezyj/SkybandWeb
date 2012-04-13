/*  
This file: UserForm.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean form is used to get user's email from the form
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class UserForm extends FormBean {
	private String email = "";
	
	public String getEmail()  { return email; }
	
	public void setEmail(String s)  { email = s; }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (email == null || email.length() == 0) {
			errors.add("Email is required");
		}
		else if (email.matches(".*[<>\"].*")) 
        	errors.add("Email may not contain angle brackets or quotes");
				
		return errors;
	}
}
