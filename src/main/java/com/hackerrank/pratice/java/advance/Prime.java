// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrimeChecker.java

package com.hackerrank.pratice.java.advance;

import java.io.PrintStream;

class Prime
{

    Prime()
    {
    }

    public transient void checkPrime(int n1[])
    {
        int ai[] = n1;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int n = ai[j];
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
                System.out.print((new StringBuilder()).append(n).append(" ").toString());
            else
                System.out.print("");
        }

        System.out.println();
    }
}
