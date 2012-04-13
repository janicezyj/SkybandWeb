package controller;
class Pair implements Comparable<Pair> {
	int first;
	int second;

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.first - o.first;/*
									 * if (this.first != o.first)
									 * 
									 * return this.second - o.second;
									 */
	}
	
	public String toString(){
		return "(" + first + "," + second + ")";
	}
}