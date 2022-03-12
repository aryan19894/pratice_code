package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class LongestCommonSubsequence_SubsequenceCounting2 {
    // [Better DP: Recur] TC: O(2powN) + O(2powM):  each character has option with match or not match

    // [Better DP: Memo] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M) + O(N+M): using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        int[][] dp = new int[lt + 1][ls + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        return count(t, lt, s, ls, dp);
    }

    private static int count(String t, int i, String s, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (t.charAt(i - 1) == s.charAt(j - 1))
            return dp[i][j] = 1 + count(t, i - 1, s, j - 1, dp);
        else
            return dp[i][j] = Math.max(count(t, i - 1, s, j, dp), count(t, i, s, j - 1, dp));
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int subsequenceCounting2(String t, String s, int lt, int ls) {
        int[][] dp = new int[lt + 1][ls + 1];

        //base case is not required - array prefilled with 0

        for (int i = 1; i <= lt; i++) {
            for (int j = 1; j <= ls; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1]; //count(t, i - 1, s, j - 1, dp);
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lt][ls];
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int subsequenceCounting3(String t, String s, int lt, int ls) {
        int[][] dp = new int[lt + 1][ls + 1];
        int[] prev = new int[ls+1];
        //base case is not required - array prefilled with 0

        for (int i = 1; i <= lt; i++) {
            //int[] curr = new int[lt+1];
            for (int j = 1; j <= ls; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    prev[j] = 1 + prev[j - 1]; //count(t, i - 1, s, j - 1, dp);
                else
                    prev[j] = Math.max(prev[j], prev[j - 1]);
            }
            //prev = curr;
        }
        return prev[ls];
    }

    public static void main(String[] args) {
        String t = "dingdingdingding";
        String s = "ing";
        int lt = 0;
        int ls = 0;
        Out.print(subsequenceCounting(t, s, t.length(), s.length()));
        Out.print(subsequenceCounting2(t, s, t.length(), s.length()));
        Out.print(subsequenceCounting3(t, s, t.length(), s.length()));
    }
}
