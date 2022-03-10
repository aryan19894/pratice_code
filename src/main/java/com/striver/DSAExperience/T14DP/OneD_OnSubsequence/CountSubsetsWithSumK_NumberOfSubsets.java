package com.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import com.common.Out;

import java.util.Arrays;

public class CountSubsetsWithSumK_NumberOfSubsets {
    // [Better DP: Memo] TC: O(N*K):  There are N*K states therefore at max ‘N*K’ new problems will be solved.
    // SC: O(N) + O(N*K): using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return countSubset(num, n - 1, tar, dp);
    }

    private static int countSubset(int[] num, int i, int target, int[][] dp) {
        if (target == 0)
            return 1;
        if (i == 0)
            return num[0] == target ? 1 : 0;
        if (dp[i][target] != -1) return dp[i][target];

        int notTake = countSubset(num, i - 1, target, dp);
        int take = 0;
        if (target >= num[i])
            take = countSubset(num, i - 1, target - num[i], dp);
        return dp[i][target] = notTake + take;
    }

    // [Better DP: Tab] TC: O(N*K): two nested loops
    // SC: O(N*K): using an external array of size ‘N*K’. Stack Space is eliminated.
    public static int findWays2(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        if (tar >= num[0])
            dp[0][num[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= tar; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (target >= num[i])
                    take = dp[i - 1][target - num[i]];
                dp[i][target] = notTake + take;
            }
        }
        return dp[n - 1][tar];
    }

    // [Better DP: Tab] TC: O(N*K): two nested loops
    // SC: O(K): using an external array of size ‘K+1’ to store only one row.
    public static int findWays3(int num[], int tar) {
        int n = num.length;
        int[] prev = new int[tar + 1];
        prev[0] = 1;
        if (tar >= num[0])
            prev[num[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[tar + 1];
            curr[0] = 1;
            for (int target = 0; target <= tar; target++) {
                int notTake = prev[target];
                int take = 0;
                if (target >= num[i])
                    take = prev[target - num[i]];
                curr[target] = notTake + take;
            }
            prev = curr;
        }
        return prev[tar];
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 2, 3};
        int tar = 0;
        Out.print(findWays(num, 3));
        Out.print(findWays2(num, 3));
        Out.print(findWays3(num, 3));
    }
}
