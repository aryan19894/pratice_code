package com.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import com.common.Out;

import java.util.Arrays;

public class ZeroOneKnapsack {
    // [Better DP: Memo] TC: O(N*W): N*W states therefore at max ‘N*W’ new problems will be solved.
    // SC: O(N) + O(N*W): using a recursion stack space(O(N)) and a 2D array (O(N*W)).
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return calcMaxWeight(weight, value, n - 1, maxWeight, dp);
    }

    private static int calcMaxWeight(int[] weight, int[] value, int i, int W, int[][] dp) {
        if (i == 0) {
            if (weight[i] <= W) return value[i];
            return 0;
        }
        if (dp[i][W] != -1) return dp[i][W];

        int notTake = calcMaxWeight(weight, value, i - 1, W, dp);
        int take = Integer.MIN_VALUE;
        if (weight[i] <= W)
            take = value[i] + calcMaxWeight(weight, value, i - 1, W - weight[i], dp);

        return dp[i][W] = Math.max(take, notTake);
    }

    // [Better DP: Tab] TC: O(N*W): two nested loops
    // SC: O(N*W): using an external DP Array of size ‘N*W’.
    static int knapsack2(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for (int W = weight[0]; W <= maxWeight; W++)
            dp[0][W] = value[0];

        for (int i = 1; i < n; i++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = dp[i - 1][W];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= W)
                    take = value[i] + dp[i - 1][W - weight[i]];

                dp[i][W] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][maxWeight];
    }

    // [Better DP: Tab] TC: O(N*W): two nested loops
    // SC: O(W): using an external array of size ‘W+1’ to store only one row.
    static int knapsack3(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for (int W = weight[0]; W <= maxWeight; W++)
            prev[W] = value[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[maxWeight+1];
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= W)
                    take = value[i] + prev[W - weight[i]];

                curr[W] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }

    // [Better DP: Tab: 1D More Opt] TC: O(N*W): two nested loops
    // SC: O(W): using an external array of size ‘W+1’ to store only one row.
    static int knapsack4(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for (int W = weight[0]; W <= maxWeight; W++)
            prev[W] = value[0];

        for (int i = 1; i < n; i++) {
            for (int W = maxWeight; W >= 0; W--) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= W)
                    take = value[i] + prev[W - weight[i]];

                prev[W] = Math.max(take, notTake);
            }
        }

        return prev[maxWeight];
    }

    public static void main(String[] args) {
//        int[] weight = {1, 2, 4, 5};
//        int[] value = {5, 4, 8, 6};
        int[] weight = {6};
        int[] value = {1};
        int n = 78;
        int maxWeight = 5;
        Out.print(knapsack(weight, value, value.length, maxWeight));
        Out.print(knapsack2(weight, value, value.length, maxWeight));
        Out.print(knapsack3(weight, value, value.length, maxWeight));
        Out.print(knapsack4(weight, value, value.length, maxWeight));
    }
}
