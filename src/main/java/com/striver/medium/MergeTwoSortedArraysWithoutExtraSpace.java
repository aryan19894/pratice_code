// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeTwoSortedArraysWithoutExtraSpace.java

package com.striver.medium;

import com.common.Obj;
import java.io.PrintStream;
import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace
{

    public MergeTwoSortedArraysWithoutExtraSpace()
    {
    }

    static void mergeArray1(int a[], int b[], int n, int m)
    {
        int c[] = new int[n + m];
        int o = c.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for(k = 0; k < o && i < n && j < m; k++)
        {
            if(a[i] < b[j])
            {
                c[k] = a[i++];
                continue;
            }
            if(a[i] > b[j])
            {
                c[k] = b[j++];
            } else
            {
                c[k] = a[i++];
                c[k++] = b[j++];
            }
        }

        while(i < n) 
            c[k++] = a[i++];
        while(j < m) 
            c[k++] = b[j++];
        for(i = 0; i < n; i++)
            a[i] = c[i];

        for(i = 0; i < m; i++)
            b[i] = c[n + i];

    }

    static void mergeArray2(int a[], int b[], int n, int m)
    {
        int i = 0;
        int j = 0;
        for(; i < n; i++)
            if(a[i] > b[0])
            {
                Obj.swapBetweenTwoArray(a, i, b, 0);
                maintainSortedArray(b);
            }

    }

    private static void maintainSortedArray(int b[])
    {
        int swap = b[0];
        for(int i = 1; i < b.length; i++)
        {
            if(swap > b[i])
            {
                b[i - 1] = b[i];
                continue;
            }
            if(swap >= b[i])
                continue;
            b[i - 1] = swap;
            break;
        }

    }

    static void mergeArray3(int a[], int b[], int n, int m)
    {
        int i = 0;
        int j = 0;
        int gap = n + m;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap))
        {
            for(i = 0; i + gap < n; i++)
                if(a[i] > a[i + gap])
                    Obj.swap(a, i, i + gap);

            for(j = gap <= n ? 0 : gap - n; i < n && j < m; j++)
            {
                if(a[i] > b[j])
                    Obj.swapBetweenTwoArray(a, i, b, j);
                i++;
            }

            if(j >= m)
                continue;
            for(j = 0; j + gap < m; j++)
                if(b[j] > b[j + gap])
                    Obj.swap(b, j, j + gap);

        }

    }

    private static int nextGap(int gap)
    {
        if(gap <= 1)
            return 0;
        else
            return gap / 2 + gap % 2;
    }

    public static void main(String args[])
    {
        int a[] = {
            3, 5, 6, 8, 12
        };
        int b[] = {
            1, 4, 9, 13
        };
        int n = a.length;
        int m = b.length;
        mergeArray3(a, b, n, m);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
