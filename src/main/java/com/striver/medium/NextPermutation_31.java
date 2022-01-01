// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NextPermutation_31.java

package com.striver.medium;

import com.common.Obj;

public class NextPermutation_31
{
    static class Solution
    {

        public void nextPermutation(int nums[])
        {
            int n = nums.length;
            if(nums == null || n <= 1)
                return;
            int i;
            for(i = n - 2; i >= 0 && nums[i] >= nums[i + 1]; i--);
            if(i >= 0)
            {
                int j;
                for(j = n - 1; nums[j] <= nums[i]; j--);
                Obj.swap(nums, i, j);
            }
            reverse(nums, i + 1, n - 1);
        }

        public static void reverse(int a[], int i, int j)
        {
            while(i < j) 
                Obj.swap(a, i++, j--);
        }

        Solution()
        {
        }
    }


    public NextPermutation_31()
    {
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[] = {
            1, 3, 5, 4, 2
        };
        sol.nextPermutation(nums);
        Obj.printArray(nums);
    }
}
