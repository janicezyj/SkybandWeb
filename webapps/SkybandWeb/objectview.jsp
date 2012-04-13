<jsp:include page="top-template2.jsp" />
<style type="text/css">
.askbutton   {   
background-image:url(help.png); 
height:25px; 
width: 24px;
font-size:12px; 
border:0px  
}
</style>
<%@ page import="java.util.ArrayList, java.lang.String" %>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="homepage.do">Home</a></li>
			<li class="current_page_item"><a href="objectview.do">ranking</a></li>
			<li><a href="subspaceview.do">Subspace View</a></li>
            <li><a href="setting.do">Set metadata for database</a></li>
            <li><a href="checkclaim.do">Check a Claim</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
		<div id="content">
			<div class="post">
				<div class="bg1">
					<div class="bg2">
						<div class="bg3">
						<h2 class="title"><a>Ranking by overall score</a></h2>
						<div class="entry1">
						 <table id="table" width="100%" height="151"  border="1" cellpadding="0" cellspacing="0">
                        <% ArrayList<String[]> table  = (ArrayList<String[]>)session.getAttribute("table");
                           ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
                            int column_num = column_names.size();                          
                            ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
                            ArrayList<Integer> sub_rank_index = (ArrayList<Integer>)session.getAttribute("subrankindex");
                            boolean[] sub_rankable_attr = (boolean[])session.getAttribute("subrankableattr");
                            boolean[] sub_rank_attr = (boolean[])session.getAttribute("subrankattr");
           					String[][] ranking_list = (String[][])session.getAttribute("rankinglist");
           				%>           					
                               	 <%String objectname = (String)session.getAttribute("objectname"); 
                                 String[] row = new String[sub_rank_index.size()+3];
                                    %>
                                    <%
                                        row[0]="rank";
                                        row[1]= objectname;
                                        for(int i = 0; i<sub_rank_index.size(); ++i){
                                            row[i+2] = column_names.get(sub_rank_index.get(i));
                                        }
                                        row[row.length-1] = "score";
                                    %>
                                        <tr>
                                            <%
                                            for(int j = 0; j<row.length; j++){
                                            %>
                                                <td> <%=row[j]%></td>
                                            <% 
                                            } 
                                            %>
                                        </tr>     		
                             <script type="text/javascript" language="javascript"> 
								var table = document.getElementById("table");      		
							<%for(int i = 0; i<ranking_list.length; i++){%>
								var row = table.insertRow(-1);
								cell = row.insertCell(-1);
        						<%String str2=""+(i+1);%>
        						cell.innerHTML = "<%=str2%>";
        						<%str2 = "";%>
        						<%for(int j = 0; j<sub_name_index.size(); j++){%>
              						 <%str2 = str2+ranking_list[i][sub_name_index.get(j)]+" ";%>            		
       							<%}%>
       							cell = row.insertCell(-1);
              					cell.innerHTML = "<%=str2%>"; 
              					<%String info = "";
              					for(int j = 0; j<column_names.size(); j++){
              						info = info+column_names.get(j)+"  "+ranking_list[i][j]+", ";
              					}%>
       							cell.onclick = function(){alert("<%=info%>")};
       							<%for(int j = 0; j<sub_rank_index.size(); j++){%>
       								<%str2 = ""+ranking_list[i][sub_rank_index.get(j)];%>
       								cell = row.insertCell(-1);
              						cell.innerHTML = "<%=str2%>";  		
   								<%}%>
   								cell = row.insertCell(-1);
   								cell.innerHTML = "<%=ranking_list[i][ranking_list[i].length-2]%>"
   							<%}%>
                           
                          </script>
                          	</table>						  
							</div>
						</div>
					</div>
				</div>
			</div>
          </div>
			
		<!-- end #content -->
	<div id="sidebar2">  
		  <ul>
				<li>
					<h2><a>Choose Ranking Attributes</a></h2>
				</li>
				<li>
					<ul>
		<form method="post" action="submitrankattr.do">				  
        <% 
        String str1;
        for(int i = 0; i<column_names.size(); i++){
        	str1 = column_names.get(i);
        	if(sub_rank_attr[i]){%>
        		<input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" CHECKED onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>" style = "color:white"><%=str1%></label>
        		<br>
			<%}
			if((!sub_rank_attr[i])&&sub_rankable_attr[i]){%>
				<input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>" style = "color:white"><%=str1%></label>
				<br>
   <% 		}
   		}
   	%>
                    </ul>
              </li>
          </ul>
          <ul>
			  <li>
					<h2><a>Input &alpha;</a></h2>
					
			  </li>
              <li>
					<ul>	
					<label for = "alpha" style = "color:white">0<&alpha;<1     </lable><input class = "askbutton" type="button" name="askbutton" id="askbutton" onClick = "alert('&alpha; is the parameter that discounts score by position in each subspace;smaller &alpha; means specialized objects are preferred,bigger &alpha; means well-banlanced objects are preferred;')"/>
					<br>
					<input type="text" name="alpha" id="alpha" size="15" value = "0.5"/>
					<br>
					<br>
					<br>
					<input type="submit" id="submit" value="submit" />
			</form>
			        </ul>
              </li>
          </ul>
		</div>   
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
</div>
<jsp:include page="bottom-template.jsp" />
