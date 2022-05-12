// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SetMatrixZeroes_73_Medium.java

package pratice.striver.DSAExperience.T1Array;

import pratice.common.Out;

import java.util.*;

public class SetMatrixZeroes_73_Medium {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        sol.setZeroes3(nums);
        Out.print(nums);
    }

    static class Solution {
        Solution() {
        }

        public void setZeroes1(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            List<int[]> zeroes = new ArrayList();

            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (matrix[i][j] == 0) {
                        zeroes.add(new int[]{i, j});
                    }
                }
            }

            Iterator var8 = zeroes.iterator();

            while (var8.hasNext()) {
                int[] z = (int[]) var8.next();

                int c;
                for (c = 0; c < col; ++c) {
                    matrix[z[0]][c] = 0;
                }

                for (c = 0; c < row; ++c) {
                    matrix[c][z[1]] = 0;
                }
            }

        }

        public void setZeroes2(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;
            int[] row = new int[r];
            int[] col = new int[c];

            int i;
            int j;
            for (i = 0; i < r; ++i) {
                for (j = 0; j < c; ++j) {
                    if (matrix[i][j] == 0) {
                        row[i] = -1;
                        col[j] = -1;
                    }
                }
            }

            for (i = 0; i < matrix.length; ++i) {
                for (j = 0; j < matrix[0].length; ++j) {
                    if (row[i] == -1 || col[j] == -1) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }

        public void setZeroes3(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;
            boolean col0 = true;

            int i;
            int j;
            for (i = 0; i < r; ++i) {
                if (matrix[i][0] == 0) {
                    col0 = false;
                }

                for (j = 1; j < c; ++j) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }

            for (i = r - 1; i >= 0; --i) {
                for (j = c - 1; j >= 1; --j) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }

                if (!col0) {
                    matrix[i][0] = 0;
                }
            }

        }
    }
}
