package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

public class ValidAnagram_easy_242 {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] container = new int[26];

            for (char ch : s.toCharArray())
                container[ch - 'a']++;

            for (char ch : t.toCharArray())
                container[ch - 'a']--;

            for (int val : container)
                if (val != 0) return false;

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";
        Out.print(sol.isAnagram(s, t));
    }
}

