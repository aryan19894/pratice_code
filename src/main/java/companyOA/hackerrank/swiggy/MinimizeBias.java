package companyOA.hackerrank.swiggy;

import java.util.Collections;
import java.util.List;

public class MinimizeBias {
	public static int minimizeBias(List<Integer> ratings) {
        // Write your code here
        int N = ratings.size();
        Collections.sort(ratings);
        int minBias = 0;
        for(int i=0;i<N-1;i=i+2) {
            minBias =minBias+ (ratings.get(i) - ratings.get(i+1));
        }
        return Math.abs(minBias);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
