// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PascalsTriangleIi_119.java

package com.striver.easy;

import com.common.Obj;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi_119
{
    static class Solution
    {

        public List getRow(int rowIndex)
        {
            int val = 1;
            long factor = 1L;
            List row = new ArrayList();
            for(int i = 0; i <= rowIndex; i++)
            {
                row.add(Integer.valueOf(val));
                factor *= rowIndex - i;
                factor /= i + 1;
                val = (int)factor;
            }

            return row;
        }

        Solution()
        {
        }
    }


    public PascalsTriangleIi_119()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        List ans = sol.getRow(4);
        Obj.printList(ans);
    }
}
