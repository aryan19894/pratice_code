package revise._2024.striver.DP.intro;

import java.util.Arrays;

public class IntroToDp_FibonacciSeries {
    private static final long MOD = (long) (1e9 + 7);

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return fibo(n, dp);
    }

    private static long fibo(int n, long[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        return (dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp)) % MOD;
    }

    static long bottomUp(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;

        return dp[n];
    }

    static long memoryOpt(int n) {
        long a = 0, b = 1, c = a + b;
        for (int i = 1; i < n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n=6;

        System.out.println(topDown(n));
        System.out.println(bottomUp(n));
        System.out.println(memoryOpt(n));
    }
}
