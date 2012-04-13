<jsp:include page="top-template2.jsp" />
<%@ page import="java.util.ArrayList, java.lang.String" %>

</div>
<!-- end #header -->
<div id="menu">
		<ul>
		</ul>
	</div>
	<!-- end #menu -->
<div id="page">
		<div id="content" style ="float:left;width:1500px">
			<div class="post">
				<div class="bg1">
					<div class="bg2">
						<div class="bg3">
							<div class="entry">
<p style="font-size:small">&nbsp;</p>
<form method="post" action="clicktable.do">
	<% ArrayList<String[]> tablelist = (ArrayList<String[]>)session.getAttribute("tablelist");
	if(tablelist.size()==0){%>
		<td>You don't have any Google Fusion Tables, please upload one!</td>
		<%}
		else{%>	
    <td>All my Fusion Tables, choose one to begin!</td>
    <br>
    <br>
    <%
        for(int i = 0; i<tablelist.size(); ++i){
            String name = ""+tablelist.get(i)[0];
            String id = ""+tablelist.get(i)[1];%>
            <td><a href= "clicktable.do?tableid=<%=id%>"><%=name%></a></td>
            <br>
    <%}
    }%>
    
    <br>
    <br>
    --or--
    <br>
    <br>
    Search for a public Fusion Table
    <br>
    <br>
    Input table ID<input type = "text" name = tableid ><input type = "submit" value = "submit">

</form>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
   <!-- end #content -->
        <div id="sidebar">  
		  <ul>
          </ul>
           </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>

        <!-- end #page -->
    </div>
<jsp:include page="bottom-template.jsp" />