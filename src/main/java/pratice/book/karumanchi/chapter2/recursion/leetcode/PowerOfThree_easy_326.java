package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.common.Out;

public class PowerOfThree_easy_326 {
    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n == 1) return true;
            if (n == 0 || n % 3 != 0) return false;

            return isPowerOfThree(n / 3);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 12;
        Out.print(sol.isPowerOfThree(n));
    }
}
