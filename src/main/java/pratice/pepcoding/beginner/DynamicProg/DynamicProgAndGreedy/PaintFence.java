// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PaintFence.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class PaintFence
{

    public PaintFence()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ii = 0;
        int ij = k;
        int total = ii + ij;
        for(int i = 1; i < n; i++)
        {
            ii = ij;
            ij = total * (k - 1);
            total = ii + ij;
        }

        System.out.println(total);
    }
}
