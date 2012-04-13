/*  
This file: Controller.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to control and determine which action
should be executed
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package controller;

import java.io.IOException;
import org.mybeans.dao.DAOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.Transaction;

import model.Model;
import model.UserDAO;
import model.BookmarkDAO;

import databeans.*;


public class Controller extends HttpServlet {
	
	private UserDAO userDAO;
	private BookmarkDAO bookmarkDAO;
    public void init() throws ServletException{
        Model model = new Model(getServletConfig());
        userDAO = model.getUserDAO();
        bookmarkDAO = model.getBookmarkDAO();
        
        Action.add(new ChangePwdAction(model));
        Action.add(new ListAction(model));
        Action.add(new LoginAction(model));
        Action.add(new LogoutAction(model));
        Action.add(new ManageAction(model));
        Action.add(new RegisterAction(model));
        Action.add(new RemoveAction(model));
        Action.add(new AddBmAction(model));
        Action.add(new ViewAction(model));
        
        UserBean userA;
        UserBean userB;
        UserBean userC;
        int userIdA;
        int userIdB;
        int userIdC;
        String emailA = "userA@andrew.cmu.edu";
        String emailB = "userB@andrew.cmu.edu";
        String emailC = "userC@andrew.cmu.edu";
        try {
			if (userDAO.isEmpty()) {
				userDAO.create(emailA, "fnA", "lnA", "aaa");
				userDAO.create(emailB, "fnB", "lnB", "bbb");
				userDAO.create(emailC, "fnC", "lnC", "ccc");
			}
			if (bookmarkDAO.isEmpty()) {
				if ((userA = userDAO.lookup(emailA))!=null){
					userIdA = userA.getId(); 
					bookmarkDAO.create("http://www.google.com", "A's google", userIdA);
					bookmarkDAO.create("http://www.yahoo.com",  "A's yahoo" , userIdA);
					bookmarkDAO.create("http://www.cnn.com", 	 "A's cnn"	 , userIdA);
					bookmarkDAO.create("http://www.cmu.edu", 	 "A's CMU"	 , userIdA);
				}
				if ((userB = userDAO.lookup(emailB))!=null){
					userIdB = userB.getId(); 
					bookmarkDAO.create("http://www.google.com", "B's google", userIdB);
					bookmarkDAO.create("http://www.yahoo.com",  "B's yahoo" , userIdB);
					bookmarkDAO.create("http://www.cnn.com", 	 "B's cnn"	 , userIdB);
					bookmarkDAO.create("http://www.cmu.edu", 	 "B's CMU"	 , userIdB);
				}
				if ((userC = userDAO.lookup(emailC))!=null){
					userIdC = userC.getId(); 
					bookmarkDAO.create("http://www.google.com", "C's google", userIdC);
					bookmarkDAO.create("http://www.yahoo.com",  "C's yahoo" , userIdC);
					bookmarkDAO.create("http://www.cnn.com", 	 "C's cnn"	 , userIdC);
					bookmarkDAO.create("http://www.cmu.edu", 	 "C's CMU"	 , userIdC);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage,request,response);
    }
    
    /*
     * Extracts the requested action and (depending on whether the user is logged in)
     * perform it (or make the user login).
     * @param request
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        HttpSession session     = request.getSession(true);
        String      servletPath = request.getServletPath();
        UserBean        user = (UserBean) session.getAttribute("user");
        String      action = getActionName(servletPath);

        // System.out.println("servletPath="+servletPath+" requestURI="+request.getRequestURI()+"  user="+user);

        if (action.equals("register.do") || action.equals("login.do") || action.equals("list.do") || action.equals("view.do")) {
        	// Allow these actions without logging in
			return Action.perform(action,request);
        }
        
        if (user == null) {
        	// If the user hasn't logged in, direct him to the login page
			return Action.perform("login.do",request);
        }
        
        if (action.equals("start")) {
        	// If he's logged in but back at the /start page, send him to manage his pics
			return Action.perform("manage.do",request);
        }

      	// Let the logged in user run his chosen action
		return Action.perform(action,request);
    }
    
    /*
     * If nextPage is null, send back 404
     * If nextPage starts with a '/', redirect to this page.
     *    In this case, the page must be the whole servlet path including the webapp name
     * Otherwise dispatch to the page (the view)
     *    This is the common case
     * Note: If nextPage equals "image", we will dispatch to /image.  In the web.xml file, "/image"
     *    is mapped to the ImageServlet will which return the image bytes for display.
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	// System.out.println("nextPage="+nextPage);
    	
    	if (nextPage == null) {
    		response.sendError(HttpServletResponse.SC_NOT_FOUND,request.getServletPath());
    		return;
    	}
    	
    	if (nextPage.charAt(0) == '/') {
			String host  = request.getServerName();
			String port  = ":"+String.valueOf(request.getServerPort());
			if (port.equals(":80")) port = "";
			response.sendRedirect("http://"+host+port+nextPage);
			return;
    	}
    	else if (nextPage.charAt(0) == '@')
    	{
    		String URL = nextPage.substring(1);
    		if (URL.startsWith("http://"))
    			response.sendRedirect(URL);
    		else
    			response.sendRedirect("http://" + URL);
			return;
    	}
    	
   		RequestDispatcher d = request.getRequestDispatcher("/"+nextPage);
   		d.forward(request,response);
    }

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
    private String getActionName(String path) {
    	// We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }
}
