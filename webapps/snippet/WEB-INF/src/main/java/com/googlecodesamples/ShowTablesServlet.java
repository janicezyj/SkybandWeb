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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Shows list of tables for the currently authorized user. Requires {@code OAuthAccessFilter} to
 * ensure that the current session has an {@code OAuthAccessor}. Invokes Fusion Tables API with SQL
 * {@code show tables}. Displays each table with a link to either register or view a snippet.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
public class ShowTablesServlet extends HttpServlet {

  public static final String URI = "show_tables";
  private static final String QUOTED_CELL = "\"(?:[^\"]*\"\")*[^\"]*\"";
  private static final String UNQUOTED_CELL = "[^\",\\n\\r]*";
  private static final String CELL = "((?:" + QUOTED_CELL + ")|(?:" + UNQUOTED_CELL
      + "))(,|\\r?\\n)";
  protected static final Pattern CELL_PATTERN = Pattern.compile(CELL);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    FusionTablesAccessor accessor = new FusionTablesAccessor(req, resp);
    String body = accessor.invokeSql("show tables");
    HashSet<Long> registeredTables = new HashSet<Long>();
    for (TableData tableData : TableStore.THE_ONE.getAll()) {
      registeredTables.add(tableData.id);
    }

    Matcher m = CELL_PATTERN.matcher(body);
    out.println("<html><head><title>My Fusion Tables</title>");
    out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
    out.println("<script type='text/javascript' src='godocs.js'></script></head>");
    out.println("<body style=\"max-width:1170\"><h1>Fusion Tables Listing</h1>");
    out.println(
        "Once registered, you and the rest of the world can see a 10 row snippet of the table.");
    out.println("<a href='https://www.google.com/accounts/IssuedAuthSubTokens'>"
        + "Manage authorized websites</a> to revoke this permission.<p>");
    if (m.find() && m.find()) {// skip header cells
      out.println("<table>");
      while (m.find()) {
        long id = Long.parseLong(m.group(1));
        if (!m.find()) {
          break;
        }
        String name = m.group(1);
        boolean isRegistered = registeredTables.contains(id);
        out.print("<tr><td>" + name + "</td><td><a href='"
            + (isRegistered ? SnippetServlet.URI : AddTableServlet.URI)
            + "?table=" + id + "&title=" + name + "'>"
            + (isRegistered ? "View Snippet" : "Register") + "</a></td></tr>");
      }
      out.println("</table>");
    }
    out.println("</body></html>");
  }
}
