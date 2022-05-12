package pratice.leetcode.prev.facebook.medium;

import pratice.common.Out;

public class DivideTwoIntegers_29 {
    static class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 1) return dividend;
            if (divisor == -1) {
                if (dividend == Integer.MIN_VALUE)
                    return Integer.MAX_VALUE;
                else return -dividend;
            }
            if (dividend == divisor) return 1;

            boolean neg = dividend < 0 ^ divisor < 0;
            dividend = reverseAbs(dividend);
            divisor = reverseAbs(divisor);

            int ans = 0;
            while (dividend <= divisor) {
                dividend -= divisor;
                ans++;
            }
            return neg ? -ans : ans;
        }

        private static int reverseAbs(int a) {
            return (a < 0) ? a : -a;
        }

        public int divide2(int dividend, int divisor) {
            if (divisor == 1) return dividend;
            if (dividend == 1 << 31 && divisor == -1)
                return Integer.MAX_VALUE;
            if (dividend == divisor) return 1;

            boolean sign = dividend < 0 ^ divisor < 0;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            int ans = 0;
            while (dividend - divisor >= 0) {
                int count = 0;
                while (dividend - (divisor << 1 << count) >= 0) count++;
                ans += 1 << count;
                dividend -= divisor << count;
            }
            return sign ? -ans : ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int dividend = -10;
        int divisor = 2;
        Out.print(sol.divide(dividend, divisor));
        Out.print(sol.divide2(dividend, divisor));
    }
}
