// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClimbStairsMemo.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ClimbStairsMemo
{

    public ClimbStairsMemo()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cp = countPath(n, new int[n + 1]);
        System.out.println(cp);
    }

    private static int countPath(int n, int qb[])
    {
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        if(qb[n] != 0)
        {
            return qb[n];
        } else
        {
            int cp1 = countPath(n - 1, qb);
            int cp2 = countPath(n - 2, qb);
            int cp3 = countPath(n - 3, qb);
            int cp = cp1 + cp2 + cp3;
            qb[n] = cp;
            return cp;
        }
    }
}
