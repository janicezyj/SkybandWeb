package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top-template2.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li class=\"current_page_item\"><a href=\"homepage.do\">Home</a></li>\n");
      out.write("\t\t\t<li><a href=\"objectview.do\">ranking</a></li>\n");
      out.write("\t\t\t<li><a href=\"subspaceview.do\">Subspace View</a></li>\n");
      out.write("            <li><a href=\"setting.do\">Set metadata for database</a></li>\n");
      out.write("            <li><a href=\"checkclaim.do\">Check a Claim</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #menu -->\n");
      out.write("\t<div id=\"page\" >\n");
      out.write("\t\t<div id=\"content\" style =\"float:left;width:1500px\">\n");
      out.write("            <div class=\"post\">\n");
      out.write("\t\t\t\t<div class=\"bg1\">\n");
      out.write("\t\t\t\t\t<div class=\"bg2\">\n");
      out.write("\t\t\t\t\t\t<div class=\"bg3\">\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>Home</a></h2>\n");
      out.write("                            <div class=\"entry\">\n");
      out.write("\t\t\t\t\t\t\t\t<form method=\"post\" action=\"submitclaim.do\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\tNow start exploring One-of-the-Few claims from your data!\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href= \"objectview.do\">Ranking</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href= \"subspaceview.do\">Subspace View</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href= \"setting.do\">Set Metadata for Database</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href= \"checkclaim.do\">Check a Claim</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         <!-- end #content -->\n");
      out.write("        <div id=\"sidebar\" width = \"100px\">  \n");
      out.write("\t\t  <ul>\n");
      out.write("\n");
      out.write("\t\t\t\t<li>\n");
      out.write("              </li>\n");
      out.write("          </ul>\n");
      out.write("           </div>\n");
      out.write("\t\t<!-- end #sidebar -->\n");
      out.write("\t\t<div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("        <!-- end #page -->\n");
      out.write("</div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "bottom-template.jsp", out, false);
      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
