package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class PartitionsWithGivenDifference {
    private static int MOD = (int) (1e9 + 7);

    // [Better DP: Memo] TC: O(N*K) + O(N):  N*K states therefore at max ‘N*K’ new problems will be solved and
    // we are running a for loop for ‘N’ times to calculate the total sum
    // SC: O(N) + O(N*K): using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        int k = (totalSum - d) / 2;

        int[][] dp = new int[n][k + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        return countSubset(arr, n - 1, k, dp);
    }

    private static int countSubset(int[] arr, int i, int target, int[][] dp) {
        if (i == 0) {
            if (target == 0 && arr[i] == 0) return 2;
            if (target == 0 || arr[i] == target) return 1;
            return 0;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notPick = countSubset(arr, i - 1, target, dp);
        int pick = 0;
        if (arr[i] <= target)
            pick = countSubset(arr, i - 1, target - arr[i], dp);
        return dp[i][target] = (notPick + pick) % MOD;
    }

    // [Better DP: Tab] TC: O(N*K) + O(N):  N*K states therefore at max ‘N*K’ new problems will be solved and
    // we are running a for loop for ‘N’ times to calculate the total sum
    // SC: O(N*K): using an external array of size ‘N*K’. Stack Space is eliminated.
    public static int countPartitions2(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        int k = (totalSum - d) / 2;

        int[][] dp = new int[n][k + 1];

        dp[0][0] = arr[0] == 0 ? 2 : 1;
        if (arr[0] != 0 && arr[0] <= k)
            dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (target >= arr[i])
                    take = dp[i - 1][target - arr[i]];
                dp[i][target] = (notTake + take) % MOD;
            }
        }
        return dp[n - 1][k];
    }

    // [Better DP: Tab] TC: O(N*K) + O(N):  N*K states therefore at max ‘N*K’ new problems will be solved and
    // we are running a for loop for ‘N’ times to calculate the total sum
    // SC: O(K): using an external array of size ‘K+1’ to store only one row.
    public static int countPartitions3(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        int k = (totalSum - d) / 2;

        int[] prev = new int[k + 1];

        prev[0] = arr[0] == 0 ? 2 : 1;
        if (arr[0] != 0 && arr[0] <= k) prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[k + 1];
            curr[0] = 1;
            for (int target = 0; target <= k; target++) {
                int notTake = prev[target];
                int take = 0;
                if (target >= arr[i])
                    take = prev[target - arr[i]];
                curr[target] = (notTake + take) % MOD;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        int n = 0;
        int d = 0;
        int[] arr = {5, 2, 6, 4};
        Out.print(countPartitions(arr.length, 3, arr));
        Out.print(countPartitions2(arr.length, 3, arr));
        Out.print(countPartitions3(arr.length, 3, arr));
    }
}
