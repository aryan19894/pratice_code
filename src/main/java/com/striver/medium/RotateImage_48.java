// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateImage_48.java

package com.striver.medium;

import com.common.Obj;
import com.common.Printer;

public class RotateImage_48
{
    public static void main(String[] args) {
        RotateImage_48.Solution sol = new RotateImage_48.Solution();
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.rotate(nums);
        Printer.print(nums);
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
