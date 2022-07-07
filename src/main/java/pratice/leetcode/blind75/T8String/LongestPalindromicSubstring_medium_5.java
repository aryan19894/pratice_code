package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

public class LongestPalindromicSubstring_medium_5 {
    static class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int maxLength = 1;
            int start = 0;

            for (int i = 0; i < n; i++) dp[i][i] = true;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    start = i;
                    maxLength = 2;
                }
            }

            for (int currLen = 3; currLen <= n; currLen++) {
                for (int i = 0; i < n - currLen + 1; i++) {
                    int j = i + currLen - 1;

                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (maxLength < currLen) {
                            maxLength = currLen;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLength);
        }

        public String longestPalindrome2(String s) {
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int oddSubLen = expand(s, i, i);
                int evenSubLen = expand(s, i, i + 1);
                int len = Math.max(oddSubLen, evenSubLen);

                int currLen = end - start + 1;
                if (len > currLen) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expand(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "babad";
        Out.print(sol.longestPalindrome(s));
        Out.print(sol.longestPalindrome2(s));
        Out.print(sol.longestPalindrome(s));
    }
}
