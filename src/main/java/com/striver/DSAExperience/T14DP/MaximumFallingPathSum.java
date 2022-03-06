package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class MaximumFallingPathSum {
    // [Better DP: Memo] TC: O(N*M):  At max, there will be (half of, due to triangle) N*M calls of recursion.
    // SC: O(N) + O(N*M): using a recursion stack space: O((N),
    // where N is the path length and an external DP Array of size ‘N*M’.
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++)
            max = Math.max(max, findMinPathSum(matrix, n - 1, j, m, dp));

        return max;
    }

    private static int findMinPathSum(int[][] matrix, int i, int j, int m, int[][] dp) {
        if (j < 0 || j >= m) return (int) -1e9;
        if (i == 0) return matrix[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + findMinPathSum(matrix, i - 1, j, m, dp);
        int rightDiagonal = matrix[i][j] + findMinPathSum(matrix, i - 1, j - 1, m, dp);
        int leftDiagonal = matrix[i][j] + findMinPathSum(matrix, i - 1, j + 1, m, dp);

        return dp[i][j] = max(up, leftDiagonal, rightDiagonal);
    }

    private static int max(int... ele) {
        int max = Integer.MIN_VALUE;
        for (int e : ele)
            max = Math.max(max, e);
        return max;
    }

    // [Better DP: Tab] TC: O(N*M): two nested loops
    // SC: O(N*M): using an external DP Array of size ‘N*M’.
    public static int getMaxPathSum2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    dp[i][j] = matrix[i][j];
                else if (i > 0) {
                    int up = matrix[i][j] + dp[i - 1][j];

                    int rightDiagonal = (int) -1e9;
                    if (j - 1 >= 0)
                        rightDiagonal = matrix[i][j] + dp[i - 1][j - 1];

                    int leftDiagonal = (int) -1e9;
                    if (j + 1 < m)
                        leftDiagonal = matrix[i][j] + dp[i - 1][j + 1];

                    dp[i][j] = max(up, leftDiagonal, rightDiagonal);
                }
                if (i == n - 1)
                    max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // [Better DP: Tab] TC: O(N*M): two nested loops
    // SC: O(M): using an external array of size ‘M’ to store only one row.
    public static int getMaxPathSum3(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int prev[] = new int[m];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curr[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    curr[j] = matrix[i][j];
                else if (i > 0) {
                    int up = matrix[i][j] + prev[j];

                    int rightDiagonal = (int) -1e9;
                    if (j - 1 >= 0)
                        rightDiagonal = matrix[i][j] + prev[j - 1];

                    int leftDiagonal = (int) -1e9;
                    if (j + 1 < m)
                        leftDiagonal = matrix[i][j] + prev[j + 1];

                    curr[j] = max(up, leftDiagonal, rightDiagonal);
                }
                if (i == n - 1)
                    max = Math.max(max, curr[j]);
            }
            prev = curr;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 10, 4},
//                {100, 3, 2, 1},
//                {1, 1, 20, 2},
//                {1, 2, 2, 1}};

        int[][] matrix = {{-10000}};
        Out.print(getMaxPathSum(matrix));
        Out.print(getMaxPathSum2(matrix));
        Out.print(getMaxPathSum3(matrix));
    }
}
