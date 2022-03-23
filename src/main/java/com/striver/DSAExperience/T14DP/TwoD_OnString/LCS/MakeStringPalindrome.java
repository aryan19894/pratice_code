package com.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import com.common.Out;

public class MakeStringPalindrome {
    public static String minInsertion(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        String str1 = str;
        String str2 = reverse(new StringBuilder(str));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuffer ans = new StringBuffer();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            }
            else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) ans.append(str1.charAt(i-- - 1));
        while (j > 0) ans.append(str2.charAt(j-- - 1));

        return new String(ans);
    }

    private static String reverse(StringBuilder s) {
        return new String(s.reverse());
    }

    public static void main(String[] args) {
        String str = "codingninjas";
        Out.print(minInsertion(str));
    }
}
