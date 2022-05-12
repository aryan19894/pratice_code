package pratice.striver.DSAExperience.T7RecursionBacktracking;/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

import pratice.common.Out;

// @lc code=start
public class SudokuSolver_hard_37 {
    static class Solution {
        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0)
                return;
            solve(board);
        }

        private boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c; //Put c for this cell
                                if (solve(board))
                                    return true; //If it's the solution return true
                                else
                                    board[i][j] = '.'; //Otherwise go back
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                //check row
                if (board[i][col] != '.' && board[i][col] == c) return false;
                //check column
                if (board[row][i] != '.' && board[row][i] == c) return false;
                //check 3*3 block
                int rowi = 3 * (row / 3) + i / 3;
                int colj = 3 * (col / 3) + i % 3;
                if (board[rowi][colj] != '.' && board[rowi][colj] == c) return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution sol = new Solution();
        sol.solveSudoku(board);
        Out.print(board);
    }
}

// @lc code=end

