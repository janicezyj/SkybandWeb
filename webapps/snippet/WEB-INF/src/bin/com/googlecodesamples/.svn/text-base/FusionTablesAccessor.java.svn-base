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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Invokes Fusion Tables API with OAuth access token from servlet session.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
public class FusionTablesAccessor {

  public static final String API_URL = "https://www.google.com/fusiontables/api/query";

  private final HttpServletResponse resp;
  private final HttpSession session;

  public FusionTablesAccessor(HttpServletRequest req, HttpServletResponse resp) {
    this.resp = resp;
    session = req.getSession(true);
  }

  /**
   * Invokes Fusion Tables API with the given SQL command. Uses the given servlet response and
   * servlet context to send an error and log problems.
   *
   * @return Fusion Tables repsonse as a string, or null if an error was sent
   */
  protected String invokeSql(String sql) throws IOException {

    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(session);
    OAuthClient client = new OAuthClient(new HttpClient4());
    try {
      List<OAuth.Parameter> parameters = OAuth.newList("sql", sql);
      OAuthMessage apiRequest = accessor.newRequestMessage("POST", API_URL, parameters);
      OAuthMessage message = client.invoke(apiRequest, ParameterStyle.AUTHORIZATION_HEADER);
      return message.readBodyAsString();
    } catch (OAuthProblemException e) {
      session.getServletContext().log("" + e.getParameters().get(HttpMessage.RESPONSE), e);
      resp.sendError(e.getHttpStatusCode());
      return null;
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    } catch (OAuthException e) {
      throw new AssertionError(e);
    }
  }
}
