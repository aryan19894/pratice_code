package pratice.striver.DSAExperience.T14DP.TwoD_OnString.StringMatching;

import pratice.common.Out;

import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return count(str1, str2, n, m, dp);
    }

    private static int count(String str1, String str2, int i, int j, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (dp[i][j] != -1) return dp[i][j];

        if (str1.charAt(i - 1) == str2.charAt(j - 1))
            return dp[i][j] = count(str1, str2, i - 1, j - 1, dp);
        else {
            int insert = count(str1, str2, i - 1, j, dp);
            int delete = count(str1, str2, i, j - 1, dp);
            int replace = count(str1, str2, i - 1, j - 1, dp);

            return dp[i][j] = 1 + min(insert, delete, replace);
        }
    }

    private static int min(int... ele) {
        int min = Integer.MAX_VALUE;
        for (int e : ele)
            min = Math.min(min, e);
        return min;
    }

    public static int editDistance2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
            }
        }

        return dp[n][m];
    }

    public static int editDistance3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++)
            prev[j] = j;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = 1 + min(prev[j], curr[j - 1], prev[j - 1]);
            }
            prev = curr;
        }

        return prev[m];
    }

    public static void main(String[] args) {
        String str1 = "whgtdwhgtdg";
        String str2 = "aswcfg";
        Out.print(editDistance(str1, str2));
        Out.print(editDistance2(str1, str2));
        Out.print(editDistance3(str1, str2));
    }
}
