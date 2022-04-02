package com.leetcode.blind75.T3DP;

import com.common.Out;
import com.common.converter.Array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_medium_139 {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return check(s, new HashSet<String>(wordDict));
        }

        private boolean check(String str, HashSet<String> dict) {
            int n = str.length();
            if (n == 0) return true;

            for (int i = 1; i <= n; i++) {
                if (dict.contains(str.substring(0, i)) && check(str.substring(i, n), dict))
                    return true;
            }
            return false;
        }

        public boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>();
            for (String w : wordDict)
                dict.add(w);

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "leetcode";
        List<String> wordDict = Array.toList(new String[]{"leet", "code"});
        Out.print(sol.wordBreak(s, wordDict));
        Out.print(sol.wordBreak2(s, wordDict));
    }
}
