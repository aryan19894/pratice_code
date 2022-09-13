package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.common.Out;

public class WildcardMatching_hard_44 {
    static class Solution {
        private final char WILD = '?';
        private final char STAR = '*';

        public boolean isMatch(String s, String p) {
            if (p == null || p.length() == 0) return s == null || s.length() == 0;
            return isMatch(s, s.length(), p, p.length());
        }

        private boolean isMatch(String s, int si, String p, int pi) {
            if (si == 0 && pi == 0) return true;
            if (pi == 0) return false;
            if (si == 0) {
                for (int pii = 1; pii <= pi; pii++)
                    if (p.charAt(pii - 1) != STAR) return false;
                return true;
            }

            if (s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == WILD)
                return isMatch(s, si - 1, p, pi - 1);
            else if (p.charAt(pi - 1) == STAR)
                return isMatch(s, si, p, pi - 1) || isMatch(s, si - 1, p, pi);
            return false;
        }

//        private boolean isMatch(String s, int si, String p, int pi) {
//            if (si == s.length() && pi == p.length()) return true;
//            if (pi == p.length()) return false;
//            if (si == s.length()) {
//                for (int pii = pi; pii < p.length(); pii++)
//                    if (p.charAt(pii) != STAR) return false;
//                return true;
//            }
//
//            if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == WILD)
//                return isMatch(s, si + 1, p, pi + 1);
//            else if (p.charAt(pi) == STAR)
//                return isMatch(s, si, p, pi + 1) || isMatch(s, si + 1, p, pi);
//            return false;
//        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aa";
        String p = "*";
        Out.print(sol.isMatch(s, p));
    }
}
