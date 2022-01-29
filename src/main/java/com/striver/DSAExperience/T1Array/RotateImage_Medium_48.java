package com.striver.DSAExperience.T1Array;

import com.common.Out;

public class RotateImage_Medium_48
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.rotate(nums);
        Out.print(nums);
    }

    static class Solution {
        Solution() {
        }

        public void rotate(int[][] matrix) {
            int i;
            int j;
            int k;
            for(i = 0; i < matrix.length; ++i) {
                for(j = i; j < matrix[0].length; ++j) {
                    k = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = k;
                }
            }

            for(i = 0; i < matrix.length; ++i) {
                j = 0;
                k = matrix[i].length - 1;

                while(j < k) {
                    swap(matrix[i], j++, k--);
                }
            }

        }

        private static void swap(int[] arr, int a, int b) {
            if (a != b) {
                int t = arr[a];
                arr[a] = arr[b];
                arr[b] = t;
            }

        }
    }
}
