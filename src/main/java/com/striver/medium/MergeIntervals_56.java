// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeIntervals_56.java

package com.striver.medium;

import com.common.Obj;

public class MergeIntervals_56
{
    /* member class not found */
    class Solution {}


    public MergeIntervals_56()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[][] = {
            {
                1, 3
            }, {
                2, 6
            }, {
                8, 10
            }, {
                15, 18
            }
        };
        int ans[][] = sol.merge2(nums);
        Obj.printArray(ans, true);
    }
}
