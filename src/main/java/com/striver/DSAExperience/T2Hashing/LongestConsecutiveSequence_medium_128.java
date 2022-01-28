package com.striver.DSAExperience.T2Hashing;/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

import java.util.Arrays;
import java.util.HashSet;

// @lc code=start
public class LongestConsecutiveSequence_medium_128 {
    static class Solution {
        // [Brute] O(nlogn), O(n) - sort the array check consecutive element
        // Sorting
        public int longestConsecutive1(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            Arrays.sort(nums);

            int max = 0, len = 1;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1])
                    continue;
                if (nums[i] == nums[i + 1] - 1)
                    len++;
                else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            return Math.max(max, len);
        }

        // [Better] TC, SC: O(n) - store into hashset and verify the consecutive elements
        // HashSet and Intelligent Sequence Building
        public int longestConsecutive2(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;

            HashSet<Integer> set = new HashSet<>();
            for (int e : nums)
                set.add(e);

            int max = 1;
            for (int ele : nums) {
                if (!set.contains(ele - 1)) {
                    int current = ele;
                    int len = 1;
                    while (set.contains(++current))
                        len++;
                    max = Math.max(max, len);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 0, 1, 3, 3};
        System.out.println(sol.longestConsecutive1(nums));
        System.out.println(sol.longestConsecutive2(nums));
    }
}

// @lc code=end

