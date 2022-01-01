// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateImage_48.java

package com.striver.medium;

import com.common.Obj;

public class RotateImage_48
{
    static class Solution
    {

        public void rotate(int matrix[][])
        {
            for(int i = 0; i < matrix.length; i++)
            {
                for(int j = i; j < matrix[0].length; j++)
                {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }

            }

            for(int i = 0; i < matrix.length; i++)
            {
                int j = 0;
                for(int k = matrix[i].length - 1; j < k;)
                    swap(matrix[i], j++, k--);

            }

        }

        private static void swap(int arr[], int a, int b)
        {
            if(a != b)
            {
                int t = arr[a];
                arr[a] = arr[b];
                arr[b] = t;
            }
        }

        Solution()
        {
        }
    }


    public RotateImage_48()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[][] = {
            {
                1, 2, 3
            }, {
                4, 5, 6
            }, {
                7, 8, 9
            }
        };
        sol.rotate(nums);
        Obj.printArray(nums);
    }
}
