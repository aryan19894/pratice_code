// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day6_LetsReview.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day6_LetsReview
{

    public Day6_LetsReview()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            String s = sc.next();
            char ch[] = s.toCharArray();
            String e = "";
            String o = "";
            for(int j = 0; j < ch.length; j++)
                if(j % 2 == 0)
                    e = (new StringBuilder()).append(e).append(ch[j]).toString();
                else
                    o = (new StringBuilder()).append(o).append(ch[j]).toString();

            System.out.println((new StringBuilder()).append(e).append(" ").append(o).toString());
        }

    }
}
