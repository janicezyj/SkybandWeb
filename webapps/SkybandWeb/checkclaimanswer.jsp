<jsp:include page="top-template2.jsp" />

		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
		<style type="text/css">
			svg {
				border: 1px solid #000;
			}
			line {
                stroke: black;
            }
            line1{
                stroke: black;
            }
 
            text {
                font-family: Arial;
                font-size: 9pt;
            }
            title1 {
                font-family: Arial;
                font-size: 20pt;
            }
		</style>
        <script type="text/javascript" src="http://mbostock.github.com/d3/d3.v2.js">


  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-2513896-19']);
  _gaq.push(['_setDomainName', 'clintonmontague.co.uk']);
  _gaq.push(['_setAllowLinker', true]);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

<%@ page import="java.util.ArrayList, java.lang.String" %>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="homepage.do">Home</a></li>
			<li><a href="objectview.do">Object View</a></li>
			<li class="current_page_item"><a href="subspaceview.do">Subspace View</a></li>
            <li><a href="setting.do">Setting</a></li>
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
						<%String checkans = (String)session.getAttribute("checkans");%>
							<h2 class="title"><a><%=checkans%></a></h2>
							<br>
							<br>
							<%if(checkans=="true"){%>
							<h2 class="title"><a>Data Visualization</a></h2>
							<div class="entry">
    <%} 
    	Integer selectindex = (Integer)session.getAttribute("selectindex");
        ArrayList<Integer> sub_vis_index = (ArrayList<Integer>)session.getAttribute("subcheckindex");
        ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
        ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");
        ArrayList<String> column_names = (ArrayList<String>)session.getAttribute("column_names");
        boolean[] direction = (boolean[])session.getAttribute("direction");
        int size = (sub_vis_index).size();
        String[][][] Data = (String[][][])session.getAttribute("checkData");
        
 if(size == 1){%>
    <script>
    var maxX = Number.MIN_VALUE;
	var minX = Number.MAX_VALUE;
    var maxY = Number.MIN_VALUE;
    var plotData = new Array();
    var interval = <%=(Double)session.getAttribute("interval")%>;
    var namesize = <%=sub_name_index.size()%>;
    <%for(int i = 0; i<Data.length; i++){%>
        plotData[<%=i%>] = new Array();
        <%for(int j = 0; j<Data[i].length; j++){%>
            plotData[<%=i%>][<%=j%>] = new Array();
            <%
               String str = "";
               for(int k = 0; k<sub_name_index.size(); k++){
             
                str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            }
            %>
                plotData[<%=i%>][<%=j%>][0] = "<%=str%>"; 
            <%
                for(int k = 0; k<4; k++){%>
                plotData[<%=i%>][<%=j%>][<%=k+1%>] = "<%=Data[i][j][k]%>";
	 
            <%}%>
            if(maxX < parseInt(plotData[<%=i%>][<%=j%>][1]))
			{
			maxX = parseInt(plotData[<%=i%>][<%=j%>][1]);
			}
			if(minX > parseInt(plotData[<%=i%>][<%=j%>][1])){
				minX = parseInt(plotData[<%=i%>][<%=j%>][1]);
			}
            
			<%
        }%>
        if(maxY < plotData[<%=i%>].length){
            maxY = plotData[<%=i%>].length;
            }
    <%}
    %>
    var minY = 0;
    var margin = 40,
    width = 600,
    height = 500;
    
    xscale = d3.scale.linear().domain([minX*0.9, maxX*1.1]).range([0 + margin, width- margin]),
    yscale = d3.scale.linear().domain([minY*0.9, maxY*1.1]).range([0 + margin, height - margin])
    
    var vis = d3.select("div.entry")
        .append("svg:svg")
        .attr("width", width)
        .attr("height", height)

    var g = vis.append("svg:g")
        .attr("transform", "translate(0, 500)scale(1, -1)");

    g.append("svg:line")
        .attr("x1", xscale(minX*0.9))
        .attr("y1", yscale(minY*0.9))
        .attr("x2", xscale(maxX*1.1))
        .attr("y2", yscale(minY*0.9))
	 
    g.append("svg:line")
        .attr("x1", xscale(minX*0.9))
        .attr("y1", yscale(minY*0.9))
        .attr("x2", xscale(minX*0.9))
        .attr("y2", yscale(maxY*1.1))
    
    var xtick_number = (maxX-minX)/interval+1;
        
    g.selectAll(".xLabel")
        .data(xscale.ticks(xtick_number))
        .enter().append("svg:text")
        .attr("class", "xLabel")
        .text(String)
        .attr("x", function(d) { return xscale(d) })
        .attr("y", -5)
        .attr("transform", "scale(1,-1)")
        .attr("text-anchor", "middle")
        
    g.selectAll(".yLabel")
        .data(yscale.ticks(10))
        .enter().append("svg:text")
        .attr("class", "yLabel")
        .text(String)
        .attr("x", 5)
        .attr("y", function(d) { return -yscale(d) })
        .attr("transform", "scale(1,-1)")
        .attr("text-anchor", "right")
        .attr("dy", 4)
        
      g.selectAll(".yTicks")
        .data(yscale.ticks(10))
        .enter().append("svg:line")
        .attr("class", "yTicks")
        .attr("y1", function(d) { return  yscale(d); })
        .attr("x1", xscale(minX*0.9))
        .attr("y2", function(d) { return  yscale(d); })
        .attr("x2", xscale(minX*0.9)+10)
        
        
     var color = new Array();//d3.scale.category20()
            color[0] = d3.rgb("#d62728").darker(2);
            color[1] = d3.rgb("#ff7f0e").darker(2);
            color[2] = d3.rgb("#bcbd22").darker(2);
            color[3] = d3.rgb("#2ca02c").darker(2);
            color[4] = d3.rgb("#17becf").darker(2);
            color[5] = d3.rgb("#9467bd").darker(2);
            color[6] = d3.rgb("#8c564b").darker(2);
            for(var k = 0; k < 200; k++){
                color[k+7] = color[k].brighter(0.3);
            }
		
    var rect = g.selectAll("rect")
            .data(randomData(), function (d) { return d.colorid; })
            .enter()
            .append("rect")
            .attr("class","rect")
            .attr("width", xscale(interval)-xscale(0))
            .attr("x", function(d) {return d.x;})
            .attr("y", function(d) {return d.y;})
            .attr("height", (yscale(maxY)-yscale(0))/maxY)
            .style("fill", function(d){return color[d.colorid];})
            .on("click", function(){
        	var curname = d3.select(this).data()[0].name;
        	var curcount = d3.select(this).data()[0].count;
        	alert(curname+" is dominated by "+curcount+" object(s), in subspace defined by attribute "+ "<%=column_names.get(sub_vis_index.get(0))%>"+".");
        })
            
    rect.append("title")
        .text(function(d) { return d.name + ", tier "+(d.id+1)+", "+d.value1});
        
        
    var tierLable = g.selectAll("tierLable")
        .data(titleData(), function(d){return d.id; })
        .enter().append("text")
        .attr("class", "titleLabel")
        .text(function (d){return "tier "+ (d.id+1);})
        .attr("x", function(d) {return d.x;})
        .attr("y", function(d) {return -1*d.y;})
        .attr("text-anchor", "right")
        .attr("transform", "scale(1,-1)")

    function randomData () {
        var band_number = 0;
        dataset = [];
        if(!<%=direction[sub_vis_index.get(0)]%>){
        for (var i = 0; i < plotData.length; i++) {
            for(var j = 0; j<plotData[i].length; j++){
                var data = {
                    id: i,                    
                    colorid: band_number+7*j,
                    name: plotData[i][j][0],
                    count: plotData[i][j][3],
                    x: xscale(maxX-(i+1)*interval),
                    y: yscale(minY)+j*(yscale(maxY)-yscale(0))/maxY,
                    value1:parseInt(plotData[i][j][1]),
                    value2:j,
                }
                dataset.push (data);
                }
            if(plotData[i].length!=0){
                band_number = band_number+1;
            }
        }
        }else{
        for (var i = 0; i < plotData.length; i++) {
            for(var j = 0; j<plotData[i].length; j++){
                var data = {
                    id: i,                    
                    colorid: band_number+7*j,
                    name: plotData[i][j][0],
                    x: xscale(minX+i*interval),
                    y: yscale(minY)+j*(yscale(maxY)-yscale(0))/maxY,
                    count: plotData[i][j][3],
                    value1:parseInt(plotData[i][j][1]),
                    value2:j,
                }
                dataset.push (data);
                }
            if(plotData[i].length!=0){
                band_number = band_number+1;
            }
        }
        }
        return dataset;
    }
    
    function titleData(){
        titleset = [];
        if(!<%=direction[sub_vis_index.get(0)]%>){
        for (var i = 0; i < plotData.length; i++) {
                var titledata = {
                    id: i,                    
                    x: xscale(maxX-(i+1)*interval),
                    y: yscale(minY)+plotData[i].length*(yscale(maxY)-yscale(0))/maxY+10,
                }
                titleset.push (titledata);
        }
        }else{
        for (var i = 0; i < plotData.length; i++) {
                var titledata = {
                    id: i,                    
                    x: xscale(minX+i*interval),
                    y: yscale(minY)+plotData[i].length*(yscale(maxY)-yscale(0))/maxY+10,
                }
                titleset.push (titledata);
        }
        }
        return titleset;
    }

    </script>
    
    <%}
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
 	}%>
    
    <script>
	var maxX = Number.MIN_VALUE;
	var maxY = Number.MIN_VALUE;
	var minX = Number.MAX_VALUE;
	var minY = Number.MAX_VALUE;
	var directionX = <%=direction[sub_vis_index.get(0)]%>;
	var directionY = <%=direction[sub_vis_index.get(1)]%>;
    var plotData = new Array();
    <%for(int i = 0; i<Data.length; i++)
    {%>
        plotData[<%=i%>] = new Array();
        <%for(int j = 0; j<Data[i].length; j++){%>
            plotData[<%=i%>][<%=j%>] = new Array();
            <%String str = "";
            for(int k = 0; k<sub_name_index.size(); k++){
                
                str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            }
            %>
                plotData[<%=i%>][<%=j%>][0] = "<%=str%>"; 
            <%
                for(int k = 0; k<5; k++){%>
                plotData[<%=i%>][<%=j%>][<%=k+1%>] = "<%=Data[i][j][k]%>";
	 
            <%}%>	
			if(maxX < parseInt(plotData[<%=i%>][<%=j%>][1]))
			{
                maxX = parseInt(plotData[<%=i%>][<%=j%>][1]);
			}
			if(minX > parseInt(plotData[<%=i%>][<%=j%>][1]))
            {
				minX = parseInt(plotData[<%=i%>][<%=j%>][1]);
			}
            if(maxY < parseInt(plotData[<%=i%>][<%=j%>][2]))
            {
                maxY = parseInt(plotData[<%=i%>][<%=j%>][2]);
            }
            if(minY > parseInt(plotData[<%=i%>][<%=j%>][2]))
            {
                minY = parseInt(plotData[<%=i%>][<%=j%>][2]);
            }
        <%
        }
    }
    %>

    var margin = 40,
    width = 600,
    height = 500,
    
    xscale = d3.scale.linear().domain([minX*0.9, maxX*1.1]).range([0 + margin, width-50 - margin]),
    yscale = d3.scale.linear().domain([minY*0.9, maxY*1.1]).range([0 + margin, height - margin])
    
	var vis = d3.select("div.entry")
        .append("svg:svg")
        .attr("width", width)
        .attr("height", height)

    var g = vis.append("svg:g")
        .attr("transform", "translate(0, 500)");

    g.append("svg:line")
        .attr("x1", xscale(minX*0.9))
        .attr("y1", -1 * yscale(minY*0.9))
        .attr("x2", xscale(maxX*1.1))
        .attr("y2", -1 *yscale(minY*0.9))
	 
    g.append("svg:line")
        .attr("x1", xscale(minX*0.9))
        .attr("y1", -1 * yscale(minY*0.9))
        .attr("x2", xscale(minX*0.9))
        .attr("y2", -1 * yscale(maxY*1.1))
	
	g.selectAll(".xLabel")
        .data(xscale.ticks(10))
        .enter().append("svg:text")
        .attr("class", "xLabel")
        .text(String)
        .attr("x", function(d) { return xscale(d) })
        .attr("y", -10)
        .attr("text-anchor", "middle")
 
    g.selectAll(".yLabel")
        .data(yscale.ticks(10))
        .enter().append("svg:text")
        .attr("class", "yLabel")
        .text(String)
        .attr("x", 0)
        .attr("y", function(d) { return -1 * yscale(d) })
        .attr("text-anchor", "right")
        .attr("dy", 4)
	
	g.selectAll(".xTicks")
        .data(xscale.ticks(10))
        .enter().append("svg:line")
        .attr("class", "xTicks")
        .attr("x1", function(d) { return xscale(d); })
        .attr("y1", -1 * yscale(minY*0.9))
        .attr("x2", function(d) { return xscale(d); })
        .attr("y2", -1 * yscale(minY*0.9)-10)

    g.selectAll(".yTicks")
        .data(yscale.ticks(10))
        .enter().append("svg:line")
        .attr("class", "yTicks")
        .attr("y1", function(d) { return -1 * yscale(d); })
        .attr("x1", xscale(minX*0.9))
        .attr("y2", function(d) { return -1 * yscale(d); })
        .attr("x2", xscale(minX*0.9)+10)
     

    var color = new Array();//d3.scale.category20()
        color[0] = d3.rgb("#d62728");
        color[1] = d3.rgb("#ff7f0e");
        color[2] = d3.rgb("#bcbd22");
        color[3] = d3.rgb("#2ca02c");
        color[4] = d3.rgb("#17becf");
        color[5] = d3.rgb("#9467bd");
        color[6] = d3.rgb("#8c564b");
        for(var k = 0; k < plotData.length; k++){
            color[k+7] = color[k].brighter();
        }


		 
	var node = g.selectAll("circle.node").data(randomData(), function (d) { return d.id; })
        .enter()
        .append("svg:circle")
        .attr("class", "node")
        .attr("cx", function (d) { return d.x; })
        .attr("cy", function (d) { return d.y; })
        .attr("r", 7)
        .style("fill", function(d){return color[d.id];})
        .on("click", function(){
        	var curname = d3.select(this).data()[0].name;
        	var curcount = d3.select(this).data()[0].count;
        	alert(curname+" is dominated by "+curcount+" object(s), in subspace defined by attributes "+ "<%=column_names.get(sub_vis_index.get(0))%>"+" and "+"<%=column_names.get(sub_vis_index.get(1))%>"+".");
        })
        .on("mouseover", function(){
                var curid = d3.select(this).data()[0].id;
                var curx = d3.select(this).data()[0].x;
                var cury = d3.select(this).data()[0].y;
                            if((!directionX)&&(!directionY)){
                                g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", curx)
                                    .attr("y2", -1*yscale(1.1*maxY))
                                    .style("stroke", color[curid]);
                                g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", xscale(1.1*maxX))
                                    .attr("y2", cury)
                                    .style("stroke", color[curid]);
                              }else if((!directionX)&&(directionY)){
                              	 g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", curx)
                                    .attr("y2", -1*yscale(0.9*minY))
                                    .style("stroke", color[curid]);
                                g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", xscale(1.1*maxX))
                                    .attr("y2", cury)
                                    .style("stroke", color[curid]);
                              }else if((directionX)&&(!directionY)){
                               g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", curx)
                                    .attr("y2", -1*yscale(1.1*maxY))
                                    .style("stroke", color[curid]);
                                g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", xscale(0.9*minX))
                                    .attr("y2", cury)
                                    .style("stroke", color[curid]);
                              }else{
                               g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", curx)
                                    .attr("y2", -1*yscale(0.9*minY))
                                    .style("stroke", color[curid]);
                                g.append("svg:line")
                                    .attr("class", "line1")
                                    .attr("x1", curx)
                                    .attr("y1", cury)
                                    .attr("x2", xscale(0.9*minX))
                                    .attr("y2", cury)
                                    .style("stroke", color[curid]);
                              }
                
                d3.selectAll("circle.node").filter(
                    function(d){return d.id == curid&&d.index!=selectindex;}).attr("r", 15);
                for(var i = 0;i<d3.selectAll("circle.node").filter(function(d){return d.id == curid;}).data().length;i++){
                                    curx = d3.selectAll("circle.node").filter(function(d){return d.id == curid;}).data()[i].x;
                                    cury = d3.selectAll("circle.node").filter(function(d){return d.id == curid;}).data()[i].y;
                                    if((!directionX)&&(!directionY)){
                                    g.append("svg:line")
                                        .attr("class", "line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", curx)
                                        .attr("y2", -1*yscale(1.1*maxY))
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                    g.append("svg:line")
                                        .attr("class","line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", xscale(1.1*maxX))
                                        .attr("y2", cury)
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                        }
                                        else if((!directionX)&&(directionY)){
                                        g.append("svg:line")
                                        .attr("class", "line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", curx)
                                        .attr("y2", -1*yscale(0.9*minY))
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                    	g.append("svg:line")
                                        .attr("class","line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", xscale(1.1*maxX))
                                        .attr("y2", cury)
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                        }
                                        else if((directionX)&&(!directionY)){
                                        g.append("svg:line")
                                        .attr("class", "line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", curx)
                                        .attr("y2", -1*yscale(1.1*maxY))
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                    	g.append("svg:line")
                                        .attr("class","line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", xscale(0.9*minX))
                                        .attr("y2", cury)
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                        }
                                        else{
                                        g.append("svg:line")
                                        .attr("class", "line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", curx)
                                        .attr("y2", -1*yscale(0.9*minY))
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                    	g.append("svg:line")
                                        .attr("class","line1")
                                        .attr("x1", curx)
                                        .attr("y1", cury)
                                        .attr("x2", xscale(0.9*minX))
                                        .attr("y2", cury)
                                        .style("stroke", color[curid])
                                        .style("stroke-dasharray",5,3,2);
                                        }
                }
                    var title = g.append("text")
                        .attr("class", "title1")
                        .style("font-size", 22+"pt")
                        .attr("dy", -450)
                        .attr("dx", 400)
                        .style("fill", color[curid])
                        .text("tier "+(curid+1));})

        .on("mouseout", function(){
                var curid = d3.select(this).data()[0].id;
                d3.selectAll("circle.node").filter(
                    function(d){return d.id == curid;}).attr("r", 7);      
                d3.selectAll(".title1").transition().style("opacity",0);
                d3.selectAll(".line1").transition().style("opacity",0);})
  
    node.append("title")
        .text(function(d) { return d.name +", tier "+(d.id+1)+", "+d.value1+", "+d.value2; });
        var selectindex = <%=selectindex%>
		var selectval1 = <%=selectx%>
		var selectval2 = <%=selecty%>
		var selectid = <%=selectid%>
		
    
      
     d3.selectAll("circle.node").filter(
       function(d){return d.index==selectindex;}).style("opacity",0);
       
       	g.append('path') 
      .attr('d', function(d) { 
        var x = xscale(selectval1), y = -1*yscale(selectval2)-10; 
        return 'M ' + x +' '+ y + ' l 10 20 l -20 0 z'; 
      })
      .style("fill",color[selectid]); 
		 
    	
    var rect = g.selectAll("rect")
            .data(colorData(), function (d) { return d.id; })
            .enter()
            .append("rect")
            .attr("class","rect")
            .attr("width", 20)
            .attr("x", 520)
            .attr("y", function(d) {return d.y;})
            .attr("height", 9.9)
            .style("fill", function(d){return color[d.id];})
     
    
    var colorLable = g.selectAll("colorLable")
        .data(colorData(), function(d){return d.id; })
        .enter().append("text")
        .attr("class", "colorLabel")
        .text(function (d){return "tier "+ (d.id+1);})
        .attr("x", 545)
        .attr("y", function(d) {return d.y+10;})
        .attr("text-anchor", "right")



  
    function randomData () {
        dataset = [];
        for (var i = 0; i < plotData.length; i++) {
            for(var j = 0; j<plotData[i].length; j++){
                var data = {
                    id: i,
                    name: plotData[i][j][0],
                    index: plotData[i][j][plotData[0][0].length-1],
                    count: plotData[i][j][plotData[0][0].length-2],
                    x: xscale(parseInt(plotData[i][j][1])),
                    y: -1*yscale(parseInt(plotData[i][j][2])),
                    value1:parseInt(plotData[i][j][1]),
                    value2:parseInt(plotData[i][j][2])
                }
                dataset.push (data);
            }
        }
        return dataset;
    }	
    
    function colorData () {
        colorset = [];
        for (var i = 0; i < plotData.length; i++) {
                var colordata = {
                    id: i,
                    y: -1*(10*(plotData.length-i)+50),
                }
                colorset.push (colordata);
        }
        return colorset;
    }	
    </script>
<%
   }
   else if(size<1){
%>
    Please choose attributes for visualization
<%
    }
    else{
%>
    There's no visualization when the number of chosen attributes is bigger than 2
<%
   }
%>
<br>
<br>
<br>
<br>
<%if(checkans=="true"){%>
								<table id="table" width="40%" height="151"  border="1" cellpadding="0" cellspacing="0">
                                    <%
                                        String[][] ranking_list  = (String[][])session.getAttribute("rankinglist");
                               
                                        Integer tau = (Integer)session.getAttribute("tau");
                                        String objectname = (String)session.getAttribute("objectname"); 
                                        String[] row = new String[sub_vis_index.size()+2];
                                    %>
                                    <%
                                        row[0]="tier";
                                        row[1]= objectname;
                                        for(int i = 0; i<sub_vis_index.size(); ++i){
                                            row[i+2] = column_names.get(sub_vis_index.get(i));
                                        }
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
                                    var plotData = new Array();
                                    <%for(int i = 0; i<Data.length; i++)
    								{%>
       									 plotData[<%=i%>] = new Array();
        								<%for(int j = 0; j<Data[i].length; j++){%>
           									 plotData[<%=i%>][<%=j%>] = new Array();
           									 <%String str = "";
           									 for(int k = 0; k<sub_name_index.size(); k++){
                
               									 str = str + notitletable.get(Integer.parseInt(Data[i][j][Data[0][0].length-1]))[sub_name_index.get(k)]+" ";
            								}
           								 %>
                							plotData[<%=i%>][<%=j%>][0] = "<%=str%>"; 
            							<%
              							  for(int k = 0; k<3+sub_vis_index.size(); k++){%>
                						  	plotData[<%=i%>][<%=j%>][<%=k+1%>] = "<%=Data[i][j][k]%>";	 
           								 <%}
           								}
           							}%>
           							var color = new Array();//d3.scale.category20()
           							if(plotData[0][0].length==5){
           								 var color = new Array();//d3.scale.category20()
            								color[0] = d3.rgb("#d62728").darker(2);
            								color[1] = d3.rgb("#ff7f0e").darker(2);
            								color[2] = d3.rgb("#bcbd22").darker(2);
            								color[3] = d3.rgb("#2ca02c").darker(2);
            								color[4] = d3.rgb("#17becf").darker(2);
            								color[5] = d3.rgb("#9467bd").darker(2);
            								color[6] = d3.rgb("#8c564b").darker(2);
            								for(var k = 0; k < 200; k++){
                								color[k+7] = color[k].brighter(0.3);
           									}
           									var band = 0;
           									for(var i = 0; i<plotData.length; i++){
           										if(plotData[i].length!=0){
                                       			 for(var j = 0; j<plotData[i].length; j++){
                                           			var row = table.insertRow(-1);
                                            		cell = row.insertCell(-1);
                                            		cell.innerHTML = i+1;
                                            		cell.style.color = color[i];
                                            		 for(var k = 0; k<plotData[i][j].length-3; k++){
                                                		cell = row.insertCell(-1);
                                                		cell.innerHTML = plotData[i][j][k];
                                                		cell.style.color = color[band+7*j];
                                            		}                                
                                        		}
                                        		band=band+1;
                                        		}
                                    		}
           								}else{
        							color[0] = d3.rgb("#d62728");
       								color[1] = d3.rgb("#ff7f0e");
        							color[2] = d3.rgb("#bcbd22");
       							 	color[3] = d3.rgb("#2ca02c");
        							color[4] = d3.rgb("#17becf");
        							color[5] = d3.rgb("#9467bd");
        							color[6] = d3.rgb("#8c564b");
        							for(var k = 0; k < plotData.length; k++){
            							color[k+7] = color[k].brighter();
        							}
        							for(var i = 0; i<plotData.length; i++){
                                        for(var j = 0; j<plotData[i].length; j++){
                                            var row = table.insertRow(-1);
                                            cell = row.insertCell(-1);
                                            cell.innerHTML = i+1;
                                            cell.style.color = color[i];
                                            for(var k = 0; k<plotData[i][j].length-3; k++){
                                                cell = row.insertCell(-1);
                                                cell.innerHTML = plotData[i][j][k];
                                                cell.style.color = color[i];
                                            }                                           
                                        }
                                    }
        						}
                            </script>                                   
                                </table>
      <%}%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>        
       

		<!-- end #content -->
<div id="sidebar2">  
    </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
</div>
<jsp:include page="bottom-template.jsp" />
