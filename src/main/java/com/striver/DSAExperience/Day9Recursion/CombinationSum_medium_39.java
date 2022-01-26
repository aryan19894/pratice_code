package com.striver.DSAExperience.Day9Recursion;/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import com.common.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_medium_39 {
    static class Solution {
        // [Optimal] TC: O(2powT*K) - 2powT - T is for digit is used to repetitive so, N is not possible.
        // K - process time for putting a data structure into another ds.
        // SC: O(K*X) - K - assuming that K is average length and X would be combinations.
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length < 1 || candidates == null) {
                return null;
            }
            List<List<Integer>> result = new ArrayList();
            findCombinationSum(0, candidates, new ArrayList(), result, target);
            return result;
        }

        private void findCombinationSum(int i, int[] candidates, List<Integer> ds,
                                        List<List<Integer>> result, int target) {
            if (i == candidates.length) {
                if (target == 0)
                    result.add(new ArrayList<>(ds));
                return;
            }

            //element is picked
            if (candidates[i] <= target) {
                ds.add(candidates[i]);
                findCombinationSum(i, candidates, ds, result, target - candidates[i]);
                ds.remove(ds.size() - 1);
            }
            //element is not picked
            findCombinationSum(i + 1, candidates, ds, result, target);
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 6, 7};
        Solution sol = new Solution();
        List<List<Integer>> res = sol.combinationSum(nums, 7);
        Printer.print(res);
    }
}

// @lc code=end

