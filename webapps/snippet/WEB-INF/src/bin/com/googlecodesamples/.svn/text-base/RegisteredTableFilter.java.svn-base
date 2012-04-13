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

import net.oauth.OAuthAccessor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;

/**
 * Enforces that the query parameter {@code table} refers to a registered table, for which we have
 * an access token. Copies OAuth secret and access token to session scoped OAuthAccessor.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
public class RegisteredTableFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    String table = req.getParameter("table");
    HttpServletResponse httpResponse = (HttpServletResponse) resp;
    if (table == null) {
      httpResponse.sendError(SC_BAD_REQUEST, "missing parameter: table");
      return;
    }
    long tableId;
    try {
      tableId = Long.parseLong(table);
    } catch (NumberFormatException e) {
      httpResponse.sendError(SC_BAD_REQUEST, "malformed table parameter: " + e.getMessage());
      return;
    }
    TableData tableData = TableStore.THE_ONE.lookup(tableId);
    if (tableData == null) {
      httpResponse.sendError(SC_CONFLICT, "table not registered: " + tableId);
      return;
    }
    HttpServletRequest httpReq = (HttpServletRequest) req;
    OAuthAccessor sessionAccessor = OAuthConfig.getSessionAccessor(httpReq.getSession(true));
    sessionAccessor.tokenSecret = tableData.oauthSecret;
    sessionAccessor.accessToken = tableData.oauthAccess;
    chain.doFilter(req, resp);
    // TODO(arl) Detect revoked access and remove the table from store
  }
}
