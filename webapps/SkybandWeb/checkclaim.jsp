<jsp:include page="top-template2.jsp" />
<%@ page import="java.util.ArrayList, java.lang.String" %>
	</div>
          <%
        	ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
			int column_num = column_names.size();
           %>

	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="homepage.do">Home</a></li>
			<li><a href="objectview.do">ranking</a></li>
			<li><a href="subspaceview.do">Subspace View</a></li>
            <li><a href="setting.do">Set metadata for database</a></li>
            <li class="current_page_item"><a href="checkclaim.do">Check a Claim</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page" >
		<div id="content" style ="float:left;width:1500px">
            <div class="post">
				<div class="bg1">
					<div class="bg2">
						<div class="bg3">
							<h2 class="title"><a>Create your dominance claim</a></h2>
                            <div class="entry">
								<form method="post" action="submitclaim.do">
									<%boolean[] sub_vis_attr = (boolean[])session.getAttribute("subcheckattr");
									 boolean[] sub_rankable_attr = (boolean[])session.getAttribute("subrankableattr");
									 ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");
									 ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
									 %>
									<br>
									<br>
									Fill in at least two of the following blanks:
									<br>
									<br>
									<table>
									<td>Is</td>
									<td>
									<select name="selectobject">
									 <%
										for(int i = 0; i<notitletable.size(); i++){
        									String str="";
       										 for(int j = 0; j<sub_name_index.size(); j++){
               									str = str+notitletable.get(i)[sub_name_index.get(j)]+" ";               		
        									}%>
       								 		<option value = "<%=i%>"><%=str%></option>
   										<% }%>
									</select>
									</td> 
									<td>is dominated by less than</td>
									<td><input type = "text" name = "top" size ="5px"></td>
									<td>other objects in attributes</td>
									<td><select name="selectattr" MULTIPLE>
									 <%
										for(int i = 0; i<column_num; i++){
        									String str = column_names.get(i);
        									if(sub_vis_attr[i]&&sub_rankable_attr[i]){%>
       								 			<option selected = true><%=str%></option>
       								 		<%}else if((!sub_vis_attr[i])&&sub_rankable_attr[i]){%>
       								 			<option><%=str%></option>
   										<%}
   											}%>
									</select> 
									</td>
									<td>?</td>
									<tr></tr>
									<tr></tr>
									<td></td><td></td><td><input type = "submit" value="Check!"></td>
									</table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <!-- end #content -->
        <div id="sidebar" width = "100px">  
		  <ul>

				<li>
              </li>
          </ul>
           </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>

        <!-- end #page -->
</div>
<jsp:include page="bottom-template.jsp" />

