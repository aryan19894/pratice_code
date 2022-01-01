// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day25_RunningTimeComplexity.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day25_RunningTimeComplexity
{

    public Day25_RunningTimeComplexity()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            int div = 2;
            boolean st = false;
            do
            {
                if(div * div > n)
                    break;
                if(n % div == 0)
                {
                    st = true;
                    break;
                }
                div++;
            } while(true);
            if(!st && n != 1)
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }

    }
}
