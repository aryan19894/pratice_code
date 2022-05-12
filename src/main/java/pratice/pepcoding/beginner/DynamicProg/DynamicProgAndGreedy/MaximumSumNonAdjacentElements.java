// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MaximumSumNonAdjacentElements.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class MaximumSumNonAdjacentElements
{

    public MaximumSumNonAdjacentElements()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int inc = a[0];
        int exc = 0;
        for(int i = 1; i < n; i++)
        {
            int temp = exc;
            exc = Math.max(inc, exc);
            inc = temp + a[i];
        }

        System.out.println(Math.max(inc, exc));
    }
}
