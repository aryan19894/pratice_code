package com.striver.DSAExperience.T14DP;

import com.common.Out;

public class PrintLongestCommonSubsequence {
    // [Better DP: Tab] TC: O(N*M) + O(N+M):  N*M character combination and N+M is for backtracking
    // SC: O(N*M):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static String lcs(String s, String t) {
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
        int index = dp[n][m];
        char[] sub = new char[index];

        while (n > 0 && m > 0) {
            if (s.charAt(n - 1) == t.charAt(m - 1)) {
                sub[index-- - 1] = s.charAt(n - 1);
                n--;
                m--;
            } else if (dp[n - 1][m] >= dp[n][m - 1]) n--;
            else m--;
        }
        return new String(sub);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";
        int n = 0;
        int m = 0;
        Out.print(lcs(s, t));
    }
}
