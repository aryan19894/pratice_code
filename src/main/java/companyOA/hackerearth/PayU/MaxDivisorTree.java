package companyOA.hackerearth.PayU;

import java.util.Arrays;

public class MaxDivisorTree {

	static int[] dp = new int[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.fill(dp, -1);
		int n = 96;
		
		int max = 0;
		for(int i = 2 ; i <= n / 2 ; i++) {
			if(n % i == 0) {
				int h = getHeight(n / i);
				max = Math.max(h, max);
			}
		}
		System.out.println(max);

	}
	private static int getHeight(int n) {
		// TODO Auto-generated method stub
		if(dp[n] != -1) {
			return dp[n];
		}
		int max = 0;
		for(int i = 2 ; i <= n / 2 ; i++) {
			if(n % i == 0) {
				int h = getHeight(n / i);
				max = Math.max(h, max);
			}
		}
		
		return dp[n] = max + 1;
	}

}
