package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBoggleDFS {
    static public class Solution {
        private static int[] di = {0, 0, 1, 1, 1, -1, -1, -1};
        private static int[] dj = {-1, 1, 0, 1, -1, 0, 1, -1};
        private static Set<String> EMPTY = new HashSet<>();
        Set<String> res = new HashSet<>();
        int maxLen = 0;

        public String[] wordBoggle(char board[][], String[] dictionary) {
            int n = board.length;
            int m = board[0].length;
            boolean[][] visited = new boolean[n][m];
            HashMap<Integer, Set<String>> lenMap = new HashMap<>();
            for (String dict : dictionary) {
                lenMap.putIfAbsent(dict.length(), new HashSet<>());
                lenMap.get(dict.length()).add(dict);
                maxLen = Math.max(maxLen, dict.length());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    findWordBoggle(board, i, j, lenMap, visited, "" + board[i][j], 1);
            }

            String[] result = new String[res.size()];
            int i = 0;
            for (String s : res)
                result[i++] = s;
            return result;
        }

        private void findWordBoggle(char[][] board, int i, int j, HashMap<Integer, Set<String>> dict,
                                    boolean[][] visited, String current, int strLen) {
            if (dict.getOrDefault(strLen, EMPTY).contains(current))
                res.add(current.toString());

            visited[i][j] = true;
            for (int k = 0; k < 8; k++) {
                int ci = i + di[k];
                int cj = j + dj[k];

                if (ci >= 0 && cj >= 0 && ci < board.length && cj < board[0].length
                        && !visited[ci][cj] && strLen <= maxLen - 1) {
                    findWordBoggle(board, ci, cj, dict, visited, current + board[ci][cj], strLen + 1);
                }
            }

            if (strLen > 1)
                current = current.substring(0, strLen - 1);
            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char board[][] = {{'d', 'd'},
                {'c', 'c'},
                {'b', 'f'},
                {'d', 'd'},
                {'c', 'd'}};
        String[] dictionary = {"ffb", "ccb", "b", "edc", "ddd", "cc"};
        Out.print(sol.wordBoggle(board, dictionary));
    }
}
