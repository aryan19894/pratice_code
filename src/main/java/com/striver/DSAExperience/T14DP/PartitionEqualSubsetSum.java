package com.striver.DSAExperience.T14DP;

import com.common.Out;

public class PartitionEqualSubsetSum {
    // [Better DP: Tab] TC: O(N*K) +O(N): two nested loops that account for O(N*K) and
    // at starting we are running a for loop to calculate totSum.
    // SC: O(K): using an external array of size ‘K+1’ to store only one row.
    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;

        if (totalSum % 2 == 1) return false;

        int k = totalSum / 2;

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int t = 1; t <= k; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t >= arr[i])
                    take = prev[t - arr[i]];
                curr[t] = notTake || take;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = 0;
        Out.print(canPartition(arr, arr.length));
    }
}
