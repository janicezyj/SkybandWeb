package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class ObjectViewAction extends Action {

	public String getName() {
		return "objectview.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//if ((Integer)session.getAttribute("objectid") >= 0) {
		String[][] rankinglist = (String[][])session.getAttribute("rankinglist");
			return "objectview.jsp";			
/*		} 
		else
			return "highlevelinfo2.jsp";*/

	}
}