package com.striver.DSAExperience.Day11BinarySearch;/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

import com.common.Printer;

import java.util.List;

// @lc code=start
public class SingleElementInASortedArray_medium_540 {
    static class Solution {
        // [Basic] TC: O(n), SC: O(1) - traverse the array from left to right. Since the array is sorted
        //compare the element to its next element

        // [Better] TC: O(n), SC: O(1) - using XOR technique because
        // XOR of similar element is 0 A^A = 0 and
        // XOR of element with 0 is itself the number A^0 = A
        public int singleNonDuplicate1(int[] nums) {
            int XOR = 0;
            for (int i = 0; i < nums.length; i++)
                XOR ^= nums[i];
            return XOR;
        }

        // [Optimal] TC: O(logn), SC: O(1) - will use binary search technique
        // we just verify with checking only left half.

        // Right half - 1st instance - odd index & 2nd instance - even index
        // Left half - 1st instance - even index & 2nd instance - odd index

        // To optimize ths odd even index using XOR because
        // If we perform XOR with 1 to even - result would be next odd number and
        // XOR with 1 to odd - result would be previous even number
        public int singleNonDuplicate2(int[] nums) {
            int l = 0;
            int h = nums.length - 2; // second last element as high

            while (l <= h) {
                int mid = (h + l) / 2;

                if (nums[mid ^ 1] != nums[mid]) h = mid - 1;
                else l = mid + 1;
            }
            return nums[l];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(sol.singleNonDuplicate1(nums));
        System.out.println(sol.singleNonDuplicate2(nums));
    }
}

// @lc code=end

