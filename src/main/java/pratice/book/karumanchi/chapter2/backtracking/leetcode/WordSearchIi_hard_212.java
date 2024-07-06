package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.*;

public class WordSearchIi_hard_212 {
    static class Solution {
        static class Dict {
            private HashMap<Character, HashSet<String>> map;

            public Dict(String[] wordDict) {
                map = new HashMap<>();

                for (String s : wordDict)
                    this.add(s);
            }

            public void add(String data) {
                char key = data.charAt(0);
                if (!this.map.containsKey(key))
                    this.map.put(key, new HashSet<>());
                this.map.get(key).add(data);
            }

            public HashSet<String> getOrDefault(char cell) {
                return this.map.getOrDefault(cell, new HashSet<>());
            }
        }

        Set<String> dict = new HashSet<>();
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public List<String> findWords(char[][] board, String[] wordDict) {
            int maxWordLength = 0;
            for (String word : wordDict) {
                dict.add(word);
                maxWordLength = Math.max(maxWordLength, word.length());
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++)
                    find(board, i, j, 0, maxWordLength);
            }

            return new ArrayList<>(result);
        }

        private void find(char[][] board, int i, int j, int count, int maxWordLength) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
            if (count >= maxWordLength || board[i][j] == '0') return;

            sb.append(board[i][j]);
            board[i][j] = '0';
            if (dict.contains(sb.toString()))
                result.add(new String(sb));

            for (int[] d : dir)
                find(board, i + d[0], j + d[1], count + 1, maxWordLength);
            board[i][j] = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }


//        private boolean find(char[][] board, int i, int j, String word, int k) {
//            if (k == word.length()) return true;
//            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0') return false;
//
//            char curr = word.charAt(k);
//            if (board[i][j] != curr) return false;
//
//            board[i][j] = '0';
//            boolean match = false;
//            for (int[] d : dir)
//                match |= find(board, i + d[0], j + d[1], word, k + 1);
//            board[i][j] = curr;
//
//            return match;
//        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = {"oa", "oaa"};
        Out.print(sol.findWords(board, words));
    }
}
