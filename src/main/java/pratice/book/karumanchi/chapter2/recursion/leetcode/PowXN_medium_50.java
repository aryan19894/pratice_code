package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.common.Out;

public class PowXN_medium_50 {
    static class Solution {
        public double myPow(double x, int n) {
            boolean isNumNeg = x < 0 && n % 2 != 0;
            boolean isPowNeg = n < 0;
            n = Math.abs(n);
            x = Math.abs(x);

            double ans = find(x, n);
            ans = isNumNeg ? -ans : ans;
            return isPowNeg ? 1L / ans : ans;
        }

        private double find(double x, int n) {
            if (n == 0 || x == 1.0) return 1.0;
            if (n == 1) return x;

            double ans = find(x, n / 2);
            ans *= ans;
            return n % 2 == 0 ? ans : x * ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double x = -2.000;
        int n = 2;
        Out.print(sol.myPow(x, n));
    }
}
