package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class CountWaysToReachTheNthStairs {
    public static int countDistinctWayToClimbStair(long nStairs) {
        int n = (int) nStairs;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(nStairs, dp);
    }

    private static int count(long n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[(int) n] != -1) return dp[(int) n];

        return dp[(int) n] = count(n - 1, dp) + count(n - 2, dp);
    }

    public static void main(String[] args) {
        long nStairs = 4;

        Out.print(countDistinctWayToClimbStair(nStairs));
    }
}
