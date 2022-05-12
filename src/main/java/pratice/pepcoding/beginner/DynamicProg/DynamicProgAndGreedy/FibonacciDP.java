// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FibonacciDP.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class FibonacciDP
{

    public FibonacciDP()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = fibonacci(n, new int[n + 1]);
        System.out.println(a);
    }

    private static int fibonacci(int n, int qb[])
    {
        if(n == 0 || n == 1)
            return n;
        if(qb[n] != 0)
        {
            return qb[n];
        } else
        {
            int fi1 = fibonacci(n - 1, qb);
            int fi2 = fibonacci(n - 2, qb);
            int fin = fi1 + fi2;
            qb[n] = fin;
            return fin;
        }
    }
}
