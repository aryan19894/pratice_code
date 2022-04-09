package com.striver.DSAExperience.T14DP.TwoD_OnString.LIS;

import com.common.Out;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain_medium_1048 {
    static class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
            int n = words.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int p = 0; p < i; p++) {
                    if (isChain(words[i], words[p]))
                        dp[i] = Math.max(dp[i], 1 + dp[p]);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        private boolean isChain(String s1, String s2) {
            if (s1.length() != s2.length() + 1) return false;
            int i = 0, j = 0;
            while (i < s1.length()) {
                if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else i++;
            }
            return i == s1.length() && j == s2.length();
        }

        HashMap<Integer, Integer> map;
        int[] dp;

        public int longestStrChain2(String[] words) {
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
            int n = words.length;
            map = new HashMap<>();
            int val = 0;
            for (int i = 0; i < n; i++) {
                if (words[i].length() > val) {
                    val = words[i].length();
                    map.put(val, i);
                }
            }
            dp = new int[n];
            Arrays.fill(dp, -1);
            longestChain(words, n, 0);
            int res = Arrays.stream(dp).max().getAsInt();
            return res;
        }

        int longestChain(String[] words, int n, int i) {
            if (i == n) return 0;
            if (dp[i] != -1) return dp[i];
            char str[] = words[i].toCharArray();
            if (!map.containsKey(str.length + 1)) return dp[i] = 1;
            int j = map.get(str.length + 1);
            int size = str.length + 1, res = 0;
            for (; j < n && words[j].length() == size; ++j) {
                char cmp[] = words[j].toCharArray();
                if (isChain(str, cmp)) {
                    if (dp[j] != -1) res = Math.max(res, 1 + dp[j]);
                    else {
                        res = Math.max(res, 1 + longestChain(words, n, j));
                    }
                    dp[i] = res;
                } else dp[i] = Math.max(dp[i], 1);
            }
            longestChain(words, n, i + 1);
            return dp[i];
        }

        private boolean isChain(char[] str, char[] cmp) {
            return isChain(new String(cmp), new String(str));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //String[] words = {"a", "b", "bca", "ba", "bda", "bdca"};
        //String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        String[] words = {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr",
                "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        Out.print(sol.longestStrChain(words));
        Out.print(sol.longestStrChain2(words));
    }
}
