package com.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import com.common.Out;

import java.util.Arrays;

public class RodCuttingProblem {
    // [Better DP: Memo] TC: O(N*N): N*N states therefore at max ‘N*N’ new problems will be solved.
    // SC: O(N) + O(N*N): using a recursion stack space(O(N)) and a 2D array (O(N*N)).
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return calcMaxWeight(n - 1, price, n, dp);
    }

    private static int calcMaxWeight(int i, int[] price, int target, int[][] dp) {
        if (i == 0)
            return price[0] * target;

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = calcMaxWeight(i - 1, price, target, dp);
        int take = Integer.MIN_VALUE;
        int rodLen = i + 1; //1-based indexing
        if (rodLen <= target)
            take = price[i] + calcMaxWeight(i, price, target - rodLen, dp);

        return dp[i][target] = Math.max(notTake, take);
    }

    // [Better DP: Tab] TC: O(N*N): two nested loops
    // SC: O(N*N): using an external DP Array of size ‘N*N’.
    public static int cutRod2(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int len = 0; len <= n; len++) {
                int notTake = dp[i - 1][len];
                int take = Integer.MIN_VALUE;
                int rodLen = i + 1; //1-based indexing
                if (rodLen <= len)
                    take = price[i] + dp[i][len - rodLen];

                dp[i][len] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][n];
    }

    // [Better DP: Tab] TC: O(N*N): two nested loops
    // SC: O(N): using an external array of size ‘N+1’ to store only one row.
    public static int cutRod3(int price[], int n) {
        int[] prev = new int[n+1];

        for (int i = 0; i <= n; i++)
            prev[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n+1];
            for (int len = 0; len <= n; len++) {
                int notTake = prev[len];
                int take = Integer.MIN_VALUE;
                int rodLen = i + 1; //1-based indexing
                if (rodLen <= len)
                    take = price[i] + curr[len - rodLen];

                curr[len] = Math.max(notTake, take);
            }
            prev = curr;
        }
        return prev[n];
    }

    // [Better DP: Tab: 1D More Opt] TC: O(N*N): two nested loops
    // SC: O(N): using an external array of size ‘N+1’ to store only one row.
    public static int cutRod4(int price[], int n) {
        int[] prev = new int[n+1];

        for (int i = 0; i <= n; i++)
            prev[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int len = 0; len <= n; len++) {
                int notTake = prev[len];
                int take = Integer.MIN_VALUE;
                int rodLen = i + 1; //1-based indexing
                if (rodLen <= len)
                    take = price[i] + prev[len - rodLen];

                prev[len] = Math.max(notTake, take);
            }
        }
        return prev[n];
    }

    public static void main(String[] args) {
        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = 0;
        Out.print(cutRod(price, price.length));
        Out.print(cutRod2(price, price.length));
        Out.print(cutRod3(price, price.length));
        Out.print(cutRod4(price, price.length));
    }
}
