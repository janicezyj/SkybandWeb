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
			<li><a href="objectview.do">Object View</a></li>
			<li><a href="subspaceview.do">Subspace View</a></li>
            <li class="current_page_item"><a href="setting.do">Setting</a></li>
            <li><a href="checkclaim.do">Check Claim</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
		<div id="content" style ="float:left;width:1500px">
            <div class="post">
				<div class="bg1">
					<div class="bg2">
						<div class="bg3">
							<h2 class="title"><a>Select attributes for naming an object</a></h2>
                            <div class="entry">
								<form method="post" action="submitdefaultset.do">
		     <table>
             <script type="text/javascript" language="javascript"> 

    function add(str,i){
        var sr = document.getElementById("rank"+str);
		var vc = document.getElementById("vis"+str);
		var lb = document.getElementById("lable"+str);
        var button = document.getElementById(str+"button");
        if(sr.checked){  
           button.style.visibility = "visible"; 
           vc.disabled = false;
           lb.style.color = "black";
        }
        else{
            button.style.visibility = "hidden";
            vc.disabled = true;
            vc.checked = false;
            lb.style.color = "gray";           
            }
    }

    function preview(str,i){
        var sr = document.getElementById("name"+str);
        var lable = document.getElementById("namestr");
        var hn = document.getElementById("hiddenname");
        if(sr.checked){     
            namestr.innerText=namestr.innerText+"%" + str;
            hn.value = hn.value+"%"+str;
        }
        else{
            var innertext = lable.innerText;
            var deletetext = "%" + str;
            var split = innertext.split(deletetext);
            lable.innerText = split[0] +split[1];
            hn.value = split[0]+split[1];
            }
    }
    
        function change(str,i){
        	var button = document.getElementById(str+"button");
        	var hiddenbutton = document.getElementById(str+"hiddenbutton");
            if(hiddenbutton.value == "false"){
            	hiddenbutton.value = "true";
            	button.style.backgroundImage = "url('arrow2.png')";
            }
           	else {
           		hiddenbutton.value = "false";
            	button.style.backgroundImage = "url('arrow1.png')";
            }
    	}
</script>
		 <table id = "nametable">
		<%
			boolean[] sub_naming_attr = (boolean[])session.getAttribute("subnamingattr");
			String str0;
            String id0;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		%>
    				<tr>
				      <td valign="top">
             			<%str0 = column_names.get(i);
                        %>
                        <%if(sub_naming_attr[i]){%>
                		  <input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" CHECKED onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label>
                         <%}
                         else{%>
							<input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label> 
						 <%}%>
                    
                      </td>
            		  <td> <%=str0         %>
                      </td>
              <%
			     }
			 	else if(i%8 == 7){
               %>		
            		<td valign="top">
            		<%str0 = column_names.get(i);%>
                	   <%if(sub_naming_attr[i]){%>
                		  <input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" CHECKED onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label>
                         <%}
                         else{%>
							<input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label> 
						 <%}%>
                    </td>
            		<td> <%=str0         %>                    
                    </td>
           		 </tr>

				<%
		
				}
			   else{
				%>
            	   <td valign="top">
            		<%str0 = column_names.get(i);%>
                	<%if(sub_naming_attr[i]){%>
                		  <input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" CHECKED onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label>
                         <%}
                         else{%>
							<input type="checkbox" name="name<%=str0 %>" id="name<%=str0 %>" onClick="preview('<%=str0%>',<%=i%>);"/><label for="<%=str0 %>"></label> 
						 <%}%>
                    </td>
            		<td> <%=str0         %>
                    </td>
            	<%
				}
			}
			%>
		<%	String objectname = (String)session.getAttribute("objectname");
			ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
			String namestr = "";
			for(int i = 0; i<sub_name_index.size(); i++){
				namestr = namestr+"%"+column_names.get(sub_name_index.get(i));
			}%>	
         </table>
         Preview of name:
         <table id = "previewtable" height="50"  border="1" cellpadding="0" cellspacing="0">    
			<tr><td><input type="text" name="name" id="name" value="<%=objectname%>" /></td></tr>
			<tr><td><lable for = "namestr" id = "namestr"><%=namestr%></lable></td></tr>	
		</table>
		<input type="hidden" name="hiddenname" id = "hiddenname" value="<%=namestr%>">
		
                            </div>
							<h2 class="title"><a>Set directions for attributes: </a></h2>
                            <div class="entry">
		      <table id = "ranktable">
		<%
			boolean[] direction = (boolean[])session.getAttribute("direction");
			String str1;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		%>
    				<tr>
             			<%str1 = column_names.get(i);%>
            		  <td> <%=str1         %></td>
            		  <%if(direction[i]){%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button"  onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		
                      	<%}else{%>
                      		
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      <%}%>
              <%
			     }
			 	else if(i%8 == 7){
               %>		
            		<%str1 = column_names.get(i);%>
            		<td> <%=str1         %> </td>                   
                      <%if(direction[i]){%>
            		  		
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		
                      	<%}else{%>
                      		
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		
                      <%}%>
           		 </tr>
				<%	
				}
			   else{
				%>
            		<%str1 = column_names.get(i); %>
            		<td> <%=str1         %></td>
                      <%if(direction[i]){%>
            		  		
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		
                      	<%}else{%>
                      		
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		
                      <%}%>
            	<%
				}
			}
			%>	
         </table>
         <%for(int i = 0; i<column_num; i++){
         	if(direction[i]){%>
         		<input type="hidden" name="<%=column_names.get(i)%>hiddenbutton" id = "<%=column_names.get(i)%>hiddenbutton" value="true">
         	<%}else{%>
         		<input type="hidden" name="<%=column_names.get(i)%>hiddenbutton" id = "<%=column_names.get(i)%>hiddenbutton" value="false">
         	<%}
         }%>

							
                                    <br>
                                    <br>
                                    <br>
                                    <input type="submit" name="submit" id="submit" value="Submit"/>
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

