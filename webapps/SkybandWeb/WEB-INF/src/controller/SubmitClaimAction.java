package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class SubmitClaimAction extends Action {

	public String getName() {
		return "submitclaim.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		ArrayList<String> column_names = (ArrayList<String>) session.getAttribute("column_names");
		ArrayList<Integer> sub_name_index = (ArrayList<Integer>)session.getAttribute("subnameindex");
		ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");	
		boolean[] direction = (boolean[])session.getAttribute("direction");
		Integer selectindex = Integer.parseInt(request.getParameter("selectobject"));
		System.out.println(selectindex);
		session.setAttribute("selectindex", selectindex);
		Integer top = Integer.parseInt(request.getParameter("top"));
		session.setAttribute("top", top);
		boolean[] sub_vis_attr = (boolean[]) session.getAttribute("subcheckattr");
		ArrayList<Integer> sub_vis_index = new ArrayList<Integer>();
		String[] selectedattr = request.getParameterValues("selectattr");
		for(int i = 0; i<column_names.size(); i++){
			sub_vis_attr[i] = false;
		}
		for(int j = 0; j<column_names.size(); j++){
			for(int i = 0; i<selectedattr.length; i++){
				if(selectedattr[i].equals(column_names.get(j))){
					sub_vis_attr[j] = true;
					sub_vis_index.add(j);
					break;
				}		
			}			
		}
		session.setAttribute("subcheckattr", sub_vis_attr);
		session.setAttribute("subcheckindex", sub_vis_index);
		for(int j = 0; j<sub_vis_attr.length; ++j){
				System.out.print(column_names.get(j)+"  "+ sub_vis_attr[j]+"  ");
		}
		System.out.println("");
		SkybandAlgorithm saObj = new SkybandAlgorithm();
		String[][][] getData = saObj.bruteforce_toptau(notitletable, sub_vis_index, direction, notitletable.size());
		String ans ="false";
		int sum = 0;
		boolean breakornot = false;
		for(int i = 0; i<getData.length; i++){
			for(int j = 0; j<getData[i].length; j++){
				if(selectindex == Integer.parseInt(getData[i][j][getData[i][j].length-1])&&(top>Integer.parseInt(getData[i][j][getData[i][j].length-2]))){
					ans = "true";
				}
				if(top<Integer.parseInt(getData[i][j][getData[i][j].length-2])){
					breakornot = true;
					break;
				}
			}
			if(breakornot)
				break;
			sum = sum+getData[i].length;
		}
		session.setAttribute("checkans", ans);
		String[][][] newgetData = saObj.bruteforce_toptau(notitletable, sub_vis_index, direction, sum);
		session.setAttribute("checkData", newgetData);
		return "checkclaimanswer.jsp";
		
	}
}



