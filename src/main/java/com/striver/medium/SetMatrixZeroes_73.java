// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SetMatrixZeroes_73.java

package com.striver.medium;

import com.common.Obj;
import java.util.*;

public class SetMatrixZeroes_73
{
    static class Solution
    {

        public void setZeroes1(int matrix[][])
        {
            int row = matrix.length;
            int col = matrix[0].length;
            List zeroes = new ArrayList();
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                    if(matrix[i][j] == 0)
                        zeroes.add(new int[] {
                            i, j
                        });

            }

            for(Iterator iterator = zeroes.iterator(); iterator.hasNext();)
            {
                int z[] = (int[])iterator.next();
                for(int r = 0; r < col; r++)
                    matrix[z[0]][r] = 0;

                int c = 0;
                while(c < row) 
                {
                    matrix[c][z[1]] = 0;
                    c++;
                }
            }

        }

        public void setZeroes2(int matrix[][])
        {
            int r = matrix.length;
            int c = matrix[0].length;
            int row[] = new int[r];
            int col[] = new int[c];
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                    if(matrix[i][j] == 0)
                    {
                        row[i] = -1;
                        col[j] = -1;
                    }

            }

            for(int i = 0; i < matrix.length; i++)
            {
                for(int j = 0; j < matrix[0].length; j++)
                    if(row[i] == -1 || col[j] == -1)
                        matrix[i][j] = 0;

            }

        }

        public void setZeroes3(int matrix[][])
        {
            int r = matrix.length;
            int c = matrix[0].length;
            int col0 = 1;
            for(int i = 0; i < r; i++)
            {
                if(matrix[i][0] == 0)
                    col0 = 0;
                for(int j = 1; j < c; j++)
                    if(matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;

            }

            for(int i = r - 1; i >= 0; i--)
            {
                for(int j = c - 1; j >= 1; j--)
                    if(matrix[0][j] == 0 || matrix[i][0] == 0)
                        matrix[i][j] = 0;

                if(col0 == 0)
                    matrix[i][0] = 0;
            }

        }

        Solution()
        {
        }
    }


    public SetMatrixZeroes_73()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[][] = {
            {
                1, 2, 3, 4
            }, {
                5, 0, 7, 8
            }, {
                0, 10, 11, 12
            }, {
                13, 14, 15, 0
            }
        };
        sol.setZeroes3(nums);
        Obj.printArray(nums);
    }
}
