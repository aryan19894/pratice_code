// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClimbStairsWithMinimumMoves.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ClimbStairsWithMinimumMoves
{

    public ClimbStairsWithMinimumMoves()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        Integer qb[] = new Integer[n + 1];
        qb[n] = Integer.valueOf(0);
        for(int i = n - 1; i >= 0; i--)
        {
            if(a[i] <= 0)
                continue;
            int min = 0x7fffffff;
            for(int j = 1; j <= a[i] && i + j < qb.length; j++)
                if(qb[i + j] != null)
                    min = Math.min(min, qb[i + j].intValue());

            if(min != 0x7fffffff)
                qb[i] = Integer.valueOf(min + 1);
        }

        System.out.println(qb[0]);
    }
}
