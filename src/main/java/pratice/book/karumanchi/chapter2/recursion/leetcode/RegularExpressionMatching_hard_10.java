package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.common.Out;

public class RegularExpressionMatching_hard_10 {
    static class Solution {
        private final char DOT = '.';
        private final char AST = '*';

        public boolean isMatch(String s, String p) {
            if (p == null || p.length() == 0) return s == null || s.length() == 0;
            return isMatch(s, 0, p, 0);
        }

        private boolean isMatch(String s, int si, String p, int pi) {
            if (pi == p.length()) return si == s.length();

            boolean charMatch = si < s.length() && s.charAt(si) == p.charAt(pi) || p.charAt(pi) == DOT;
            if (pi + 1 < p.length() && p.charAt(pi + 1) == AST) {
                if (isMatch(s, si, p, pi + 2)) return true;
                if (si < s.length() && charMatch) return isMatch(s, si + 1, p, pi);
            } else if (si < s.length() && charMatch)
                return isMatch(s, si + 1, p, pi + 1);

            return false;
        }

        public boolean isMatch2(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            if (p == null || pLen == 0) return s == null || sLen == 0;

            boolean baseMatch = sLen > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == DOT);
            if (pLen > 1 && p.charAt(1) == AST)
                return isMatch(s, p.substring(2)) || (baseMatch && isMatch(s.substring(1), p));
            else if (baseMatch)
                return isMatch(s.substring(1), p.substring(1));
            return false;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ab";
        String p = ".*c";
        Out.print(sol.isMatch(s, p));
        Out.print(sol.isMatch2(s, p));
    }
}
