package pratice.striver.DSAExperience.T14DP.OneD_OnSubsequence;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements_HouseRobber1 {
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick

    // [Better DP: Tab] TC: O(N): The overlapping subproblems will return the answer in constant time O(1).
    // Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
    // SC: O(N). using a recursion stack space(O(N)) and an array (again O(N)).
    // Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(n - 1, nums, dp);
    }

    private static int maxSum(int i, ArrayList<Integer> nums, int[] dp) {
        if (i == 0) return nums.get(i);
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int pick = nums.get(i) + maxSum(i - 2, nums, dp);
        int nPick = maxSum(i - 1, nums, dp);
        return dp[i] = Math.max(pick, nPick);
    }

    // [Better DP: Tab] TC: O(N), O(N): running a simple iterative loop
    // using an external array of size ‘n+1’.
    public static int maximumNonAdjacentSum2(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums.get(0);

        int[] dp = new int[n];
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(nums.get(i) + dp[i - 2], dp[i - 1]);

        return dp[n - 1];
    }

    // [Better DP: Tab] TC: O(N), O(1): running a simple iterative loop
    public static int maximumNonAdjacentSum3(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums.get(0);

        int prev1 = nums.get(0);
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int curr = Math.max(nums.get(i) + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums = Array.toList(new int[]{2,1,4,9});
        Out.print(maximumNonAdjacentSum(nums));
        Out.print(maximumNonAdjacentSum2(nums));
        Out.print(maximumNonAdjacentSum3(nums));
    }
}
