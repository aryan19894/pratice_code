package com.striver.DSAExperience.T14DP.TwoD_OnStock;

import com.common.Out;

public class BestTimeToBuyAndSellStockI_1Time_easy_121 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int min = Integer.MAX_VALUE;
            for (int p : prices) {
                profit = Math.max(profit, p - min);
                min = Math.min(min, p);
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        Out.print(sol.maxProfit(prices));
    }
}
