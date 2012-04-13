package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RankingAlgorithm {

	public static String[][] ranking(ArrayList<String[]> stats, ArrayList<Integer> sub_index, int tau, boolean direction[], double alpha){
        System.out.println("ranking algorithm start here");
		ArrayList<ArrayList<Integer>> allcombination = Combination
		.getAllCombinations(sub_index);
		SkybandAlgorithm sa = new SkybandAlgorithm();
		ArrayList<double[]> scorelist= new ArrayList<double[]>();
		for(int i = 0; i<allcombination.size(); ++i){//compute every combination's score
			String[][][] temp = sa.bruteforce_toptau(stats, allcombination.get(i), direction, stats.size());
			int cnt = 0;
			double[] sc = new double[stats.size()];//by skyband order
			double[] sc1 = new double[stats.size()];//by original order
			for(int j = 0; j<temp.length; ++j){	
				double sum = 0.0;
				double score = 0.0;
				for(int k = 0; k<temp[j].length; ++k){
					sum =sum+ Math.pow(alpha, cnt+k);				
				}
				score = sum/temp[j].length;
				for(int k = 0; k<temp[j].length; ++k){
					sc[cnt+k] = score;
				}
				cnt = cnt+ temp[j].length;	
			}
			int count = 0;
			for(int j = 0; j<temp.length; ++j){
				for(int k = 0; k<temp[j].length; ++k){
					sc1[Integer.parseInt(temp[j][k][temp[0][0].length-1])] = sc[count+k];
				}
				count = count+temp[j].length;
			}
			scorelist.add(sc1);
		}
		double[] score = new double[stats.size()];//overall score

		for(int j = 0; j<scorelist.get(0).length; ++j){
			double sum = 0.0;
			for(int i = 0; i<scorelist.size(); ++i){//compute overall score
					sum =sum+ scorelist.get(i)[j];
			}
			score[j] = sum;
			//System.out.println(score[j]);
		}

		Pair2[] pairlist = new Pair2[stats.size()];//pair for ranking using compareto 
        for(int i = 0; i<score.length; ++i){
    		Pair2 pair = new Pair2();
        	pair.first = score[i];//overall score
        	pair.second = i;//index
        	pairlist[i] = pair;
        	//System.out.println("pair.first  "+pair.first+"  pair.second  "+pair.second);
        }
        Arrays.sort(pairlist, Collections.reverseOrder());
        String[][] result = new String[stats.size()][stats.get(0).length+2];
        for(int i = 0; i<pairlist.length; ++i){
        	for(int j = 0; j<stats.get(0).length; ++j){
            	result[i][j] = stats.get(pairlist[i].second)[j];
        	}
        	result[i][stats.get(0).length] = ((Double)(pairlist[i].first)).toString();//score
        	result[i][stats.get(0).length+1] = ((Integer)(pairlist[i].second)).toString();//index
        }
        //System.out.println("ranking algorithm stop here");
        return result;
	}
}
