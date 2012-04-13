package controller;

	class Pair2 implements Comparable<Pair2> {
		double first;
		int second;

		@Override
		public int compareTo(Pair2 o) {
			// TODO Auto-generated method stub
			int ans = 0;
			if(this.first -o.first>0)
				ans = 1;
			else if(this.first - o.first == 0 )
				ans = 0;
			else
				ans = -1;
			return ans;/*
										 * if (this.first != o.first)
										 * 
										 * return this.second - o.second;
										 */
		}
		
		public String toString(){
			return "(" + first + "," + second + ")";
		}
	}

