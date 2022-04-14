package com.leetcode.blind75.T7Matrix;

import com.common.Out;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_medium_54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int rStart = 0, cStart = 0;
            int rEnd = matrix.length - 1;
            int cEnd = matrix[0].length - 1;
            while (rStart <= rEnd && cStart <= cEnd) {
                //up
                for (int c = cStart; c <= cEnd; c++) result.add(matrix[rStart][c]);
                //right
                for (int r = rStart + 1; r <= rEnd; r++) result.add(matrix[r][cEnd]);
                if (rStart < rEnd && cStart < cEnd) {
                    //bottom
                    for (int c = cEnd - 1; c > cStart; c--) result.add(matrix[rEnd][c]);
                    //left
                    for (int r = rEnd; r > rStart; r--) result.add(matrix[r][cStart]);
                }
                rStart++;
                rEnd--;
                cStart++;
                cEnd--;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Out.print(sol.spiralOrder(matrix));
    }
}
