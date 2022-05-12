package pratice.striver.DSAExperience.T14DP.TwoD_OnStock;

import pratice.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee_medium_714 {
    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return calcProfit(prices, 0, 1, fee, dp);
        }

        private int calcProfit(int[] prices, int i, int buyFlag, int fee, int[][] dp) {
            if (i == prices.length) return 0;
            if (dp[i][buyFlag] != -1) return dp[i][buyFlag];

            int profit = 0;
            if (buyFlag == 1) {
                int buy = -1 * prices[i] + calcProfit(prices, i + 1, 0, fee, dp);
                int notBuy = calcProfit(prices, i + 1, 1, fee, dp);
                profit = Math.max(buy, notBuy);
            } else {
                int sell = prices[i] - fee + calcProfit(prices, i + 1, 1, fee, dp);
                int notSell = calcProfit(prices, i + 1, 0, fee, dp);
                profit = Math.max(sell, notSell);
            }
            return dp[i][buyFlag] = profit;
        }

        public int maxProfit2(int[] prices, int fee) {
            int n = prices.length;
            int[] ahead = new int[2];

            for (int i = n - 1; i >= 0; i--) {
                int[] curr = new int[2];
                for (int buy = 0; buy <= 1; buy++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-1 * prices[i] + ahead[0], ahead[1]);
                    else
                        profit = Math.max(prices[i] - fee + ahead[1], ahead[0]);
                    curr[buy] = profit;
                }
                ahead = curr;
            }
            return ahead[1];
        }

        public int maxProfit3(int[] prices, int fee) {
            int n = prices.length;
            int aheadBuy = 0, aheadNotBuy = 0;
            for (int i = n - 1; i >= 0; i--) {
                int currBuy = Math.max(-1 * prices[i] + aheadNotBuy, aheadBuy);
                int currNotBuy = Math.max(prices[i] - fee + aheadBuy, aheadNotBuy);
                aheadBuy = currBuy;
                aheadNotBuy = currNotBuy;
            }
            return aheadBuy;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        Out.print(sol.maxProfit(prices, fee));
        Out.print(sol.maxProfit2(prices, fee));
        Out.print(sol.maxProfit3(prices, fee));
    }
}
