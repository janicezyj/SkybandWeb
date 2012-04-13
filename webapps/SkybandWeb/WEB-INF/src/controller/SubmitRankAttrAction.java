package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class SubmitRankAttrAction extends Action {

	public String getName() {
		return "submitrankattr.do";
	}
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		ArrayList<String> column_names = (ArrayList<String>) session.getAttribute("column_names");
		ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");
		boolean[] direction = (boolean[])session.getAttribute("direction");
		boolean[] sub_rank_attr = (boolean[]) session.getAttribute("subrankattr");
		ArrayList<Integer> sub_rank_index = new ArrayList<Integer>();
		for(int i = 0; i<column_names.size(); i++){
			String str = column_names.get(i);
			if(request.getParameter("rank"+str)!= null){
				sub_rank_attr[i] = true;
				sub_rank_index.add(i);
			}		
			else
				sub_rank_attr[i] = false;
		}
		
		for(int j = 0; j<sub_rank_attr.length; ++j){
				System.out.print(column_names.get(j)+"  "+ sub_rank_attr[j]+"  ");
		}
		System.out.println("");	
	
		session.setAttribute("subrankattr", sub_rank_attr);

		session.setAttribute("subrankindex", sub_rank_index);
		
		Double alpha = Double.parseDouble(request.getParameter("alpha"));
		String[][] ranking_list = RankingAlgorithm.ranking(notitletable, sub_rank_index, notitletable.size(), direction, alpha);
		session.setAttribute("rankinglist", ranking_list);
		return "objectview.jsp";
	}
}



