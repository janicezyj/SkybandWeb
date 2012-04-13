
package controller;

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
