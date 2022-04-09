package com.striver.DSAExperience.T14DP.TwoD_OnString.LIS;

import com.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence_medium_300 {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            return countLIS(nums, 0, -1, dp);
        }

        private int countLIS(int[] nums, int i, int prev, int[][] dp) {
            if (i == nums.length) return 0;
            if (dp[i][prev + 1] != -1) return dp[i][prev + 1];

            int len = countLIS(nums, i + 1, prev, dp);
            if (prev == -1 || nums[i] > nums[prev])
                len = Math.max(len, 1 + countLIS(nums, i + 1, i, dp));
            return dp[i][prev + 1] = len;
        }

        public int lengthOfLIS2(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n + 1][n + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int prev = i - 1; prev >= -1; prev--) {
                    int len = dp[i + 1][prev + 1];
                    if (prev == -1 || nums[i] > nums[prev])
                        len = Math.max(len, 1 + dp[i + 1][i + 1]);
                    dp[i][prev + 1] = len;
                }
            }

            return dp[0][0];
        }

        public int lengthOfLIS3(int[] nums) {
            int n = nums.length;
            int[] front = new int[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                int[] curr = new int[n + 1];
                for (int prev = i - 1; prev >= -1; prev--) {
                    int len = front[prev + 1];
                    if (prev == -1 || nums[i] > nums[prev])
                        len = Math.max(len, 1 + front[i + 1]);
                    curr[prev + 1] = len;
                }
                front = curr;
            }

            return front[0];
        }

        public int lengthOfLIS4(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int prev = 0; prev < i; prev++) {
                    if (nums[i] > nums[prev])
                        dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
                max = Math.max(dp[i], max);
            }

            return max;
        }

        //_BinarySearch
        public int lengthOfLIS5(int[] nums) {
            int n = nums.length;
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            for (int i = 1; i < n; i++) {
                int r = list.size() - 1;
                if (list.get(r) < nums[i])
                    list.add(nums[i]);
                else {
                    int id = lowerBound(list, nums[i]);
                    list.set(id, nums[i]);
                }
            }

            return list.size();
        }

        private int lowerBound(List<Integer> list, int num) {
            int n = list.size();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (list.get(mid) < num)
                    l = mid + 1;
                else if (list.get(mid) >= num)
                    r = mid;
            }
            if (l < n && list.get(l) < num)
                l++;
            return l;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //int[] nums = {5, 4, 11, 1, 16, 8};
//        int[] nums = {1,1, 7, 8, 4, 5, 6, -1, 9};
        int[] nums = {2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 9, 10};
        Out.print(sol.lengthOfLIS(nums));
        Out.print(sol.lengthOfLIS2(nums));
        Out.print(sol.lengthOfLIS3(nums));
        Out.print(sol.lengthOfLIS4(nums));
        Out.print(sol.lengthOfLIS5(nums));
    }
}
