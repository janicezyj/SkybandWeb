/*  
This file: LoginAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to do login for user
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.UserDAO;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.UserBean;
import formbeans.LoginForm;

/*
 * Processes the parameters from the form in login.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */
public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private UserDAO userDAO;
	
	public LoginAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	request.setAttribute("userList",userDAO.getUsers());
        	
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);

	        // If the servlet path isn't "/login.do", the controller sent a request here
	        // because the user needed to login.  We want to support redirect back to the
	        // original request only if the user is just trying to view an image.
	        // So, only set up redirect back to original request path="/view.do".
	        if (request.getServletPath().equals("/view.do")) {
	        	String redirectTo = request.getRequestURI()+"?"+request.getQueryString();
	        	HttpSession session = request.getSession();
	        	session.setAttribute("redirectTo",redirectTo);
	        }

	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "login.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "login.jsp";
	        }

	        // Look up the user
	        UserBean user = userDAO.lookup(form.getEmail());
	        
	        if (user == null) {
	            errors.add("Email not found");
	            return "login.jsp";
	        }

	        // Check the password
	        if (!user.checkPassword(form.getPassword())) {
	            errors.add("Incorrect password");
	            return "login.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        HttpSession session = request.getSession();
	        session.setAttribute("user",user);
	
	        // After successful login send to...
	        String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;
	        
	        
	        // If redirectTo is null, redirect to the "manage" action
			String webapp = request.getContextPath();
			return webapp + "/manage.do";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
