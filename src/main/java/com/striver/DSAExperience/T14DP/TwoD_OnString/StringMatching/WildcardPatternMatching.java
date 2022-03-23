package com.striver.DSAExperience.T14DP.TwoD_OnString.StringMatching;

import com.common.Out;

import java.util.Arrays;

public class WildcardPatternMatching {
    public static boolean wildcardMatching(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return isMatch(pattern, text, n, m, dp);
    }

    private static boolean isMatch(String pattern, String text, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return true;
        else if (i == 0 && j > 0) return false;
        if (j == 0 && i > 0) {
            for (int ii = 1; ii <= i; ii++)
                if (pattern.charAt(ii - 1) != '*') return false;
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
            boolean val = isMatch(pattern, text, i - 1, j - 1, dp);
            dp[i][j] = val ? 1 : 0;
            return val;
        }
        if (pattern.charAt(i - 1) == '*') {
            boolean val = isMatch(pattern, text, i, j - 1, dp) || isMatch(pattern, text, i - 1, j, dp);
            dp[i][j] = val ? 1 : 0;
            return val;
        }
        dp[i][j] = 0;
        return false;
    }

    public static boolean wildcardMatching2(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (pattern.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern.charAt(i - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }


    public static boolean wildcardMatching3(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        boolean[] prev = new boolean[m + 1];

        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (pattern.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?')
                    curr[j] = prev[j - 1];
                else if (pattern.charAt(i - 1) == '*')
                    curr[j] = curr[j - 1] || prev[j];
                else curr[j] = false;
            }
            prev = curr;
        }
        return prev[m];
    }


    public static void main(String[] args) {
        String pattern = "ab?d";
        String text = "abcc";
        Out.print(wildcardMatching(pattern, text));
        Out.print(wildcardMatching2(pattern, text));
        Out.print(wildcardMatching3(pattern, text));
    }
}
