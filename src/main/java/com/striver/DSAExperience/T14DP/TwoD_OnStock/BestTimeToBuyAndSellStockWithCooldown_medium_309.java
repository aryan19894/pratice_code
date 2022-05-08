package com.striver.DSAExperience.T14DP.TwoD_OnStock;

import com.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown_medium_309 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return calcProfit(prices, 0, 1, dp);
        }

        private int calcProfit(int[] prices, int i, int buyFlag, int[][] dp) {
            if (i >= prices.length) return 0;
            if (dp[i][buyFlag] != -1) return dp[i][buyFlag];

            int profit = 0;
            if (buyFlag == 1) {
                int buy = -1 * prices[i] + calcProfit(prices, i + 1, 0, dp);
                int notBuy = calcProfit(prices, i + 1, 1, dp);
                profit = Math.max(buy, notBuy);
            } else {
                int sell = prices[i] + calcProfit(prices, i + 2, 1, dp);
                int notSell = calcProfit(prices, i + 1, 0, dp);
                profit = Math.max(sell, notSell);
            }
            return dp[i][buyFlag] = profit;
        }

        public int maxProfit2(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 2][2];

            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy <= 1; buy++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-1 * prices[i] + dp[i + 1][0], dp[i + 1][1]);
                    else
                        profit = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                    dp[i][buy] = profit;
                }
            }

            return dp[0][1];
        }

        public int maxProfit3(int[] prices) {
            int n = prices.length;
            int[] front1 = new int[2];
            int[] front2 = new int[2];
            for (int i = n - 1; i >= 0; i--) {
                int[] curr = new int[2];
                for (int buy = 0; buy <= 1; buy++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-1 * prices[i] + front1[0], front1[1]);
                    else
                        profit = Math.max(prices[i] + front2[1], front1[0]);
                    curr[buy] = profit;
                }
                front2 = front1;
                front1 = curr;
            }

            return front1[1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        Out.print(sol.maxProfit(prices));
        Out.print(sol.maxProfit2(prices));
        Out.print(sol.maxProfit3(prices));
    }
}
