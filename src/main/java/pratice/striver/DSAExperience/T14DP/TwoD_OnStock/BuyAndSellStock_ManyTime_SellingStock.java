package pratice.striver.DSAExperience.T14DP.TwoD_OnStock;

import pratice.common.Out;

public class BuyAndSellStock_ManyTime_SellingStock {
    public static long getMaximumProfit(int n, long[] values) {
        return calcProfit(values, 0, true);
    }

    private static long calcProfit(long[] arr, int i, boolean buyFlag) {
        if (i == arr.length) return 0;

        long profit = Long.MIN_VALUE;
        if (buyFlag) {
            long notBuy = calcProfit(arr, i + 1, true);
            long buy = -1 * arr[i] + calcProfit(arr, i + 1, false);
            profit = Math.max(notBuy, buy);
        } else {
            long notSell = calcProfit(arr, i + 1, false);
            long sell = arr[i] + calcProfit(arr, i + 1, true);
            profit = Math.max(notSell, sell);
        }
        return profit;
    }

    public static void main(String[] args) {
        int n = 0;
        long[] values = {7, 1, 5, 3, 6, 4};
        Out.print(getMaximumProfit(n, values));
    }
}
