// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TwoStrings.java

package com.hackerrank.pratice.interview.dictionaries_hashmaps;

import java.io.PrintStream;
import java.util.Scanner;

public class TwoStrings
{

    public TwoStrings()
    {
    }

    static String twoStrings(String s1, String s2)
    {
        String res = "NO";
        char ac[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int i = ac.length;
        int j = 0;
        do
        {
            if(j >= i)
                break;
            char c = ac[j];
            if(s1.indexOf(c) >= 0 && s2.indexOf(c) >= 0)
            {
                res = "YES";
                break;
            }
            j++;
        } while(true);
        return res;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            String s1 = in.next();
            String s2 = in.next();
            String ans = twoStrings(s1, s2);
            System.out.println(ans);
        }

    }
}
