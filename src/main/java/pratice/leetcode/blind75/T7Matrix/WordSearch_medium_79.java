package pratice.leetcode.blind75.T7Matrix;

import pratice.common.Out;

public class WordSearch_medium_79 {
    static class Solution {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited;
        private int n, m;

        public boolean exist(char[][] board, String word) {
            n = board.length;
            m = board[0].length;
            if (board == null || n == 0 || word == null || word.isEmpty()) return false;

            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                        return true;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int idx) {
            if (idx == word.length()) return true;
            if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j]) return false;
            if (board[i][j] != word.charAt(idx)) return false;

            if (board[i][j] == word.charAt(idx)) {
                visited[i][j] = true;
                boolean res = false;
                for (int k = 0; k < 4; k++) {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    res |= dfs(board, word, r, c, idx + 1);
                }
                visited[i][j] = false;
                return res;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'A'}};
        String word = "A";
        Out.print(sol.exist(board, word));
    }
}
