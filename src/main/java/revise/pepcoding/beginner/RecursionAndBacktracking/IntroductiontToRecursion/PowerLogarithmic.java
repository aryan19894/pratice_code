// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PowerLogarithmic.java

package revise.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class PowerLogarithmic
{

    public PowerLogarithmic()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x, n));
    }

    public static int power(int x, int n)
    {
        if(n == 0)
            return 1;
        int xn = power(x, n / 2) * power(x, n / 2);
        if(n % 2 != 0)
            xn *= x;
        return xn;
    }
}
