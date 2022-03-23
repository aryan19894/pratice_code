package com.gfg.companywise.google;

import com.common.Out;

public class InterleavedStrings {
    static public class Solution {
        public boolean isInterLeave(String a, String b, String c) {
            int n = a.length();
            int m = b.length();
            if (n + m != c.length()) return false;

            Boolean[][] dp = new Boolean[n + 1][m + 1];
            return checkInterLeaved(a, b, c, n, m, dp);
        }

        private boolean checkInterLeaved(String a, String b, String c, int i, int j, Boolean[][] dp) {
            if (i == 0 && j == 0) return dp[i][j] = true;
            if (dp[i][j] != null) return dp[i][j];

            if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1))
                if (checkInterLeaved(a, b, c, i - 1, j, dp)) return dp[i][j] = true;
            if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1))
                if (checkInterLeaved(a, b, c, i, j - 1, dp)) return dp[i][j] = true;
            return dp[i][j] = false;
        }

        public boolean isInterLeave2(String a, String b, String c) {
            int n = a.length();
            int m = b.length();
            if (n + m != c.length()) return false;
            boolean[][] dp = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i == 0 && j == 0) dp[i][j] = true;
                    else if (i == 0) {
                        if (b.charAt(j - 1) == c.charAt(j - 1))
                            dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        if (a.charAt(i - 1) == c.charAt(i - 1))
                            dp[i][j] = dp[i - 1][j];
                    } else {
                        boolean acCompare = a.charAt(i - 1) == c.charAt(i + j - 1);
                        boolean bcCompare = b.charAt(j - 1) == c.charAt(i + j - 1);

                        if (acCompare && !bcCompare) dp[i][j] = dp[i - 1][j];
                        else if (!acCompare && bcCompare) dp[i][j] = dp[i][j - 1];
                        else if (acCompare && bcCompare) dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
            return dp[n][m];
        }

        public boolean isInterLeave3(String a, String b, String c) {
            int n = a.length();
            int m = b.length();
            if (n + m != c.length()) return false;
            boolean[] prev = new boolean[m + 1];

            for (int i = 0; i <= n; i++) {
                boolean[] curr = new boolean[m + 1];
                for (int j = 0; j <= m; j++) {
                    if (i == 0 && j == 0) curr[j] = true;
                    else if (i == 0) {
                        if (b.charAt(j - 1) == c.charAt(j - 1))
                            curr[j] = curr[j - 1];
                    } else if (j == 0) {
                        if (a.charAt(i - 1) == c.charAt(i - 1))
                            curr[j] = prev[j];
                    } else {
                        boolean acCompare = a.charAt(i - 1) == c.charAt(i + j - 1);
                        boolean bcCompare = b.charAt(j - 1) == c.charAt(i + j - 1);

                        if (acCompare && !bcCompare) curr[j] = prev[j];
                        else if (!acCompare && bcCompare) curr[j] = curr[j - 1];
                        else if (acCompare && bcCompare) curr[j] = prev[j] || curr[j - 1];
                    }
                }
                prev = curr;
            }
            return prev[m];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String a = "aabc";
        String b = "abad";
        String c = "aabadabc";
        Out.print(sol.isInterLeave(a, b, c));
        Out.print(sol.isInterLeave2(a, b, c));
        Out.print(sol.isInterLeave3(a, b, c));
    }
}
