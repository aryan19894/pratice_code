package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class CountWaysToReachTheNthStairs {
    // [Better DP: Memo] TC: O(N): running a simple iterative loop
    // SC: O(N) + O(N) using an external array of size ‘n+1’ and recursive stack space.
    public static int countDistinctWayToClimbStair(long nStairs) {
        int n = (int) nStairs;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }

    private static int count(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        return dp[n] = count(n - 1, dp) + count(n - 2, dp);
    }

    // [Better DP: Tab] TC: O(N), O(N): running a simple iterative loop
    // using an external array of size ‘n+1’.
    public static int countDistinctWayToClimbStair2(long nStairs) {
        int n = (int) nStairs;
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return (int)dp[n];
    }

    // [Better DP: Tab] TC: O(N), O(1): running a simple iterative loop
    public static int countDistinctWayToClimbStair3(long nStairs) {
        int n = (int) nStairs;
        long prev1 = 1, prev2 =1;
        for (int i = 2; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return (int)prev1;
    }

    public static void main(String[] args) {
        long nStairs = 64;
//        Out.print(countDistinctWayToClimbStair(nStairs));
//        Out.print(countDistinctWayToClimbStair2(nStairs));
        Out.print(countDistinctWayToClimbStair3(nStairs));
    }
}
