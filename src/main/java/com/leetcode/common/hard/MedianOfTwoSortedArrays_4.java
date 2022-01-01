// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MedianOfTwoSortedArrays_4.java

package com.leetcode.common.hard;


class MedianOfTwoSortedArrays_4
{

    MedianOfTwoSortedArrays_4()
    {
    }

    public double findMedianSortedArrays(int A[], int B[])
    {
        int m = A.length;
        int n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(A, 0, B, 0, l) + getKth(A, 0, B, 0, r)) / 2D;
    }

    private double getKth(int A[], int aStart, int B[], int bStart, int k)
    {
        if(aStart > A.length - 1)
            return (double)B[(bStart + k) - 1];
        if(bStart > B.length - 1)
            return (double)A[(aStart + k) - 1];
        if(k == 1)
            return (double)Math.min(A[aStart], B[bStart]);
        int aMid = 0x7fffffff;
        int bMid = 0x7fffffff;
        if((aStart + k / 2) - 1 < A.length)
            aMid = A[(aStart + k / 2) - 1];
        if((bStart + k / 2) - 1 < B.length)
            bMid = B[(bStart + k / 2) - 1];
        if(aMid < bMid)
            return getKth(A, aStart + k / 2, B, bStart, k - k / 2);
        else
            return getKth(A, aStart, B, bStart + k / 2, k - k / 2);
    }
}
