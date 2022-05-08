package com.leetcode.blind75.T2Binary;

import com.common.Out;

public class ReverseBits_easy_190 {
    static public class Solution {
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans <<= 1;
                ans |= (n & 1);
                n >>= 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 00000000000000000000000000001011;
        Out.print(sol.reverseBits(n));
    }
}
