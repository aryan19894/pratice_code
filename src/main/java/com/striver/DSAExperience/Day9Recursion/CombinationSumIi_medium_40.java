package com.striver.DSAExperience.Day9Recursion;/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

import com.common.Printer;
import com.striver.DSAExperience.Day9Recursion.CombinationSum_medium_39;

import java.util.*;

public class CombinationSumIi_medium_40 {

    static class Solution {
        // [Better] TC: O(2powN*K*logN) - K - process time for putting a data structure into another ds.
        // logN - putting those value to set
        // SC: O(2powN) - K - assuming that K is average length and X would be combinations.
        public List<List<Integer>> combinationSumII1(int[] candidates, int target) {
            if (candidates.length < 1 || candidates == null) {
                return null;
            }
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList();
            findCombinationSumII1(0, candidates, target, result, new ArrayList(), new HashSet());
            return result;
        }

        private void findCombinationSumII1(int i, int[] candidates, int target,
                                           List<List<Integer>> result, List<Integer> list,
                                           Set<List<Integer>> set) {
            if (i == candidates.length) {
                if (target == 0 && !set.contains(list))
                    result.add(new ArrayList<>(list));
                set.add(list);
                return;
            }

            //element is picked
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                findCombinationSumII1(i + 1, candidates, target - candidates[i], result, list, set);
                list.remove(list.size() - 1);
            }
            //element is not picked
            findCombinationSumII1(i + 1, candidates, target, result, list, set);
        }

        // [Better2] TC: O(2powN*K*logN) - K - process time for putting a data structure into another ds.
        // logN - putting those value to set
        // SC: O(2powN) - K - assuming that K is average length and X would be combinations.
        public List<List<Integer>> combinationSumII2(int[] candidates, int target) {
            if (candidates.length < 1 || candidates == null) {
                return null;
            }
            Arrays.sort(candidates);
            Set<List<Integer>> res = new HashSet<>();
            findCombinationSumII2(0, candidates, target, res, new ArrayList());
            List<List<Integer>> result = new ArrayList<>();
            for (List<Integer> r : res)
                result.add(r);
            return result;
        }

        private void findCombinationSumII2(int i, int[] candidates, int target,
                                           Set<List<Integer>> result, List<Integer> list) {
            if (i == candidates.length) {
                if (target == 0 && !result.contains(list))
                    result.add(new ArrayList<>(list));
                return;
            }

            //element is picked
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                findCombinationSumII2(i + 1, candidates, target - candidates[i], result, list);
                list.remove(list.size() - 1);
            }
            //element is not picked
            findCombinationSumII2(i + 1, candidates, target, result, list);
        }
    }

    public static void main(String[] args) {
        int nums[] = {10, 1, 2, 7, 6, 1, 5};
        Solution sol = new Solution();
        List<List<Integer>> res = sol.combinationSumII1(nums, 8);
        Printer.print(res);
        res = sol.combinationSumII2(nums, 8);
        Printer.print(res);
    }
}
// @lc code=end

