package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class TotalUniquePaths {
    // [Better DP: Memo] TC: O(M*N):  At max, there will be M*N calls of recursion.
    // SC: O((N-1)+(M-1)) + O(M*N): using a recursion stack space:O((N-1)+(M-1)),
    // here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return countPath(m - 1, n - 1, dp);
    }

    private static int countPath(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return dp[m][n] = 1;
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = countPath(m - 1, n, dp) + countPath(m, n - 1, dp);
    }

    // [Better DP: Tab] TC: O(M*N):  two nested loops
    // SC: O(M*N): using an external DP Array of size ‘M*N’.
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //base case
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    // [Better DP: Tab] TC: O(M*N): two nested loops
    // SC: O(N): using an external array of size ‘N’ to store only one row.
    public static int uniquePaths3(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                //base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }

    // [Optimal : Combination] TC: O(M) or O(N):  m+n-2Cn-1 combination formula
    // SC: O(1)
    public static int uniquePaths4(int m, int n) {
        int N = m + n + -2;
        int R = m - 1;
        double ans = 1;
        for (int i = 1; i <= R; i++)
            ans = ans * (N - R + i) / i;

        return (int) ans;
    }

    public static void main(String[] args) {
        Out.print(uniquePaths(13, 16));
        Out.print(uniquePaths2(13, 16));
        Out.print(uniquePaths3(13, 16));
        Out.print(uniquePaths4(13, 16));
    }
}
