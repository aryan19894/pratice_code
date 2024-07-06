// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseAnArray.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class ReverseAnArray
{

    public ReverseAnArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        int i;
        for(i = 0; i < n; i++)
            a[i] = scn.nextInt();

        i = 0;
        for(int j = a.length - 1; i < j; j--)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
        }

        for(i = 0; i < n; i++)
            System.out.println(a[i]);

        System.out.println(a.toString());
    }
}
