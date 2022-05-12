package pratice.striver.DSAExperience.T14DP.TwoD_OnStock;

import pratice.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII_ManyTimes_medium_122 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            return calProfit(prices, 0, 1, dp);
        }

        private int calProfit(int[] prices, int i, int buyFlag, int[][] dp) {
            if (i == prices.length) return 0;
            if (dp[i][buyFlag] != -1) return dp[i][buyFlag];

            int profit = Integer.MIN_VALUE;
            if (buyFlag == 1) {
                int notBuy = calProfit(prices, i + 1, 1, dp);
                int buy = -1 * prices[i] + calProfit(prices, i + 1, 0, dp);
                profit = Math.max(notBuy, buy);
            } else {
                int notSell = calProfit(prices, i + 1, 0, dp);
                int sell = prices[i] + calProfit(prices, i + 1, 1, dp);
                profit = Math.max(notSell, sell);
            }
            return dp[i][buyFlag] = profit;
        }

        public int maxProfit2(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy <= 1; buy++) {
                    int next0 = dp[i + 1][0];
                    int next1 = dp[i + 1][1];
                    int profit = Integer.MIN_VALUE;

                    if (buy == 1)
                        profit = Math.max(next1, -1 * prices[i] + next0);
                    else
                        profit = Math.max(next0, prices[i] + next1);

                    dp[i][buy] = profit;
                }
            }
            return dp[0][1];
        }

        public int maxProfit3(int[] prices) {
            int n = prices.length;
            int[] ahead = new int[2];

            for (int i = n - 1; i >= 0; i--) {
                int[] curr = new int[2];
                for (int buy = 0; buy <= 1; buy++) {
                    int next0 = ahead[0];
                    int next1 = ahead[1];
                    int profit = Integer.MIN_VALUE;

                    if (buy == 1)
                        profit = Math.max(next1, -1 * prices[i] + next0);
                    else
                        profit = Math.max(next0, prices[i] + next1);

                    curr[buy] = profit;
                }
                ahead = curr;
            }
            return ahead[1];
        }

        public int maxProfit4(int[] prices) {
            int n = prices.length;
            int aheadNotBuy = 0, aheadBuy = 0;

            for (int i = n - 1; i >= 0; i--) {
                int currBuy = Math.max(aheadBuy, -1 * prices[i] + aheadNotBuy);
                int currNotBuy = Math.max(aheadNotBuy, prices[i] + aheadBuy);
                aheadNotBuy = currNotBuy;
                aheadBuy = currBuy;
            }
            return aheadBuy;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 4, 5};
        Out.print(sol.maxProfit(prices));
        Out.print(sol.maxProfit2(prices));
        Out.print(sol.maxProfit3(prices));
        Out.print(sol.maxProfit4(prices));
    }
}
