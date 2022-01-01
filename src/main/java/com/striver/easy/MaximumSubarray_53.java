// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MaximumSubarray_53.java

package com.striver.easy;

import java.io.PrintStream;

// Referenced classes of package com.striver.easy:
//            Solution

public class MaximumSubarray_53
{

    public MaximumSubarray_53()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[] = {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        int ans = sol.maxSubArray4(nums);
        System.out.println(ans);
    }
}
