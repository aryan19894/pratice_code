package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

public class PalindromicSubstrings_medium_647 {
    static class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            int count = n;
            for (int i = 0; i < n; i++) dp[i][i] = true;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    count++;
                }
            }

            for (int currLen = 3; currLen <= n; currLen++) {
                for (int i = 0; i < n - currLen + 1; i++) {
                    int j = i + currLen - 1;

                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
            return count;
        }

        public int countSubstrings2(String s) {
            int n = s.length();
            int[] count = {0};

            for (int i = 0; i < n; i++) {
                expand(s, i, i, count);
                expand(s, i, i + 1, count);
            }
            return count[0];
        }

        private void expand(String s, int l, int r, int[] count) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count[0]++;
                l--;
                r++;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        Out.print(sol.countSubstrings(s));
        Out.print(sol.countSubstrings2(s));
    }
}
