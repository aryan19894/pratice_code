package com.striver.DSAExperience.T7RecursionBacktracking;/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

import com.common.Out;

import java.util.ArrayList;
import java.util.List;

// @lc code=start
public class Permutations_medium_46 {
    static class Solution {
        // [Better Recursive] TC: O(n!*n) - n! is for all permutation and
        // n is for iterating 0 to n-1 for each recursion call.
        // SC: O(n) - for map array
        public List<List<Integer>> permute1(int[] nums) {
            if (nums == null || nums.length < 1) {
                return null;
            }
            boolean[] status = new boolean[nums.length];
            List<List<Integer>> result = new ArrayList();
            permuteRecursive(nums, status, result, new ArrayList<>());
            return result;
        }

        private void permuteRecursive(int[] nums, boolean[] status, List<List<Integer>> result,
                                      ArrayList<Integer> ds) {
            if (ds.size() == nums.length) {
                result.add(new ArrayList<>(ds));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!status[i]) {
                    status[i] = true;
                    ds.add(nums[i]);
                    permuteRecursive(nums, status, result, ds);
                    ds.remove(ds.size() - 1);
                    status[i] = false;
                }

            }
        }

        // [Optimal Recursive] TC: O(n!*n) - n! is for all permutation and
        // n is for iterating 0 to n-1 for each recursion call.
        // SC: O(1) - for map array
        public List<List<Integer>> permute2(int[] nums) {
            if (nums == null || nums.length < 1) {
                return null;
            }
            List<List<Integer>> result = new ArrayList();
            permuteRecursive2(0, nums, result);
            return result;
        }

        private void permuteRecursive2(int idx, int[] nums, List<List<Integer>> result) {
            if (idx == nums.length) {
                // copy the ds to ans
                List<Integer> ds = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    ds.add(nums[i]);
                }
                result.add(new ArrayList<>(ds));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                swap(nums, idx, i);
                permuteRecursive2(idx + 1, nums, result);
                swap(nums, idx, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = sol.permute1(nums);
        Out.print(res);
        int[] n = {1, 2, 3};
        res = sol.permute2(n);
        Out.print(res);
    }
}
// @lc code=end

