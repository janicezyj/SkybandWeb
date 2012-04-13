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


public class SubmitDefaultSettingAction extends Action {

	public String getName() {
		return "submitdefaultset.do";
	}
	public static void setdefaultset(String id, String name, ArrayList<Integer> index, boolean[] direction){
		DefaultSet defaultset = new DefaultSet();
		defaultset.name = name;
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
		boolean[] sub_naming_attr = (boolean[]) session.getAttribute("subnamingattr");
	
		for(int i = 0; i<column_names.size(); i++){
			String str = column_names.get(i);
			if(request.getParameter("name"+str)!= null){
				sub_naming_attr[i] = true;
				//sub_name_index.add(i);
			}		
			else
				sub_naming_attr[i] = false;
		}
		session.setAttribute("subnamingattr", sub_naming_attr);
		
		for(int j = 0; j<sub_naming_attr.length; ++j){
				System.out.print(column_names.get(j)+"  "+ sub_naming_attr[j]+"  ");
		}
		System.out.println("");
		
		String objectname = request.getParameter("name");
		session.setAttribute("objectname", objectname);
		
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
		session.setAttribute("subnameindex", sub_name_index);
		
		
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
		session.setAttribute("direction",direction);
		String tableid = (String)session.getAttribute("tableid");
		setdefaultset(tableid, objectname, sub_name_index, direction);
		return "setting.jsp";
	}
}




