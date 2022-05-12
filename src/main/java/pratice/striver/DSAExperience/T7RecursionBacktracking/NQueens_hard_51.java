package pratice.striver.DSAExperience.T7RecursionBacktracking;/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
public class NQueens_hard_51 {
    static class Solution {
        // [Better Recursive] TC: O(n2), SC: O(n)
        // Iterating row wise and find perfect place for queen at each row
        public List<List<String>> solveNQueens1(int n) {
            if (n == 0) return null;
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(board[i], '.');

            List<List<String>> result = new ArrayList();
            findNQueens(0, board, result);
            return result;
        }

        private void findNQueens(int row, char[][] board, List<List<String>> result) {
            if (row == board.length) {
                ArrayList<String> ds = new ArrayList<>();
                for (char[] b : board) {
                    ds.add(new String(b));
                }
                result.add(new ArrayList<>(ds));
                return;
            }

            for (int col = 0; col < board[0].length; col++) {
                if (isQueenAtSafePlace(board, row, col)) {
                    board[row][col] = 'Q';
                    findNQueens(row + 1, board, result);
                    board[row][col] = '.';
                }
            }
        }

        private boolean isQueenAtSafePlace(char[][] nums, int row, int col) {
            int duprow = row;
            int dupcol = col;

            //forward diagonal wise
            while (row >= 0 && col >= 0)
                if (nums[row--][col--] == 'Q')
                    return false;

            //backward diagonal wise
            row = duprow;
            col = dupcol;
            while (row >= 0 && col < nums[0].length)
                if (nums[row--][col++] == 'Q')
                    return false;

            //row wise
            row = duprow;
            col = dupcol;
            while (row >= 0)
                if (nums[row--][col] == 'Q')
                    return false;

            return true;
        }

        // [Optimal Recursive] TC: O(n), SC: O(n)
        // Iterating col wise and optimize the choose process of safe place for queen on board
        public List<List<String>> solveNQueens2(int n) {
            if (n == 0) return null;
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(board[i], '.');

            List<List<String>> res = new ArrayList();
            int leftRow[] = new int[n];
            int upperDiagonal[] = new int[2 * n - 1];
            int lowerDiagonal[] = new int[2 * n - 1];
            findNQueens(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
            return res;
        }

        private void findNQueens(int col, char[][] board, List<List<String>> res,
                                 int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
            if (col == board.length) {
                ArrayList<String> ds = new ArrayList<>();
                for (char[] b : board) {
                    ds.add(new String(b));
                }
                res.add(new ArrayList<>(ds));
                return;
            }

            for (int row = 0; row < board.length; row++) {
                if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 &&
                        upperDiagonal[board.length - 1 + col - row] == 0) {
                    board[row][col] = 'Q';
                    leftRow[row] = 1;
                    lowerDiagonal[row + col] = 1;
                    upperDiagonal[board.length - 1 + col - row] = 1;

                    findNQueens(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                    board[row][col] = '.';
                    leftRow[row] = 0;
                    lowerDiagonal[row + col] = 0;
                    upperDiagonal[board.length - 1 + col - row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> res = sol.solveNQueens1(4);
        Out.print(res);
        res = sol.solveNQueens2(4);
        Out.print(res);

    }
}

// @lc code=end

