package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.*;

public class WordBreakIi_hard_140 {
    static class Solution {


        public List<String> wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            List<String> result = new ArrayList<>();
            find(s, 0, set, new ArrayList<>(), result);

            return result;
        }

        private void find(String str, int idx, HashSet<String> dict, ArrayList<String> path, List<String> res) {
            if (idx == str.length()) {
                res.add(String.join(" ", path));
                return;
            }

            for (int i = idx; i < str.length(); i++) {
                String sub = str.substring(idx, i + 1);
                if (dict.contains(sub)) {
                    path.add(sub);
                    find(str, i + 1, dict, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        System.out.println(sol.wordBreak(s, wordDict));
    }
}
