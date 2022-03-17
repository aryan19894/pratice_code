package com.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import com.common.Out;

public class LongestCommonSubstring {
    // [Better DP: Recur] TC: O(2powN) + O(2powM):  each character has option with match or not match
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        return count(str1, n, str2, m, 0);
    }

    private static int count(String str1, int i, String str2, int j, int count) {
        if (i == 0 || j == 0) return count;

        if (str1.charAt(i - 1) == str2.charAt(j - 1))
            count = count(str1, i - 1, str2, j - 1, count + 1);

        return Math.max(count,
                Math.max(count(str1, i - 1, str2, j, 0),
                        count(str1, i, str2, j - 1, 0)));
    }

    // [Better DP: Tab] TC: O(N*M):  N*M character combination
    // SC: O(N*M):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int lcs2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int count = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    count = Math.max(count, dp[i][j]);
                }
            }
        }

        return count;
    }

    // [Better DP: Tab] TC: O(N*M):  N*M character combination
    // SC: O(M):using an external array of size ‘M’
    public static int lcs3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int count = 0;

        int[] prev = new int[m+1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    count = Math.max(count, curr[j]);
                }
            }
            prev = curr;
        }

        return count;
    }

    public static void main(String[] args) {
        String str1 = "bb";
        String str2 = "aa";
        Out.print(lcs(str1, str2));
        Out.print(lcs2(str1, str2));
        Out.print(lcs3(str1, str2));
    }
}
