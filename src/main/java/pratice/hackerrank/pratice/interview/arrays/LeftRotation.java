// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LeftRotation.java

package pratice.hackerrank.pratice.interview.arrays;

import pratice.common.Out;

import java.util.Scanner;

public class LeftRotation
{

    public LeftRotation()
    {
    }

    static int[] rotLeft(int a[], int d)
    {
        for(int i = 0; i < d; i++)
        {
            int f = a[0];
            for(int j = 1; j < a.length; j++)
                a[j - 1] = a[j];

            a[a.length - 1] = f;
        }

        return a;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        Out.print(a);
        int ans[] = rotLeft(a, d);
        Out.print(ans);
    }
}
