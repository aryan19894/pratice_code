package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class CoinChangeMinimumElements {
    // [Better DP: Memo] TC: O(N*T): N*T states therefore at max ‘N*T’ new problems will be solved.
    // SC: O(N) + O(N*T): using a recursion stack space(O(N)) and a 2D array (O(N*T)).
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int[][] dp = new int[n][x + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = findMinCoins(num, n - 1, x, dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

    private static int findMinCoins(int[] num, int i, int x, int[][] dp) {
        if (i == 0) {
            if (x == 0) return 1;
            else if (x % num[0] == 0) return x / num[0];
            else return (int) 1e9;
        }
        if (dp[i][x] != -1) return dp[i][x];

        int notTake = findMinCoins(num, i - 1, x, dp);
        int take = Integer.MAX_VALUE;
        if (num[i] <= x)
            take = 1 + findMinCoins(num, i, x - num[i], dp);

        return dp[i][x] = Math.min(take, notTake);
    }

    // [Better DP: Tab] TC: O(N*T): two nested loops
    // SC: O(N*T): using an external DP Array of size ‘N*T’.
    public static int minimumElements2(int num[], int x) {
        int n = num.length;
        int[][] dp = new int[n][x + 1];

        for (int t = 0; t <= x; t++) {
            if (t % num[0] == 0)
                dp[0][t] = t / num[0];
            else dp[0][t] = (int) Math.pow(10, 9);
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= x; t++) {
                int notTake = dp[i - 1][t];
                int take = (int) Math.pow(10, 9);
                if (num[i] <= t)
                    take = 1 + dp[i][t - num[i]];

                dp[i][t] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][x];
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

    // [Better DP: Tab] TC: O(N*T): two nested loops
    // SC: O(T): using an external array of size ‘W+1’ to store only one row.
    public static int minimumElements3(int num[], int x) {
        int n = num.length;
        int[] prev = new int[x+1];

        for (int t = 0; t <= x; t++) {
            if (t % num[0] == 0)
                prev[t] = t / num[0];
            else prev[t] = (int) Math.pow(10, 9);
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[x+1];
            for (int t = 0; t <= x; t++) {
                int notTake = prev[t];
                int take = (int) Math.pow(10, 9);
                if (num[i] <= t)
                    take = 1 + curr[t - num[i]];

                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[x];
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 3};
        int x = 7;
        Out.print(minimumElements(num, x));
        Out.print(minimumElements2(num, x));
        Out.print(minimumElements3(num, x));
    }
}
