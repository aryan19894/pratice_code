package pratice.leetcode.blind75.T2Binary;

import pratice.common.Out;

public class CountingBits_easy_338 {
    static class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int i = 0; i <= n; i++)
                result[i] = result[i / 2] + (i % 2);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        Out.print(sol.countBits(n));
    }
}
