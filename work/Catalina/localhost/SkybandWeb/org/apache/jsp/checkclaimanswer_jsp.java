package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.lang.String;

public final class checkclaimanswer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge;chrome=1\">\n");
      out.write("\t\t<style type=\"text/css\">\n");
      out.write("\t\t\tsvg {\n");
      out.write("\t\t\t\tborder: 1px solid #000;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tline {\n");
      out.write("                stroke: black;\n");
      out.write("            }\n");
      out.write("            line1{\n");
      out.write("                stroke: black;\n");
      out.write("            }\n");
      out.write(" \n");
      out.write("            text {\n");
      out.write("                font-family: Arial;\n");
      out.write("                font-size: 9pt;\n");
      out.write("            }\n");
      out.write("            title1 {\n");
      out.write("                font-family: Arial;\n");
      out.write("                font-size: 20pt;\n");
      out.write("            }\n");
      out.write("\t\t</style>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://mbostock.github.com/d3/d3.v2.js\">\n");
      out.write("\n");
      out.write("\n");
      out.write("  var _gaq = _gaq || [];\n");
      out.write("  _gaq.push(['_setAccount', 'UA-2513896-19']);\n");
      out.write("  _gaq.push(['_setDomainName', 'clintonmontague.co.uk']);\n");
      out.write("  _gaq.push(['_setAllowLinker', true]);\n");
      out.write("  _gaq.push(['_trackPageview']);\n");
      out.write("\n");
      out.write("  (function() {\n");
      out.write("    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n");
      out.write("    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n");
      out.write("    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n");
      out.write("  })();\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li><a href=\"homepage.do\">Home</a></li>\n");
      out.write("\t\t\t<li><a href=\"objectview.do\">Object View</a></li>\n");
      out.write("\t\t\t<li class=\"current_page_item\"><a href=\"subspaceview.do\">Subspace View</a></li>\n");
      out.write("            <li><a href=\"setting.do\">Setting</a></li>\n");
      out.write("            <li><a href=\"checkclaim.do\">Check Claim</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #menu -->\n");
      out.write("\t<div id=\"page\">\n");
      out.write("\t\t<div id=\"content\" style =\"float:left;width:1500px\">\n");
      out.write("\t\t\t<div class=\"post\">\n");
      out.write("\t\t\t\t<div class=\"bg1\">\n");
      out.write("\t\t\t\t\t<div class=\"bg2\">\n");
      out.write("\t\t\t\t\t\t<div class=\"bg3\">\n");
      out.write("\t\t\t\t\t\t");
String checkans = (String)session.getAttribute("checkans");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>");
      out.print(checkans);
      out.write("</a></h2>\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t");
if(checkans=="true"){
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<h2 class=\"title\"><a>Data Visualization</a></h2>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"entry\">\n");
      out.write("    ");
} 
    	Integer selectindex = (Integer)session.getAttribute("selectindex");
        ArrayList<Integer> sub_vis_index = (ArrayList<Integer>)session.getAttribute("subcheckindex");
        ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
        ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");
        ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
        boolean[] direction = (boolean[])session.getAttribute("direction");
        int size = (sub_vis_index).size();
        String[][][] Data = (String[][][])session.getAttribute("checkData");
        
 if(size == 1){
      out.write("\n");
      out.write("    <script>\n");
      out.write("    var maxX = Number.MIN_VALUE;\n");
      out.write("\tvar minX = Number.MAX_VALUE;\n");
      out.write("    var maxY = Number.MIN_VALUE;\n");
      out.write("    var plotData = new Array();\n");
      out.write("    var interval = ");
      out.print((Double)session.getAttribute("interval"));
      out.write(";\n");
      out.write("    var namesize = ");
      out.print(sub_name_index.size());
      out.write(";\n");
      out.write("    ");
for(int i = 0; i<Data.length; i++){
      out.write("\n");
      out.write("        plotData[");
      out.print(i);
      out.write("] = new Array();\n");
      out.write("        ");
for(int j = 0; j<Data[i].length; j++){
      out.write("\n");
      out.write("            plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("] = new Array();\n");
      out.write("            ");

               String str = "";
               for(int k = 0; k<sub_name_index.size(); k++){
             
                str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            }
            
      out.write("\n");
      out.write("                plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][0] = \"");
      out.print(str);
      out.write("\"; \n");
      out.write("            ");

                for(int k = 0; k<4; k++){
      out.write("\n");
      out.write("                plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write(']');
      out.write('[');
      out.print(k+1);
      out.write("] = \"");
      out.print(Data[i][j][k]);
      out.write("\";\n");
      out.write("\t \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            if(maxX < parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]))\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\tmaxX = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tif(minX > parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1])){\n");
      out.write("\t\t\t\tminX = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]);\n");
      out.write("\t\t\t}\n");
      out.write("            \n");
      out.write("\t\t\t");

        }
      out.write("\n");
      out.write("        if(maxY < plotData[");
      out.print(i);
      out.write("].length){\n");
      out.write("            maxY = plotData[");
      out.print(i);
      out.write("].length;\n");
      out.write("            }\n");
      out.write("    ");
}
    
      out.write("\n");
      out.write("    var minY = 0;\n");
      out.write("    var margin = 40,\n");
      out.write("    width = 600,\n");
      out.write("    height = 500;\n");
      out.write("    \n");
      out.write("    xscale = d3.scale.linear().domain([minX*0.9, maxX*1.1]).range([0 + margin, width- margin]),\n");
      out.write("    yscale = d3.scale.linear().domain([minY*0.9, maxY*1.1]).range([0 + margin, height - margin])\n");
      out.write("    \n");
      out.write("    var vis = d3.select(\"div.entry\")\n");
      out.write("        .append(\"svg:svg\")\n");
      out.write("        .attr(\"width\", width)\n");
      out.write("        .attr(\"height\", height)\n");
      out.write("\n");
      out.write("    var g = vis.append(\"svg:g\")\n");
      out.write("        .attr(\"transform\", \"translate(0, 500)scale(1, -1)\");\n");
      out.write("\n");
      out.write("    g.append(\"svg:line\")\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y1\", yscale(minY*0.9))\n");
      out.write("        .attr(\"x2\", xscale(maxX*1.1))\n");
      out.write("        .attr(\"y2\", yscale(minY*0.9))\n");
      out.write("\t \n");
      out.write("    g.append(\"svg:line\")\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y1\", yscale(minY*0.9))\n");
      out.write("        .attr(\"x2\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y2\", yscale(maxY*1.1))\n");
      out.write("    \n");
      out.write("    var xtick_number = (maxX-minX)/interval+1;\n");
      out.write("        \n");
      out.write("    g.selectAll(\".xLabel\")\n");
      out.write("        .data(xscale.ticks(xtick_number))\n");
      out.write("        .enter().append(\"svg:text\")\n");
      out.write("        .attr(\"class\", \"xLabel\")\n");
      out.write("        .text(String)\n");
      out.write("        .attr(\"x\", function(d) { return xscale(d) })\n");
      out.write("        .attr(\"y\", -5)\n");
      out.write("        .attr(\"transform\", \"scale(1,-1)\")\n");
      out.write("        .attr(\"text-anchor\", \"middle\")\n");
      out.write("        \n");
      out.write("    g.selectAll(\".yLabel\")\n");
      out.write("        .data(yscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:text\")\n");
      out.write("        .attr(\"class\", \"yLabel\")\n");
      out.write("        .text(String)\n");
      out.write("        .attr(\"x\", 5)\n");
      out.write("        .attr(\"y\", function(d) { return -yscale(d) })\n");
      out.write("        .attr(\"transform\", \"scale(1,-1)\")\n");
      out.write("        .attr(\"text-anchor\", \"right\")\n");
      out.write("        .attr(\"dy\", 4)\n");
      out.write("        \n");
      out.write("      g.selectAll(\".yTicks\")\n");
      out.write("        .data(yscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:line\")\n");
      out.write("        .attr(\"class\", \"yTicks\")\n");
      out.write("        .attr(\"y1\", function(d) { return  yscale(d); })\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y2\", function(d) { return  yscale(d); })\n");
      out.write("        .attr(\"x2\", xscale(minX*0.9)+10)\n");
      out.write("        \n");
      out.write("        \n");
      out.write("     var color = new Array();//d3.scale.category20()\n");
      out.write("            color[0] = d3.rgb(\"#d62728\").darker(2);\n");
      out.write("            color[1] = d3.rgb(\"#ff7f0e\").darker(2);\n");
      out.write("            color[2] = d3.rgb(\"#bcbd22\").darker(2);\n");
      out.write("            color[3] = d3.rgb(\"#2ca02c\").darker(2);\n");
      out.write("            color[4] = d3.rgb(\"#17becf\").darker(2);\n");
      out.write("            color[5] = d3.rgb(\"#9467bd\").darker(2);\n");
      out.write("            color[6] = d3.rgb(\"#8c564b\").darker(2);\n");
      out.write("            for(var k = 0; k < 200; k++){\n");
      out.write("                color[k+7] = color[k].brighter(0.3);\n");
      out.write("            }\n");
      out.write("\t\t\n");
      out.write("    var rect = g.selectAll(\"rect\")\n");
      out.write("            .data(randomData(), function (d) { return d.colorid; })\n");
      out.write("            .enter()\n");
      out.write("            .append(\"rect\")\n");
      out.write("            .attr(\"class\",\"rect\")\n");
      out.write("            .attr(\"width\", xscale(interval)-xscale(0))\n");
      out.write("            .attr(\"x\", function(d) {return d.x;})\n");
      out.write("            .attr(\"y\", function(d) {return d.y;})\n");
      out.write("            .attr(\"height\", (yscale(maxY)-yscale(0))/maxY)\n");
      out.write("            .style(\"fill\", function(d){return color[d.colorid];})\n");
      out.write("            .on(\"click\", function(){\n");
      out.write("        \tvar curname = d3.select(this).data()[0].name;\n");
      out.write("        \tvar curcount = d3.select(this).data()[0].count;\n");
      out.write("        \talert(curname+\" is dominated by \"+curcount+\" object(s), in subspace defined by attribute \"+ \"");
      out.print(column_names.get(sub_vis_index.get(0)));
      out.write("\"+\".\");\n");
      out.write("        })\n");
      out.write("            \n");
      out.write("    rect.append(\"title\")\n");
      out.write("        .text(function(d) { return d.name + \", tier \"+(d.id+1)+\", \"+d.value1});\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    var tierLable = g.selectAll(\"tierLable\")\n");
      out.write("        .data(titleData(), function(d){return d.id; })\n");
      out.write("        .enter().append(\"text\")\n");
      out.write("        .attr(\"class\", \"titleLabel\")\n");
      out.write("        .text(function (d){return \"tier \"+ (d.id+1);})\n");
      out.write("        .attr(\"x\", function(d) {return d.x;})\n");
      out.write("        .attr(\"y\", function(d) {return -1*d.y;})\n");
      out.write("        .attr(\"text-anchor\", \"right\")\n");
      out.write("        .attr(\"transform\", \"scale(1,-1)\")\n");
      out.write("\n");
      out.write("    function randomData () {\n");
      out.write("        var band_number = 0;\n");
      out.write("        dataset = [];\n");
      out.write("        if(!");
      out.print(direction[sub_vis_index.get(0)]);
      out.write("){\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("            for(var j = 0; j<plotData[i].length; j++){\n");
      out.write("                var data = {\n");
      out.write("                    id: i,                    \n");
      out.write("                    colorid: band_number+7*j,\n");
      out.write("                    name: plotData[i][j][0],\n");
      out.write("                    count: plotData[i][j][3],\n");
      out.write("                    x: xscale(maxX-(i+1)*interval),\n");
      out.write("                    y: yscale(minY)+j*(yscale(maxY)-yscale(0))/maxY,\n");
      out.write("                    value1:parseInt(plotData[i][j][1]),\n");
      out.write("                    value2:j,\n");
      out.write("                }\n");
      out.write("                dataset.push (data);\n");
      out.write("                }\n");
      out.write("            if(plotData[i].length!=0){\n");
      out.write("                band_number = band_number+1;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        }else{\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("            for(var j = 0; j<plotData[i].length; j++){\n");
      out.write("                var data = {\n");
      out.write("                    id: i,                    \n");
      out.write("                    colorid: band_number+7*j,\n");
      out.write("                    name: plotData[i][j][0],\n");
      out.write("                    x: xscale(minX+i*interval),\n");
      out.write("                    y: yscale(minY)+j*(yscale(maxY)-yscale(0))/maxY,\n");
      out.write("                    count: plotData[i][j][3],\n");
      out.write("                    value1:parseInt(plotData[i][j][1]),\n");
      out.write("                    value2:j,\n");
      out.write("                }\n");
      out.write("                dataset.push (data);\n");
      out.write("                }\n");
      out.write("            if(plotData[i].length!=0){\n");
      out.write("                band_number = band_number+1;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        }\n");
      out.write("        return dataset;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function titleData(){\n");
      out.write("        titleset = [];\n");
      out.write("        if(!");
      out.print(direction[sub_vis_index.get(0)]);
      out.write("){\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("                var titledata = {\n");
      out.write("                    id: i,                    \n");
      out.write("                    x: xscale(maxX-(i+1)*interval),\n");
      out.write("                    y: yscale(minY)+plotData[i].length*(yscale(maxY)-yscale(0))/maxY+10,\n");
      out.write("                }\n");
      out.write("                titleset.push (titledata);\n");
      out.write("        }\n");
      out.write("        }else{\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("                var titledata = {\n");
      out.write("                    id: i,                    \n");
      out.write("                    x: xscale(minX+i*interval),\n");
      out.write("                    y: yscale(minY)+plotData[i].length*(yscale(maxY)-yscale(0))/maxY+10,\n");
      out.write("                }\n");
      out.write("                titleset.push (titledata);\n");
      out.write("        }\n");
      out.write("        }\n");
      out.write("        return titleset;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("    ");
}
 else if(size ==2){
 	Integer selectx = Integer.parseInt(notitletable.get(selectindex)[sub_vis_index.get(0)]);
 	Integer selecty = Integer.parseInt(notitletable.get(selectindex)[sub_vis_index.get(1)]);
 	Integer selectid = 0;
 	for(int i = 0; i< Data.length; i++){
 		for(int j = 0; j<Data[i].length; j++){
 			if(Integer.parseInt(Data[i][j][Data[i][j].length-1])==selectindex)
 				selectid = i;
 			else
 				continue;
 		}
 	}
      out.write("\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("\tvar maxX = Number.MIN_VALUE;\n");
      out.write("\tvar maxY = Number.MIN_VALUE;\n");
      out.write("\tvar minX = Number.MAX_VALUE;\n");
      out.write("\tvar minY = Number.MAX_VALUE;\n");
      out.write("\tvar directionX = ");
      out.print(direction[sub_vis_index.get(0)]);
      out.write(";\n");
      out.write("\tvar directionY = ");
      out.print(direction[sub_vis_index.get(1)]);
      out.write(";\n");
      out.write("    var plotData = new Array();\n");
      out.write("    ");
for(int i = 0; i<Data.length; i++)
    {
      out.write("\n");
      out.write("        plotData[");
      out.print(i);
      out.write("] = new Array();\n");
      out.write("        ");
for(int j = 0; j<Data[i].length; j++){
      out.write("\n");
      out.write("            plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("] = new Array();\n");
      out.write("            ");
String str = "";
            for(int k = 0; k<sub_name_index.size(); k++){
                
                str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            }
            
      out.write("\n");
      out.write("                plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][0] = \"");
      out.print(str);
      out.write("\"; \n");
      out.write("            ");

                for(int k = 0; k<5; k++){
      out.write("\n");
      out.write("                plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write(']');
      out.write('[');
      out.print(k+1);
      out.write("] = \"");
      out.print(Data[i][j][k]);
      out.write("\";\n");
      out.write("\t \n");
      out.write("            ");
}
      out.write("\t\n");
      out.write("\t\t\tif(maxX < parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]))\n");
      out.write("\t\t\t{\n");
      out.write("                maxX = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tif(minX > parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]))\n");
      out.write("            {\n");
      out.write("\t\t\t\tminX = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][1]);\n");
      out.write("\t\t\t}\n");
      out.write("            if(maxY < parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][2]))\n");
      out.write("            {\n");
      out.write("                maxY = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][2]);\n");
      out.write("            }\n");
      out.write("            if(minY > parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][2]))\n");
      out.write("            {\n");
      out.write("                minY = parseInt(plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][2]);\n");
      out.write("            }\n");
      out.write("        ");

        }
    }
    
      out.write("\n");
      out.write("\n");
      out.write("    var margin = 40,\n");
      out.write("    width = 600,\n");
      out.write("    height = 500,\n");
      out.write("    \n");
      out.write("    xscale = d3.scale.linear().domain([minX*0.9, maxX*1.1]).range([0 + margin, width-50 - margin]),\n");
      out.write("    yscale = d3.scale.linear().domain([minY*0.9, maxY*1.1]).range([0 + margin, height - margin])\n");
      out.write("    \n");
      out.write("\tvar vis = d3.select(\"div.entry\")\n");
      out.write("        .append(\"svg:svg\")\n");
      out.write("        .attr(\"width\", width)\n");
      out.write("        .attr(\"height\", height)\n");
      out.write("\n");
      out.write("    var g = vis.append(\"svg:g\")\n");
      out.write("        .attr(\"transform\", \"translate(0, 500)\");\n");
      out.write("\n");
      out.write("    g.append(\"svg:line\")\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y1\", -1 * yscale(minY*0.9))\n");
      out.write("        .attr(\"x2\", xscale(maxX*1.1))\n");
      out.write("        .attr(\"y2\", -1 *yscale(minY*0.9))\n");
      out.write("\t \n");
      out.write("    g.append(\"svg:line\")\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y1\", -1 * yscale(minY*0.9))\n");
      out.write("        .attr(\"x2\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y2\", -1 * yscale(maxY*1.1))\n");
      out.write("\t\n");
      out.write("\tg.selectAll(\".xLabel\")\n");
      out.write("        .data(xscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:text\")\n");
      out.write("        .attr(\"class\", \"xLabel\")\n");
      out.write("        .text(String)\n");
      out.write("        .attr(\"x\", function(d) { return xscale(d) })\n");
      out.write("        .attr(\"y\", -10)\n");
      out.write("        .attr(\"text-anchor\", \"middle\")\n");
      out.write(" \n");
      out.write("    g.selectAll(\".yLabel\")\n");
      out.write("        .data(yscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:text\")\n");
      out.write("        .attr(\"class\", \"yLabel\")\n");
      out.write("        .text(String)\n");
      out.write("        .attr(\"x\", 0)\n");
      out.write("        .attr(\"y\", function(d) { return -1 * yscale(d) })\n");
      out.write("        .attr(\"text-anchor\", \"right\")\n");
      out.write("        .attr(\"dy\", 4)\n");
      out.write("\t\n");
      out.write("\tg.selectAll(\".xTicks\")\n");
      out.write("        .data(xscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:line\")\n");
      out.write("        .attr(\"class\", \"xTicks\")\n");
      out.write("        .attr(\"x1\", function(d) { return xscale(d); })\n");
      out.write("        .attr(\"y1\", -1 * yscale(minY*0.9))\n");
      out.write("        .attr(\"x2\", function(d) { return xscale(d); })\n");
      out.write("        .attr(\"y2\", -1 * yscale(minY*0.9)-10)\n");
      out.write("\n");
      out.write("    g.selectAll(\".yTicks\")\n");
      out.write("        .data(yscale.ticks(10))\n");
      out.write("        .enter().append(\"svg:line\")\n");
      out.write("        .attr(\"class\", \"yTicks\")\n");
      out.write("        .attr(\"y1\", function(d) { return -1 * yscale(d); })\n");
      out.write("        .attr(\"x1\", xscale(minX*0.9))\n");
      out.write("        .attr(\"y2\", function(d) { return -1 * yscale(d); })\n");
      out.write("        .attr(\"x2\", xscale(minX*0.9)+10)\n");
      out.write("     \n");
      out.write("\n");
      out.write("    var color = new Array();//d3.scale.category20()\n");
      out.write("        color[0] = d3.rgb(\"#d62728\");\n");
      out.write("        color[1] = d3.rgb(\"#ff7f0e\");\n");
      out.write("        color[2] = d3.rgb(\"#bcbd22\");\n");
      out.write("        color[3] = d3.rgb(\"#2ca02c\");\n");
      out.write("        color[4] = d3.rgb(\"#17becf\");\n");
      out.write("        color[5] = d3.rgb(\"#9467bd\");\n");
      out.write("        color[6] = d3.rgb(\"#8c564b\");\n");
      out.write("        for(var k = 0; k < plotData.length; k++){\n");
      out.write("            color[k+7] = color[k].brighter();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t \n");
      out.write("\tvar node = g.selectAll(\"circle.node\").data(randomData(), function (d) { return d.id; })\n");
      out.write("        .enter()\n");
      out.write("        .append(\"svg:circle\")\n");
      out.write("        .attr(\"class\", \"node\")\n");
      out.write("        .attr(\"cx\", function (d) { return d.x; })\n");
      out.write("        .attr(\"cy\", function (d) { return d.y; })\n");
      out.write("        .attr(\"r\", 7)\n");
      out.write("        .style(\"fill\", function(d){return color[d.id];})\n");
      out.write("        .on(\"click\", function(){\n");
      out.write("        \tvar curname = d3.select(this).data()[0].name;\n");
      out.write("        \tvar curcount = d3.select(this).data()[0].count;\n");
      out.write("        \talert(curname+\" is dominated by \"+curcount+\" object(s), in subspace defined by attributes \"+ \"");
      out.print(column_names.get(sub_vis_index.get(0)));
      out.write("\"+\" and \"+\"");
      out.print(column_names.get(sub_vis_index.get(1)));
      out.write("\"+\".\");\n");
      out.write("        })\n");
      out.write("        .on(\"mouseover\", function(){\n");
      out.write("                var curid = d3.select(this).data()[0].id;\n");
      out.write("                var curx = d3.select(this).data()[0].x;\n");
      out.write("                var cury = d3.select(this).data()[0].y;\n");
      out.write("                            if((!directionX)&&(!directionY)){\n");
      out.write("                                g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", curx)\n");
      out.write("                                    .attr(\"y2\", -1*yscale(1.1*maxY))\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                                g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", xscale(1.1*maxX))\n");
      out.write("                                    .attr(\"y2\", cury)\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                              }else if((!directionX)&&(directionY)){\n");
      out.write("                              \t g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", curx)\n");
      out.write("                                    .attr(\"y2\", -1*yscale(0.9*minY))\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                                g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", xscale(1.1*maxX))\n");
      out.write("                                    .attr(\"y2\", cury)\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                              }else if((directionX)&&(!directionY)){\n");
      out.write("                               g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", curx)\n");
      out.write("                                    .attr(\"y2\", -1*yscale(1.1*maxY))\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                                g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", xscale(0.9*minX))\n");
      out.write("                                    .attr(\"y2\", cury)\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                              }else{\n");
      out.write("                               g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", curx)\n");
      out.write("                                    .attr(\"y2\", -1*yscale(0.9*minY))\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                                g.append(\"svg:line\")\n");
      out.write("                                    .attr(\"class\", \"line1\")\n");
      out.write("                                    .attr(\"x1\", curx)\n");
      out.write("                                    .attr(\"y1\", cury)\n");
      out.write("                                    .attr(\"x2\", xscale(0.9*minX))\n");
      out.write("                                    .attr(\"y2\", cury)\n");
      out.write("                                    .style(\"stroke\", color[curid]);\n");
      out.write("                              }\n");
      out.write("                \n");
      out.write("                d3.selectAll(\"circle.node\").filter(\n");
      out.write("                    function(d){return d.id == curid&&d.index!=selectindex;}).attr(\"r\", 15);\n");
      out.write("                for(var i = 0;i<d3.selectAll(\"circle.node\").filter(function(d){return d.id == curid;}).data().length;i++){\n");
      out.write("                                    curx = d3.selectAll(\"circle.node\").filter(function(d){return d.id == curid;}).data()[i].x;\n");
      out.write("                                    cury = d3.selectAll(\"circle.node\").filter(function(d){return d.id == curid;}).data()[i].y;\n");
      out.write("                                    if((!directionX)&&(!directionY)){\n");
      out.write("                                    g.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\", \"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", curx)\n");
      out.write("                                        .attr(\"y2\", -1*yscale(1.1*maxY))\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                    g.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\",\"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", xscale(1.1*maxX))\n");
      out.write("                                        .attr(\"y2\", cury)\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                        }\n");
      out.write("                                        else if((!directionX)&&(directionY)){\n");
      out.write("                                        g.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\", \"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", curx)\n");
      out.write("                                        .attr(\"y2\", -1*yscale(0.9*minY))\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                    \tg.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\",\"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", xscale(1.1*maxX))\n");
      out.write("                                        .attr(\"y2\", cury)\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                        }\n");
      out.write("                                        else if((directionX)&&(!directionY)){\n");
      out.write("                                        g.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\", \"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", curx)\n");
      out.write("                                        .attr(\"y2\", -1*yscale(1.1*maxY))\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                    \tg.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\",\"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", xscale(0.9*minX))\n");
      out.write("                                        .attr(\"y2\", cury)\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                        }\n");
      out.write("                                        else{\n");
      out.write("                                        g.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\", \"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", curx)\n");
      out.write("                                        .attr(\"y2\", -1*yscale(0.9*minY))\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                    \tg.append(\"svg:line\")\n");
      out.write("                                        .attr(\"class\",\"line1\")\n");
      out.write("                                        .attr(\"x1\", curx)\n");
      out.write("                                        .attr(\"y1\", cury)\n");
      out.write("                                        .attr(\"x2\", xscale(0.9*minX))\n");
      out.write("                                        .attr(\"y2\", cury)\n");
      out.write("                                        .style(\"stroke\", color[curid])\n");
      out.write("                                        .style(\"stroke-dasharray\",5,3,2);\n");
      out.write("                                        }\n");
      out.write("                }\n");
      out.write("                    var title = g.append(\"text\")\n");
      out.write("                        .attr(\"class\", \"title1\")\n");
      out.write("                        .style(\"font-size\", 22+\"pt\")\n");
      out.write("                        .attr(\"dy\", -450)\n");
      out.write("                        .attr(\"dx\", 400)\n");
      out.write("                        .style(\"fill\", color[curid])\n");
      out.write("                        .text(\"tier \"+(curid+1));})\n");
      out.write("\n");
      out.write("        .on(\"mouseout\", function(){\n");
      out.write("                var curid = d3.select(this).data()[0].id;\n");
      out.write("                d3.selectAll(\"circle.node\").filter(\n");
      out.write("                    function(d){return d.id == curid;}).attr(\"r\", 7);      \n");
      out.write("                d3.selectAll(\".title1\").transition().style(\"opacity\",0);\n");
      out.write("                d3.selectAll(\".line1\").transition().style(\"opacity\",0);})\n");
      out.write("  \n");
      out.write("    node.append(\"title\")\n");
      out.write("        .text(function(d) { return d.name +\", tier \"+(d.id+1)+\", \"+d.value1+\", \"+d.value2; });\n");
      out.write("        var selectindex = ");
      out.print(selectindex);
      out.write("\n");
      out.write("\t\tvar selectval1 = ");
      out.print(selectx);
      out.write("\n");
      out.write("\t\tvar selectval2 = ");
      out.print(selecty);
      out.write("\n");
      out.write("\t\tvar selectid = ");
      out.print(selectid);
      out.write("\n");
      out.write("\t\t\n");
      out.write("    \n");
      out.write("      \n");
      out.write("     d3.selectAll(\"circle.node\").filter(\n");
      out.write("       function(d){return d.index==selectindex;}).style(\"opacity\",0);\n");
      out.write("       \n");
      out.write("       \tg.append('path') \n");
      out.write("      .attr('d', function(d) { \n");
      out.write("        var x = xscale(selectval1), y = -1*yscale(selectval2)-10; \n");
      out.write("        return 'M ' + x +' '+ y + ' l 10 20 l -20 0 z'; \n");
      out.write("      })\n");
      out.write("      .style(\"fill\",color[selectid]); \n");
      out.write("\t\t \n");
      out.write("    \t\n");
      out.write("    var rect = g.selectAll(\"rect\")\n");
      out.write("            .data(colorData(), function (d) { return d.id; })\n");
      out.write("            .enter()\n");
      out.write("            .append(\"rect\")\n");
      out.write("            .attr(\"class\",\"rect\")\n");
      out.write("            .attr(\"width\", 20)\n");
      out.write("            .attr(\"x\", 520)\n");
      out.write("            .attr(\"y\", function(d) {return d.y;})\n");
      out.write("            .attr(\"height\", 9.9)\n");
      out.write("            .style(\"fill\", function(d){return color[d.id];})\n");
      out.write("     \n");
      out.write("    \n");
      out.write("    var colorLable = g.selectAll(\"colorLable\")\n");
      out.write("        .data(colorData(), function(d){return d.id; })\n");
      out.write("        .enter().append(\"text\")\n");
      out.write("        .attr(\"class\", \"colorLabel\")\n");
      out.write("        .text(function (d){return \"tier \"+ (d.id+1);})\n");
      out.write("        .attr(\"x\", 545)\n");
      out.write("        .attr(\"y\", function(d) {return d.y+10;})\n");
      out.write("        .attr(\"text-anchor\", \"right\")\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("    function randomData () {\n");
      out.write("        dataset = [];\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("            for(var j = 0; j<plotData[i].length; j++){\n");
      out.write("                var data = {\n");
      out.write("                    id: i,\n");
      out.write("                    name: plotData[i][j][0],\n");
      out.write("                    index: plotData[i][j][plotData[0][0].length-1],\n");
      out.write("                    count: plotData[i][j][plotData[0][0].length-2],\n");
      out.write("                    x: xscale(parseInt(plotData[i][j][1])),\n");
      out.write("                    y: -1*yscale(parseInt(plotData[i][j][2])),\n");
      out.write("                    value1:parseInt(plotData[i][j][1]),\n");
      out.write("                    value2:parseInt(plotData[i][j][2])\n");
      out.write("                }\n");
      out.write("                dataset.push (data);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        return dataset;\n");
      out.write("    }\t\n");
      out.write("    \n");
      out.write("    function colorData () {\n");
      out.write("        colorset = [];\n");
      out.write("        for (var i = 0; i < plotData.length; i++) {\n");
      out.write("                var colordata = {\n");
      out.write("                    id: i,\n");
      out.write("                    y: -1*(10*(plotData.length-i)+50),\n");
      out.write("                }\n");
      out.write("                colorset.push (colordata);\n");
      out.write("        }\n");
      out.write("        return colorset;\n");
      out.write("    }\t\n");
      out.write("    </script>\n");

   }
   else if(size<1){

      out.write("\n");
      out.write("    Please choose attributes for visualization\n");

    }
    else{

      out.write("\n");
      out.write("    There's no visualization when the number of chosen attributes is bigger than 2\n");

   }

      out.write("\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
if(checkans=="true"){
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<table id=\"table\" width=\"40%\" height=\"151\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("                                    ");

                                        String[][] ranking_list  = (String[][])session.getAttribute("rankinglist");
                               
                                        Integer tau = (Integer)session.getAttribute("tau");
                                        String objectname = (String)session.getAttribute("objectname"); 
                                        String[] row = new String[sub_vis_index.size()+2];
                                    
      out.write("\n");
      out.write("                                    ");

                                        row[0]="tier";
                                        row[1]= objectname;
                                        for(int i = 0; i<sub_vis_index.size(); ++i){
                                            row[i+2] = column_names.get(sub_vis_index.get(i));
                                        }
                                    
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
      out.write("                                        </tr>\n");
      out.write("                            <script type=\"text/javascript\" language=\"javascript\"> \n");
      out.write("                                    var table = document.getElementById(\"table\");\n");
      out.write("                                    var plotData = new Array();\n");
      out.write("                                    ");
for(int i = 0; i<Data.length; i++)
    								{
      out.write("\n");
      out.write("       \t\t\t\t\t\t\t\t\t plotData[");
      out.print(i);
      out.write("] = new Array();\n");
      out.write("        \t\t\t\t\t\t\t\t");
for(int j = 0; j<Data[i].length; j++){
      out.write("\n");
      out.write("           \t\t\t\t\t\t\t\t\t plotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("] = new Array();\n");
      out.write("           \t\t\t\t\t\t\t\t\t ");
String str = "";
           									 for(int k = 0; k<sub_name_index.size(); k++){
                
               									 str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            								}
           								 
      out.write("\n");
      out.write("                \t\t\t\t\t\t\tplotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write("][0] = \"");
      out.print(str);
      out.write("\"; \n");
      out.write("            \t\t\t\t\t\t\t");

              							  for(int k = 0; k<3+sub_vis_index.size(); k++){
      out.write("\n");
      out.write("                \t\t\t\t\t\t  \tplotData[");
      out.print(i);
      out.write(']');
      out.write('[');
      out.print(j);
      out.write(']');
      out.write('[');
      out.print(k+1);
      out.write("] = \"");
      out.print(Data[i][j][k]);
      out.write("\";\t \n");
      out.write("           \t\t\t\t\t\t\t\t ");
}
           								}
           							}
      out.write("\n");
      out.write("           \t\t\t\t\t\t\tvar color = new Array();//d3.scale.category20()\n");
      out.write("           \t\t\t\t\t\t\tif(plotData[0][0].length==5){\n");
      out.write("           \t\t\t\t\t\t\t\t var color = new Array();//d3.scale.category20()\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[0] = d3.rgb(\"#d62728\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[1] = d3.rgb(\"#ff7f0e\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[2] = d3.rgb(\"#bcbd22\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[3] = d3.rgb(\"#2ca02c\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[4] = d3.rgb(\"#17becf\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[5] = d3.rgb(\"#9467bd\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tcolor[6] = d3.rgb(\"#8c564b\").darker(2);\n");
      out.write("            \t\t\t\t\t\t\t\tfor(var k = 0; k < 200; k++){\n");
      out.write("                \t\t\t\t\t\t\t\tcolor[k+7] = color[k].brighter(0.3);\n");
      out.write("           \t\t\t\t\t\t\t\t\t}\n");
      out.write("           \t\t\t\t\t\t\t\t\tvar band = 0;\n");
      out.write("           \t\t\t\t\t\t\t\t\tfor(var i = 0; i<plotData.length; i++){\n");
      out.write("           \t\t\t\t\t\t\t\t\t\tif(plotData[i].length!=0){\n");
      out.write("                                       \t\t\t for(var j = 0; j<plotData[i].length; j++){\n");
      out.write("                                           \t\t\tvar row = table.insertRow(-1);\n");
      out.write("                                            \t\tcell = row.insertCell(-1);\n");
      out.write("                                            \t\tcell.innerHTML = i+1;\n");
      out.write("                                            \t\tcell.style.color = color[i];\n");
      out.write("                                            \t\t for(var k = 0; k<plotData[i][j].length-3; k++){\n");
      out.write("                                                \t\tcell = row.insertCell(-1);\n");
      out.write("                                                \t\tcell.innerHTML = plotData[i][j][k];\n");
      out.write("                                                \t\tcell.style.color = color[band+7*j];\n");
      out.write("                                            \t\t}                                \n");
      out.write("                                        \t\t}\n");
      out.write("                                        \t\tband=band+1;\n");
      out.write("                                        \t\t}\n");
      out.write("                                    \t\t}\n");
      out.write("           \t\t\t\t\t\t\t\t}else{\n");
      out.write("        \t\t\t\t\t\t\tcolor[0] = d3.rgb(\"#d62728\");\n");
      out.write("       \t\t\t\t\t\t\t\tcolor[1] = d3.rgb(\"#ff7f0e\");\n");
      out.write("        \t\t\t\t\t\t\tcolor[2] = d3.rgb(\"#bcbd22\");\n");
      out.write("       \t\t\t\t\t\t\t \tcolor[3] = d3.rgb(\"#2ca02c\");\n");
      out.write("        \t\t\t\t\t\t\tcolor[4] = d3.rgb(\"#17becf\");\n");
      out.write("        \t\t\t\t\t\t\tcolor[5] = d3.rgb(\"#9467bd\");\n");
      out.write("        \t\t\t\t\t\t\tcolor[6] = d3.rgb(\"#8c564b\");\n");
      out.write("        \t\t\t\t\t\t\tfor(var k = 0; k < plotData.length; k++){\n");
      out.write("            \t\t\t\t\t\t\tcolor[k+7] = color[k].brighter();\n");
      out.write("        \t\t\t\t\t\t\t}\n");
      out.write("        \t\t\t\t\t\t\tfor(var i = 0; i<plotData.length; i++){\n");
      out.write("                                        for(var j = 0; j<plotData[i].length; j++){\n");
      out.write("                                            var row = table.insertRow(-1);\n");
      out.write("                                            cell = row.insertCell(-1);\n");
      out.write("                                            cell.innerHTML = i+1;\n");
      out.write("                                            cell.style.color = color[i];\n");
      out.write("                                            for(var k = 0; k<plotData[i][j].length-3; k++){\n");
      out.write("                                                cell = row.insertCell(-1);\n");
      out.write("                                                cell.innerHTML = plotData[i][j][k];\n");
      out.write("                                                cell.style.color = color[i];\n");
      out.write("                                            }                                           \n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("        \t\t\t\t\t\t}\n");
      out.write("                            </script>                                   \n");
      out.write("                                </table>\n");
      out.write("      ");
}
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>        \n");
      out.write("       \n");
      out.write("\n");
      out.write("\t\t<!-- end #content -->\n");
      out.write("<div id=\"sidebar2\">  \n");
      out.write("    </div>\n");
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