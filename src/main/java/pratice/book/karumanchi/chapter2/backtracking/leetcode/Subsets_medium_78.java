package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_medium_78 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> curr = new ArrayList<Integer>();
            List<List<Integer>> ans = new ArrayList<>();
            findSubsets(nums, 0, ans, curr);
            return ans;
        }

        private void findSubsets(int[] nums, int i, List<List<Integer>> output, List<Integer> sub) {
            if (i == nums.length) {
                output.add(new ArrayList<>(sub));
                return;
            }

            sub.add(nums[i]);
            findSubsets(nums, i + 1, output, sub);
            sub.remove(sub.size() - 1);
            findSubsets(nums, i + 1, output, sub);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        Out.print(sol.subsets(nums));
    }
}
