package com.leetcode.blind75.T7Matrix;

import com.common.Out;

public class RotateImage_medium_48 {
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            transpose(matrix, n, m);
            reverse(matrix, n, m);
        }

        private void transpose(int[][] matrix, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < m; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        private void reverse(int[][] matrix, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][m-1-j];
                    matrix[i][m-1-j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {7, 8, 9}};
        //int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        sol.rotate(matrix);
        Out.print(matrix);
    }
}
