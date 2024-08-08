package revise._2024.striver.DP._1D;

import java.util.Arrays;

public class CountWaysToReachTheNThStairs {
    private static final int MOD = (int) (1e9 + 7);

    public static int countDistinctWayToClimbStair(long nStairs) {
        int n = (int) nStairs;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }

    private static int count(int n, int[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != -1) return dp[n];

        return dp[n] = (count(n - 1, dp) + count(n - 2, dp)) % MOD;
    }

        public static int countDistinctWayToClimbStair1(long nStairs) {
        if (nStairs <= 1) return 1;

        int n = (int) nStairs;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;

        return dp[n];
    }

    public static int countDistinctWayToClimbStair2(long nStairs) {
        if (nStairs <= 1) return 1;

        int n = (int) nStairs;
        int a = 1, b = 1, c = a + b;
        for (int i = 1; i < n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 0;

        System.out.println(countDistinctWayToClimbStair(n));
        System.out.println(countDistinctWayToClimbStair1(n));
        System.out.println(countDistinctWayToClimbStair2(n));
    }
}
