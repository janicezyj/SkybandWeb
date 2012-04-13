/*  
This file: IdForm.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean form is used to get Id from the form
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class IdForm extends FormBean {
	private String id;

	public String getId() { return id;    }
	
	public int getIdAsInt() {
		try {
			return Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// call getValidationErrors() to detect this
			return -1;
		}
	}
	public void setId(String id) { this.id = id; }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if (id == null || id.length() == 0) {
			errors.add("Id is required");
			return errors;
		}

		try {
			Integer.parseInt(id);
		} catch (NumberFormatException e) {
			errors.add("Id is not an integer");
		}
		
		return errors;
	}
}
