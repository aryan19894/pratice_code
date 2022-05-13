package pratice.leetcode.prev.facebook.hard;

import pratice.common.Out;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    static class Solution {
        public String minWindow(String s, String t) {
            int n = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : t.toCharArray())
                map.put(ch, map.getOrDefault(ch, 0) + 1);

            int i = 0, minLen = Integer.MAX_VALUE, count = map.size(), startIdx = -1;
            for (int j = 0; j < n; j++) {
                char ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) count--;
                }
                while (count == 0) {
                    int currWindowSize = j - i + 1;
                    if (minLen > currWindowSize) {
                        minLen = currWindowSize;
                        startIdx = i;
                    }
                    char winCh = s.charAt(i);
                    i++;
                    if (map.containsKey(winCh)) {
                        if (map.get(winCh) == 0) count++;
                        map.put(winCh, map.get(winCh) + 1);
                    }
                }
            }
            return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Out.print(sol.minWindow(s, t));
    }
}
