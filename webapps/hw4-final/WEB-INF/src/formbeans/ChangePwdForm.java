/*  
This file: ChangePwdForm.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The form bean handles the password change
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangePwdForm extends FormBean {
	private String confirmPassword;
	private String newPassword;
	
	public String getConfirmPassword() { return confirmPassword; }
	public String getNewPassword()     { return newPassword;     }
	
	public void setConfirmPassword(String s) { confirmPassword = s.trim(); }
	public void setNewPassword(String s)     { newPassword     = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (newPassword == null || newPassword.length() == 0) {
			errors.add("New Password is required");
		}
		else if (newPassword.matches(".*[<>\"].*")) 
        	errors.add("New password may not contain angle brackets or quotes");
		
		if (confirmPassword == null || confirmPassword.length() == 0) {
			errors.add("Confirm Pwd is required");
		}
		else if (confirmPassword.matches(".*[<>\"].*")) 
        	errors.add("Confirmed password may not contain angle brackets or quotes");
		
		if (errors.size() > 0) {
			return errors;
		}
		
		if (!newPassword.equals(confirmPassword)) {
			errors.add("Passwords do not match");
		}

		return errors;
	}
}
