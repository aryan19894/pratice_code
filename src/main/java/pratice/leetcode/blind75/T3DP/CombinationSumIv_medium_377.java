package pratice.leetcode.blind75.T3DP;

import pratice.common.Out;

import java.util.Arrays;

public class CombinationSumIv_medium_377 {
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);

            return count(nums, target, dp);
        }

        private int count(int[] nums, int t, int[] dp) {
            if (t < 0) return 0;
            if (t == 0) return 1;
            if (dp[t] != -1) return dp[t];

            int sum = 0;
            for (int n : nums) {
                if (t >= n)
                    sum += count(nums, t - n, dp);
            }
            return dp[t] = sum;
        }

        public int combinationSum42(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int n : nums) {
                    if (i >= n)
                        dp[i] += dp[i - n];
                }
            }
            return dp[target];
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int[] nums = {1, 2, 3};
        int target = 4;
        Out.print(sol.combinationSum4(nums, target));
        Out.print(sol.combinationSum42(nums, target));
    }
}

