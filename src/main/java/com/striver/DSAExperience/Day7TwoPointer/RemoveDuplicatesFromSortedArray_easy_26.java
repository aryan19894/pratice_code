package com.striver.DSAExperience.Day7TwoPointer;/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

import java.util.HashSet;
import java.util.LinkedHashSet;

// @lc code=start
public class RemoveDuplicatesFromSortedArray_easy_26 {
    static class Solution {
        // [Basic] O(nlogn)+O(n), O(n) - logn - for hashset operation
        // store all elements to hashset, so it will not allow inserting duplicate element.
        public int removeDuplicates1(int[] nums) {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int n : nums)
                set.add(n);
            int i = 0;
            for (int s : set)
                nums[i++] = s;
            return set.size();
        }

        // [Optimal] O(n), O(1) - will use 2-pointer technique and check whether both are matching.
        public int removeDuplicates2(int[] nums) {
            int i = 0, j = i + 1, n = nums.length;
            if (n == 0)
                return 0;

            while (j < n) {
                if (nums[i] == nums[j])
                    j++;
                else {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-3, -1, 0, 0, 0, 3, 3};
        System.out.println(sol.removeDuplicates1(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(sol.removeDuplicates2(nums));
    }
}

// @lc code=end

