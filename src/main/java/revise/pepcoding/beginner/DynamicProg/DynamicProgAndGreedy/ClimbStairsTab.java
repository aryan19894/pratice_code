// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClimbStairsTab.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ClimbStairsTab
{

    public ClimbStairsTab()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int qb[] = new int[n + 1];
        qb[0] = 1;
        for(int i = 1; i < qb.length; i++)
        {
            if(i == 1)
            {
                qb[i] = qb[i - 1];
                continue;
            }
            if(i == 2)
                qb[i] = qb[i - 1] + qb[i - 2];
            else
                qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
        }

        System.out.println(qb[n]);
    }
}
