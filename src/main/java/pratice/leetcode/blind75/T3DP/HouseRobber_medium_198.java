package pratice.leetcode.blind75.T3DP;

import pratice.common.Out;

import java.util.Arrays;

public class HouseRobber_medium_198 {
    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return count(nums, n - 1, dp);
        }

        private int count(int[] nums, int i, int[] dp) {
            if (i < 0) return 0;
            if (i == 0) return nums[i];
            if (dp[i] != -1) return dp[i];

            int pick = nums[i] + count(nums, i - 2, dp);
            int notPick = count(nums, i - 1, dp);
            return dp[i] = Math.max(pick, notPick);
        }

        public int rob2(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                int pick = nums[i] + dp[i - 2];
                int notPick = dp[i - 1];
                dp[i] = Math.max(pick, notPick);
            }
            return dp[n - 1];
        }

        public int rob3(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];

            int prev2 = nums[0];
            int prev1 = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                int curr = Math.max(nums[i] + prev2, prev1);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 9, 3, 1};
        Out.print(sol.rob(nums));
        Out.print(sol.rob2(nums));
        Out.print(sol.rob3(nums));
    }
}
