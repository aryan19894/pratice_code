package pratice.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import pratice.common.Out;

public class PartitionSetMinAbsoluteSumDiff {
    // [Better DP: Tab] TC: O(N*totSum) +O(N) +O(N): two nested loops that account for O(N*totSum),
    // at starting we are running a for loop to calculate totSum and at last a for loop to traverse the last row.
    // SC: O(totSum): using an external array of size ‘totSum+1’ to store only one row.
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;

        boolean[] lastRow = calcSubsetSum(arr, n, totalSum);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum/2; i++) {
            if (lastRow[i])
                ans = Math.min(ans, Math.abs(2 * i - totalSum));
        }
        return ans;
    }

    private static boolean[] calcSubsetSum(int[] arr, int n, int k) {
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
                curr[t] = take || notTake;
            }
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7};
        int n = 0;
        Out.print(minSubsetSumDifference(arr, arr.length));
    }
}
