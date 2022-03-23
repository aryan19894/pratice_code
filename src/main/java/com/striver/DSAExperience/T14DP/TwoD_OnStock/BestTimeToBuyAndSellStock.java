package com.striver.DSAExperience.T14DP.TwoD_OnStock;

import com.common.Out;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
//    public static int maximumProfit(int[] prices, int n, int k) {
//        int[][] dp = new int[n+1][k+1];
//        for (int[] row : dp)
//            Arrays.fill(row, -1);
//
//        return calcMaxProfit(prices,n-1,k, dp);
////        int[] min = new int[k];
////        Arrays.fill(min, prices[0]);
////        int profit = 0;
////        while (k-- > 0) {
////            for (int i = 1; i < n; i++) {
////                int cost = prices[i] - min[0] ;
////                profit = Math.max(profit, cost);
////                min[0] = Math.min(min[0], prices[i]);
////            }
////        }
////        return profit;
//    }

//    private static int calcMaxProfit(int[] prices, int i, int k, int[][] dp) {
//        int notTake = calcMaxProfit(prices,i-1,k,dp);
//        int take = Integer.MIN_VALUE;
//        if (num[i] <= x)
//            take = 1 + findMinCoins(num, i, x - num[i], dp);
//    }

    public static int maximumProfit4(int[] prices, int n, int k) {
        int[] min = new int[k];
        Arrays.fill(min, prices[0]);
        int profit = 0;
        while (k-- > 0) {
            for (int i = 1; i < n; i++) {
                int cost = prices[i] - min[0] ;
                profit = Math.max(profit, cost);
                min[0] = Math.min(min[0], prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int n = 0;
        int k = 0;
        Out.print(maximumProfit4(prices, prices.length, 2));
    }
}
