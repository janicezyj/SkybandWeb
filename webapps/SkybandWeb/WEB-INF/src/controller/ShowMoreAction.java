package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class ShowMoreAction extends Action {

	public String getName() {
		return "showmore.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		Integer tau = Integer.parseInt(request.getParameter("showmore"));
		System.out.println("tau  "+ tau);
		session.setAttribute("tau", tau);
		ArrayList<String> column_names = (ArrayList<String>) session.getAttribute("column_names");
		ArrayList<String[]> table = (ArrayList<String[]>) session.getAttribute("table");
		boolean[] sub_vis_attr = (boolean[])session.getAttribute("subvisattr");
		ArrayList<Integer> sub_vis_index = (ArrayList<Integer>)session.getAttribute("subvisindex"); 
		SkybandAlgorithm saObj = new SkybandAlgorithm();
		ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");	
		boolean[] direction = (boolean[])session.getAttribute("direction");
		String[][][] getData;
		if(sub_vis_index.size() == 1){
			int k = sub_vis_index.get(0);
			
			ArrayList<Double> value = new ArrayList<Double>();
			for(int i = 0; i<notitletable.size(); i++){//get max and min to compute interval
				 value.add(Double.parseDouble(notitletable.get(i)[k]));
	        }
			double max = Double.MIN_VALUE;
			double min = Double.MAX_VALUE;
			double interval;
			if(direction[sub_vis_index.get(0)]){
				Collections.sort(value);
				 max = value.get(tau);
				 min = value.get(0);
		         interval = (max-min)/10.0;
			}else{
				Collections.sort(value,Collections.reverseOrder());
				min = value.get(tau);
				max = value.get(0);
		        interval = (max-min)/10.0;
			}			
			getData = saObj.bruteforce_toptau_onlyone(notitletable, sub_vis_index, direction, tau,interval);
			session.setAttribute("interval", interval);
		}
		else{
			getData = saObj.bruteforce_toptau(notitletable, sub_vis_index, direction, tau);
		}
		session.setAttribute("Data", getData);
		System.out.println("Data.length:" + getData.length);
		System.out.println("Data:");
		for(int z=0; z<getData.length; ++z){
			for(int h=0; h<getData[z].length; ++h){
				//System.out.println("plotData.get(z).size():" + plotData.get(z).size());
				for(int n = 0; n<getData[z][h].length; ++n)
				System.out.print(getData[z][h][n] + "\t");
			}
			System.out.println();
		}
		return "subspaceview.jsp";
	}
}
