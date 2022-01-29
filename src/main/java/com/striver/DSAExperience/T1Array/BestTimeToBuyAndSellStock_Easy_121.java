// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BestTimeToBuyAndSellStock_Easy_121.java

package com.striver.DSAExperience.T1Array;

public class BestTimeToBuyAndSellStock_Easy_121 {
    static class Solution {

        public int maxProfit1(int prices[]) {
            int n = prices.length;
            int profit = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++)
                    if (prices[i] < prices[j])
                        profit = Math.max(profit, prices[j] - prices[i]);

            }

            return profit;
        }

        public int maxProfit2(int prices[]) {
            int n = prices.length;
            int profit = 0;
            int min = prices[0];
            for (int i = 0; i < n; i++) {
                min = Math.min(min, prices[i]);
                profit = Math.max(profit, prices[i] - min);
            }

            return profit;
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        int nums[] = {
                7, 1, 5, 3, 6, 4
        };
        int ans = sol.maxProfit2(nums);
        System.out.println(ans);
    }
}
