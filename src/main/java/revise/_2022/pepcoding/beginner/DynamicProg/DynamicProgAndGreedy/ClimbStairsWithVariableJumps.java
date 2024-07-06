// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClimbStairsWithVariableJumps.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ClimbStairsWithVariableJumps
{

    public ClimbStairsWithVariableJumps()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int qb[] = new int[n + 1];
        qb[n] = 1;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = 1; j <= a[i] && i + j < qb.length; j++)
                qb[i] += qb[i + j];

        }

        System.out.println(qb[0]);
    }
}
