package pratice.leetcode.blind75.T1Array;

import pratice.common.Out;

public class BestTimeToBuyAndSellStock_easy_121 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int maxDiff = 0, minBuy = Integer.MAX_VALUE;

            for (int p : prices) {
                minBuy = Math.min(minBuy, p);
                maxDiff = Math.max(maxDiff, p - minBuy);
            }
            return maxDiff;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        Out.print(sol.maxProfit(prices));
    }
}
