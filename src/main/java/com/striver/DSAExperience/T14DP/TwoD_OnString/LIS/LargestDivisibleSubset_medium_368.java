package com.striver.DSAExperience.T14DP.TwoD_OnString.LIS;

import com.common.Out;

import java.util.*;

public class LargestDivisibleSubset_medium_368 {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int[] dp = new int[n]; // will store LIS till dp[i]
            int[] prevIdx = new int[n]; // just previous index of dp[i]
            Arrays.fill(dp, 1);
            int maxLen = 0, maxIdx = 0;
            for (int i = 1; i < n; i++) {
                prevIdx[i] = i;
                for (int p = 0; p < i; p++) {
                    if (isDivisible(nums, i, p) && dp[i] < 1 + dp[p]) {
                        dp[i] = 1 + dp[p];
                        prevIdx[i] = p;
                    }
                }
                if (maxLen < dp[i]) {
                    maxLen = dp[i];
                    maxIdx = i;
                }
            }

            List<Integer> res = new ArrayList<>();
            res.add(nums[maxIdx]);
            while (prevIdx[maxIdx] != maxIdx) {
                maxIdx = prevIdx[maxIdx];
                res.add(nums[maxIdx]);
            }
            Collections.sort(res);
            return res;
        }

        private boolean isDivisible(int[] nums, int i, int p) {
            return nums[p] % nums[i] == 0 || nums[i] % nums[p] == 0;
        }

        public List<Integer> largestDivisibleSubset2(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int[] dp = new int[n]; // will store LIS till dp[i]
            Arrays.fill(dp, 1);
            int maxLen = 0, maxIdx = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0)
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }

            LinkedList<Integer> res = new LinkedList<>();
            int prev = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (maxLen != dp[i]) continue;
                if (prev == -1 || prev % nums[i] == 0) {
                    res.addFirst(nums[i]);
                    maxLen--;
                    prev = nums[i];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        int[] nums = {1};
        Out.print(sol.largestDivisibleSubset(nums));
        Out.print(sol.largestDivisibleSubset2(nums));
    }
}
