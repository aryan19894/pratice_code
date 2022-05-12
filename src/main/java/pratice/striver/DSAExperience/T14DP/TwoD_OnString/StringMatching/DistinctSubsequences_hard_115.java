package pratice.striver.DSAExperience.T14DP.TwoD_OnString.StringMatching;

import pratice.common.Out;

import java.util.Arrays;

public class DistinctSubsequences_hard_115 {
    static class Solution {
        private static final int MOD = (int) (1e9 + 7);

        public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return countDistinct(s, t, n, m, dp);
        }

        private int countDistinct(String s, String t, int i, int j, int[][] dp) {
            if (j == 0) return 1;
            if (i == 0) return 0;
            if (dp[i][j] != -1) return dp[i][j];

            if (s.charAt(i - 1) == t.charAt(j - 1))
                return dp[i][j] = (countDistinct(s, t, i - 1, j - 1, dp) + countDistinct(s, t, i - 1, j, dp)) % MOD;
            else
                return dp[i][j] = countDistinct(s, t, i - 1, j, dp) % MOD;
        }

        public int numDistinct2(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                    else
                        dp[i][j] = dp[i - 1][j] % MOD;
                }
            }
            return dp[n][m];
        }

        public int numDistinct3(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[] prev = new int[m + 1];

            prev[0] = 1;
            for (int i = 1; i <= n; i++) {
                int[] curr = new int[m + 1];
                curr[0] = 1;
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        curr[j] = (prev[j - 1] + prev[j]) % MOD;
                    else
                        curr[j] = prev[j] % MOD;
                }
                prev = curr;
            }
            return prev[m];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        Out.print(sol.numDistinct(s, t));
        Out.print(sol.numDistinct2(s, t));
        Out.print(sol.numDistinct3(s, t));
    }
}
