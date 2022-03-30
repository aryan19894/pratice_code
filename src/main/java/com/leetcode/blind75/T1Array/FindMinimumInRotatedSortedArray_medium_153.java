package com.leetcode.blind75.T1Array;

import com.common.Out;

public class FindMinimumInRotatedSortedArray_medium_153 {
    static class Solution {
        public int findMin(int[] nums) {
            int r = nums.length - 1;
            if (nums[0] <= nums[r]) return nums[0];
            while (nums[0] > nums[r]) r--;
            return nums[r + 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 4, 5, 1, 2};
        Out.print(sol.findMin(nums));
    }
}
