/*  
This file: BookmarkFormBean.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean handles the interaction with 
the bookmark form.
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package formbeans;

import java.util.ArrayList;
import java.util.List;
import org.mybeans.form.FormBean;

public class BookmarkForm extends FormBean{
	private String url = "";
	private String comment = "";
	private String button = "";
	
    public String getUrl()  	{ return url; }
    public String getComment()  { return comment; }
    public String getButton()   { return button;   }
    
    public void setUrl(String url)				{ this.url = trimAndConvert(url,"<>\"");}
    public void setComment(String comment)		{ this.comment = trimAndConvert(comment,"<>\"");}
    public void setButton(String button)		{ this.button = button; }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (url == null || url.length() == 0) 
        	errors.add("URL is required");
        else if (url.matches(".*[<>\"].*")) 
        	errors.add("URL may not contain angle brackets or quotes");
        
        if (comment == null || comment.length() == 0) 
        	errors.add("comment is required");
        else if (comment.matches(".*[<>\"].*")) 
        	errors.add("Comment may not contain angle brackets or quotes");
        
        if (button == null) errors.add("Button is required");  
        
        return errors;
    }	
}
