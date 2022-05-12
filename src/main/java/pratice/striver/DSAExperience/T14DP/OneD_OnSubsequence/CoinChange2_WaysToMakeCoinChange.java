package pratice.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import pratice.common.Out;

import java.util.Arrays;

public class CoinChange2_WaysToMakeCoinChange {
    // [Better DP: Memo] TC: O(N*T): N*T states therefore at max ‘N*T’ new problems will be solved.
    // SC: O(N) + O(N*T): using a recursion stack space(O(N)) and a 2D array (O(N*T)).
    public static long countWaysToMakeChange(int num[], int x) {
        int n = num.length;
        long[][] dp = new long[n][x + 1];
        for (long[] d : dp)
            Arrays.fill(d, -1);

        return countCoins(num, n - 1, x, dp);
    }

    private static long countCoins(int[] num, int i, int x, long[][] dp) {
        if (i == 0) return x % num[0] == 0 ? 1 : 0;

        if (dp[i][x] != -1) return dp[i][x];

        long notTaken = countCoins(num, i - 1, x, dp);
        long taken = 0;
        if (num[i] <= x)
            taken = countCoins(num, i, x - num[i], dp);

        return dp[i][x] = notTaken + taken;
    }

    // [Better DP: Tab] TC: O(N*T): two nested loops
    // SC: O(N*T): using an external DP Array of size ‘N*T’.
    public static long countWaysToMakeChange2(int num[], int x) {
        int n = num.length;
        long[][] dp = new long[n][x + 1];

        for (int i = 0; i <= x; i++) {
            if (x % num[0] == 0)
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= x; t++) {
                long notTaken = dp[i - 1][t];
                long taken = 0;
                if (num[i] <= t)
                    taken = dp[i][t - num[i]];

                dp[i][t] = notTaken + taken;
            }
        }
        return dp[n - 1][x];
    }

    // [Better DP: Tab] TC: O(N*T): two nested loops
    // SC: O(T): using an external array of size ‘W+1’ to store only one row.
    public static long countWaysToMakeChange3(int num[], int x) {
        int n = num.length;
        long[] prev = new long[x+1];

        for (int i = 0; i <= x; i++) {
            if (x % num[0] == 0)
                prev[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            long[] curr = new long[x+1];
            for (int t = 0; t <= x; t++) {
                long notTaken = prev[t];
                long taken = 0;
                if (num[i] <= t)
                    taken = curr[t - num[i]];

                curr[t] = notTaken + taken;
            }
            prev = curr;
        }
        return prev[x];
    }

    // [Better DP: Tab: 1D More Opt] TC: O(N*W): two nested loops
    // SC: O(W): using an external array of size ‘W+1’ to store only one row.
    public static long countWaysToMakeChange4(int num[], int x) {
        int n = num.length;
        long[] prev = new long[x+1];

        for (int i = 0; i <= x; i++) {
            if (x % num[0] == 0)
                prev[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= x; t++) {
                long notTaken = prev[t];
                long taken = 0;
                if (num[i] <= t)
                    taken = prev[t - num[i]];

                prev[t] = notTaken + taken;
            }
        }
        return prev[x];
    }

    public static void main(String[] args) {
        int denominations[] = {1, 2, 3};
        int value = 4;
        Out.print(countWaysToMakeChange(denominations, value));
        Out.print(countWaysToMakeChange2(denominations, value));
        Out.print(countWaysToMakeChange3(denominations, value));
        Out.print(countWaysToMakeChange4(denominations, value));
    }
}
