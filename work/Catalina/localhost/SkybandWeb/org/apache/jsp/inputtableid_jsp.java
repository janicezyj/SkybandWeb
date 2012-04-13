package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class inputtableid_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- end #header -->\n");
      out.write("<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #menu -->\n");
      out.write("<div id=\"page\">\n");
      out.write("\t\t<div id=\"content\" style =\"float:left;width:1500px\">\n");
      out.write("\t\t\t<div class=\"post\">\n");
      out.write("\t\t\t\t<div class=\"bg1\">\n");
      out.write("\t\t\t\t\t<div class=\"bg2\">\n");
      out.write("\t\t\t\t\t\t<div class=\"bg3\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"entry\">\n");
      out.write("<p style=\"font-size:small\">&nbsp;</p>\n");
      out.write("<form method=\"post\" action=\"clicktable.do\">\n");
      out.write("\t");
 ArrayList<String[]> tablelist = (ArrayList<String[]>)session.getAttribute("tablelist");
	if(tablelist.size()==0){
      out.write("\n");
      out.write("\t\t<td>You don't have any Google Fusion Tables, please upload one!</td>\n");
      out.write("\t\t");
}
		else{
      out.write("\t\n");
      out.write("    <td>All my Fusion Tables, choose one to begin!</td>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    ");

        for(int i = 0; i<tablelist.size(); ++i){
            String name = ""+tablelist.get(i)[0];
            String id = ""+tablelist.get(i)[1];
      out.write("\n");
      out.write("            <td><a href= \"clicktable.do?tableid=");
      out.print(id);
      out.write('"');
      out.write('>');
      out.print(name);
      out.write("</a></td>\n");
      out.write("            <br>\n");
      out.write("    ");
}
    }
      out.write("\n");
      out.write("    \n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    --or--\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    Search for a public Fusion Table\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    Input table ID<input type = \"text\" name = tableid ><input type = \"submit\" value = \"submit\">\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("   <!-- end #content -->\n");
      out.write("        <div id=\"sidebar\">  \n");
      out.write("\t\t  <ul>\n");
      out.write("          </ul>\n");
      out.write("           </div>\n");
      out.write("\t\t<!-- end #sidebar -->\n");
      out.write("\t\t<div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("        <!-- end #page -->\n");
      out.write("    </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "bottom-template.jsp", out, false);
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
