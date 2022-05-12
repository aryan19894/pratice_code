package pratice.leetcode.blind75.T3DP;

import pratice.common.Out;

import java.util.Arrays;

public class CoinChange_medium_322 {
    static class Solution {
        private static final int UPPER = (int) Math.pow(10, 9);

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;

            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            int ans = countCoins(coins, n - 1, amount, dp);
            return ans >= UPPER ? -1 : ans;
        }

        private int countCoins(int[] coins, int i, int amount, int[][] dp) {
            if (i == 0) {
                if (amount == 0) return 0;
                else if (amount % coins[0] == 0) return amount / coins[0];
                else return UPPER;
            }
            if (dp[i][amount] != -1) return dp[i][amount];

            int notPick = countCoins(coins, i - 1, amount, dp);
            int pick = UPPER;
            if (coins[i] <= amount)
                pick = 1 + countCoins(coins, i, amount - coins[i], dp);
            return dp[i][amount] = Math.min(notPick, pick);
        }

        public int coinChange2(int[] coins, int amount) {
            if (amount == 0) return 0;

            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for (int i = 0; i <= amount; i++) {
                if (i % coins[0] == 0) dp[0][i] = i / coins[0];
                else dp[0][i] = UPPER;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= amount; j++) {
                    int notPick = dp[i - 1][j];
                    int pick = UPPER;
                    if (coins[i] <= j)
                        pick = 1 + dp[i][j - coins[i]];
                    dp[i][j] = Math.min(notPick, pick);
                }
            }
            int ans = dp[n - 1][amount];
            return ans >= UPPER ? -1 : ans;
        }

        public int coinChange3(int[] coins, int amount) {
            if (amount == 0) return 0;

            int n = coins.length;
            int[] prev = new int[amount + 1];

            for (int i = 0; i <= amount; i++) {
                if (i % coins[0] == 0) prev[i] = i / coins[0];
                else prev[i] = UPPER;
            }

            for (int i = 1; i < n; i++) {
                int[] curr = new int[amount + 1];
                for (int j = 0; j <= amount; j++) {
                    int notPick = prev[j];
                    int pick = UPPER;
                    if (coins[i] <= j)
                        pick = 1 + curr[j - coins[i]];
                    curr[j] = Math.min(notPick, pick);
                }
                prev = curr;
            }
            int ans = prev[amount];
            return ans >= UPPER ? -1 : ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins = {1};
        int amount = 2;
        Out.print(sol.coinChange(coins, amount));
        Out.print(sol.coinChange2(coins, amount));
        Out.print(sol.coinChange3(coins, amount));
    }
}
