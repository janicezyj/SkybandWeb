package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;


public class Controller extends HttpServlet {

    public void init() throws ServletException{
        
        Action.add(new ClickTableAction());
        Action.add(new LoginAction());
        Action.add(new SubmitAttrAction());
        Action.add(new ClickObjectAction());
        Action.add(new SubmitAttrAction());
        Action.add(new SubspaceViewAction());
        Action.add(new ObjectViewAction());
        Action.add(new SettingAction());
        Action.add(new SubtractVisAttrAction());
        Action.add(new AddVisAttrAction());
        Action.add(new CheckClaimAction());
        Action.add(new SubmitClaimAction());
        Action.add(new ChangeDefaultAction());
        Action.add(new SubmitDefaultSettingAction());
        Action.add(new SubmitRankAttrAction());
        Action.add(new HomePageAction());
        Action.add(new ShowMoreAction());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage,request,response);
    }
    
    private String performTheAction(HttpServletRequest request) {
        HttpSession session     = request.getSession(true);
        String      servletPath = request.getServletPath();
        //User        user = (User) session.getAttribute("user");
        String      action = getActionName(servletPath);

        // System.out.println("servletPath="+servletPath+" requestURI="+request.getRequestURI()+"  user="+user);

        if (action.equals("login.do")) {
        	// Allow these actions without logging in
			return Action.perform(action,request);
        }
        
        if (action.equals("start")) {
			return Action.perform("login.do",request);
        }

		return Action.perform(action,request);
    }
    
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
