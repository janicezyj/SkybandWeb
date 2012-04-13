<jsp:include page="top-template2.jsp" />
<%@ page import="java.util.ArrayList, java.lang.String" %>
	</div>

	<!-- end #header -->
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="homepage.do">Home</a></li>
			<li><a href="objectview.do">ranking</a></li>
			<li><a href="subspaceview.do">Subspace View</a></li>
            <li><a href="setting.do">Set metadata for database</a></li>
            <li><a href="checkclaim.do">Check a Claim</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page" >
		<div id="content" style ="float:left;width:1500px">
            <div class="post">
				<div class="bg1">
					<div class="bg2">
						<div class="bg3">
							<h2 class="title"><a>Home</a></h2>
                            <div class="entry">
								<form method="post" action="submitclaim.do">
									<br>
									<br>
									Now start exploring One-of-the-Few claims from your data!
									<br>
									<br>
									<a href= "objectview.do">Ranking</a>
									<br>
									<br>
									<a href= "subspaceview.do">Subspace View</a>
									<br>
									<br>
									<a href= "setting.do">Set Metadata for Database</a>
									<br>
									<br>
									<a href= "checkclaim.do">Check a Claim</a>
									<br>
									<br>
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

