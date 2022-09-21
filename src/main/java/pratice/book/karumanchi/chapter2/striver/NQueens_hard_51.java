package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_hard_51 {
    static class Solution {
        private final char Q = 'Q';
        private final char DOT = '.';

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] m : board)
                Arrays.fill(m, '.');

            find(board, 0, n, result);
            return result;
        }

        private void find(char[][] board, int i, int n, List<List<String>> res) {
            if (i == n) {
                ArrayList<String> ds = new ArrayList<>();
                for (char[] m : board)
                    ds.add(new String(m));
                res.add(new ArrayList<>(ds));
                return;
            }

            for (int j = 0; j < n; j++) {
                if (isQueenAtSafePlace(board, i, j, n)) {
                    board[i][j] = Q;
                    find(board, i + 1, n, res);
                    board[i][j] = DOT;
                }
            }
        }

        private boolean isQueenAtSafePlace(char[][] board, int i, int j, int n) {
            int di = i, dj = j;

            //forward diagonal
            while (i >= 0 && j >= 0)
                if (board[i--][j--] == Q) return false;

            //backward diagonal
            i = di;
            j = dj;
            while (i >= 0 && j < n)
                if (board[i--][j++] == Q) return false;

            //row wise
            i = di;
            j = dj;
            while (i >= 0)
                if (board[i--][j] == Q) return false;

            return true;
        }

    }

    static class Solution1 {
        private final char Q = 'Q';
        private final char DOT = '.';
        private boolean[] upCol;
        private boolean[] lowerDiagonal; // row+col
        private boolean[] upperDiagonal; // n-1-row + col - reverse counting n-1-row

        public List<List<String>> solveNQueens(int n) {
            upCol = new boolean[n];
            lowerDiagonal = new boolean[2 * n - 1];
            upperDiagonal = new boolean[2 * n - 1];
            List<List<String>> result = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] m : board)
                Arrays.fill(m, '.');

            find(board, 0, n, result);
            return result;
        }

        private void find(char[][] board, int row, int n, List<List<String>> res) {
            if (row == n) {
                ArrayList<String> ds = new ArrayList<>();
                for (char[] m : board)
                    ds.add(new String(m));
                res.add(new ArrayList<>(ds));
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isQueenAtSafePlace(row, col, n)) {
                    board[row][col] = Q;
                    updateHashData(row, col, n, true);
                    find(board, row + 1, n, res);
                    board[row][col] = DOT;
                    updateHashData(row, col, n, false);
                }
            }
        }

        private void updateHashData(int row, int col, int n, boolean val) {
            upCol[col] = val;
            lowerDiagonal[row + col] = val;
            upperDiagonal[n - 1 - row + col] = val;
        }

        private boolean isQueenAtSafePlace(int row, int col, int n) {
            return !upCol[col] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 - row + col];
        }

    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int n = 4;
        Out.print(sol.solveNQueens(n));
    }
}
