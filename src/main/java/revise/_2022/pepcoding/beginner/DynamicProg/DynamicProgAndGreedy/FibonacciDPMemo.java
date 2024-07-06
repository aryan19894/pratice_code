// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FibonacciDPMemo.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class FibonacciDPMemo
{

    public FibonacciDPMemo()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = fib(n, new int[n + 1]);
        System.out.println(a);
    }

    private static int fib(int n, int qb[])
    {
        if(n == 0 || n == 1)
            return n;
        if(qb[n] != 0)
        {
            return qb[n];
        } else
        {
            int fibn = fib(n - 1, qb) + fib(n - 2, qb);
            qb[n] = fibn;
            return fibn;
        }
    }
}
