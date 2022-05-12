package pratice.gfg.companywise.google;

import pratice.common.Out;

import java.util.Arrays;

public class EggDroppingPuzzle {
    static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return countAttempt(n, k, dp);
    }

    private static int countAttempt(int i, int j, int[][] dp) {
        if (j <= 1) return j;
        if (i == 1) return j;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= j; x++) {
            int brk = countAttempt(i - 1, x - 1, dp);
            int notBrk = countAttempt(i, j - x, dp);
            min = Math.min(min, Math.max(brk, notBrk));
        }
        return dp[i][j] = min + 1;
    }

    static int eggDrop2(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= k; j++)
            dp[1][j] = j;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int brk = dp[i - 1][x - 1];
                    int notBrk = dp[i][j - x];
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(brk, notBrk));
                }
            }
        }
        return dp[n][k];
    }

    static int eggDrop3(int n, int k) {
        int[] prev = new int[k+1];

        for (int j = 1; j <= k; j++)
            prev[j] = j;

        for (int i = 2; i <= n; i++) {
            int[] curr = new int[k+1];
            curr[1] = 1;
            for (int j = 2; j <= k; j++) {
                curr[j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int brk = prev[x - 1];
                    int notBrk = curr[j - x];
                    curr[j] = Math.min(curr[j], 1 + Math.max(brk, notBrk));
                }
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 10;
        Out.print(eggDrop(n, k));
        Out.print(eggDrop2(n, k));
        Out.print(eggDrop3(n, k));
    }
}
