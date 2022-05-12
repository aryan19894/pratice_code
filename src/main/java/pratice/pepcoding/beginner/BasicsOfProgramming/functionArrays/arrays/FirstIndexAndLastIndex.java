// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FirstIndexAndLastIndex.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class FirstIndexAndLastIndex
{

    public FirstIndexAndLastIndex()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int d = scn.nextInt();
        getFirstLastIndex(n, arr, d);
    }

    private static void getFirstLastIndex(int n, int arr[], int d)
    {
        int l = 0;
        int r = n - 1;
        int first = -1;
        int last = -1;
        while(l <= r) 
        {
            int m = (l + r) / 2;
            if(d < arr[m])
                r = m - 1;
            else
            if(d > arr[m])
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
            if(d < arr[m])
                r = m - 1;
            else
            if(d > arr[m])
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
