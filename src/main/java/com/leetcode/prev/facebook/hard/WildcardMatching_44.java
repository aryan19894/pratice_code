package com.leetcode.prev.facebook.hard;

import com.common.Out;

import java.util.Arrays;

public class WildcardMatching_44 {
    static class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] r : dp)
                Arrays.fill(r, -1);
            return isMatch(n, m, s, p, dp);
        }

        private boolean isMatch(int i, int j, String s, String p, int[][] dp) {
            if (i == 0 && j == 0) return true;
            else if (j == 0 && i > 0) return false;
            else if (i == 0 && j > 0) {
                for (int lj = 1; lj <= j; lj++)
                    if (p.charAt(lj - 1) != '*') return false;
                return true;
            }
            if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

            if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                boolean val = isMatch(i - 1, j - 1, s, p, dp);
                dp[i][j] = val ? 1 : 0;
                return val;
            }

            if (p.charAt(j - 1) == '*') {
                boolean val = isMatch(i, j - 1, s, p, dp) || isMatch(i - 1, j, s, p, dp);
                dp[i][j] = val ? 1 : 0;
                return val;
            }
            dp[i][j] = 0;
            return false;
        }

        public boolean isMatch2(String s, String p) {
            int n = s.length();
            int m = p.length();
            boolean[][] dp = new boolean[n + 1][m + 1];

            dp[0][0] = true;
            for (int j = 1; j <= m; j++) {
                boolean flag = true;
                for (int lj = 1; lj <= j; lj++)
                    if (p.charAt(lj - 1) != '*') {
                        flag = false;
                        break;
                    }
                dp[0][j] = flag;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (p.charAt(j - 1) == '*')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    else dp[i][j] = false;
                }
            }
            return dp[n][m];
        }

        public boolean isMatch3(String s, String p) {
            int n = s.length();
            int m = p.length();
            boolean[] prev = new boolean[m+1];

            prev[0] = true;
            for (int j = 1; j <= m; j++) {
                boolean flag = true;
                for (int lj = 1; lj <= j; lj++)
                    if (p.charAt(lj - 1) != '*') {
                        flag = false;
                        break;
                    }
                prev[j] = flag;
            }
            for (int i = 1; i <= n; i++) {
                boolean[] curr = new boolean[m+1];
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        curr[j] = prev[j - 1];
                    else if (p.charAt(j - 1) == '*')
                        curr[j] = prev[j] || curr[j - 1];
                    else curr[j] = false;
                }
                prev = curr;
            }
            return prev[m];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aa";
        String p = "*";
        Out.print(sol.isMatch(s, p));
        Out.print(sol.isMatch2(s, p));
        Out.print(sol.isMatch3(s, p));
    }
}
