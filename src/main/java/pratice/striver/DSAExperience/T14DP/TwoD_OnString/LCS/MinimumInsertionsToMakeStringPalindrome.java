package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import pratice.common.Out;

import java.util.Arrays;

public class MinimumInsertionsToMakeStringPalindrome {
    public static int minInsertion(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        String str2 = reverse(new StringBuilder(str));
        int count = count(str, n, str2, n, dp);
        return n - count;
    }

    private static int count(String str1, int i, String str2, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (str1.charAt(i - 1) == str2.charAt(j - 1))
            return dp[i][j] = 1 + count(str1, i - 1, str2, j - 1, dp);
        return dp[i][j] = Math.max(count(str1, i - 1, str2, j, dp), count(str1, i, str2, j - 1, dp));
    }

    public static int minInsertion2(String str) {
        int n = str.length();
        int[] prev = new int[n + 1];
        String str1 = str;
        String str2 = reverse(new StringBuilder(str));

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }

        return n - prev[n];
    }

    private static String reverse(StringBuilder s) {
        return new String(s.reverse());
    }

    public static void main(String[] args) {
        String str = "edge";
        Out.print(minInsertion(str));
        Out.print(minInsertion2(str));
        Out.print(minInsertion(str));
    }
}
