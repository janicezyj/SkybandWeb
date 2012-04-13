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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Shows a snippet of up to 10 rows from the indicated table. Requires {@code RegisteredTableFilter}
 * to ensure that the table parameter has registered OAuth credentials. Invokes Fusion Tables API
 * with SQL {@code select * from ... limit 10}.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
public class ListRegisteredTablesServlet extends HttpServlet {

  public static final String URI = "list_registered";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println("<html><head><title>Tables with viewable snippets</title>");
    out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
    out.println("<body style=\"max-width:1170\"><h1>Tables with viewable snippets</h1>");
    out.println("<table>");
    for (TableData data : TableStore.THE_ONE.getAll()) {
      out.println("<tr><td><a href='" + SnippetServlet.URI + "?table=" + data.id + "'>" + data.title
          + "</a></td></tr>");
    }
    out.println("</table></body></html>");
    out.println();
  }
}
