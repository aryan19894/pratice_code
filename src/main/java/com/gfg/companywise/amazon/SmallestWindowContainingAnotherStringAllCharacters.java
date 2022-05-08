package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingAnotherStringAllCharacters {
    static final int noOfChar = 128;

    public static String smallestWindow3(String s, String p) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int i = 0, minLen = Integer.MAX_VALUE, count = map.size(), startIdx = -1;
        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) count--;
            }
            while (count == 0) {
                int currWinSize = j - i + 1;
                if (minLen > currWinSize) {
                    minLen = currWinSize;
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
        return startIdx == -1 ? "-1" : s.substring(startIdx, startIdx + minLen);
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";
        Out.print(smallestWindow3(s, p));
    }
}
