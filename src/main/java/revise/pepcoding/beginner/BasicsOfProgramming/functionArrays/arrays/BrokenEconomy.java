// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BrokenEconomy.java

package revise.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class BrokenEconomy
{

    public BrokenEconomy()
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
        getCeilFloor(n, a, d);
    }

    private static void getCeilFloor(int n, int a[], int d)
    {
        int l = 0;
        int r = n - 1;
        int min = 0x80000000;
        int max = 0x7fffffff;
        do
        {
            if(l > r)
                break;
            int m = (l + r) / 2;
            if(a[m] == d)
            {
                min = max = a[m];
                break;
            }
            if(a[m] > d)
            {
                r = m - 1;
                min = a[m];
            } else
            {
                l = m + 1;
                max = a[m];
            }
        } while(true);
        System.out.println(min);
        System.out.println(max);
    }
}
