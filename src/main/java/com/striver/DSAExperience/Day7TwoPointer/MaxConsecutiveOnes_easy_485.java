package com.striver.DSAExperience.Day7TwoPointer;/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

import com.striver.DSAExperience.Day7TwoPointer.RemoveDuplicatesFromSortedArray_easy_26;

// @lc code=start
public class MaxConsecutiveOnes_easy_485 {
    static class Solution {
        // [Optimal] O(n), O(1) - will keep track of count and max of 1's count with traversal of array
        public int findMaxConsecutiveOnes(int[] nums) {
            int cnt = 0, max = 0;
            for (int n : nums) {
                if (n == 1)
                    cnt++;
                else
                    cnt = 0;
                max = Math.max(max, cnt);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 0, 1, 1, 1,1};
        System.out.println(sol.findMaxConsecutiveOnes(nums));
    }
}

// @lc code=end

