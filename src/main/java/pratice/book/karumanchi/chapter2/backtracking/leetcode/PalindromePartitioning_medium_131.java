package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_medium_131 {
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            ArrayList<String> path = new ArrayList<>();
            find(s, 0, path, res);
            return res;
        }

        private void find(String s, int idx, ArrayList<String> path, List<List<String>> res) {
            if (idx == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = idx; i < s.length(); i++) {
                if (isPalindrome(s, idx, i)) {
                    path.add(s.substring(idx, i + 1));
                    find(s, i + 1, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str, int l, int r) {
            if (l == r || r - l == 0) return true;
            if (str.charAt(l) != str.charAt(r)) return false;

            if (l < r + 1)
                return isPalindrome(str, l + 1, r - 1);
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aaabba";
        Out.print(sol.partition(s));
    }
}
