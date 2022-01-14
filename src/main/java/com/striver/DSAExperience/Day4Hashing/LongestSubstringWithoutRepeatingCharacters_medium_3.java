package com.striver.DSAExperience.Day4Hashing;/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

import com.common.Obj;

import java.util.HashMap;
import java.util.HashSet;

// @lc code=start
public class LongestSubstringWithoutRepeatingCharacters_medium_3 {
    static class Solution {
        // [Brute] O(n3) - find each subarray and verify its longest substring - Kdane algo
        // [Better] TC: O(2n), SC: O(n) - work with hashset with 2 pointer technique
        public int lengthOfLongestSubstring1(String s) {
            HashSet<Character> set = new HashSet<>();
            int l = 0;
            int r = 0;
            int len = 0;
            while (r < s.length()) {
                char ch = s.charAt(r);
                while (set.contains(ch)) {
                    set.remove(s.charAt(l++));
                }
                set.add(ch);
                len = Math.max(len, (r - l + 1));
                r++;
            }
            return len;
        }

        // [Optimal] TC: O(n)Exact, SC: O(n) - work with hashmap store prev character index with 2 pointer technique
        public int lengthOfLongestSubstring2(String s) {
            HashMap<Character, Integer> set = new HashMap<>();
            int l = 0;
            int r = 0;
            int len = 0;
            while (r < s.length()) {
                char ch = s.charAt(r);
                if (set.containsKey(ch) && set.get(ch) >= l)
                    l = Math.max(l, (set.get(ch) + 1));
                len = Math.max(len, (r - l + 1));
                set.put(ch, r++);
            }
            return len;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring1("abcaabcdba"));
        System.out.println(sol.lengthOfLongestSubstring2("abcaabcdba"));
    }
}

// @lc code=end

