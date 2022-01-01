// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountABCSubsequences.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class CountABCSubsequences
{

    public CountABCSubsequences()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int a = 0;
        int ab = 0;
        int abc = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == 'a')
            {
                a = 2 * a + 1;
                continue;
            }
            if(ch == 'b')
            {
                ab = 2 * ab + a;
                continue;
            }
            if(ch == 'c')
                abc = 2 * abc + ab;
        }

        System.out.println(abc);
    }
}
