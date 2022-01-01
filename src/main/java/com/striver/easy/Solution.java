// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MaximumSubarray_53.java

package com.striver.easy;


class Solution
{

    Solution()
    {
    }

    public int maxSubArray1(int nums[])
    {
        int maxSum = 0x80000000;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i; j < nums.length; j++)
            {
                int sum = 0;
                for(int k = i; k <= j; k++)
                    sum += nums[k];

                maxSum = Math.max(maxSum, sum);
            }

        }

        return maxSum;
    }

    public int maxSubArray2(int nums[])
    {
        int maxSum = 0x80000000;
        for(int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for(int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }

        }

        return maxSum;
    }

    public int maxSubArray3(int nums[])
    {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int nums[], int l, int h)
    {
        if(l == h)
        {
            return nums[l];
        } else
        {
            int m = (l + h) / 2;
            return Math.max(Math.max(maxSubArray(nums, l, m), maxSubArray(nums, m + 1, h)), maxCrossingSum(nums, l, m, h));
        }
    }

    private int maxCrossingSum(int nums[], int l, int m, int h)
    {
        int sum = 0;
        int left = 0x80000000;
        for(int i = m; i >= l; i--)
        {
            sum += nums[i];
            left = Math.max(left, sum);
        }

        sum = 0;
        int right = 0x80000000;
        for(int i = m + 1; i <= h; i++)
        {
            sum += nums[i];
            right = Math.max(right, sum);
        }

        return Math.max(left + right, Math.max(left, right));
    }

    public int maxSubArray4(int nums[])
    {
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }

        return maxSum;
    }
}
