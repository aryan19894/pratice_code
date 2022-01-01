// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FibonacciDPTab.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class FibonacciDPTab
{

    public FibonacciDPTab()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int qb[] = new int[n + 1];
        qb[0] = 0;
        qb[1] = 1;
        for(int i = 2; i < qb.length; i++)
            qb[i] = qb[i - 1] + qb[i - 2];

        System.out.println(qb[n]);
    }
}
