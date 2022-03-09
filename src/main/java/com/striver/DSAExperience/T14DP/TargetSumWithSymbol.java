package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSumWithSymbol {
    // using dp map due to target value become larger when we perform addition
    // [Better DP: Memo] TC: O(N*W): N*W states therefore at max ‘N*W’ new problems will be solved.
    // SC: O(N) + O(N*W): using a recursion stack space(O(N)) and a 2D array (O(N*W)).
    public static int targetSum(int n, int target, int[] arr) {
        Map<Integer, Integer>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = new HashMap<>();

        return calcTargetSum(arr, n - 1, target, dp);
    }

    private static int calcTargetSum(int[] arr, int i, int target, Map<Integer, Integer>[] dp) {
        if (i < 0) return target == 0 ? 1 : 0;
        if (dp[i].containsKey(target))
            return dp[i].get(target);

        int plus = calcTargetSum(arr, i - 1, target - arr[i], dp);
        int minus = calcTargetSum(arr, i - 1, target + arr[i], dp);
        dp[i].put(target, plus + minus);

        return dp[i].get(target);
    }

    // using dp rule: PartitionsWithGivenDifference
    // [Better DP: Memo] TC: O(N*W): N*W states therefore at max ‘N*W’ new problems will be solved.
    // SC: O(N) + O(N*W): using a recursion stack space(O(N)) and a 2D array (O(N*W)).
    public static int targetSum2(int n, int target, int[] arr) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        if (totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;
        target = (totalSum - target) / 2;

        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return calcTargetSum2(arr, n, target, dp);
    }

    private static int calcTargetSum2(int[] arr, int n, int target, int[][] dp) {
        int[] prev = new int[target + 1];

        prev[0] = arr[0] == 0 ? 2 : 1;
        if (arr[0] != 0 && arr[0] <= target)
            prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int t = target; t >= 0; t--) {
                int notPick = prev[t];
                int pick = 0;
                if (arr[i] <= t)
                    pick = prev[t - arr[i]];

                prev[t] = pick + notPick;
            }
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int n = 5;
        int target = -44;
        int[] arr = {43, 35, 23, 6, 39, 64, 9, 44, 8, 51, 70, 91, 35, 61, 53, 13, 65, 26, 59, 13, 4, 53, 46, 48, 33, 55, 50, 63, 16, 30, 65, 94};
        // int[] arr = {5, 13, 10, 25, 16, 21, 7, 13, 7};
        Out.print(targetSum(arr.length, target, arr));
        Out.print(targetSum2(arr.length, target, arr));
    }
}
