package com.striver.DSAExperience.T14DP.theory;

import com.common.Out;

import java.util.Arrays;

public class FibonacciSeries {
    // [Better DP] TC: O(N). Recursive with memoization
    // SC: O(N) + O(N). dp array and stack space
    private static int fibonacci(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }

    // [Better DP] TC: O(N). Tabulation method
    // SC: O(N). dp array and stack space
    private static void fibo(int n) {
        int[] dp = new int[11];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        Out.print(dp);
    }

    // [Better DP] TC: O(N). swap assign rule
    // SC: O(1).
    private static void fibo2(int n) {
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        int ans = fibonacci(5, dp);
        System.out.println(ans);

        fibo(5);
        fibo2(5);
    }
}
