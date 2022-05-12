package pratice.leetcode.blind75.T3DP;

import pratice.common.Out;

import java.util.Arrays;

public class LongestCommonSubsequence_medium_1143 {
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m = text2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return countLCS(text1, text2, n, m, dp);
        }

        private int countLCS(String s1, String s2, int i, int j, int[][] dp) {
            if (i == 0 || j == 0) return 0;
            if (dp[i][j] != -1) return dp[i][j];

            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                return dp[i][j] = 1 + countLCS(s1, s2, i - 1, j - 1, dp);
            else
                return dp[i][j] = Math.max(countLCS(s1, s2, i - 1, j, dp), countLCS(s1, s2, i, j - 1, dp));
        }

        public int longestCommonSubsequence2(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[n][m];
        }

        public int longestCommonSubsequence3(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            int[] prev = new int[m + 1];

            for (int i = 1; i <= n; i++) {
                int[] curr = new int[m + 1];
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        curr[j] = 1 + prev[j - 1];
                    else
                        curr[j] = Math.max(prev[j], curr[j - 1]);
                }
                prev = curr;
            }
            return prev[m];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        Out.print(sol.longestCommonSubsequence(text1, text2));
        Out.print(sol.longestCommonSubsequence2(text1, text2));
        Out.print(sol.longestCommonSubsequence3(text1, text2));
    }
}
