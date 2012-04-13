package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gdata.util.AuthenticationException;
import controller.FusionTablesAccessor;
import controller.TableData;
import controller.TableStore;
import controller.OAuthAccessFilter;


public class LoginAction extends Action {
	public static final String URI = "show_tables";
	  private static final String QUOTED_CELL = "\"(?:[^\"]*\"\")*[^\"]*\"";
	  private static final String UNQUOTED_CELL = "[^\",\\n\\r]*";
	  private static final String CELL = "((?:" + QUOTED_CELL + ")|(?:" + UNQUOTED_CELL
	      + "))(,|\\r?\\n)";
	  protected static final Pattern CELL_PATTERN = Pattern.compile(CELL);

	public LoginAction() {
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
    	//PrintWriter out = resp.getWriter();
    	HttpSession session = request.getSession();
        FusionTablesAccessor accessor = new FusionTablesAccessor(request);
        String body;
		try {
			body = accessor.showtable("show tables");
		    HashSet<Long> registeredTables = new HashSet<Long>();
		    for (TableData tableData : TableStore.THE_ONE.getAll()) {
		         registeredTables.add(tableData.id);
		    }
	    Matcher m = CELL_PATTERN.matcher(body);
	      
	    if (m.find() && m.find()) {// skip header cells
	    	ArrayList<String[]> tablelist = new ArrayList<String[]>();
	        while (m.find()) {
	        	String id = m.group(1);
	            if (!m.find()) {
	              break;
	            }
	            String name = m.group(1);
	            String[] pair = new String[2];

	            pair[0] = name;
	            pair[1] = id;
	            tablelist.add(pair);
	        }
	          session.setAttribute("tablelist", tablelist);
	    }
	    try {
	    	String accesstoken = (String)session.getAttribute(OAuthAccessFilter.OAUTH_ACCESS_TOKEN);
			GoogleDataRequest google_data_request = new GoogleDataRequest(accesstoken);
			System.out.println(accesstoken);
			session.setAttribute("google_data_request",google_data_request);
		} catch (AuthenticationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        return "inputtableid.jsp";
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "login.jsp";
	}
  }
}

    	
/*    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	try {
    		if(email == null)
    			return "login.jsp";
			GoogleDataRequest google_data_request = new GoogleDataRequest("janicezyj@gmail.com","1280zyjUSA88");
	    	LoginForm loginform = new LoginForm();
	    	loginform.setEmail(email);
	    	loginform.setPassword(password);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginform", loginform);
	    	session.setAttribute("google_data_request", google_data_request);
			return "inputtableid.jsp";
		} catch (AuthenticationException e) {
			return "login.jsp";
		}*/

