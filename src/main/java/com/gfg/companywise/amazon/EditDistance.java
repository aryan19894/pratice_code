package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.Arrays;

public class EditDistance {
    static public class Solution {
        public int editDistance(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] r : dp)
                Arrays.fill(r, -1);
            return countDistance(s, t, n, m, dp);
        }

        private int countDistance(String s, String t, int i, int j, int[][] dp) {
            if (i == 0) return j;
            if (j == 0) return i;
            if (dp[i][j] != -1) return dp[i][j];

            if (s.charAt(i - 1) == t.charAt(j - 1))
                return dp[i][j] = countDistance(s, t, i - 1, j - 1, dp);
            else {
                int insert = countDistance(s, t, i - 1, j, dp);
                int delete = countDistance(s, t, i, j - 1, dp);
                int replace = countDistance(s, t, i - 1, j - 1, dp);

                return dp[i][j] = 1 + min(insert, delete, replace);
            }
        }

        private static int min(int... ele) {
            int min = Integer.MAX_VALUE;
            for (int e : ele)
                min = Math.min(min, e);
            return min;
        }

        public int editDistance2(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int i = 0; i <= n; i++)
                dp[i][0] = i;
            for (int j = 0; j <= m; j++)
                dp[0][j] = j;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
            return dp[n][m];
        }

        public int editDistance3(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[] prev = new int[m + 1];

            for (int j = 0; j <= m; j++)
                prev[j] = j;

            for (int i = 1; i <= n; i++) {
                int[] curr = new int[m + 1];
                curr[0] = i;
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        curr[j] = prev[j - 1];
                    else
                        curr[j] = 1 + min(prev[j], curr[j - 1], prev[j - 1]);
                }
                prev = curr;
            }
            return prev[m];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "gfg";
        String t = "gfag";
        Out.print(sol.editDistance(s, t));
        Out.print(sol.editDistance2(s, t));
        Out.print(sol.editDistance3(s, t));
    }
}
