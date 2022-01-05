// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PascalsTriangle_118.java

package com.striver.easy;

import com.common.Obj;
import com.common.Printer;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118
{
    static class Solution
    {

        public List generate(int numRows)
        {
            List res = new ArrayList();
            List pre = null;
            for(int i = 0; i < numRows; i++)
            {
                List row = new ArrayList();
                for(int j = 0; j <= i; j++)
                    if(j == 0 || j == i)
                        row.add(Integer.valueOf(1));
                    else
                        row.add(Integer.valueOf(((Integer)pre.get(j - 1)).intValue() + ((Integer)pre.get(j)).intValue()));

                pre = row;
                res.add(row);
            }

            return res;
        }

        Solution()
        {
        }
    }


    public PascalsTriangle_118()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        List ans = sol.generate(8);
        Printer.print(ans);
    }
}
