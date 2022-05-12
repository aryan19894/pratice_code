package pratice.striver.DSAExperience.T14DP.TwoD_OnStock;

import pratice.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII_2Times_hard_123 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int k = 2;
            int[][][] dp = new int[n + 1][2][k + 1];
            for (int[][] row : dp) {
                for (int[] r : row)
                    Arrays.fill(r, -1);
            }

            return calcProfit(prices, 0, 1, k, dp);
        }

        private int calcProfit(int[] prices, int i, int buyFlag, int k, int[][][] dp) {
            if (i == prices.length || k == 0) return 0;
            if (dp[i][buyFlag][k] != -1) return dp[i][buyFlag][k];


            int profit = Integer.MIN_VALUE;
            if (buyFlag == 1) {
                int notBuy = calcProfit(prices, i + 1, 1, k, dp);
                int buy = -1 * prices[i] + calcProfit(prices, i + 1, 0, k, dp);
                profit = Math.max(notBuy, buy);
            } else {
                int notSell = calcProfit(prices, i + 1, 0, k, dp);
                int sell = prices[i] + calcProfit(prices, i + 1, 1, k - 1, dp);
                profit = Math.max(notSell, sell);
            }
            return dp[i][buyFlag][k] = profit;
        }

        public int maxProfit2(int[] prices) {
            int n = prices.length;
            int cap = 2;
            int[][][] dp = new int[n + 1][2][cap + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy <= 1; buy++) {
                    for (int k = 1; k <= cap; k++) {
                        int profit = Integer.MIN_VALUE;
                        if (buy == 1)
                            profit = Math.max(dp[i + 1][1][k], -1 * prices[i] + dp[i + 1][0][k]);
                        else
                            profit = Math.max(dp[i + 1][0][k], prices[i] + dp[i + 1][1][k - 1]);
                        dp[i][buy][k] = profit;
                    }
                }
            }

            return dp[0][1][cap];
        }

        public int maxProfit3(int[] prices) {
            int n = prices.length;
            int cap = 2;
            int[][] ahead = new int[2][cap + 1];

            for (int i = n - 1; i >= 0; i--) {
                int[][] curr = new int[2][cap + 1];
                for (int buy = 0; buy <= 1; buy++) {
                    for (int k = 1; k <= cap; k++) {
                        int profit = Integer.MIN_VALUE;
                        if (buy == 1)
                            profit = Math.max(ahead[1][k], -1 * prices[i] + ahead[0][k]);
                        else
                            profit = Math.max(ahead[0][k], prices[i] + ahead[1][k - 1]);
                        curr[buy][k] = profit;
                    }
                }
                ahead = curr;
            }

            return ahead[1][cap];
        }

        public int maxProfit4(int[] prices) {
            int n = prices.length;
            int k = 2, t = 2 * k;
            int[][] dp = new int[n + 1][t + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return calcProfitTrans(prices, 0, t, dp);
        }

        private int calcProfitTrans(int[] prices, int i, int t, int[][] dp) {
            if (i == prices.length || t == 0) return 0;
            if(dp[i][t] != -1) return dp[i][t];

            boolean buyFlag = t % 2 == 0;
            int profit = Integer.MIN_VALUE;
            if (buyFlag) {
                int buy = -1 * prices[i] + calcProfitTrans(prices, i + 1, t - 1, dp);
                int notBuy = calcProfitTrans(prices, i + 1, t, dp);
                profit = Math.max(notBuy, buy);
            } else {
                int sell = prices[i] + calcProfitTrans(prices, i + 1, t - 1, dp);
                int notSell = calcProfitTrans(prices, i + 1, t, dp);
                profit = Math.max(notSell, sell);
            }
            return dp[i][t] = profit;
        }

        public int maxProfit5(int[] prices) {
            int n = prices.length;
            int k = 2, cap = 2 * k;
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

        public int maxProfit6(int[] prices) {
            int n = prices.length;
            int k = 2, cap = 2 * k;
            int[] ahead = new int[cap + 1];

            for (int i = n - 1; i >= 0; i--) {
                int[] curr = new int[cap + 1];
                for (int t = 1; t <= cap; t++) {
                    boolean buyFlag = t % 2 == 0;
                    int profit = Integer.MIN_VALUE;
                    if (buyFlag)
                        profit = Math.max(ahead[t], -1 * prices[i] + ahead[t - 1]);
                    else
                        profit = Math.max(ahead[t], prices[i] + ahead[t - 1]);
                    curr[t] = profit;
                }
                ahead = curr;
            }
            return ahead[cap];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {3, 2, 6, 5, 0, 3};
        Out.print(sol.maxProfit(prices));
        Out.print(sol.maxProfit2(prices));
        Out.print(sol.maxProfit3(prices));
        Out.print(sol.maxProfit4(prices));
        Out.print(sol.maxProfit5(prices));
        Out.print(sol.maxProfit6(prices));
    }
}
