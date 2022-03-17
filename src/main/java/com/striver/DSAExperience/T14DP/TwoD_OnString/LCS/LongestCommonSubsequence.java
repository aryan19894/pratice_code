package com.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import com.common.Out;

import java.util.Arrays;

public class LongestCommonSubsequence {
    // [Better DP: Recur] TC: O(2powN) + O(2powM):  each character has option with match or not match

    // [Better DP: Memo] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M) + O(N+M): using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        return count(s, n, t, m, dp);
    }

    private static int count(String s, int i, String t, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1))
            return dp[i][j] = 1 + count(s, i - 1, t, j - 1, dp);
        else
            return dp[i][j] = Math.max(count(s, i - 1, t, j, dp), count(s, i, t, j - 1, dp));
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int lcs2(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        //base case is not required - array prefilled with 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int lcs3(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1]; //count(t, i - 1, s, j - 1, dp);
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String s = "abcdb";
        String t = "bcacdhb";
        int n = 0;
        int m = 0;
        Out.print(lcs(s, t));
        Out.print(lcs2(s, t));
        Out.print(lcs3(s, t));
    }
}
