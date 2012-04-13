package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class defaultsetting_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("          ");

        	ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
			int column_num = column_names.size();
           
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li><a href=\"objectview.do\">Object View</a></li>\n");
      out.write("\t\t\t<li><a href=\"subspaceview.do\">Subspace View</a></li>\n");
      out.write("            <li class=\"current_page_item\"><a href=\"setting.do\">Setting</a></li>\n");
      out.write("            <li><a href=\"checkclaim.do\">Check Claim</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #menu -->\n");
      out.write("\t<div id=\"page\">\n");
      out.write("\t\t<div id=\"content\" style =\"float:left;width:1500px\">\n");
      out.write("            <div class=\"post\">\n");
      out.write("\t\t\t\t<div class=\"bg1\">\n");
      out.write("\t\t\t\t\t<div class=\"bg2\">\n");
      out.write("\t\t\t\t\t\t<div class=\"bg3\">\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>Select attributes for naming an object</a></h2>\n");
      out.write("                            <div class=\"entry\">\n");
      out.write("\t\t\t\t\t\t\t\t<form method=\"post\" action=\"submitdefaultset.do\">\n");
      out.write("\t\t     <table>\n");
      out.write("             <script type=\"text/javascript\" language=\"javascript\"> \n");
      out.write("\n");
      out.write("    function add(str,i){\n");
      out.write("        var sr = document.getElementById(\"rank\"+str);\n");
      out.write("\t\tvar vc = document.getElementById(\"vis\"+str);\n");
      out.write("\t\tvar lb = document.getElementById(\"lable\"+str);\n");
      out.write("        var button = document.getElementById(str+\"button\");\n");
      out.write("        if(sr.checked){  \n");
      out.write("           button.style.visibility = \"visible\"; \n");
      out.write("           vc.disabled = false;\n");
      out.write("           lb.style.color = \"black\";\n");
      out.write("        }\n");
      out.write("        else{\n");
      out.write("            button.style.visibility = \"hidden\";\n");
      out.write("            vc.disabled = true;\n");
      out.write("            vc.checked = false;\n");
      out.write("            lb.style.color = \"gray\";           \n");
      out.write("            }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function preview(str,i){\n");
      out.write("        var sr = document.getElementById(\"name\"+str);\n");
      out.write("        var lable = document.getElementById(\"namestr\");\n");
      out.write("        var hn = document.getElementById(\"hiddenname\");\n");
      out.write("        if(sr.checked){     \n");
      out.write("            namestr.innerText=namestr.innerText+\"%\" + str;\n");
      out.write("            hn.value = hn.value+\"%\"+str;\n");
      out.write("        }\n");
      out.write("        else{\n");
      out.write("            var innertext = lable.innerText;\n");
      out.write("            var deletetext = \"%\" + str;\n");
      out.write("            var split = innertext.split(deletetext);\n");
      out.write("            lable.innerText = split[0] +split[1];\n");
      out.write("            hn.value = split[0]+split[1];\n");
      out.write("            }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("        function change(str,i){\n");
      out.write("        \tvar button = document.getElementById(str+\"button\");\n");
      out.write("        \tvar hiddenbutton = document.getElementById(str+\"hiddenbutton\");\n");
      out.write("            if(hiddenbutton.value == \"false\"){\n");
      out.write("            \thiddenbutton.value = \"true\";\n");
      out.write("            \tbutton.style.backgroundImage = \"url('arrow2.png')\";\n");
      out.write("            }\n");
      out.write("           \telse {\n");
      out.write("           \t\thiddenbutton.value = \"false\";\n");
      out.write("            \tbutton.style.backgroundImage = \"url('arrow1.png')\";\n");
      out.write("            }\n");
      out.write("    \t}\n");
      out.write("</script>\n");
      out.write("\t\t <table id = \"nametable\">\n");
      out.write("\t\t");

			boolean[] sub_naming_attr = (boolean[])session.getAttribute("subnamingattr");
			String str0;
            String id0;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		
      out.write("\n");
      out.write("    \t\t\t\t<tr>\n");
      out.write("\t\t\t\t      <td valign=\"top\">\n");
      out.write("             \t\t\t");
str0 = column_names.get(i);
                        
      out.write("\n");
      out.write("                        ");
if(sub_naming_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" CHECKED onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label>\n");
      out.write("                         ");
}
                         else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label> \n");
      out.write("\t\t\t\t\t\t ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                      </td>\n");
      out.write("            \t\t  <td> ");
      out.print(str0         );
      out.write("\n");
      out.write("                      </td>\n");
      out.write("              ");

			     }
			 	else if(i%8 == 7){
               
      out.write("\t\t\n");
      out.write("            \t\t<td valign=\"top\">\n");
      out.write("            \t\t");
str0 = column_names.get(i);
      out.write("\n");
      out.write("                \t   ");
if(sub_naming_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" CHECKED onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label>\n");
      out.write("                         ");
}
                         else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label> \n");
      out.write("\t\t\t\t\t\t ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("            \t\t<td> ");
      out.print(str0         );
      out.write("                    \n");
      out.write("                    </td>\n");
      out.write("           \t\t </tr>\n");
      out.write("\n");
      out.write("\t\t\t\t");

		
				}
			   else{
				
      out.write("\n");
      out.write("            \t   <td valign=\"top\">\n");
      out.write("            \t\t");
str0 = column_names.get(i);
      out.write("\n");
      out.write("                \t");
if(sub_naming_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" CHECKED onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label>\n");
      out.write("                         ");
}
                         else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"name");
      out.print(str0 );
      out.write("\" id=\"name");
      out.print(str0 );
      out.write("\" onClick=\"preview('");
      out.print(str0);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/><label for=\"");
      out.print(str0 );
      out.write("\"></label> \n");
      out.write("\t\t\t\t\t\t ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("            \t\t<td> ");
      out.print(str0         );
      out.write("\n");
      out.write("                    </td>\n");
      out.write("            \t");

				}
			}
			
      out.write('\n');
      out.write('	');
      out.write('	');
	String objectname = (String)session.getAttribute("objectname");
			ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
			String namestr = "";
			for(int i = 0; i<sub_name_index.size(); i++){
				namestr = namestr+"%"+column_names.get(sub_name_index.get(i));
			}
      out.write("\t\n");
      out.write("         </table>\n");
      out.write("         Preview of name:\n");
      out.write("         <table id = \"previewtable\" height=\"50\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">    \n");
      out.write("\t\t\t<tr><td><input type=\"text\" name=\"name\" id=\"name\" value=\"");
      out.print(objectname);
      out.write("\" /></td></tr>\n");
      out.write("\t\t\t<tr><td><lable for = \"namestr\" id = \"namestr\">");
      out.print(namestr);
      out.write("</lable></td></tr>\t\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"hidden\" name=\"hiddenname\" id = \"hiddenname\" value=\"");
      out.print(namestr);
      out.write("\">\n");
      out.write("\t\t\n");
      out.write("                            </div>\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>Set directions for attributes: </a></h2>\n");
      out.write("                            <div class=\"entry\">\n");
      out.write("\t\t      <table id = \"ranktable\">\n");
      out.write("\t\t");

			boolean[] direction = (boolean[])session.getAttribute("direction");
			String str1;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		
      out.write("\n");
      out.write("    \t\t\t\t<tr>\n");
      out.write("             \t\t\t");
str1 = column_names.get(i);
      out.write("\n");
      out.write("            \t\t  <td> ");
      out.print(str1         );
      out.write("</td>\n");
      out.write("            \t\t  ");
if(direction[i]){
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\"  onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t\n");
      out.write("                      \t");
}else{
      out.write("\n");
      out.write("                      \t\t\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("              ");

			     }
			 	else if(i%8 == 7){
               
      out.write("\t\t\n");
      out.write("            \t\t");
str1 = column_names.get(i);
      out.write("\n");
      out.write("            \t\t<td> ");
      out.print(str1         );
      out.write(" </td>                   \n");
      out.write("                      ");
if(direction[i]){
      out.write("\n");
      out.write("            \t\t  \t\t\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t\n");
      out.write("                      \t");
}else{
      out.write("\n");
      out.write("                      \t\t\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("           \t\t </tr>\n");
      out.write("\t\t\t\t");
	
				}
			   else{
				
      out.write("\n");
      out.write("            \t\t");
str1 = column_names.get(i); 
      out.write("\n");
      out.write("            \t\t<td> ");
      out.print(str1         );
      out.write("</td>\n");
      out.write("                      ");
if(direction[i]){
      out.write("\n");
      out.write("            \t\t  \t\t\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t\n");
      out.write("                      \t");
}else{
      out.write("\n");
      out.write("                      \t\t\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("            \t");

				}
			}
			
      out.write("\t\n");
      out.write("         </table>\n");
      out.write("         ");
for(int i = 0; i<column_num; i++){
         	if(direction[i]){
      out.write("\n");
      out.write("         \t\t<input type=\"hidden\" name=\"");
      out.print(column_names.get(i));
      out.write("hiddenbutton\" id = \"");
      out.print(column_names.get(i));
      out.write("hiddenbutton\" value=\"true\">\n");
      out.write("         \t");
}else{
      out.write("\n");
      out.write("         \t\t<input type=\"hidden\" name=\"");
      out.print(column_names.get(i));
      out.write("hiddenbutton\" id = \"");
      out.print(column_names.get(i));
      out.write("hiddenbutton\" value=\"false\">\n");
      out.write("         \t");
}
         }
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("                                    <br>\n");
      out.write("                                    <br>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\"/>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         <!-- end #content -->\n");
      out.write("        <div id=\"sidebar\">  \n");
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
