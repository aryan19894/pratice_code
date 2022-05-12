package pratice.leetcode.blind75.T2Binary;

import pratice.common.Out;

public class SumOfTwoIntegers_medium_371 {
    static class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int t = a;
                a ^= b;
                b = (t & b) << 1;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 15;
        int b = 2;
        Out.print(sol.getSum(a, b));
    }
}
