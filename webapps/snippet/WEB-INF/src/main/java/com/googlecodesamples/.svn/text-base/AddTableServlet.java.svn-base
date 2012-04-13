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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

/**
 * Registers the table indicated by the query parameter with the current OAuth access token.
 * Redirects to show_tables.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */

public class AddTableServlet extends HttpServlet {

  public static final String URI = "add_table";

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String tableString = req.getParameter("table");
    if (tableString == null) {
      resp.sendError(SC_BAD_REQUEST, "missing parameter: table");
      return;
    }
    long table;
    try {
      table = Long.parseLong(tableString);
    } catch (NumberFormatException e) {
      resp.sendError(SC_BAD_REQUEST, "malformed table parameter: " + e.getMessage());
      return;
    }

    OAuthAccessor accessor = OAuthConfig.getSessionAccessor(req.getSession(true));
    String title = req.getParameter("title");
    TableStore.THE_ONE.store(
        new TableData(table, title, accessor.accessToken, accessor.tokenSecret));
    resp.sendRedirect(ShowTablesServlet.URI);
  }
}
