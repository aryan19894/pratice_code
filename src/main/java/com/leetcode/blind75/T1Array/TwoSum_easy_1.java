package com.leetcode.blind75.T1Array;

import com.common.Out;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_easy_1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]))
                    return new int[]{map.get(target - nums[i]), i};
                map.put(nums[i], i);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        Out.print(sol.twoSum(nums, target));
    }
}
