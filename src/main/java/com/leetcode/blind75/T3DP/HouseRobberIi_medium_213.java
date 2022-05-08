package com.leetcode.blind75.T3DP;

import com.common.Out;

public class HouseRobberIi_medium_213 {
    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[0], nums[1]);

            return Math.max(count(nums, 1, n), count(nums, 0, n - 1));
        }

        private int count(int[] nums, int i, int n) {
            int prev2 = nums[i];
            int prev1 = Math.max(nums[i], nums[i + 1]);

            i += 2;
            while (i < n) {
                int curr = Math.max(nums[i++] + prev2, prev1);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2};
        Out.print(sol.rob(nums));
    }
}
