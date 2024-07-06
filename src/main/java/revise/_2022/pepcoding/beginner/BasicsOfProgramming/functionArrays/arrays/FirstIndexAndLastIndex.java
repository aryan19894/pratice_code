// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FirstIndexAndLastIndex.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class FirstIndexAndLastIndex
{

    public FirstIndexAndLastIndex()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int d = scn.nextInt();
        int l = 0;
        int r = n - 1;
        int first = -1;
        int last = -1;
        while(l <= r) 
        {
            int m = (l + r) / 2;
            if(d < a[m])
                r = m - 1;
            else
            if(d > a[m])
            {
                l = m + 1;
            } else
            {
                first = m;
                r = m - 1;
            }
        }
        System.out.println(first);
        l = 0;
        for(r = n - 1; l <= r;)
        {
            int m = (l + r) / 2;
            if(d < a[m])
                r = m - 1;
            else
            if(d > a[m])
            {
                l = m + 1;
            } else
            {
                last = m;
                l = m + 1;
            }
        }

        System.out.println(last);
    }
}
