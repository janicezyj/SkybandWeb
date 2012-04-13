/*  
This file: LogoutAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to do logout for user
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.dao.DAOException;

import model.Model;
import model.UserDAO;


/*
 * Logs out by setting the "user" session attribute to null.
 * (Actions don't be much simpler than this.)
 */
public class LogoutAction extends Action {

	private UserDAO  userDAO;
	
	public LogoutAction(Model model) { 
		userDAO  = model.getUserDAO();
	}

	public String getName() { return "logout.do"; }

	public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
		try {
			request.setAttribute("userList",userDAO.getUsers());
		} catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
		}
        HttpSession session = request.getSession(false);
        session.setAttribute("user",null);

		request.setAttribute("message","You are now logged out");
        return "success.jsp";
    }
}
