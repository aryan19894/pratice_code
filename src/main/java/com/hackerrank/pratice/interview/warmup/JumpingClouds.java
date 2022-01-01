// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JumpingClouds.java

package com.hackerrank.pratice.interview.warmup;

import java.io.PrintStream;
import java.util.Scanner;

public class JumpingClouds
{

    public JumpingClouds()
    {
    }

    static int jumpingOnClouds(int c[])
    {
        int jump = 0;
        for(int i = 0; i < c.length - 1; i++)
            if(c[i] == 0)
            {
                if(i + 2 < c.length)
                {
                    jump++;
                    i++;
                } else
                {
                    jump++;
                }
            } else
            {
                jump++;
            }

        if(c[c.length - 1] == 1)
            jump--;
        return jump;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int i = 0; i < n; i++)
            c[i] = in.nextInt();

        int res = jumpingOnClouds(c);
        System.out.println(res);
    }
}
