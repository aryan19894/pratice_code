// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day9_Recursion3.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day9_Recursion3
{

    public Day9_Recursion3()
    {
    }

    static int factorial(int n)
    {
        if(n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        n = factorial(n);
        System.out.println(n);
    }
}
