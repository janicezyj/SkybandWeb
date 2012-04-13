package controller;

import java.util.ArrayList;

public class Combination {
	public static void main(String[] args)  
    {  
        ArrayList<Integer> testData = new ArrayList<Integer>();  
        for(int i = 0; i<10; ++i){
        	testData.add(i);
        }
        ArrayList<ArrayList<Integer>> results = getAllCombinations(testData);  
        for(int i=0; i<results.size(); i++)  
            System.out.println(results.get(i));  
    }  
  
    public static ArrayList<ArrayList<Integer>> getAllCombinations(ArrayList<Integer> data)  
    {  
        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();  
        for(int i=1; i<=data.size(); i++)  
        {  
            ArrayList<Integer> initialCombination = new ArrayList<Integer>();  
            allCombinations.addAll(getAllCombinations(data, i));  
        }    
        return allCombinations;  
    }  
  
    public static ArrayList<ArrayList<Integer>> getAllCombinations(ArrayList<Integer> data, int length)  
    {  
        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> initialCombination = new ArrayList<Integer>();  
        combination(allCombinations, data, initialCombination, length);  
        return allCombinations;  
    }  
  
    private static void combination(ArrayList<ArrayList<Integer>> allCombinations, ArrayList<Integer> data,   
        ArrayList<Integer> initialCombination, int length)  
    {  
        if(length == 1)  
        {  
            for(int i=0; i<data.size(); i++)  
            {  
                ArrayList<Integer> newCombination = new ArrayList<Integer>(initialCombination);  
                newCombination.add(data.get(i));  
                allCombinations.add(newCombination);  
            }  
        }  
  
        if(length > 1)  
        {  
            for(int i=0; i<data.size(); i++)  
            {  
                ArrayList<Integer> newCombination = new ArrayList<Integer>(initialCombination);  
                newCombination.add(data.get(i));  
  
                ArrayList<Integer> newData = new ArrayList<Integer>(data);  
                for(int j=0; j<=i; j++)  
                    newData.remove(data.get(j));  
                combination(allCombinations, newData, newCombination, length - 1);  
            }  
        }  
    }  

}
