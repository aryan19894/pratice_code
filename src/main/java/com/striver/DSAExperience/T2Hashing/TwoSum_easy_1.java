package com.striver.DSAExperience.T2Hashing;/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

import com.common.Out;

import java.util.HashMap;

// @lc code=start
public class TwoSum_easy_1 {
    static class Solution {
        // [Brute] O(n2) - iterate ech and every element and calculate the sum
        public int[] twoSum1(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] + nums[i] == target)
                        return new int[]{i, j};
                }
            }
            return null;
        }

        // [Better] O(n), O(n) - we will use hashtable
        public int[] twoSum2(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(target - nums[i]))
                    return new int[]{map.get(target - nums[i]), i};
                else
                    map.put(nums[i], i);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        Out.print(sol.twoSum2(nums, 9));
    }
}

// @lc code=end

