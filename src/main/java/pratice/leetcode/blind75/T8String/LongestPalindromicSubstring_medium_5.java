package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

public class LongestPalindromicSubstring_medium_5 {
    static class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int maxLength = 0, startIdx = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    boolean isMatch = s.charAt(j) == s.charAt(i);
                    if (j == i) dp[j][i] = true;
                    else if (j == i - 1) dp[j][i] = isMatch;
                    else dp[j][i] = isMatch && dp[j + 1][i - 1];

                    int currLen = i - j + 1;
                    if (dp[j][i] && currLen > maxLength) {
                        maxLength = currLen;
                        startIdx = j;
                    }
                }
            }
            return s.substring(startIdx, startIdx + maxLength);
        }

        public String longestPalindrome2(String s) {
            StringBuffer sb = new StringBuffer();
            lcs(s, s.length() - 1, 0, sb, 0);
            return new String(sb);
        }

        private int lcs(String s, int i, int j, StringBuffer sb, int count) {
            if (i == 0 || j == s.length()) return count;

            if (s.charAt(i) == s.charAt(j))
                count = lcs(s, i - 1, j + 1, sb.append(s.charAt(i)), count + 1);
            else {
//                lcs(s, i - 1, j, sb);
//                lcs(s, i, j + 1, sb);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "babad";
//        Out.print(sol.longestPalindrome(s));
        Out.print(sol.longestPalindrome2(s));
    }
}
