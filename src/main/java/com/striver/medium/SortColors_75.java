// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SortColors_75.java

package com.striver.medium;

import java.io.PrintStream;
import java.util.Arrays;

// Referenced classes of package com.striver.medium:
//            Solution

public class SortColors_75
{

    public SortColors_75()
    {
    }

    public static void main(String args[])
    {
        int nums[] = {
            0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 
            0, 1
        };
        Solution sol = new Solution();
        sol.sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
