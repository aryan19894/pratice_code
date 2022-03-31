package com.leetcode.blind75.T2Binary;

import com.common.Out;

public class MissingNumber_easy_268 {
    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = n * (n + 1) / 2;
            for (int num : nums)
                sum -= num;
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        Out.print(sol.missingNumber(nums));
    }
}
