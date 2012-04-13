/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecodesamples;

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

/**
 * Obtains an OAuth access token, and saves it in session state. This filter implements all client
 * steps of the OAuth dance.
 *
 * <ul><li>On the first invocation, the session lacks an access token and the request lacks an
 * {@code oauth_token_secret} parameter. In that case the filter obtains a request token, constructs
 * a callback URL for the current request URL that includes an {@code oauth_token_secret} parameter,
 * and uses this callback in a redirect to the authorization URL.</li>
 *
 * <li>The second invocation is a redirect from the authorizer to the provided callback. Now the
 * session still lacks an access token, but there are two characteristic parameters: {@code
 * oauth_token_secret} and {@code oauth_token}. In this case we upgrade to an access token and save
 * it in session state.</li>
 *
 * <li>All subsequent invocations find the access token in their session state.</li></ul>
 *
 * See <a href="http://code.google.com/apis/accounts/docs/OAuth.html">OAuth for Web Applications</a>
 * for more information.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
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
      return;
    }

    String token = req.getParameter(OAUTH_TOKEN);
    String secret = req.getParameter(OAUTH_TOKEN_SECRET);
    if (token != null && secret != null) {
      // Step Two. This is a callback from the Authorizer
      String accessToken = getAccessToken(token, secret, httpReq.getSession(true));
      httpReq.getSession(true).setAttribute(OAUTH_ACCESS_TOKEN, accessToken);
      chain.doFilter(req, resp);
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
