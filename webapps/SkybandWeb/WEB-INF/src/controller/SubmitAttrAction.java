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


public class SubmitAttrAction extends Action {

	public String getName() {
		return "submitattr.do";
	}
	public static void setdefaultset(String id, boolean[] rankable, ArrayList<Integer> index, boolean[] direction){
		DefaultSet defaultset = new DefaultSet();
		defaultset.sub_rankable_attr = rankable;
		defaultset.sub_name_index = index;
		defaultset.direction = direction;
		String str = id+";"+defaultset.toString();
		System.out.println(str);
		try {
        	File file;
        	file = new File("defaultset.txt");
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	BufferedReader reader = new BufferedReader(new FileReader(file));
        	ArrayList<String> list = new ArrayList<String>();
        	String line = null;  
        	boolean found = false;
            while ((line=reader.readLine()) != null) {
            	if(!line.startsWith(id)){
            		list.add(line);
            		continue;
            	}
            	list.add(str);
            	found = true;
            }
            if(!found)
            	list.add(str);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for( int i=0;i<list.size();i++ ){
            	bw.write(list.get(i).toString());
            	bw.newLine();
            }
            bw.flush();
            bw.close();
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		ArrayList<String> column_names = (ArrayList<String>) session.getAttribute("column_names");
		
		boolean[] sub_name_attr = (boolean[]) session.getAttribute("subnameattr");
		
		for(int i = 0; i<column_names.size(); i++){
			String str = column_names.get(i);
			if(request.getParameter("name"+str)!= null){
				sub_name_attr[i] = true;
				//sub_name_index.add(i);
			}		
			else
				sub_name_attr[i] = false;
		}
		
		for(int j = 0; j<sub_name_attr.length; ++j){
				System.out.print(column_names.get(j)+"  "+ sub_name_attr[j]+"  ");
		}
		System.out.println("");
		
		ArrayList<Integer> sub_name_index = new ArrayList<Integer>();
		String namestr = request.getParameter("hiddenname");
		//System.out.println(namestr);
		String[] namestrarray = namestr.split("%");	
		for(int j = 1; j<namestrarray.length; j++){
			for(int k = 0; k<column_names.size(); k++){
				if(namestrarray[j].equals(column_names.get(k))){
					sub_name_index.add(k);
					System.out.println("index: "+ sub_name_index.get(j-1));
				}
			}
		}
		
		boolean[] sub_rankable_attr = (boolean[]) session.getAttribute("subrankableattr");
		ArrayList<Integer> sub_rankable_index = new ArrayList<Integer>();
		
		for(int i = 0; i<column_names.size(); i++){
			String str = column_names.get(i);
			//System.out.println(request.getParameter("rank"+str));
			if(request.getParameter("rank"+str)!= null){
				sub_rankable_attr[i] = true;
				sub_rankable_index.add(i);
			}		
			else
				sub_rankable_attr[i] = false;
		}

		for(int j = 0; j<sub_rankable_attr.length; ++j){
				System.out.print(column_names.get(j)+"  "+ sub_rankable_attr[j]+"  ");
		}
		System.out.println("");
		
		boolean[] direction = (boolean[])session.getAttribute("direction");

		for(int i = 0; i<column_names.size(); i++){
			String str = column_names.get(i);
			System.out.println(str + request.getParameter(str+"hiddenbutton"));
			if(request.getParameter(str+"hiddenbutton").equals("true")){
				direction[i] = true;
				System.out.println(direction[i]);
			}
			else{
				direction[i] = false;
				System.out.println(direction[i]);
			}
		}
		String tableid = (String)session.getAttribute("tableid");
		setdefaultset(tableid, sub_rankable_attr, sub_name_index, direction);
		ArrayList<String[]> notitletable = (ArrayList<String[]>)session.getAttribute("no_title_table");
		boolean[] sub_rank_attr = new boolean[column_names.size()];
		boolean[] sub_vis_attr = new boolean[column_names.size()];
		for(int i = 0; i<column_names.size(); i++){
			sub_rank_attr[i] = false;
			sub_vis_attr[i] = false;
		}
		ArrayList<Integer> sub_rank_index  = new ArrayList<Integer>();
		ArrayList<Integer> sub_vis_index = new ArrayList<Integer>();
		for(int i = 0; i<sub_rankable_index.size()&&i<2; i++){
				sub_rank_index.add(sub_rankable_index.get(i));
				sub_vis_index.add(sub_rankable_index.get(i));
		}
		for(int i = 0; i<column_names.size(); i++){
				if(sub_rank_index.contains(i)){
					sub_rank_attr[i] = true;
					sub_vis_attr[i] = true;
				}	
		}
		session.setAttribute("subrankattr", sub_rank_attr);
		session.setAttribute("subnameattr", sub_name_attr);
		session.setAttribute("subvisattr", sub_vis_attr);
		session.setAttribute("subrankableattr",sub_rankable_attr);
		session.setAttribute("subrankableindex", sub_rankable_index);
		session.setAttribute("subnameindex", sub_name_index);			
		session.setAttribute("subrankindex", sub_rank_index);			
		session.setAttribute("subvisindex", sub_vis_index);
		session.setAttribute("direction", direction);
		Double alpha = (Double)session.getAttribute("alpha");
		String[][] ranking_list = RankingAlgorithm.ranking(notitletable, sub_rank_index, notitletable.size(), direction, alpha);
		session.setAttribute("rankinglist", ranking_list);
		return "setting.jsp";
	}
}



