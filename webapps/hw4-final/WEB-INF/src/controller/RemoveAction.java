/*  
This file: RemoveAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to remove a given bookmark
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
import formbeans.IdForm;

/*
 * Removes a photo.  Given an "id" parameter.
 * Checks to see that id is valid number for a photo and that
 * the logged user is the owner.
 * 
 * Sets up the "userList" and "photoList" request attributes
 * and if successful, forwards back to to "manage.jsp".
 */
public class RemoveAction extends Action {
	private FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);

	private BookmarkDAO bookmarkDAO;
	private UserDAO  userDAO;

    public RemoveAction(Model model) {
    	bookmarkDAO = model.getBookmarkDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "remove.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

	    	IdForm form = formBeanFactory.create(request);
	    	
	    	UserBean user = (UserBean) request.getSession().getAttribute("user");

			int id = form.getIdAsInt();
    		bookmarkDAO.delete(id,user.getId());

    		// Be sure to get the photoList after the delete
        	BookmarkBean[] bookmarkList = bookmarkDAO.getBookmarks(user.getId());
	        request.setAttribute("bookmarkList",bookmarkList);

	        return "manage.jsp";
		} catch (DAOException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
		} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
