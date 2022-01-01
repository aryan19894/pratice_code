// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InterquartileRange.java

package com.hackerrank.pratice.statics.day1;

import java.io.PrintStream;
import java.util.*;

public class InterquartileRange
{

    public InterquartileRange()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a[] = new double[n];
        ArrayList dataList = new ArrayList();
        for(int i = 0; i < n; i++)
            a[i] = in.nextDouble();

        int f = 0;
        for(int i = 0; i < n; i++)
        {
            f = in.nextInt();
            for(int j = 0; j < f; j++)
                dataList.add(Double.valueOf(a[i]));

        }

        Object s[] = dataList.toArray();
        Arrays.sort(s);
        a = new double[s.length];
        n = a.length;
        a = convertArray(s);
        System.out.printf("%.1f", new Object[] {
            Double.valueOf(calculate(a, (n + 1) / 2, n - 1) - calculate(a, 0, n / 2 - 1))
        });
    }

    private static double[] convertArray(Object s[])
    {
        double ref[] = new double[s.length];
        int i = 0;
        Object aobj[] = s;
        int j = aobj.length;
        for(int k = 0; k < j; k++)
        {
            Object o = aobj[k];
            ref[i++] = ((Double)o).doubleValue();
        }

        return ref;
    }

    private static double calculate(double a[], int l, int r)
    {
        if(isEven(r - l))
            return a[(r + l) / 2];
        else
            return (double)Math.round((a[(r + l) / 2] + a[(r + l) / 2 + 1]) / 2D);
    }

    private static boolean isEven(int n)
    {
        return n % 2 == 0;
    }
}
