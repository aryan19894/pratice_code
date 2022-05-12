package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import pratice.common.Out;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    // [Better DP: Memo] TC: O(N*N) + O(N): find LCS between string and its reversed string
    // SC: O(N*M) + O(N+M): using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    public static int longestPalindromeSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        String s2 = reverse(new StringBuilder(s));
        return count(s, n, s2, n, dp);
    }

    private static int count(String s1, int i, String s2, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i][j] = 1 + count(s1, i - 1, s2, j - 1, dp);
        return dp[i][j] = Math.max(count(s1, i - 1, s2, j, dp), count(s1, i, s2, j - 1, dp));
    }

    // [Better DP: Memo] TC: O(N*N) + O(N): find LCS with similar string but second string is act as reversed.
    // SC: O(N*M) + O(N+M): using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    public static int longestPalindromeSubsequence2(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return count(s, s, n, 0, dp);
    }

    private static int count(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == s2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j))
            return dp[i][j] = 1 + count(s1, s2, i - 1, j + 1, dp);
        return dp[i][j] = Math.max(count(s1, s2, i - 1, j, dp), count(s1, s2, i, j + 1, dp));
    }

    private static String reverse(StringBuilder s) {
        return new String(s.reverse());
    }

    public static int longestPalindromeSubsequence3(String s) {
        int n = s.length();
        int[] prev = new int[n + 1];
        String s1 = s;
        String s2 = reverse(new StringBuilder(s));

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[n];
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        Out.print(longestPalindromeSubsequence(s));
        Out.print(longestPalindromeSubsequence2(s));
        Out.print(longestPalindromeSubsequence3(s));
    }
}
