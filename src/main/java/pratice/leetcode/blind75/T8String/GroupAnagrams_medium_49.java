package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_medium_49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                String sorted = sort(str);
                map.putIfAbsent(sorted, new ArrayList<>());
                map.get(sorted).add(str);
            }
            return new ArrayList<>(map.values());
        }

        private String sort(String str) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Out.print(sol.groupAnagrams(strs));
    }
}
