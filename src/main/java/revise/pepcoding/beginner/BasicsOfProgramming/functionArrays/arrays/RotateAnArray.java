// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateAnArray.java

package revise.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class RotateAnArray
{

    public RotateAnArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int k = scn.nextInt();
        rotate(a, k);
        for(int i = 0; i < n; i++)
            System.out.println(a[i]);

    }

    public static void rotate(int a[], int k)
    {
        int n = a.length;
        k %= n;
        if(k < 0)
            k = n + k;
        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
    }

    private static void reverse(int a[], int i, int j)
    {
        for(; i < j; j--)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
        }

    }
}
