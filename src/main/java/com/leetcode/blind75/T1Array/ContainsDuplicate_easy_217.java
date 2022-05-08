package com.leetcode.blind75.T1Array;

import com.common.Out;

import java.util.HashSet;

public class ContainsDuplicate_easy_217 {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums)
                if (!set.add(n)) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1};
        Out.print(sol.containsDuplicate(nums));
    }
}
