package com.striver.DSAExperience.T6RecursionBacktracking;

import com.common.Printer;

import java.util.*;

// @lc code=start
public class SubsetsII_medium_90 {
    static class Solution {
        // [Better] O(2powNlog2powN), O(2powN) - Recursive with element is picked or not
        public List<List<Integer>> subsetsWithDup1(int[] nums) {
            if (nums.length < 1 || nums == null) {
                return null;
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList();
            dfs(nums, 0, result, new ArrayList(), new HashSet());

            return result;
        }

        private void dfs(int[] nums, int id, List<List<Integer>> result,
                         List<Integer> list, Set<List<Integer>> set) {
            if (id >= nums.length) {
                if (!set.contains(list))
                    result.add(new ArrayList<>(list));
                set.add(list);
                return;
            }

            list.add(nums[id]);
            dfs(nums, id + 1, result, list, set);
            list.remove(list.size() - 1);
            dfs(nums, id + 1, result, list, set);
        }

        // [Optimal] O(2powN*N) - putting the element to ds will take O(n/2) on each elements
        // O(2powN)*O(k) - K - auxilliary space is for data strucure where it will create each length of subsets.
        // This will call recursive on basis of each length of subset like 0,1,2....n
        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            if (nums.length < 1 || nums == null) {
                return null;
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList();
            findSubsets(0, nums, new ArrayList(), result);

            return result;
        }

        private void findSubsets(int id, int[] nums, List<Integer> ds, List<List<Integer>> result) {
            result.add(new ArrayList<>(ds));
            for (int i = id; i < nums.length; i++) {
                if (i != id && nums[i] == nums[i - 1]) continue;
                ds.add(nums[i]);
                findSubsets(i + 1, nums, ds, result);
                ds.remove(ds.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        Solution sol = new Solution();
        List<List<Integer>> res = sol.subsetsWithDup1(nums);
        Printer.print(res);
        res = sol.subsetsWithDup2(nums);
        Printer.print(res);
    }
}

// @lc code=end

