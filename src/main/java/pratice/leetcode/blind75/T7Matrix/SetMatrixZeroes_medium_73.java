package pratice.leetcode.blind75.T7Matrix;

import pratice.common.Out;

public class SetMatrixZeroes_medium_73 {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            boolean col0 = true;

            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) col0 = false;
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 1; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
                if (!col0) matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        sol.setZeroes(matrix);
        Out.print(matrix);
    }
}
