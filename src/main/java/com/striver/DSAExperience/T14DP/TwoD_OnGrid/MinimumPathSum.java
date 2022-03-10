package com.striver.DSAExperience.T14DP.TwoD_OnGrid;

import com.common.Out;

import java.util.Arrays;

public class MinimumPathSum {
    // [Better DP: Memo] TC: O(M*N):  At max, there will be M*N calls of recursion.
    // SC: O((N-1)+(M-1)) + O(M*N): using a recursion stack space:O((N-1)+(M-1)),
    // here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return calcMinSum(grid, n - 1, m - 1, dp);
    }

    private static int calcMinSum(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + calcMinSum(grid, i - 1, j, dp);
        int left = grid[i][j] + calcMinSum(grid, i, j - 1, dp);
        return dp[i][j] = Math.min(up, left);
    }

    // [Better DP: Tab] TC: O(M*N): two nested loops
    // SC: O(M*N): using an external DP Array of size ‘M*N’.
    public static int minSumPath2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }

                int up = (int) Math.pow(10, 9), left = (int) Math.pow(10, 9);
                ;
                if (i > 0)
                    up = grid[i][j] + dp[i - 1][j];
                if (j > 0)
                    left = grid[i][j] + dp[i][j - 1];
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[n - 1][m - 1];
    }

    // [Better DP: Tab] TC: O(M*N): two nested loops
    // SC: O(N): using an external array of size ‘N’ to store only one row.
    public static int minSumPath3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prev[] = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                    continue;
                }

                int up = (int) Math.pow(10, 9), left = (int) Math.pow(10, 9);
                if (i > 0)
                    up = grid[i][j] + prev[j];
                if (j > 0)
                    left = grid[i][j] + curr[j - 1];
                curr[j] = Math.min(up, left);
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 9, 6},
                {11, 5, 2}};
        Out.print(minSumPath(grid));
        Out.print(minSumPath2(grid));
        Out.print(minSumPath3(grid));
    }
}
