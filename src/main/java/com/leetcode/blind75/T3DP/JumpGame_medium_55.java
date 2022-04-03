package com.leetcode.blind75.T3DP;

import com.common.Out;

import java.util.Arrays;

public class JumpGame_medium_55 {
    static class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return count(nums, 0, n, dp);
        }

        private boolean count(int[] nums, int i, int n, int[] dp) {
            if (i >= n - 1) return true;
            if (dp[i] != -1) return dp[i] == 1 ? true : false;

            boolean ans = false;
            for (int k = nums[i]; k > 0; k--) {
                ans |= count(nums, i + k, n, dp);
                if (ans) break;
            }
            dp[i] = ans ? 1 : 0;
            return ans;
        }

        public boolean canJump2(int[] nums) {
            int n = nums.length-1;
            for (int i = n - 1; i >= 0; i--) {
                if (i + nums[i] >= n)
                    n = i;
            }
            return n == 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 0};
        Out.print(sol.canJump(nums));
        Out.print(sol.canJump2(nums));
    }
}
