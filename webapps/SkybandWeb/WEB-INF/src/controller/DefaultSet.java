package controller;

import java.util.ArrayList;

public class DefaultSet {
	ArrayList<Integer> sub_name_index;
	boolean[] sub_rankable_attr;
	boolean[] direction;
	
	public String toString(){
		String str = "";
		for(int i = 0; i<sub_rankable_attr.length; i++){
			if(sub_rankable_attr[i])
				str = str+"true ";
			else
				str = str+"false ";
		}
		str = str+",";
		for(Integer i:sub_name_index){
			str = str +i.toString()+" ";
		}
		str = str+",";
		for(int i = 0; i<direction.length; i++){
			if(direction[i])
				str = str+"true ";
			else
				str = str+"false ";
		}
		return str;
	}

}
