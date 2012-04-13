package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class objectview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style type=\"text/css\">\n");
      out.write(".askbutton   {   \n");
      out.write("background-image:url(help.png); \n");
      out.write("height:25px; \n");
      out.write("width: 24px;\n");
      out.write("font-size:12px; \n");
      out.write("border:0px  \n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li><a href=\"homepage.do\">Home</a></li>\n");
      out.write("\t\t\t<li class=\"current_page_item\"><a href=\"objectview.do\">ranking</a></li>\n");
      out.write("\t\t\t<li><a href=\"subspaceview.do\">Subspace View</a></li>\n");
      out.write("            <li><a href=\"setting.do\">Set metadata for database</a></li>\n");
      out.write("            <li><a href=\"checkclaim.do\">Check a Claim</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #menu -->\n");
      out.write("\t<div id=\"page\">\n");
      out.write("\t\t<div id=\"content\">\n");
      out.write("\t\t\t<div class=\"post\">\n");
      out.write("\t\t\t\t<div class=\"bg1\">\n");
      out.write("\t\t\t\t\t<div class=\"bg2\">\n");
      out.write("\t\t\t\t\t\t<div class=\"bg3\">\n");
      out.write("\t\t\t\t\t\t<h2 class=\"title\"><a>Ranking by overall score</a></h2>\n");
      out.write("\t\t\t\t\t\t<div class=\"entry1\">\n");
      out.write("\t\t\t\t\t\t <table id=\"table\" width=\"100%\" height=\"151\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("                        ");
 ArrayList<String[]> table  = (ArrayList<String[]>)session.getAttribute("table");
                           ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
                            int column_num = column_names.size();                          
                            ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
                            ArrayList<Integer> sub_rank_index = (ArrayList<Integer>)session.getAttribute("subrankindex");
                            boolean[] sub_rankable_attr = (boolean[])session.getAttribute("subrankableattr");
                            boolean[] sub_rank_attr = (boolean[])session.getAttribute("subrankattr");
           					String[][] ranking_list = (String[][])session.getAttribute("rankinglist");
           				
      out.write("           \t\t\t\t\t\n");
      out.write("                               \t ");
String objectname = (String)session.getAttribute("objectname"); 
                                 String[] row = new String[sub_rank_index.size()+3];
                                    
      out.write("\n");
      out.write("                                    ");

                                        row[0]="rank";
                                        row[1]= objectname;
                                        for(int i = 0; i<sub_rank_index.size(); ++i){
                                            row[i+2] = column_names.get(sub_rank_index.get(i));
                                        }
                                        row[row.length-1] = "score";
                                    
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            ");

                                            for(int j = 0; j<row.length; j++){
                                            
      out.write("\n");
      out.write("                                                <td> ");
      out.print(row[j]);
      out.write("</td>\n");
      out.write("                                            ");
 
                                            } 
                                            
      out.write("\n");
      out.write("                                        </tr>     \t\t\n");
      out.write("                             <script type=\"text/javascript\" language=\"javascript\"> \n");
      out.write("\t\t\t\t\t\t\t\tvar table = document.getElementById(\"table\");      \t\t\n");
      out.write("\t\t\t\t\t\t\t");
for(int i = 0; i<ranking_list.length; i++){
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\tvar row = table.insertRow(-1);\n");
      out.write("\t\t\t\t\t\t\t\tcell = row.insertCell(-1);\n");
      out.write("        \t\t\t\t\t\t");
String str2=""+(i+1);
      out.write("\n");
      out.write("        \t\t\t\t\t\tcell.innerHTML = \"");
      out.print(str2);
      out.write("\";\n");
      out.write("        \t\t\t\t\t\t");
str2 = "";
      out.write("\n");
      out.write("        \t\t\t\t\t\t");
for(int j = 0; j<sub_name_index.size(); j++){
      out.write("\n");
      out.write("              \t\t\t\t\t\t ");
str2 = str2+ranking_list[i][sub_name_index.get(j)]+" ";
      out.write("            \t\t\n");
      out.write("       \t\t\t\t\t\t\t");
}
      out.write("\n");
      out.write("       \t\t\t\t\t\t\tcell = row.insertCell(-1);\n");
      out.write("              \t\t\t\t\tcell.innerHTML = \"");
      out.print(str2);
      out.write("\"; \n");
      out.write("              \t\t\t\t\t");
String info = "";
              					for(int j = 0; j<column_names.size(); j++){
              						info = info+column_names.get(j)+"  "+ranking_list[i][j]+", ";
              					}
      out.write("\n");
      out.write("       \t\t\t\t\t\t\tcell.onclick = function(){alert(\"");
      out.print(info);
      out.write("\")};\n");
      out.write("       \t\t\t\t\t\t\t");
for(int j = 0; j<sub_rank_index.size(); j++){
      out.write("\n");
      out.write("       \t\t\t\t\t\t\t\t");
str2 = ""+ranking_list[i][sub_rank_index.get(j)];
      out.write("\n");
      out.write("       \t\t\t\t\t\t\t\tcell = row.insertCell(-1);\n");
      out.write("              \t\t\t\t\t\tcell.innerHTML = \"");
      out.print(str2);
      out.write("\";  \t\t\n");
      out.write("   \t\t\t\t\t\t\t\t");
}
      out.write("\n");
      out.write("   \t\t\t\t\t\t\t\tcell = row.insertCell(-1);\n");
      out.write("   \t\t\t\t\t\t\t\tcell.innerHTML = \"");
      out.print(ranking_list[i][ranking_list[i].length-2]);
      out.write("\"\n");
      out.write("   \t\t\t\t\t\t\t");
}
      out.write("\n");
      out.write("                           \n");
      out.write("                          </script>\n");
      out.write("                          \t</table>\t\t\t\t\t\t  \n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("          </div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t<!-- end #content -->\n");
      out.write("\t<div id=\"sidebar2\">  \n");
      out.write("\t\t  <ul>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<h2><a>Choose Ranking Attributes</a></h2>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t<form method=\"post\" action=\"submitrankattr.do\">\t\t\t\t  \n");
      out.write("        ");
 
        String str1;
        for(int i = 0; i<column_names.size(); i++){
        	str1 = column_names.get(i);
        	if(sub_rank_attr[i]){
      out.write("\n");
      out.write("        \t\t<input type=\"checkbox\" name=\"rank");
      out.print(str1);
      out.write("\" id=\"rank");
      out.print(str1);
      out.write("\" CHECKED onClick=\"add('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str1 );
      out.write("\" style = \"color:white\">");
      out.print(str1);
      out.write("</label>\n");
      out.write("        \t\t<br>\n");
      out.write("\t\t\t");
}
			if((!sub_rank_attr[i])&&sub_rankable_attr[i]){
      out.write("\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"rank");
      out.print(str1);
      out.write("\" id=\"rank");
      out.print(str1);
      out.write("\" onClick=\"add('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str1 );
      out.write("\" style = \"color:white\">");
      out.print(str1);
      out.write("</label>\n");
      out.write("\t\t\t\t<br>\n");
      out.write("   ");
 		}
   		}
   	
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("              </li>\n");
      out.write("          </ul>\n");
      out.write("          <ul>\n");
      out.write("\t\t\t  <li>\n");
      out.write("\t\t\t\t\t<h2><a>Input &alpha;</a></h2>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t  </li>\n");
      out.write("              <li>\n");
      out.write("\t\t\t\t\t<ul>\t\n");
      out.write("\t\t\t\t\t<label for = \"alpha\" style = \"color:white\">0<&alpha;<1     </lable><input class = \"askbutton\" type=\"button\" name=\"askbutton\" id=\"askbutton\" onClick = \"alert('&alpha; is the parameter that discounts score by position in each subspace;smaller &alpha; means specialized objects are preferred,bigger &alpha; means well-banlanced objects are preferred;')\"/>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"alpha\" id=\"alpha\" size=\"15\" value = \"0.5\"/>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" id=\"submit\" value=\"submit\" />\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t        </ul>\n");
      out.write("              </li>\n");
      out.write("          </ul>\n");
      out.write("\t\t</div>   \n");
      out.write("\t\t<!-- end #sidebar -->\n");
      out.write("\t\t<div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #page -->\n");
      out.write("</div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "bottom-template.jsp", out, false);
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
