package pratice.striver.DSAExperience.T7RecursionBacktracking;/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_medium_131 {
    static class Solution {
        // [Optimal] TC: O(2powN*K) - K - process time for putting a data structure into another ds.
        // SC: O(K*X) - K - assuming that K is average length and X would be combinations.
        public List<List<String>> partition(String s) {
            if (s == null || s.length() < 1) {
                return null;
            }
            List<List<String>> result = new ArrayList();
            findPartition(0, s, result, new ArrayList<>());
            return result;
        }

        private void findPartition(int idx, String s, List<List<String>> result,
                                   ArrayList<String> list) {
            if (idx == s.length()) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = idx; i < s.length(); i++) {
                if (isPalindrome(s, idx, i)) {
                    list.add(s.substring(idx, i + 1));
                    findPartition(i + 1, s, result, list);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start <= end) {
                if (s.charAt(start++) != s.charAt(end--))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> res = sol.partition("abb");
        Out.print(res);
    }
}
// @lc code=end

