package com.striver.DSAExperience.T14DP.TwoD_OnStock;

import com.common.Out;
import com.common.converter.Array;

import java.util.ArrayList;

public class BuyAndSellStock_OneTime_StocksAreProfitable {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int profit = 0, min = prices.get(0);
        for (int ele : prices) {
            profit = Math.max(profit, ele - min);
            min = Math.min(min, ele);
        }
        return profit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> prices = Array.toList(new int[]{7, 1, 5, 3, 6, 4});
        Out.print(maximumProfit(prices));
    }
}
