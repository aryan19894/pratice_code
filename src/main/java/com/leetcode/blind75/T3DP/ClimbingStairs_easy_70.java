package com.leetcode.blind75.T3DP;

import com.common.Out;

import java.util.Arrays;

public class ClimbingStairs_easy_70 {
    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return countStair(n, dp);
        }

        private int countStair(int i, int[] dp) {
            if (i == 0) return 1;
            if (i < 0) return 0;
            if (dp[i] != -1) return dp[i];

            return dp[i] = countStair(i - 1, dp) + countStair(i - 2, dp);
        }

        public int climbStairs2(int n) {
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2];
            return dp[n];
        }

        public int climbStairs3(int n) {
            int prev1 = 1, prev2 = 1;
            for (int i = 2; i <= n; i++) {
                int curr = prev1 + prev2;
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 34;
        Out.print(sol.climbStairs(n));
        Out.print(sol.climbStairs2(n));
        Out.print(sol.climbStairs3(n));
    }
}
