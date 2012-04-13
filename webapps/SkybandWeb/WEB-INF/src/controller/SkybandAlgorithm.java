package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SkybandAlgorithm {
	// final int N = 3861;
	// final int D = 17;


	boolean dom(String[] stats, String[] stats2, boolean direction[],boolean f[]) {
		boolean ff = false;
		for (int i = 0; i < stats.length; ++i) {
			if (!f[i])
				continue;
			if(!direction[i]){
				if (Integer.valueOf(stats[i]) < Integer.valueOf(stats2[i]))
					return false;
				if (Integer.valueOf(stats[i]) > Integer.valueOf(stats2[i]))
					ff = true;
			}else{
				if (Integer.valueOf(stats[i]) < Integer.valueOf(stats2[i]))
					ff =  true;
				if (Integer.valueOf(stats[i]) > Integer.valueOf(stats2[i]))
					return false;
			}
		}
		return ff;
	}

	String[][][] bruteforce_toptau_onlyone(ArrayList<String[]> stats,
			ArrayList<Integer> sub_index, boolean direction[],int tau, double interval) {
		boolean[] sub = new boolean[stats.get(0).length];
		for(int i = 0; i<stats.get(0).length; ++i){
			sub[i] = false;
		}
		for(int i = 0; i<sub_index.size(); ++i){
			sub[sub_index.get(i)] = true;
		}
		int idx = 0;
		int N = stats.size();
		for (int i = 0; i < sub.length; ++i)
			if (sub[i] == true) {
				idx = i;
				break;
			}

		System.out.println("idx = " + idx);
		// System.out.println("N: " + N + " , tau: " + tau);
		Pair count[] = new Pair[N]; // .first = attribute value; .second = obj.
									// ID
		for (int i = 0; i < N; ++i) {
			count[i] = new Pair();
			count[i].first = Integer.parseInt(stats.get(i)[idx]);
			count[i].second = i;
		}
		if(direction[idx]){
			Arrays.sort(count);
		}else{
			Arrays.sort(count, Collections.reverseOrder());
		}
		ArrayList<ArrayList<Pair>> ans = new ArrayList<ArrayList<Pair>>();

		ArrayList<Pair> sameBand = new ArrayList<Pair>();
		// ans.clear();
		if(direction[idx]){
			double interval_max = count[0].first+interval;
			for (int i = 0; i < tau; ++i) {

				if (count[i].first > interval_max) {
					ans.add(sameBand);
					sameBand = new ArrayList<Pair>();
					interval_max += interval;
				}

				if (count[i].first <= interval_max)
					sameBand.add(count[i]);
			}
		}else{
			double interval_min = count[0].first - interval;
			for (int i = 0; i < tau; ++i) {

				if (count[i].first < interval_min) {
					ans.add(sameBand);
					sameBand = new ArrayList<Pair>();
					interval_min -= interval;
				}

				if (count[i].first >= interval_min)
					sameBand.add(count[i]);
			}
		}
		ans.add(sameBand);
		String[][][] Data = new String[ans.size()][][];
		ArrayList<Integer> sub_attr_index = new ArrayList<Integer>();

		for (int i = 0; i < sub.length; ++i) {
			if (!sub[i])
				continue;
			else
				sub_attr_index.add(i);
		}
		int sum = 0;
		for (int j = 0; j < ans.size(); ++j) {
			String[][] band = new String[ans.get(j).size()][3 + sub_attr_index
					.size()];
			for (int k = 0; k < ans.get(j).size(); ++k) {
				for (int m = 0; m < sub_attr_index.size(); ++m) {
					band[k][m] = new String(
							stats.get(ans.get(j).get(k).second)[sub_attr_index
									.get(m)]);
				}
				band[k][sub_attr_index.size()] = new String("" + j);// tier number
				//band[k][1] = new String(stats.get(ans.get(j).get(k).second)[0]);// first
																				// name
				//band[k][2] = new String(stats.get(ans.get(j).get(k).second)[1]);// last
																				// name
				band[k][sub_attr_index.size()+1] = ((Integer) (sum+k)).toString();//numbers of dominants
				band[k][sub_attr_index.size()+2] = ((Integer) ans.get(j).get(k).second).toString();// index

			}
			Data[j] = band;
			sum = sum+ans.get(j).size();
		}
		return Data;
	}

	String[][][] bruteforce_toptau(ArrayList<String[]> stats, ArrayList<Integer> sub_index, boolean direction[],
			int tau)
	// sub[]: client chosen attributes' index: 0 or 1
	{
		boolean[] sub = new boolean[stats.get(0).length];
		for(int i = 0; i<stats.get(0).length; ++i){
			sub[i] = false;
		}
		for(int i = 0; i<sub_index.size(); ++i){
			sub[sub_index.get(i)] = true;
		}
		int N = stats.size();
		// System.out.println("N: " + N + " , tau: " + tau);
		Pair count[] = new Pair[N]; // .first = dom. counts; .second = obj. ID
		for (int i = 0; i < N; ++i) {
			count[i] = new Pair();
			count[i].first = 0;
			count[i].second = i;
		}
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (dom(stats.get(i), stats.get(j),direction, sub))
					++count[j].first;

		Arrays.sort(count);
		ArrayList<ArrayList<Pair>> ans = new ArrayList<ArrayList<Pair>>();
		int curDom = count[0].first;
		ArrayList<Pair> sameBand = new ArrayList<Pair>();
		// ans.clear();

		for (int i = 0; i < tau; ++i) {
			if (tau != N && count[i].first == count[tau].first) {
				System.out.println("Go out here, i=" + i);
				System.out.println("N: " + count[i].first);
			}

			if (count[i].first != curDom) {
				ans.add(sameBand);
				sameBand = new ArrayList<Pair>();
				curDom = count[i].first;
			}
			sameBand.add(count[i]);
		}
		ans.add(sameBand);
		// return ans;
		String[][][] Data = new String[ans.size()][][];
		ArrayList<Integer> sub_attr_index = new ArrayList<Integer>();
		for (int i = 0; i < sub.length; ++i) {
			if (!sub[i])
				continue;
			else
				sub_attr_index.add(i);
		}
		for (int j = 0; j < ans.size(); ++j) {
			String[][] band = new String[ans.get(j).size()][3 + sub_attr_index
					.size()];
			for (int k = 0; k < ans.get(j).size(); ++k) {
				for (int m = 0; m < sub_attr_index.size(); ++m) {
					band[k][m] = new String(
							stats.get(ans.get(j).get(k).second)[sub_attr_index
									.get(m)]);
				}
				band[k][sub_attr_index.size()] = new String("" + j);// tier number
				//band[k][1] = new String(stats.get(ans.get(j).get(k).second)[0]);// first
																				// name
				//band[k][2] = new String(stats.get(ans.get(j).get(k).second)[1]);// last
																				// name
				band[k][sub_attr_index.size()+1] = ((Integer) ans.get(j).get(k).first).toString();//number of dominants
				band[k][sub_attr_index.size()+2] = ((Integer) ans.get(j).get(k).second).toString();// index

			}
			Data[j] = band;
		}
		return Data;
	}

}
