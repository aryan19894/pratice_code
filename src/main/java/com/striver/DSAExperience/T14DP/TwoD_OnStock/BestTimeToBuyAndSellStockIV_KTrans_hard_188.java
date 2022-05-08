package com.striver.DSAExperience.T14DP.TwoD_OnStock;

import com.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV_KTrans_hard_188 {
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            k *= 2;
            int[][] dp = new int[n + 1][k + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return calcProfit(prices, 0, k, dp);
        }

        private int calcProfit(int[] prices, int i, int k, int[][] dp) {
            if (i == prices.length || k == 0) return 0;
            if (dp[i][k] != -1) return dp[i][k];

            boolean buyFlag = k % 2 == 0;
            int profit = Integer.MIN_VALUE;
            if (buyFlag) {
                int buy = -1 * prices[i] + calcProfit(prices, i + 1, k - 1, dp);
                int notBuy = calcProfit(prices, i + 1, k, dp);
                profit = Math.max(notBuy, buy);
            } else {
                int sell = prices[i] + calcProfit(prices, i + 1, k - 1, dp);
                int notSell = calcProfit(prices, i + 1, k, dp);
                profit = Math.max(notSell, sell);
            }
            return dp[i][k] = profit;
        }

        public int maxProfit2(int k, int[] prices) {
            int n = prices.length;
            int cap = 2 * k;
            int[][] dp = new int[n + 1][cap + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int t = 1; t <= cap; t++) {
                    boolean buyFlag = t % 2 == 0;
                    int profit = Integer.MIN_VALUE;
                    if (buyFlag)
                        profit = Math.max(dp[i + 1][t], -1 * prices[i] + dp[i + 1][t - 1]);
                    else
                        profit = Math.max(dp[i + 1][t], prices[i] + dp[i + 1][t - 1]);
                    dp[i][t] = profit;
                }
            }
            return dp[0][cap];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        Out.print(sol.maxProfit(k, prices));
        Out.print(sol.maxProfit2(k, prices));
    }
}
