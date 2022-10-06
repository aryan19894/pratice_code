package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

public class SudokuSolver_hard_37 {
    static class Solution {
        private final char DOT = '.';

        public void solveSudoku(char[][] board) {
            solve(board);
        }

        private boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == DOT) {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (solve(board)) return true;
                                else board[i][j] = DOT;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i <= 8; i++) {
                if (board[row][i] == c) return false;
                if (board[i][col] == c) return false;
                if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sol.solveSudoku(board);
        Out.print(board);
    }
}
