package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.HashSet;
import java.util.Set;

public class WordBoggleTrie {
    static public class Solution {
        public static char UNIT_CHAR = 'a';
        static class TrieNode {
            TrieNode[] links = new TrieNode[26];
            boolean flag = false;

            public boolean containKey(char ch) {
                return links[ch - UNIT_CHAR] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - UNIT_CHAR];
            }

            public void put(char ch, TrieNode node) {
                links[ch - UNIT_CHAR] = node;
            }

            private int getIndex(char ch) {
                return Character.isLowerCase(ch) ? ch - 'a' : ch - 'A';
            }

            public void setEnd() {
                flag = true;
            }

            public boolean isEnd() {
                return flag;
            }
        }

        private static int[] di = {0, 0, 1, 1, 1, -1, -1, -1};
        private static int[] dj = {-1, 1, 0, 1, -1, 0, 1, -1};
        Set<String> res = new HashSet<>();

        public String[] wordBoggle(char board[][], String[] dictionary) {
            TrieNode root = new TrieNode();
            for (String dict : dictionary) {
                UNIT_CHAR = Character.isLowerCase(dict.charAt(0)) ? 'a' : 'A';
                insertToTrie(root, dict);
            }

            TrieNode pChild = root;
            int n = board.length;
            int m = board[0].length;
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char ch = board[i][j];
                    if (pChild.containKey(ch))
                        searchWord(pChild.get(ch), board, i, j, visited, "" + ch);
                }
            }

            String[] result = new String[res.size()];
            int i = 0;
            for (String s : res)
                result[i++] = s;
            return result;
        }

        private void searchWord(TrieNode node, char[][] board, int i, int j, boolean[][] visited, String current) {
            if (node.isEnd())
                res.add(current);

            visited[i][j] = true;
            for (int K = 0; K < 26; K++) {
                char curr = (char) (K + UNIT_CHAR);
                if (node.containKey(curr)) {
                    for (int k = 0; k < 8; k++) {
                        int ci = i + di[k];
                        int cj = j + dj[k];

                        if (ci >= 0 && cj >= 0 && ci < board.length && cj < board[0].length
                                && !visited[ci][cj] && board[ci][cj] == curr) {
                            searchWord(node.get(curr), board, ci, cj, visited, current + curr);
                        }
                    }
                }
            }
            visited[i][j] = false;
        }

        private void insertToTrie(TrieNode root, String dict) {
            TrieNode pChild = root;
            for (char ch : dict.toCharArray()) {
                if (!pChild.containKey(ch))
                    pChild.put(ch, new TrieNode());
                pChild = pChild.get(ch);
            }
            pChild.setEnd();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        char board[][] = {{'d', 'd'},
//                {'c', 'c'},
//                {'b', 'f'},
//                {'d', 'd'},
//                {'c', 'd'}};
        char board[][] = {{'C', 'A', 'P'}, {'A', 'N', 'D'}, {'T', 'I', 'E'}};
        String[] dictionary = {"CAT"};
        Out.print(sol.wordBoggle(board, dictionary));
    }
}
