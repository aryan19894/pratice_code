package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

public class WordSearch_medium_79 {
    static class Solution {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0))
                        return true;
                }
            }
            return false;
        }

        private boolean find(char[][] board, int i, int j, String word, int k) {
            if (k == word.length()) return true;
            if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '0') return false;

            char curr = word.charAt(k);
            if (board[i][j] != curr) return false;

            // visitor marking
            board[i][j] = '0';
            boolean match = false;
            for (int[] d : dir)
                match = match || find(board, i + d[0], j + d[1], word, k + 1);
            board[i][j] = curr;

            return match;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Out.print(sol.exist(board, word));
    }
}
