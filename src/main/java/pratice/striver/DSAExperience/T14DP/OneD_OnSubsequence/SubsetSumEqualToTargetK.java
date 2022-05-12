package pratice.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import pratice.common.Out;

import java.util.Arrays;

public class SubsetSumEqualToTargetK {
    // [Better DP: Memo] TC: O(N*K):  There are N*K states therefore at max ‘N*K’ new problems will be solved.
    // SC: O(N) + O(N*K): using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return calcSubsetSum(n - 1, k, arr, dp);
    }

    private static boolean calcSubsetSum(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[i] == target;
        if (dp[i][target] != -1) return dp[i][target] == 1;

        boolean notTake = calcSubsetSum(i - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[i])
            take = calcSubsetSum(i - 1, target - arr[i], arr, dp);

        dp[i][target] = (notTake || take) ? 1 : 0;
        return notTake || take;
    }

    // [Better DP: Tab] TC: O(N*K): two nested loops
    // SC: O(N*K): using an external array of size ‘N*K’. Stack Space is eliminated.
    public static boolean subsetSumToK2(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= arr[i])
                    take = dp[i - 1][target - arr[i]];

                dp[i][target] = notTake || take;
            }
        }
        return dp[n - 1][k];
    }

    // [Better DP: Tab] TC: O(N*K): two nested loops
    // SC: O(K): using an external array of size ‘K+1’ to store only one row.
    public static boolean subsetSumToK3(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k+1];

        prev[0] = true;
        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[i])
                    take = prev[target - arr[i]];

                curr[target] = notTake || take;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        int n = 0;
        int k = 0;
        int[] arr = {4, 3, 2, 1};
        Out.print(subsetSumToK(arr.length, 3, arr));
        Out.print(subsetSumToK2(arr.length, 3, arr));
        Out.print(subsetSumToK3(arr.length, 3, arr));
    }
}
