package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import pratice.common.Out;

public class ShortestCommonSupersequence {
    public static String shortestSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuffer ans = new StringBuffer();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                ans.append(a.charAt(i - 1));
                i--;
            } else {
                ans.append(b.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) ans.append(a.charAt(i-- - 1));
        while (j > 0) ans.append(b.charAt(j-- - 1));

        return new String(ans.reverse());
    }

    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";
        Out.print(shortestSupersequence(a, b));
    }
}
