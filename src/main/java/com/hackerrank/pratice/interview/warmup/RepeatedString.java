// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RepeatedString.java

package com.hackerrank.pratice.interview.warmup;

import java.io.PrintStream;
import java.util.Scanner;

public class RepeatedString
{

    public RepeatedString()
    {
    }

    static long repeatedString(String s, long n)
    {
        long c = 0L;
        int freq = 0;
        char chr[] = s.toCharArray();
        if(s.contains("a"))
        {
            char ac[] = s.toCharArray();
            int j = ac.length;
            for(int k = 0; k < j; k++)
            {
                char ch = ac[k];
                if(ch == 'a')
                    freq++;
            }

            c = (long)freq * (n / (long)s.length());
            for(int i = 0; (long)i < n % (long)s.length(); i++)
                if(chr[i] == 'a')
                    c++;

        }
        return c;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long res = repeatedString(s, n);
        System.out.println(res);
    }
}
