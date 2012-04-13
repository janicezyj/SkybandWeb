
package controller;

import net.oauth.OAuth;
import static net.oauth.OAuth.OAUTH_CALLBACK;
import static net.oauth.OAuth.OAUTH_TOKEN;
import static net.oauth.OAuth.OAUTH_TOKEN_SECRET;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthException;
import net.oauth.OAuthProblemException;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.http.HttpMessage;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OAuthAccessFilter implements Filter {

  /**
   * Session attribute name for the OAuth access token.
   */
  public static final String OAUTH_ACCESS_TOKEN = "oauth_acces_token";

  private ServletContext context;

  public void init(FilterConfig config) throws ServletException {
    context = config.getServletContext();
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    if (hasSessionAccessToken(httpReq)) {
      // This session obtained an access token previously.
      chain.doFilter(req, resp);
      System.out.println("dofilter1");
      return;
    }

    String token = req.getParameter(OAUTH_TOKEN);
    String secret = req.getParameter(OAUTH_TOKEN_SECRET);
    if (token != null && secret != null) {
      // Step Two. This is a callback from the Authorizer
      String accessToken = getAccessToken(token, secret, httpReq.getSession(true));
      httpReq.getSession(true).setAttribute(OAUTH_ACCESS_TOKEN, accessToken);
      chain.doFilter(req, resp);
      System.out.println("dofilter2");
      return;
    }

    // Step One: Create a callback to this request URL that includes the token secret and use this
    // callback in the redirect to the Authorizer
    OAuthAccessor accessor = getRequestToken(httpReq.getSession(true));
    String url = getFullRequestUrl(httpReq);
    String callback = OAuth.addParameters(url, OAUTH_TOKEN_SECRET, accessor.tokenSecret);
    HttpServletResponse httpResp = (HttpServletResponse) resp;
    httpResp.sendRedirect(
        OAuth.addParameters(accessor.consumer.serviceProvider.userAuthorizationURL, OAUTH_TOKEN,
            accessor.requestToken, OAUTH_CALLBACK, callback));
    System.out.println("dofilter stop");
  }

  private static String getFullRequestUrl(HttpServletRequest httpReq) {
    StringBuffer urlBuffer = httpReq.getRequestURL();
    String queryParams = httpReq.getQueryString();
    if (queryParams != null) {
      urlBuffer.append('?').append(queryParams);
    }
    return urlBuffer.toString();
  }

  /**
   * Indicates whether the session contains an OAuth access token.
   */
  private static boolean hasSessionAccessToken(HttpServletRequest httpReq) {
    HttpSession session = httpReq.getSession(false);
    return session != null && session.getAttribute(OAUTH_ACCESS_TOKEN) != null;
  }

  /**
   * Requests a request token and returns the accessor, whose state includes token and the
   * corresponding token secret.
   */
  private OAuthAccessor getRequestToken(HttpSession session) throws IOException {
    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(session);
    OAuthClient client = new OAuthClient(new HttpClient4());
    try {
      client.getRequestToken(accessor, null);
    } catch (OAuthProblemException e) {
      context.log("" + e.getParameters().get(HttpMessage.RESPONSE), e);
    } catch (OAuthException e) {
      context.log("OAuth problem: ", e);
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    }
    return accessor;
  }

  /**
   * Upgrades the given token and token secret to an access token.
   */
  private String getAccessToken(String token, String secret, HttpSession session)
      throws IOException {
    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(session);
    accessor.requestToken = token;
    accessor.tokenSecret = secret;
    OAuthClient client = new OAuthClient(new HttpClient4());
    try {
      client.getAccessToken(accessor, null, null);
    } catch (OAuthProblemException e) {
      context.log("" + e.getParameters().get(HttpMessage.RESPONSE), e);
    } catch (OAuthException e) {
      context.log("OAuth problem: ", e);
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    }
    return accessor.accessToken;
  }
}
