package com.leetcode.blind75.T8String;

import com.common.Out;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement_medium_424 {
    static class Solution {
        public int characterReplacement(String s, int k) {
            int n = s.length();
            int l = 0, r = 0;
            Map<Character, Integer> map = new HashMap<>();
            int maxLen = 0, maxFreq = 0;

            while (r < n) {
                char ch = s.charAt(r);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(ch));

                if ((r - l + 1 - maxFreq) > k) {
                    map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                    l++;
                }
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "AABABBA";
        int k = 1;
        Out.print(sol.characterReplacement(s, k));
    }
}
