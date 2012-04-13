package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class setting_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        	ArrayList<String[]> table  = (ArrayList<String[]>)session.getAttribute("table");
			int column_num = column_names.size();
			String[] exampleinfo = table.get(1);
           
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li><a href=\"homepage.do\">Home</a></li>\n");
      out.write("\t\t\t<li><a href=\"objectview.do\">ranking</a></li>\n");
      out.write("\t\t\t<li><a href=\"subspaceview.do\">Subspace View</a></li>\n");
      out.write("            <li class=\"current_page_item\"><a href=\"setting.do\">Set Metadata for database</a></li>\n");
      out.write("            <li><a href=\"checkclaim.do\">Check a Claim</a></li>\n");
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
      out.write("     \n");
      out.write("             <script type=\"text/javascript\" language=\"javascript\"> \n");
      out.write("    function add(str,i){\n");
      out.write("        var sr = document.getElementById(\"rank\"+str);\n");
      out.write("        var button = document.getElementById(str+\"button\");\n");
      out.write("        if(sr.checked){  \n");
      out.write("           button.style.visibility = \"visible\"; \n");
      out.write("        }\n");
      out.write("        else{\n");
      out.write("            button.style.visibility = \"hidden\";         \n");
      out.write("            }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function preview(str,i){\n");
      out.write("    \tvar exampleinfo = new Array();\n");
      out.write("    \t");
for(int i = 0; i<exampleinfo.length; i++){
      out.write("\n");
      out.write("    \t\texampleinfo[");
      out.print(i);
      out.write("] = \"");
      out.print(exampleinfo[i]);
      out.write("\";\n");
      out.write("    \t");
}
      out.write("\n");
      out.write("        var sr = document.getElementById(\"name\"+str);\n");
      out.write("        var text = document.getElementById(\"namestr\");\n");
      out.write("        var hn = document.getElementById(\"hiddenname\");\n");
      out.write("        var example = document.getElementById(\"examplename\");\n");
      out.write("        if(sr.checked){     \n");
      out.write("            namestr.value=namestr.value+\"%\" + str;\n");
      out.write("            hn.value = hn.value+\"%\"+str;\n");
      out.write("            example.innerText = example.innerText+\" \"+exampleinfo[i];\n");
      out.write("        }\n");
      out.write("        else{\n");
      out.write("            var innertext = text.value;\n");
      out.write("            var deletetext = \"%\" + str;\n");
      out.write("            var split = innertext.split(deletetext);\n");
      out.write("            text.value = split[0] +split[1];\n");
      out.write("            hn.value = split[0]+split[1];\n");
      out.write("          \tsplit = example.innerText.split(exampleinfo[i]);\n");
      out.write("          \texample.innerText = split[0]+split[1];\n");
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
      out.write("    \tfunction checkinput(){\n");
      out.write("\t\t\tvar form = document.getElementById(\"form\");\n");
      out.write("\t\t\tvar valid1 = false;\n");
      out.write("\t\t\tvar valid2 = false;\n");
      out.write("\t\t\t");
for(int i = 0; i<column_names.size(); i++){
				String str = column_names.get(i);
      out.write("\n");
      out.write("\t\t\t\tvar name = document.getElementById(\"name\"+\"");
      out.print(str);
      out.write("\");\n");
      out.write("\t\t\t\tif(name.checked)\n");
      out.write("\t\t\t\t\tvalid1 = true;\n");
      out.write("\t\t\t");
}
      out.write("\n");
      out.write("\t\t\t");
for(int i = 0; i<column_names.size(); i++){
				String str = column_names.get(i);
      out.write("\n");
      out.write("\t\t\t\tvar rank = document.getElementById(\"rank\"+\"");
      out.print(str);
      out.write("\");\n");
      out.write("\t\t\t\tif(rank.checked)\n");
      out.write("\t\t\t\t\tvalid2 = true;\n");
      out.write("\t\t\t");
}
      out.write("\n");
      out.write("\t\t\tif(!(valid1&&valid2))\n");
      out.write("\t\t\t\talert(\"Invalid Input!\");\n");
      out.write("\t\t\telse{\n");
      out.write("\t\t\t\tform.action=\"submitattr.do\";\n");
      out.write("\t\t\t\tform.submit();\n");
      out.write("\t\t\t\t}\n");
      out.write("    \t}\n");
      out.write("</script>\n");
      out.write(" <form method=\"post\" name = \"form\" id = \"form\" >\n");
      out.write("\t\t <table id = \"nametable\">\n");
      out.write("\t\t");

			boolean[] sub_name_attr = (boolean[])session.getAttribute("subnameattr");
			String str0;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		
      out.write("\n");
      out.write("    \t\t\t\t<tr>\n");
      out.write("\t\t\t\t      <td valign=\"top\">\n");
      out.write("             \t\t\t");
str0 = column_names.get(i);
                        
      out.write("\n");
      out.write("                        ");
if(sub_name_attr[i]){
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
if(sub_name_attr[i]){
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
if(sub_name_attr[i]){
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
			
      out.write("\n");
      out.write("\t\t</table>\n");
      out.write("\t\t");
	
			ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
			String namestr = "";
			String example = "";
			for(int i = 0; i<sub_name_index.size(); i++){
				namestr = namestr+"%"+column_names.get(sub_name_index.get(i));
				example = example+table.get(1)[sub_name_index.get(i)]+" ";
			}
      out.write("\t\n");
      out.write("        \n");
      out.write("         <table id = \"previewtable\" height=\"50\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("         <tr><td>Edit name:</td><td><input type=\"text\" id = \"namestr\" name = \"name\" value = \"");
      out.print(namestr);
      out.write("\"></td></tr>    \n");
      out.write("\t\t\t<tr></tr>\t\n");
      out.write("\t\t\t<tr><td>Preview</td><td><lable for = \"namestr\" id = \"examplename\">");
      out.print(example);
      out.write("</lable></td></tr>\t\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"hidden\" name=\"hiddenname\" id = \"hiddenname\" value=\"");
      out.print(namestr);
      out.write("\">\n");
      out.write("\t\t\n");
      out.write("                            </div>\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>Select attributes to compare objects: </a></h2>\n");
      out.write("                            <div class=\"entry\">\n");
      out.write("\t\t      <table id = \"ranktable\">\n");
      out.write("\t\t");

			boolean[] sub_rankable_attr = (boolean[])session.getAttribute("subrankableattr");
			boolean[] direction = (boolean[])session.getAttribute("direction");
			String str1;
        	for (int i=0; i<column_num; i++) {
				if(i%5 == 0){
		
      out.write("\n");
      out.write("    \t\t\t\t<tr>\n");
      out.write("\t\t\t\t      <td valign=\"top\">\n");
      out.write("             \t\t\t");
str1 = column_names.get(i);
      out.write("\n");
      out.write("                        ");
if(sub_rankable_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("                         ");
}
                         else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("\t\t\t\t\t\t ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                      </td>\n");
      out.write("            \t\t  <td> ");
      out.print(str1         );
      out.write("</td>\n");
      out.write("            \t\t  ");
if(direction[i]){
            		  		if(sub_rankable_attr[i]){
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\"  style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
                      	}else{
                      		if(sub_rankable_attr[i]){
      out.write("\n");
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
      out.write("\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("              ");

			     }
			 	else if(i%5 == 4){
               
      out.write("\t\t\n");
      out.write("            \t\t<td valign=\"top\">\n");
      out.write("            \t\t");
str1 = column_names.get(i);
      out.write("\n");
      out.write("                \t   ");
if(sub_rankable_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("                         ");
}
                         else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("\t\t\t\t\t\t ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("            \t\t<td> ");
      out.print(str1         );
      out.write(" </td>                   \n");
      out.write("                      ");
if(direction[i]){
            		  		if(sub_rankable_attr[i]){
      out.write("\n");
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
                      	}else{
                      		if(sub_rankable_attr[i]){
      out.write("\n");
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
      out.write("\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("           \t\t </tr>\n");
      out.write("\t\t\t\t");
	
				}
			   else{
				
      out.write("\n");
      out.write("            \t   <td valign=\"top\">\n");
      out.write("            \t\t");
str1 = column_names.get(i);
                      
      out.write("\n");
      out.write("                \t");
if(sub_rankable_attr[i]){
      out.write("\n");
      out.write("                \t\t  <input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("                      ");
}
                      else{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"rank");
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
      out.write("\"></label>\n");
      out.write("\t\t\t\t\t");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("            \t\t<td> ");
      out.print(str1         );
      out.write("</td>\n");
      out.write("                      ");
if(direction[i]){
            		  		if(sub_rankable_attr[i]){
      out.write("\n");
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"downbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
                      	}else{
                      		if(sub_rankable_attr[i]){
      out.write("\n");
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
      out.write("                      \t\t");
}else{
      out.write("\n");
      out.write("                      \t\t\t<td><input class = \"upbutton\" type=\"button\" name=\"");
      out.print(str1);
      out.write("button\" id=\"");
      out.print(str1);
      out.write("button\" style=\"visibility:hidden\" onClick=\"change('");
      out.print(str1);
      out.write('\'');
      out.write(',');
      out.print(i);
      out.write(");\"/> </td>\n");
      out.write("                      \t\t");
}
      out.write("\n");
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
      out.write("\t\t\t\t\t\t\t\n");
      out.write("                                    <br>\n");
      out.write("                                    <br>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input type=\"button\" name=\"button\" id=\"button\" value=\"Submit\" onClick = \"checkinput();\"/>\n");
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
