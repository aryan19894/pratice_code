package com.striver.DSAExperience.T1Array;

import java.util.Arrays;

public class UniquePaths_Medium_62 {
    static class Solution {
        // [Brute] O(2n) Expotential - use recursion call to each and every possible combination
        public int uniquePaths1(int m, int n) {
            return countPaths(m - 1, n - 1, 0, 0);
        }

        private int countPaths(int m, int n, int i, int j) {
            if (i < 0 || j < 0 || i > m || j > n)
                return 0;
            else if (i == m && j == n)
                return 1;
            return countPaths(m, n, i + 1, j) + countPaths(m, n, i, j + 1);
        }

        // [Better] TC, SC: O(m*n) - use dp array on recursion
        public int uniquePaths2(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++)
                Arrays.fill(dp[i], -1);
            return countPathsDP(dp, m - 1, n - 1, 0, 0);
        }

        private int countPathsDP(int[][] dp, int m, int n, int i, int j) {
            if (i < 0 || j < 0 || i > m || j > n)
                return 0;
            else if (i == m && j == n)
                return 1;

            if (dp[i][j] != -1)
                return dp[i][j];

            return dp[i][j] = countPathsDP(dp, m, n, i + 1, j) + countPathsDP(dp, m, n, i, j + 1);
        }

        // [Optimal] TC: O(m) or O(n) - use combination rule nCr
        public int uniquePaths3(int m, int n) {
            int N = m + n - 2;
            int R = m - 1;
            double ans = 1;

            for (int i = 1; i <= R; i++)
                ans = ans * (N - R + i) / i;

            return (int) ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.uniquePaths1(3, 7));
//        System.out.println(sol.uniquePaths2(3, 7));
        System.out.println(sol.uniquePaths3(3, 2));
    }
}

// @lc code=end

