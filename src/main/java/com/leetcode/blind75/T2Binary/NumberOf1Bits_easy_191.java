package com.leetcode.blind75.T2Binary;

import com.common.Out;

public class NumberOf1Bits_easy_191 {
    static public class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count += n & 1;
                n >>>= 1; // unsigned right shift
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 00000000000000000000000000001011;
        Out.print(sol.hammingWeight(n));
    }
}
