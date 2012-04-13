<jsp:include page="top-template2.jsp" />
<%@ page import="java.util.ArrayList, java.lang.String" %>
	</div>
          <%
        	ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
        	ArrayList<String[]> table  = (ArrayList<String[]>)session.getAttribute("table");
			int column_num = column_names.size();
			String[] exampleinfo = table.get(1);
           %>

	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="homepage.do">Home</a></li>
			<li><a href="objectview.do">ranking</a></li>
			<li><a href="subspaceview.do">Subspace View</a></li>
            <li class="current_page_item"><a href="setting.do">Set Metadata for database</a></li>
            <li><a href="checkclaim.do">Check a Claim</a></li>
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
     
             <script type="text/javascript" language="javascript"> 
    function add(str,i){
        var sr = document.getElementById("rank"+str);
        var button = document.getElementById(str+"button");
        if(sr.checked){  
           button.style.visibility = "visible"; 
        }
        else{
            button.style.visibility = "hidden";         
            }
    }

    function preview(str,i){
    	var exampleinfo = new Array();
    	<%for(int i = 0; i<exampleinfo.length; i++){%>
    		exampleinfo[<%=i%>] = "<%=exampleinfo[i]%>";
    	<%}%>
        var sr = document.getElementById("name"+str);
        var text = document.getElementById("namestr");
        var hn = document.getElementById("hiddenname");
        var example = document.getElementById("examplename");
        if(sr.checked){     
            namestr.value=namestr.value+"%" + str;
            hn.value = hn.value+"%"+str;
            example.innerText = example.innerText+" "+exampleinfo[i];
        }
        else{
            var innertext = text.value;
            var deletetext = "%" + str;
            var split = innertext.split(deletetext);
            text.value = split[0] +split[1];
            hn.value = split[0]+split[1];
          	split = example.innerText.split(exampleinfo[i]);
          	example.innerText = split[0]+split[1];
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
    	function checkinput(){
			var form = document.getElementById("form");
			var valid1 = false;
			var valid2 = false;
			<%for(int i = 0; i<column_names.size(); i++){
				String str = column_names.get(i);%>
				var name = document.getElementById("name"+"<%=str%>");
				if(name.checked)
					valid1 = true;
			<%}%>
			<%for(int i = 0; i<column_names.size(); i++){
				String str = column_names.get(i);%>
				var rank = document.getElementById("rank"+"<%=str%>");
				if(rank.checked)
					valid2 = true;
			<%}%>
			if(!(valid1&&valid2))
				alert("Invalid Input!");
			else{
				form.action="submitattr.do";
				form.submit();
				}
    	}
</script>
 <form method="post" name = "form" id = "form" >
		 <table id = "nametable">
		<%
			boolean[] sub_name_attr = (boolean[])session.getAttribute("subnameattr");
			String str0;
        	for (int i=0; i<column_num; i++) {
				if(i%8 == 0){
		%>
    				<tr>
				      <td valign="top">
             			<%str0 = column_names.get(i);
                        %>
                        <%if(sub_name_attr[i]){%>
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
                	   <%if(sub_name_attr[i]){%>
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
                	<%if(sub_name_attr[i]){%>
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
		</table>
		<%	
			ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
			String namestr = "";
			String example = "";
			for(int i = 0; i<sub_name_index.size(); i++){
				namestr = namestr+"%"+column_names.get(sub_name_index.get(i));
				example = example+table.get(1)[sub_name_index.get(i)]+" ";
			}%>	
        
         <table id = "previewtable" height="50"  border="1" cellpadding="0" cellspacing="0">
         <tr><td>Edit name:</td><td><input type="text" id = "namestr" name = "name" value = "<%=namestr%>"></td></tr>    
			<tr></tr>	
			<tr><td>Preview</td><td><lable for = "namestr" id = "examplename"><%=example%></lable></td></tr>	
		</table>
		<input type="hidden" name="hiddenname" id = "hiddenname" value="<%=namestr%>">
		
                            </div>
							<h2 class="title"><a>Select attributes to compare objects: </a></h2>
                            <div class="entry">
		      <table id = "ranktable">
		<%
			boolean[] sub_rankable_attr = (boolean[])session.getAttribute("subrankableattr");
			boolean[] direction = (boolean[])session.getAttribute("direction");
			String str1;
        	for (int i=0; i<column_num; i++) {
				if(i%5 == 0){
		%>
    				<tr>
				      <td valign="top">
             			<%str1 = column_names.get(i);%>
                        <%if(sub_rankable_attr[i]){%>
                		  <input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" CHECKED onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
                         <%}
                         else{%>
							<input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
						 <%}%>
                    
                      </td>
            		  <td> <%=str1         %></td>
            		  <%if(direction[i]){
            		  		if(sub_rankable_attr[i]){%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button"  onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button"  style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}
                      	}else{
                      		if(sub_rankable_attr[i]){%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}%>
                      <%}%>
              <%
			     }
			 	else if(i%5 == 4){
               %>		
            		<td valign="top">
            		<%str1 = column_names.get(i);%>
                	   <%if(sub_rankable_attr[i]){%>
                		  <input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" CHECKED onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
                         <%}
                         else{%>
							<input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
						 <%}%>
                    </td>
            		<td> <%=str1         %> </td>                   
                      <%if(direction[i]){
            		  		if(sub_rankable_attr[i]){%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}
                      	}else{
                      		if(sub_rankable_attr[i]){%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}%>
                      <%}%>
           		 </tr>
				<%	
				}
			   else{
				%>
            	   <td valign="top">
            		<%str1 = column_names.get(i);
                      %>
                	<%if(sub_rankable_attr[i]){%>
                		  <input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" CHECKED onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
                      <%}
                      else{%>
							<input type="checkbox" name="rank<%=str1%>" id="rank<%=str1%>" onClick="add('<%=str1%>',<%=i%>);"/><label for="<%=str1 %>"></label>
					<%}%>
                    </td>
            		<td> <%=str1         %></td>
                      <%if(direction[i]){
            		  		if(sub_rankable_attr[i]){%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "downbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}
                      	}else{
                      		if(sub_rankable_attr[i]){%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}else{%>
                      			<td><input class = "upbutton" type="button" name="<%=str1%>button" id="<%=str1%>button" style="visibility:hidden" onClick="change('<%=str1%>',<%=i%>);"/> </td>
                      		<%}%>
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
                                    <input type="button" name="button" id="button" value="Submit" onClick = "checkinput();"/>
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

