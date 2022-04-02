package com.leetcode.blind75.T3DP;

import com.common.Out;

import java.util.Arrays;

public class LongestIncreasingSubsequence_medium_300 {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return countLIS(nums, n - 1, dp);
        }

        private int countLIS(int[] nums, int i, int[] dp) {
            if (i == 0) return 1;
            if (i < 0) return 0;
            if (dp[i] != -1) return dp[i];

            int notPick = countLIS(nums, i - 1, dp);
            int pick = 0;
            if (i >= 1 && nums[i] < nums[i - 1])
                pick = 1 + countLIS(nums, i - 1, dp);
            return dp[i] = Math.max(notPick, pick);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {7,7,7,7,7,7,7};
        Out.print(sol.lengthOfLIS(nums));
    }
}
