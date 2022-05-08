package com.leetcode.blind75.T3DP;

import com.common.Out;

import java.util.Arrays;

public class UniquePaths_medium_62 {
    static class Solution {
        private static final int MOD = (int) (1e9 + 7);

        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (int[] r : dp)
                Arrays.fill(r, -1);

            return countPath(m - 1, n - 1, dp);
        }

        private int countPath(int i, int j, int[][] dp) {
            if (i < 0 || j < 0) return 0;
            if (i == 0 && j == 0) return 1;
            if (dp[i][j] != -1) return dp[i][j];

            return dp[i][j] = countPath(i - 1, j, dp) + countPath(i, j - 1, dp);
        }

        public int uniquePaths2(int m, int n) {
            int N = m + n - 2;
            int r = m - 1;

            double ans = 1;
            for (int i = 1; i <= r; i++)
                ans = ans * (N - r + i) / i;
            return (int) Math.round(ans);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int m = 53;
        int n = 4;
        Out.print(sol.uniquePaths(m, n));
        Out.print(sol.uniquePaths2(m, n));
    }
}
