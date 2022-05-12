// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SearchA2DMatrix_74.java

package pratice.striver.DSAExperience.T1Array;

public class SearchA2DMatrix_Medium_74 {
    static class Solution {

        public boolean searchMatrix1(int matrix[][], int target) {
            boolean res = false;
            for (int i = 0; i < matrix.length && !res; i++)
                res = search(matrix[i], target);

            return res;
        }

        private boolean search(int matrix[], int target) {
            return binarySearch(matrix, 0, matrix.length - 1, target);
        }

        private boolean binarySearch(int matrix[], int low, int high, int target) {
            if (high >= low) {
                int mid = low + (high - low) / 2;
                if (matrix[mid] == target)
                    return true;
                if (matrix[mid] > target)
                    return binarySearch(matrix, low, mid - 1, target);
                else
                    return binarySearch(matrix, mid + 1, high, target);
            } else {
                return false;
            }
        }

        public boolean searchMatrix2(int matrix[][], int target) {
            int i = 0;
            for (int j = matrix[0].length - 1; i < matrix.length && j >= 0; )
                if (matrix[i][j] > target)
                    j--;
                else if (matrix[i][j] < target)
                    i++;
                else
                    return true;

            return false;
        }

        public boolean searchMatrix3(int matrix[][], int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            if (n == 0)
                return false;
            int low = 0;
            for (int high = n * m - 1; low <= high; ) {
                int mid = low + (high - low) / 2;
                if (matrix[mid / m][mid % m] == target)
                    return true;
                if (matrix[mid / m][mid % m] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return false;
        }

        private boolean binarySearchOn2D(int matrix[][], int target, int col, int low, int high) {
            if (high >= low) {
                int mid = low + (high - low) / 2;
                if (matrix[mid / col][mid % col] == target)
                    return true;
                if (matrix[mid / col][mid % col] > target)
                    return binarySearchOn2D(matrix, target, col, low, mid - 1);
                else
                    return binarySearchOn2D(matrix, target, col, mid + 1, high);
            } else {
                return false;
            }
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        int nums[][] = {
                {
                        1, 3, 5, 7
                }, {
                10, 11, 16, 20
        }, {
                23, 30, 34, 60
        }
        };
        System.out.println(sol.searchMatrix3(nums, 3));
    }
}
