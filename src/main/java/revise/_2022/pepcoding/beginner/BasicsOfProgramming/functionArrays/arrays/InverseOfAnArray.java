// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InverseOfAnArray.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class InverseOfAnArray
{

    public InverseOfAnArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int b[] = new int[n];
        for(int i = 0; i < n; i++)
            b[a[i]] = i;

        for(int i = 0; i < n; i++)
            System.out.println(b[i]);

    }
}
