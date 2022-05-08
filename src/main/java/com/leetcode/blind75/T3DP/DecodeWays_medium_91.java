package com.leetcode.blind75.T3DP;

import com.common.Out;

import java.util.Arrays;

public class DecodeWays_medium_91 {
    static class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0 || (n == 1 && s.charAt(0) == '0')) return 0;

            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return count(s, n, dp);
        }

        private int count(String s, int i, int[] dp) {
            if (i < 0) return 0;
            if (i == 0 || i == 1) return 1;
            if (s.charAt(0) == '0') return 0;
            if (dp[i] != -1) return dp[i];

            int count = 0;
            if (s.charAt(i - 1) > '0')
                count = count(s, i - 1, dp);
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                count += count(s, i - 2, dp);

            return dp[i] = count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "06";
        Out.print(sol.numDecodings(s));
    }
}
