package pratice.striver.DSAExperience.T14DP.TwoD_OnString.LCS;

import pratice.common.Out;

public class MinimumInsertionsDeletionsToConvertStringAToStringB_CanYouMake {
    public static int canYouMake(String str, String ptr) {
        int n = str.length();
        int m = ptr.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == ptr.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int lcs = dp[n][m];
        return n + m - 2 * lcs;
    }

    public static void main(String[] args) {
        String str = "abcd";
        String ptr = "anc";
        Out.print(canYouMake(str, ptr));
    }
}
