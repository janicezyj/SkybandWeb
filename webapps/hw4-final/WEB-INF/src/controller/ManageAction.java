/*  
This file: ManageAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to manage bookmarks
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

import databeans.BookmarkBean;
import databeans.UserBean;


/*
 * Sets up the request attributes for manage.jsp.
 * This is the way to enter "Manage Your Photos"
 * from someplace else in the site.
 * 
 * Sets the "userList" request attribute in order to display
 * the list of users on the navbar.
 * 
 * Sets the "photoList" request attribute in order to display
 * the list of user's photos for management.
 * 
 * Forwards to manage.jsp.
 */
public class ManageAction extends Action {

	private BookmarkDAO bookmarkDAO;
	private UserDAO  userDAO;

	public ManageAction(Model model) {
    	bookmarkDAO = model.getBookmarkDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "manage.do"; }

	public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserBean user = (UserBean) request.getSession(false).getAttribute("user");
        	BookmarkBean[] bookmarkList = bookmarkDAO.getBookmarks(user.getId());
	        request.setAttribute("bookmarkList",bookmarkList);

	        return "manage.jsp";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
