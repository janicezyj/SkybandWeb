
package controller;

import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.ParameterStyle;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.http.HttpMessage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FusionTablesAccessor {
	private static final Pattern CSV_VALUE_PATTERN = Pattern
	.compile("([^,\\r\\n\"]*|\"(([^\"]*\"\")*[^\"]*)\")(,|\\r?\\n)");

  public static final String API_URL = "https://www.google.com/fusiontables/api/query";

  //private final HttpServletResponse resp;
  private final HttpSession session;

  public FusionTablesAccessor(HttpServletRequest req) {
    //this.resp = resp;
    session = req.getSession(true);
  }
  
  protected String showtable(String sql) throws IOException {
	  
	    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(session);
	    OAuthClient client = new OAuthClient(new HttpClient4());
	    try {
	      List<OAuth.Parameter> parameters = OAuth.newList("sql", sql);
	      OAuthMessage apiRequest = accessor.newRequestMessage("POST", API_URL, parameters);
	      OAuthMessage message = client.invoke(apiRequest, ParameterStyle.AUTHORIZATION_HEADER);
	      return message.readBodyAsString();
	    } catch (OAuthProblemException e) {
	      session.getServletContext().log("" + e.getParameters().get(HttpMessage.RESPONSE), e);
	      session.setAttribute("httpstatus",e.getHttpStatusCode());
	      return null;
	    } catch (URISyntaxException e) {
	      throw new AssertionError(e);
	    } catch (OAuthException e) {
	      throw new AssertionError(e);
	    }
	  }

  /**
   * Invokes Fusion Tables API with the given SQL command. Uses the given servlet response and
   * servlet context to send an error and log problems.
   *
   * @return Fusion Tables repsonse as a string, or null if an error was sent
   */
  protected ArrayList<String[]> invokeSql(String sql) throws IOException {
	  
    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(session);
    OAuthClient client = new OAuthClient(new HttpClient4());
    try {
      List<OAuth.Parameter> parameters = OAuth.newList("sql", sql);
      OAuthMessage apiRequest = accessor.newRequestMessage("POST", API_URL, parameters);
      OAuthMessage message = client.invoke(apiRequest, ParameterStyle.AUTHORIZATION_HEADER);
      String bodystr = message.readBodyAsString();
      
      ArrayList<String[]> arraylist = new ArrayList<String[]>();
      String[] body = bodystr.split("\n");
      for(int i = 0; i<body.length; i++){
    	  String[] line = body[i].split(",");
    	  arraylist.add(line);
      }
      return arraylist;
    } catch (OAuthProblemException e) {
      session.getServletContext().log("" + e.getParameters().get(HttpMessage.RESPONSE), e);
      session.setAttribute("httpstatus",e.getHttpStatusCode());
      return null;
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    } catch (OAuthException e) {
      throw new AssertionError(e);
    }
  }
}
