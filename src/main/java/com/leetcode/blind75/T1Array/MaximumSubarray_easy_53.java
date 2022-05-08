package com.leetcode.blind75.T1Array;

import com.common.Out;

public class MaximumSubarray_easy_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0, maxSum = nums[0];
            for (int n : nums) {
                sum += n;
                maxSum = Math.max(maxSum, sum);
                sum = Math.max(sum, 0);
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Out.print(sol.maxSubArray(nums));
    }
}
