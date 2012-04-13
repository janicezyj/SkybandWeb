/*  
This file: ListAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to list bookmarks on the website
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.BookmarkDAO;
import model.UserDAO;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.BookmarkBean;
import databeans.UserBean;
import formbeans.UserForm;

/*
 * Looks up the bookmarks for a given "email" (representing a user).
 * 
 * If successful:
 *   (1) Sets the "userList" request attribute in order to display
 *       the list of users on the navbar.
 *   (2) Sets the "bookmarkList" request attribute in order to display
 *       the list of given user's bookmarks for selection.
 *   (3) Forwards to list.jsp.
 */
public class ListAction extends Action {
	private FormBeanFactory<UserForm> formBeanFactory = FormBeanFactory.getInstance(UserForm.class);

	private BookmarkDAO bookmarkDAO;
	private UserDAO  userDAO;

    public ListAction(Model model) {
    	bookmarkDAO = model.getBookmarkDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "list.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the request attributes (the errors list and the form bean so
        // we can just return to the jsp with the form if the request isn't correct)
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserForm form = formBeanFactory.create(request);
	    	
			String email = form.getEmail();
			if (email == null || email.length() == 0) {
				errors.add("Email must be specified");
				return "error.jsp";
			}
	
	        // Set up bookmark list
        	UserBean user = userDAO.lookup(email);
        	if (user == null) {
    			errors.add("Invalid Email: "+ email);
    			return "error.jsp";
    		}

        	BookmarkBean[] bookmarkList = bookmarkDAO.getBookmarks(user.getId());
	        request.setAttribute("bookmarkList",bookmarkList);
	        return "list.jsp";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
