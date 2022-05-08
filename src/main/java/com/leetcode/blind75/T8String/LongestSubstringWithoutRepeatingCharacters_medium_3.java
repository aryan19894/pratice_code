package com.leetcode.blind75.T8String;

import com.common.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters_medium_3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Queue<Character> q = new LinkedList<>();
            int len = 0;
            for (char ch : s.toCharArray()) {
                while (q.contains(ch)) q.poll();
                q.offer(ch);
                len = Math.max(len, q.size());
            }
            return len;
        }

        public int lengthOfLongestSubstring2(String s) {
            HashSet<Character> set = new HashSet<>();
            int len = 0;
            int rl = 0, acq = 0;
            for (char ch : s.toCharArray()) {
                while (set.contains(ch)) set.remove(s.charAt(rl++));
                set.add(ch);
                len = Math.max(len, (acq - rl) + 1);
                acq++;
            }
            return len;
        }

        public int lengthOfLongestSubstring3(String s) {
            HashMap<Character, Integer> idx = new HashMap<>();
            int maxLen = 0;
            int rightMost = -1;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (idx.containsKey(ch))
                    rightMost = Math.max(rightMost, idx.get(ch));
                idx.put(ch, i);
                maxLen = Math.max(maxLen, i - rightMost);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "pwwkew";
        Out.print(sol.lengthOfLongestSubstring(s));
        Out.print(sol.lengthOfLongestSubstring2(s));
        Out.print(sol.lengthOfLongestSubstring3(s));
    }
}
