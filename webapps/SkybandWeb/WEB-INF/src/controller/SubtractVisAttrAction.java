package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class SubtractVisAttrAction extends Action {

	public String getName() {
		return "subtractvisattr.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		ArrayList<String> column_names = (ArrayList<String>) session.getAttribute("column_names");
		boolean[] sub_vis_attr = (boolean[]) session.getAttribute("subvisattr");
		Integer j = Integer.parseInt(request.getParameter("txt"));
		sub_vis_attr[j] = false;
		session.setAttribute("subvisattr", sub_vis_attr);
		ArrayList<Integer> sub_vis_index = (ArrayList<Integer>)session.getAttribute("subvisindex"); 
		sub_vis_index.remove(j);
		session.setAttribute("subvisattr", sub_vis_attr);
		Integer tau = (Integer)(session.getAttribute("tau"));
		ArrayList<String[]> table = (ArrayList<String[]>) session.getAttribute("table");
		SkybandAlgorithm saObj = new SkybandAlgorithm();// the argument is used to skip the first two non-number columns
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
		return "subspaceview.jsp";		
	}
}



