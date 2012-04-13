package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class ClickTableAction extends Action {

	public String getName() {
		return "clicktable.do";
	}
	public static DefaultSet getdefaultset(String id, int size){
		DefaultSet defaultset = new DefaultSet();
		try {
        	File file;
        	file = new File("defaultset.txt");
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	BufferedReader reader = new BufferedReader(new FileReader(file));
        	String line = null;
        	
            while ((line=reader.readLine()) != null) {
            	if(!line.startsWith(id))
            		continue;
            	ArrayList<Integer> sub_name_index = new ArrayList<Integer>();
            	boolean[] rankable = new boolean[size];
            	String[] pair;
            	String[] value;
            	String[] strs;
                pair = line.split(";");
                value = pair[1].split(",");
                strs = value[0].split(" ");            
                for(int i = 0;i<size; i++){
                	if(strs[i].equals("true"))
                		rankable[i] = true;
                	else
                		rankable[i] = false;
                }
                strs = value[1].split(" ");
                for(int i = 0;i<strs.length;i++){
                	sub_name_index.add(Integer.parseInt(strs[i]));
                }
                strs = value[2].split(" ");
                boolean[] direction = new boolean[size];
                for(int i = 0;i<size; i++){
                	if(strs[i].equals("true"))
                		direction[i] = true;
                	else
                		direction[i] = false;
                }
                
                defaultset.sub_rankable_attr = rankable;
                defaultset.sub_name_index = sub_name_index;
                defaultset.direction = direction;
            }
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defaultset;
	}
	public String perform(HttpServletRequest request) {
		String tableid = request.getParameter("tableid");
		HttpSession session = request.getSession();
		session.setAttribute("tableid", tableid);
		System.out.println(tableid);
		
		GoogleDataRequest google_data_request = (GoogleDataRequest) session
				.getAttribute("google_data_request");
		String describe_query = "Describe " + tableid;
		String display_query = "select * from " + tableid;
		FusionTablesAccessor accessor = new FusionTablesAccessor(request);
		ArrayList<String[]> table;
		try {
			table = accessor.invokeSql(display_query);
			if (table != null) {
				ArrayList<String> column_names = new ArrayList<String>();
				for(int i = 0; i<table.get(0).length;i++){
					column_names.add(table.get(0)[i]);
				}
				session.setAttribute("column_names", column_names);
				System.out.println(column_names.size());
				boolean[] sub_rankable_attr = new boolean[column_names.size()];
				boolean[] sub_rank_attr = new boolean[column_names.size()];
				boolean[] sub_name_attr = new boolean[column_names.size()];
				boolean[] sub_vis_attr = new boolean[column_names.size()];
				boolean[] sub_check_attr = new boolean[column_names.size()];
				ArrayList<Integer> sub_name_index = new ArrayList<Integer>();
				ArrayList<Integer> sub_rank_index = new ArrayList<Integer>();
				ArrayList<Integer> sub_rankable_index = new ArrayList<Integer>();
				ArrayList<Integer> sub_vis_index = new ArrayList<Integer>();
				ArrayList<Integer> sub_check_index = new ArrayList<Integer>();
				String objectname = "Name";
				boolean[] direction = new boolean[column_names.size()];//direction of each attribute
				for (int i = 0; i < column_names.size(); ++i) {//init all the boolean[]
					sub_name_attr[i] = false;
					sub_rank_attr[i] = false;
					sub_rankable_attr[i] = false;
					sub_vis_attr[i] = false;
					sub_check_attr[i] = false;
				}

				DefaultSet defaultset = getdefaultset(tableid, column_names.size());
				if(defaultset.direction!=null){
					sub_rankable_attr = defaultset.sub_rankable_attr;
					for(int i = 0; i<column_names.size(); i++){
						if(sub_rankable_attr[i])
							sub_rankable_index.add(i);
					}
					for(int i = 0; i<sub_rankable_index.size()&&i<2; i++){
						sub_rank_index.add(sub_rankable_index.get(i));
						sub_vis_index.add(sub_rankable_index.get(i));
						sub_check_index.add(sub_rankable_index.get(i));
					}
					for(int i = 0; i<column_names.size(); i++){
						if(sub_rank_index.contains(i)){
							sub_rank_attr[i] = true;
							sub_vis_attr[i] = true;
							sub_check_attr[i] = true;
						}
					}
					sub_name_index = defaultset.sub_name_index;
					for(int i = 0; i<sub_name_index.size();i++){
						sub_name_attr[sub_name_index.get(i)] = true;
					}
					direction = defaultset.direction;
				}
				else{
					for (int i = 0; i < column_names.size(); ++i) {
						sub_name_attr[i] = false;
						direction[i] = false;
						sub_rankable_attr[i] = false;
					}
				}
				
				session.setAttribute("subrankattr", sub_rank_attr);
				session.setAttribute("subnameattr", sub_name_attr);
				session.setAttribute("subvisattr", sub_vis_attr);
				session.setAttribute("subrankableattr",sub_rankable_attr);
				session.setAttribute("subcheckattr", sub_check_attr);
				session.setAttribute("subrankableindex", sub_rankable_index);
				session.setAttribute("subnameindex", sub_name_index);			
				session.setAttribute("subrankindex", sub_rank_index);			
				session.setAttribute("subvisindex", sub_vis_index);
				session.setAttribute("subcheckindex", sub_check_index);
				session.setAttribute("objectname", objectname);
				session.setAttribute("direction", direction);
				
				System.out.println("sub_rankable_attr");
				for(int i = 0; i<column_names.size(); i++){
					System.out.print(sub_rankable_attr[i]+" ");
				}
				
				System.out.println("sub_rank_attr");
				for(int i = 0; i<column_names.size(); i++){
					System.out.print(sub_rank_attr[i]+" ");
				}
				
				System.out.println("sub_name_attr");
				for(int i = 0; i<column_names.size(); i++){
					System.out.print(sub_name_attr[i]+" ");
				}
				
				System.out.println("sub_vis_attr");
				for(int i = 0; i<column_names.size(); i++){
					System.out.print(sub_vis_attr[i]+" ");
				}
				
				System.out.println("sub_rankable_index");
				for(int i = 0; i<sub_rankable_index.size(); i++){
					System.out.print(sub_rankable_index.get(i)+" ");
				}
				
				System.out.println("sub_rank_index");
				for(int i = 0; i<sub_rank_index.size(); i++){
					System.out.print(sub_rank_index.get(i)+" ");
				}
				
				System.out.println("sub_name_index");
				for(int i = 0; i<sub_name_index.size(); i++){
					System.out.print(sub_name_index.get(i)+" ");
				}
				
				System.out.println("sub_vis_index");
				for(int i = 0; i<sub_vis_index.size(); i++){
					System.out.print(sub_vis_index.get(i)+" ");
				}
				int objectid = 1;
				session.setAttribute("objectid", objectid);
				int tau = 50;
				session.setAttribute("tau",tau);
				session.setAttribute("table", table);
				ArrayList<String[]> notitletable = new ArrayList<String[]>();
				for (int x = 1; x < table.size(); ++x) {
					notitletable.add(table.get(x));
				}
				session.setAttribute("no_title_table", notitletable);
				Double alpha = 0.5;
				session.setAttribute("alpha", alpha);
				if(defaultset.direction!=null){
					String[][] ranking_list = RankingAlgorithm.ranking(notitletable, sub_rank_index, notitletable.size(), direction, alpha);
					session.setAttribute("rankinglist", ranking_list);
					return "homepage.jsp";
				}
				else{
					return "setting.jsp";
				}		
			}
			else{
				return "inputtable.jsp";
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "inputtableid.jsp";
		}
	}
}
